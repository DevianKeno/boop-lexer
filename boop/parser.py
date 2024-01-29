""" LR(1) Parser

    Ideally, this should use an LR(1) parsing table. However, was too lazy to learn it
    so a scuffed approached was implements.
    It is SUPER slow, and increases as the BNF gets more complex. (but hey, it works)
    
    "To make the parser, you must first become the parser."
"""

from __future__ import annotations
import os
import re
from time import time
from boop.config import *
from boop.utils import *
from boop.token import *
from boop.tokens import *
from boop.symboltable import *

cwd = os.getcwd()

CLOSURE_KLEENE = ASTERISK
CLOSURE_POSITIVE = PLUS
OPTIONAL = QUESTION_MARK
IGNORE_TOKENS = [
    'COMMENT_SINGLE',
    'COMMENT_START',
    'COMMENT_END',
]

CLOSURES = {
    CLOSURE_KLEENE : 'KLEENE_CLOSURE',
    CLOSURE_POSITIVE : 'POSITIVE_CLOSURE',
    OPTIONAL : 'OPTIONAL'
}

def isnonterminal(string: str) -> bool:
    """ Returns True if the string is a non-terminal, False otherwise or if empty.\n
        A non-terminal is represented by a rule name that
        - starts with an alphabet (a-z, A-Z)
        - has no special characters
        - not all caps
    """
    if not string: return False
    if string[0] not in ALPHABET: return False
    if str.isupper(string): return False
    return isalpha(string)

def _split_rule_tokens(input: str) -> list[str]:
    """ This splits the right hand side (rhs) into individual tokens.
        e.g. "modifier? dataType IDENTIFIER" -> ['modifier', '?', 'dataType', 'IDENTIFIER'] 
    """
    pattern = re.compile(r'([()+*?]|\b\w+\b)')
    return [match.group() for match in pattern.finditer(input)]

