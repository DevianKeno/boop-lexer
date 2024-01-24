
from __future__ import annotations
import os
import re
import collections
from time import time
from boop.utils import *
from boop.token import *
from boop.tokens import *
from boop.symboltable import *

cwd = os.getcwd()

CLOSURE_KLEENE = ASTERISK
CLOSURE_POSITIVE = PLUS
OPTIONAL = QUESTION_MARK

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

def _split_rhs(input: str) -> list[str]:
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
        
        self._firsts: dict[str, set] = {}
        self._follows: dict[str, set] = {}
        self._lasts: dict[str, set] = {}
        self._rulestrs: list[str] = EMPTY
        self._int_map = {}
        self._token_map = {}
        self._nonterminal_int_seq: dict[str, str] = {}
        self._sequences: dict[int, set] = {}
        
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
                
        # Map 'subrules' into int
        # for lhs, rhs in self.rules.items():
        #     self._parse_subrule(lhs, rhs)
            
        # for i in self.subrules:
        #     self._int_map[i] = len(self._int_map) + 1
                    
        # Create rule int sequencing
        for nonterminal in self.rules.keys():            
            self._parse_nonterminal(nonterminal)
                    
        #region Debugging only, can be removed
        self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        #endregion
        
    def _map_subrule(self, lhs, token_sequence, start_index: int):        
        subrule = []
        for i in range(start_index, len(token_sequence)):
            token = token_sequence[i]
            
            if token == RIGHT_PAREN:
                break
                
            if token == LEFT_PAREN:
                self._map_subrule(lhs, token_sequence, i + 1)
                continue
                
            subrule.append(token)
        
        subrule_id = f'{lhs}_sub_{len(self.subrules)}'
        self.subrules[subrule_id] = subrule
        return subrule
            
    def _parse_subrule(self, lhs, rhs):        
        for rule in rhs:
            if not (token_sequence := _split_rhs(rule)):
                raise Exception(f"[GrammarError]: A rule cannot be empty.")            
            # token_sequence = _split_rhs(rule)               
            subrule = []
            
            for i, token in enumerate(token_sequence):
                
                if token == RIGHT_PAREN:
                    break
                
                if token == LEFT_PAREN:
                    self._map_subrule(lhs, token_sequence, i + 1)
                    break #change this break
                    
                subrule.append(token)
    
    def _parse_nonterminal(self, lhs: str):
        if not lhs in self.rules:            
            raise Exception(f"[GrammarError]: Unknown non-terminal [{lhs}]")
        
        rules = self.rules[lhs]
        
        for i, rhs in enumerate(rules):            
            result = self._rule_to_int_seq(lhs, rhs)
                        
            for j, rhs in enumerate(result):
                self._nonterminal_int_seq[f'{lhs}_{i}_{j}'] = ''.join(rhs)
                        
    def _rule_to_int_seq(self, lhs, rhs: str) -> list[str]:
        if not (token_sequence := _split_rhs(rhs)):
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
            
            #TODO
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
        if result := self._int_map[token]:
            return result
        raise Exception(f"[GrammarError]: Unknown token [{token}].")
    
    def _to_token(self, value: int) -> str:
        """ Takes an int and returns the token mapped to it.
        """
        if value == None or value == EMPTY: return
        if result := self._token_map[value]:
            return result
        raise Exception(f"[GrammarError]: Unknown int mapping [{value}].")
    
    def find_rule(self, key: str) -> tuple[bool, str, int, int]:
        """ Given a key, search for any production rule that is a substring in this key.\n
            Returns -> matches: list[tuple[bool, str, int, int]]: can be made into a struct but whatever
                - bool - whether or not there is a match
                - str - name of the rule with variation id
                - int - start index where the rule starts in the key
                - int - length of the rule str                
        """
        # This is kinda fucked up, needs optimizing
        matches = []
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            if not (index := key.find(rhs)) == -1:
                matches.append((True, nonterminal, index, len(rhs)))
                continue
        return matches
    
    def match_rule(self, key: str) -> tuple[bool, str, int, int]:
        """ Returns the nearest production rules given an input.
        """
        matches = []
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            if not (index := rhs.find(key)) == -1:
                matches.append((True, nonterminal, index, len(rhs)))
                
                continue       
        return matches
    
    def parse(self, table: SymbolTable):
        if table == None: return
        start_time = time()
                
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        stack = ''
        tree = ''
        stack_view = '' # Debugging
        
        self.buffer = None
        finished = False
        j = 0
        while j < len(input_sequence) or stack:
            if finished:
                break
                        
            # Shift
            if input_sequence:
                input = f' {input_sequence.pop(0)} '
                stack += input
                stack_view = self._to_token(int(input.strip())) # Debugging                
                j += 1
            else:
                finished = True
                
            # Keep reducing until not possible       
            while True:
                result = self.find_rule(stack)
                
                if not result: break
                
                if len(result) == 1:
                    """ There's only one match, rule is unambiguous therefore reduce. 
                    """
                    result = result[0]
                    i = result[2]
                    n = result[3]
                    # Remove substring at index i of length n
                    stack = stack[:i] + stack[i + n:]
                    # Insert substring at index i of length n            
                    stack = stack[:i ] + f' {self._to_int(result[1][:-4])} ' + stack[i:]
                    
                    # Parse tree should be constructed here
                    continue
                
                elif len(result) >= 1:            
                    """ Need a way to check the most appropriate rule in cases that there are
                        two or more matches (result). Rule is ambiguous.
                        To combat this for now, the grammar must be structured in a way that it is not ambiguous.
                    """
                    result = result[0]
                    i = result[2]
                    n = result[3]
                    # Remove substring at index i of length n
                    stack = stack[:i] + stack[i + n:]
                    # Insert substring at index i of length n            
                    stack = stack[:i] + f' {self._to_int(result[1][:-4])} ' + stack[i:]
                    continue

        if len(stack.strip().split()) == 1:
            print(f'Successful parse\nElapsed: {time() - start_time}s')
        else:
            """ Handle syntax error. 
            """
            # result = self.match_rule(stack)
            # var = self._nonterminal_int_seq[result[-1][1]]
            
            # stack = stack.split()
            # var = var.split()            
            # difference = [item for item in var if item not in stack][0]
            # expect = self._to_token(int(difference))
            # print(f'[SyntaxError]: Expected \'{expect}\'')
            print(f'[SyntaxError]')
            
        print()
                
        