class Parser:
    """ 1. Convert tokens into integer representations.
        2. Check if the current token and preceding token is in valid rules.
    """
    def __init__(self) -> None:
        self.content: str = EMPTY
        self.tokens: dict[str, str] = {}
        self.rules = {}
        self.subrules = {}
        self.buffer = None
        
        self._stack: str = ''
        self._buffer: self.match = None
        self._firsts: dict[str, set] = {}
        self._follows: dict[str, set] = {}
        self._lasts: dict[str, set] = {}
        self._rulestrs: list[str] = EMPTY
        self._int_map = {}
        self._token_map = {}
        self._nonterminal_int_seq: dict[str, str] = {}
        self._sequences: dict[int, set] = {}
        self._tokens_ignored: list[int] = []
        
        self._prev: str = EMPTY
        self._repr_idx: int = 0
        self._token_repr: dict[str, int] = {}
        
        self._init()
    
    def _init(self):        
        self._preprocess()
        
    @property
    def token_repr_count(self) -> int:
        return len(self._token_repr)
                
    def _preprocess(self):
        path = os.path.join(cwd, 'boop/grammar/grammar.boop')
        
        with open(path, 'r', encoding='utf-8') as file:
            self.content = file.read()
            
        self._preprocess_rules()
    
    def _preprocess_rules(self):
        rules = self.content.split(';')
        
        # Map tokens to integers
        for token, value in TOKENS.items():
            self.tokens[value] = token
            
        for token, value in SPECIAL_CHARACTERS.items():
            self.tokens[value] = token
            
        for token, value in KEYWORDS.items():
            self.tokens[value] = token
        
        for token, value in OPERATORS.items():
            self.tokens[value] = token
            
        for token, value in DELIMITERS.items():
            self.tokens[value] = token
        
        # Separate individual rules
        for nonterminal in rules:
            nonterminal = nonterminal.strip() # Remove new lines                        
            if nonterminal.startswith("#") or nonterminal.startswith('//') or not nonterminal: continue # Disregard region markers and comments
            lhs, rhs = map(str.strip, nonterminal.split(':', 1)) # Split lhs and rhs
            rules = [word.strip() for word in rhs.split('|')] # Split rhs ORs, basically rules with two or more variations            
            self.rules[lhs] = rules

        # Create token-integer mapping
        # Every tokens, rules and its variations are represented by a unique int id
        for i in self.tokens:
            var = len(self._int_map) + 1
            self._int_map[i] = var
            self._token_map[var] = i
        for i in self.rules:
            var = len(self._int_map) + 1
            self._int_map[i] = len(self._int_map) + 1
            self._token_map[var] = i
        
        # Get FIRST 
        for rule in self.rules.keys():
            self._firsts[rule] = self._parse_firsts(rule)            

        # Get FOLLOW
        for rule in self.rules.keys():
            self._parse_follows(rule)   
                    
        # Create rule int sequencing
        for nonterminal in self.rules.keys():            
            self._parse_nonterminal(nonterminal)
        
        for token in IGNORE_TOKENS:
            self._tokens_ignored.append(self._to_int(token))
        
        #region Debugging only, can be removed
        self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        #endregion
        
    def _parse_firsts(self, rulename: str) -> set:
        """ Retrieve the rule's FIRST tokens. 
        """
        if not (rhs := self.rules[rulename]): # Check if rule exists
            raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
                
        firsts = set()
        
        for rule in rhs:
            if not (token_sequence := _split_rule_tokens(rule)):
                raise Exception(f"[GrammarError]: A rule cannot be empty.")
            
            first_token = token_sequence[0]
            
            if isnonterminal(first_token):
                if first_token == rulename:
                    return firsts
                
                result = self._parse_firsts(token_sequence[0])
                firsts.update(result)
            else:
                firsts.add(self._to_int(token_sequence[0]))
            
        return firsts
        
    def _parse_follows(self, rulename: str) -> set:  
        """ Parse the rule's FOLLOW tokens. 
        """
        if not (rhs := self.rules[rulename]): # Check if rule exists
            raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
        
        follows = set()
        
        for rule in rhs:            
            if not (token_sequence := _split_rule_tokens(rule)):
                raise Exception(f"[GrammarError]: A rule cannot be empty.")
            
            for i, token in enumerate(token_sequence):                
                result = set()
                
                if (i + 1) < len(token_sequence): # Check if there is next token
                    next_token = token_sequence[i + 1]
                    if token in CLOSURES or next_token in CLOSURES: continue # Disregard closures

                    if isnonterminal(next_token):
                        result.update(self._firsts[next_token])
                    else:
                        result.add(self._to_int(next_token))
                    
                    self._follows.setdefault(token, set()).update(result)
        
        return follows
    
    def _parse_nonterminal(self, lhs: str):
        if not lhs in self.rules:            
            raise Exception(f"[GrammarError]: Unknown non-terminal [{lhs}]")
        
        rules = self.rules[lhs]
        
        for i, rhs in enumerate(rules):            
            result = self._rule_to_int_seq(lhs, rhs)
                        
            for j, rhs in enumerate(result):
                self._nonterminal_int_seq[f'{lhs}-{i}_{j}'] = ''.join(rhs)
                        
    def _rule_to_int_seq(self, lhs, rhs: str) -> list[str]:
        if not (token_sequence := _split_rule_tokens(rhs)):
            raise Exception(f"[GrammarError]: A rule cannot be empty.")
        
        sequences: list[str] = []
        sequence: str = ''
        sequences.append(sequence)
        
        for i, token in enumerate(token_sequence):            

            if token == OPTIONAL:
                current_seqs = sequences # Store current sequence
                new_list = []
                
                # Create two rhs variations
                for seq in current_seqs:                    
                    new_list.append(seq) # Original
                    minus_last = "  ".join(seq.split()[:-1]) # Remove the last token
                    # The if else is necessary to check whether the resulting sequence is empty
                    # so it will be in fact empty '' instead of having the separators '  '
                    # The separators ' {} ' are important!!
                    #                 ^  ^
                    new_list.append(f' {minus_last} ' if minus_last else '')
                sequences = new_list
                continue
            
            # if token == LEFT_PAREN:
            #     result = self._parse_subrule(lhs, token_sequence, i + 1)
            #     result = self._rule_to_int_seq(lhs, self.subrules[result[0]])
            #     continue
                                
            # if token == CLOSURE_KLEENE:
            #     continue
                
            # if token == CLOSURE_POSITIVE:
            #     continue       
            
            for j, s in enumerate(sequences):
                sequences[j] = sequences[j] + f' {self._to_int(token)} '
            continue
                    
        return sequences
   
    def _to_int(self, token: str) -> int:
        """ Takes a token and returns its integer mapping.
        """
        if token in self._int_map:
            return self._int_map[token]
        raise Exception(f"[GrammarError]: Unknown token [{token}].")
    
    def get_follows(self, rulename: str) -> set:        
        if rulename in self._follows:
            return self._follows[rulename]
        return None
    
    def _to_token(self, value: int) -> str:
        """ Takes an int and returns the token mapped to it.
        """
        if value == None or value == EMPTY: return
        if result := self._token_map[value]:
            return result
        raise Exception(f"[GrammarError]: Unknown int mapping [{value}].")
    
    def follows(self, value: int, search: set) -> bool:
        """ Check if the value is in the FOLLOWS set of search. 
        """
        if (search := self.get_follows(search)) == None:
            return False
        if value in search:
            return True
        
        return False
            
    def find_rule(self, key: str, input: str = None, lookahead: str = None) -> match:
        """ Given a key, search for any production rule that is a substring in this key.\n
            Returns -> matches: list[tuple[bool, str, int, int]]: can be made into a struct but whatever
                - bool - whether or not to reduce
                - str - name of the rule with variation id
                - int - start index where the rule starts in the key
                - int - length of the rule str\n
            Ideally, this should be a parsing table.        
        """
        matches: list[self.match] = []
        intput: int = -1
        
        if input:
            intput = int(input.strip())
        else:
            intput = int(key.split()[-1].strip())
                
        if lookahead:
            lookahead = int(lookahead)
            var = self._to_token(intput)
            if self.follows(lookahead, var):
                # Do not reduce, key with look ahead is a production rule
                return None
        
        # This is kinda fucked up, this ideally should use a parsing table
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            if (index := key.find(rhs)) != -1 and rhs != '': # Match
                matches.append(self.match(True, nonterminal, index, len(rhs)))

        matches = self._get_max(matches)
        return matches
    
    def match_rule(self, key: str) -> match:
        """ Returns the nearest production rules given an input.
        """
        matches: list[self.match] = []
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            if not (index := rhs.find(key)) == -1:
                matches.append(self.match(True, nonterminal, index, len(rhs)))                
                continue       
        return matches
    
    class match:        
        def __init__(self, reduce: bool, nonterminal: str, index: int, len: int) -> None:
            self.reduce = reduce
            self.nonterminal = nonterminal
            self.index = index
            self.len = len
            
        def __repr__(self) -> str:
            return f'match: \'{self.nonterminal}\''
    
    def _reduce(self, match: match):
        i = match.index
        n = match.len
        # Remove substring at index i of length n
        self._stack = self._stack[:i] + self._stack[i + n:]
        # Insert substring at index i of length n            
        self._stack = self._stack[:i ] + f' {self._to_int(match.nonterminal.split("-")[0])} ' + self._stack[i:]
        self._buffer = None
        
    def _get_max(self, matches) -> match:
        """ Returns the longest matched rule in the list.
        """
        if not matches: return matches        
        highest = None        
        for match in matches:
            if not highest:
                highest = match                
            if match.len > highest.len:
                highest = match
            continue
        return highest
        
    def parse(self, table: SymbolTable):
        if table == None: return
        start_time = time()
                
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        self._stack = ''
        intput = '' # Debugging
        
        self._buffer = None
        finished = False
        k = 0
        while k < len(input_sequence) or self._stack:
            if finished:
                # Do a final reduction process
                while True:
                    result = self.find_rule(self._stack)
                    
                    if not result: break

                    self._reduce(result)
                    # Parse tree should be constructed here
                    continue
                break
                        
            # Shift
            if input_sequence:
                input = f' {input_sequence.pop(0)} '
                intput = self._to_token(int(input.strip()))
                
                if intput in IGNORE_TOKENS: continue
                
                self._stack += input
                lookahead = input_sequence[0] if input_sequence else None
                k += 1
            else:
                finished = True
            
            while True:
                result = self.find_rule(self._stack, input=input, lookahead=lookahead)              
                if not result: break
                
                self._reduce(result)
                input = '' # Input is consumed
                # Parse tree should be constructed here
                continue
        
        if len(self._stack.strip().split()) == 1:
            print(f'Successful parse\nElapsed: {time() - start_time}s')
            
        else:
            """ Handle syntax errors
            """            
            # match = self.match_rule(self._stack)
            # var = self._nonterminal_int_seq[match.nonterminal]
            
            # self._stack = self._stack.split()
            # var = var.split()            
            # difference = [item for item in var if item not in self._stack][0]
            # expect = self._to_token(int(difference))
            # print(f'[SyntaxError]: Expected \'{expect}\'')
            print(f'[SyntaxError]')