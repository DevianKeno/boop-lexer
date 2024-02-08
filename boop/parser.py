""" LR(1) Parser

    Ideally, this should use an LR(1) parsing table. However, was too lazy to learn it
    so a scuffed approached was to just use a for loop.
    It is slow, yeah ik, and increases as the BNF gets more complex. (but hey, it works)
    
    "To make the parser, you must first become the parser."
"""

from __future__ import annotations
import os
import codecs
import re
import json
from time import time
from boop.config import *
from boop.utils import *
from boop.token import *
from boop.tokens import *
from boop.symboltable import *
from boop.lexer import Lexer

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

DNR = {
    'OP_DOT'
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

def _split_production(input: str) -> list[str]:
    """ Splits a productin rule/rhs into its individual tokens, including closures.
        e.g. "modifier? dataType IDENTIFIER" -> ['modifier', '?', 'dataType', 'IDENTIFIER'] 
    """
    pattern = re.compile(r'([()+*?]|\b\w+\b)')
    #TODO Check if empty
    return [match.group() for match in pattern.finditer(input)]

class Parser:
    
    class match:        
        def __init__(self, reduce: bool, nonterminal: str, index: int, len: int) -> None:
            self.reduce = reduce
            self.nonterminal = nonterminal
            self.index = index
            self.len = len
            
        def __repr__(self) -> str:
            return f'match: \'{self.nonterminal}\''
        
    def __init__(self) -> None:
        self.path: str = EMPTY
        self.content: str = EMPTY
        self.tokens: dict[str, str] = {}
        self.rules = {}
        self.enable_derivation: bool = True
        self.derivation_type: str = 'left'
        self.derivation: list[str] = []        
        self.enable_syntax_checking = True
        self.lexer: Lexer = None
        self.errors = []
        
        self._stack: str = EMPTY    
        
        self._firsts: dict[str, set] = {}
        self._follows: dict[str, set] = {}
        self._lasts: dict[str, set] = {}
        self._int_map = {}
        self._token_map = {}
        self._nonterminal_int_seq: dict[str, str] = {}
        self._tokens_ignored: list[int] = []
                
        self._init()
    
    def _init(self):        
        self._preprocess()
                
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
        
        # Parse FIRSTS
        for rule in self.rules.keys():
            self._parse_firsts(rule)            

        # Parse LASTS
        for rule in self.rules.keys():
            self._parse_lasts(rule)
            
        # Parse FOLLOWS
        for rule in self.rules.keys():
            self._parse_follows(rule)
                            
        # Create rule int sequencing
        for nonterminal in self.rules.keys():            
            self._parse_nonterminal(nonterminal)
                
        for token in IGNORE_TOKENS:
            self._tokens_ignored.append(self._to_int(token))
        
        #region Debugging only, can be removed
        # self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        #endregion
            
    def _parse_firsts(self, rulename: str):
        """ Retrieve the rule's FIRST tokens. 
        """
        if not (rhs := self.rules[rulename]): # Check if rule exists
            raise Exception(f"[BOOP] GrammarError: No such rule [{rulename}] exists.")
                
        firsts = set()
        
        for rule in rhs:
            if not (token_sequence := _split_production(rule)):
                raise Exception(f"[BOOP] GrammarError: A rule cannot be empty.")            
            
            for i, token in enumerate(token_sequence):
                if token in CLOSURES: continue
                result = set()
                
                first_token = token_sequence[i]
                
                if (i + 1) < len(token_sequence):                    
                    if token_sequence[i + 1] == OPTIONAL: # Check if this token is optional
                        if isnonterminal(first_token):
                            if not first_token in self._firsts:
                                self._parse_firsts(first_token)
                            
                            result.update(self._firsts[first_token])
                            firsts.update(result)
                        else:
                            firsts.add(self._to_int(first_token))
                        continue
                               
                if isnonterminal(first_token):
                    if not first_token in self._firsts:
                        self._parse_firsts(first_token)
                    
                    result.update(self._firsts[first_token])
                    firsts.update(result)
                else:
                    firsts.add(self._to_int(first_token))
                break
                
            self._firsts.setdefault(rulename, set()).update(firsts)
            
        return
        
    def _parse_follows(self, rulename: str) -> set:  
        """ Parse the rule's FOLLOW tokens. 
        """
        if not (rhs := self.rules[rulename]): # Check if rule exists
            raise Exception(f"[BOOP] GrammarError: No such rule [{rulename}] exists.")
                
        for prod in rhs:            
            if not (tok_seq := _split_production(prod)):
                raise Exception(f"[BOOP] GrammarError: A rule cannot be empty.")
                        
            for i, token in enumerate(tok_seq):                
                if token in CLOSURES: continue # Disregard closures
                follows = set() # FOLLOWS set
                
                for j in range(i + 1, len(tok_seq)):
                    next_token = tok_seq[j]
                    if next_token in CLOSURES: continue

                    if (j + 1) < len(tok_seq):
                        closure = tok_seq[j + 1]
                    else:
                        closure = None
                                          
                    if isnonterminal(next_token):
                        follows.update(self._firsts[next_token])
                    else:
                        follows.add(self._to_int(next_token))
                    
                    if closure and closure == OPTIONAL: continue
                    else: break
                                    
                if isnonterminal(token):
                    for num in self._lasts[token]:
                        self._follows.setdefault(self._to_token(num), set()).update(follows)
                self._follows.setdefault(token, set()).update(follows)
        return
        
    def _parse_lasts(self, nonterminal: str) -> set:  
        """ Parse the nonterminal's LAST tokens. 
        """
        rhs = self.rules[nonterminal]
        
        for prod in rhs:            
            if not (token_sequence := _split_production(prod)):
                raise Exception(f"[BOOP] GrammarError: A rule cannot be empty.")
            
            lasts = set()
            
            if len(token_sequence) == 1:
                last_token = token_sequence[-1]
                if isnonterminal(last_token):
                    if not last_token in self._lasts:
                        self._parse_lasts(last_token)
                    lasts.update(self._lasts[last_token])
                else:
                    lasts.add(self._to_int(last_token))
                    
                self._lasts.setdefault(nonterminal, set()).update(lasts)
                continue
            
            tot = len(token_sequence)
            for i in range(len(token_sequence) - 1, 0, -1): # Start from the end
                last_token = token_sequence[i] # Last                
                                    
                if last_token == OPTIONAL:
                    last_token = token_sequence[i - 1] # In case of a closure, get the next
                    if isnonterminal(last_token):
                        if not last_token in self._lasts:
                            self._parse_lasts(last_token)
                        lasts.update(self._lasts[last_token])
                    else:
                        lasts.add(self._to_int(last_token))
                    continue # Continue because this token optional
                
                else: # This is the last token                
                    if isnonterminal(last_token):
                        if not last_token in self._lasts:
                            self._parse_lasts(last_token)
                        lasts.update(self._lasts[last_token])
                    else:
                        lasts.add(self._to_int(last_token))
                                
                self._lasts.setdefault(nonterminal, set()).update(lasts)
                break
                    
    def _parse_nonterminal(self, lhs: str):
        if not lhs in self.rules:            
            raise Exception(f"[BOOP] GrammarError: Unknown non-terminal [{lhs}]")
        
        rules = self.rules[lhs]
        
        for i, rhs in enumerate(rules):            
            result = self._rule_to_int_seq(lhs, rhs)
                        
            for j, rhs in enumerate(result):
                self._nonterminal_int_seq[f'{lhs}-{i}_{j}'] = ''.join(rhs)
                        
    def _rule_to_int_seq(self, lhs, rhs: str) -> list[str]:
        if not (token_sequence := _split_production(rhs)):
            raise Exception(f"[BOOP] GrammarError: A rule cannot be empty.")
        
        sequences: list[str] = []
        sequence: str = ''
        sequences.append(sequence)
        
        for i, token in enumerate(token_sequence):            
            if token == OPTIONAL:
                current_seqs = sequences # Store current sequence
                new_list = []
                
                for seq in current_seqs: # Create two rhs variations       
                    new_list.append(seq) # Original
                    minus_last = "  ".join(seq.split()[:-1]) # Remove the last token
                    # The if else is necessary to check whether the resulting sequence is empty
                    # so it will be in fact empty '' instead of having the separators '  '
                    # The separators ' {} ' are important!!
                    #                 ^  ^
                    new_list.append(f' {minus_last} ' if minus_last else '')
                sequences = new_list
                continue
                                 
            for j, s in enumerate(sequences):
                sequences[j] = sequences[j] + f' {self._to_int(token)} '
            continue
                    
        return sequences
   
    def _to_int(self, token: str) -> int:
        """ Takes a token and returns its integer mapping.
        """
        if token in self._int_map:
            return self._int_map[token]
        raise Exception(f"[BOOP] GrammarError: Unknown token [{token}].")
    
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
        raise Exception(f"[BOOP] GrammarError: Unknown int mapping [{value}].")
    
    def check_follows(self, value: int, search: set) -> bool:
        """ Check if the value is in the FOLLOWS set of search. 
        """
        if (search := self.get_follows(search)) == None:
            return False
        if value in search:
            return True        
        return False
            
    def find_rule(self, key: str, input: str = None, lookahead: str = None) -> match:
        """ Given a key, search for any production rule that is a substring in this key.\n
            Returns -> matches: list[tuple[bool, str, int, int]]: can be made into a struct but whatever#DONE
            - `bool`: whether or not to reduce
            - `str`: name of the rule with variation id
            - `int`: start index where the rule starts in the key
            - `int`: length of the rule str\n
            Ideally, this should implement a parsing table.        
        """
        matches = []
        intput = int(input.strip()) if input else int(key.split()[-1].strip())
                
        if lookahead:
            lookahead = int(lookahead)
            var = self._to_token(intput)
            
            # This is kinda fucked up, this ideally should use a parsing table
            for nonterminal, rhs in self._nonterminal_int_seq.items():
                if (index := key.find(rhs)) != -1 and rhs != '': # Match
                    matches.append(self.match(True, nonterminal, index, len(rhs)))
                    return self._get_max(matches)
            
            if self.check_follows(lookahead, var): # Do not reduce if key with lookahead is a production rule
                return None
            else:                
                if not matches:
                    self.error_token()
                else:                    
                    return self._get_max(matches)
                
        else:
            for nonterminal, rhs in self._nonterminal_int_seq.items():
                if (index := key.find(rhs)) != -1 and rhs != '': # Match
                    matches.append(self.match(True, nonterminal, index, len(rhs)))

            return self._get_max(matches)
            
    def match_rule(self, key: str) -> match:
        """ Returns the nearest production rules given an input.
        """
        matches: list[self.match] = []
        self._int_map
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            if not (index := rhs.find(key)) == -1:
                matches.append(self.match(True, nonterminal, index, len(rhs)))                
                continue       
        return matches
    
    def _reduce(self, match: match):
        i = match.index
        n = match.len        
        self._stack = self._stack[:i] + self._stack[i + n:] # Remove substring at index i of length n
        self._stack = self._stack[:i] + f' {self._to_int(match.nonterminal.split("-")[0])} ' + self._stack[i:] # Insert substring at index i of length n
        
    def _get_max(self, matches) -> match:
        """ Returns the longest matched rule in the list.
        """
        if not matches: return matches
        highest = None        
        for match in matches:
            if not highest: highest = match                
            if match.len > highest.len: highest = match
            continue
        return highest
    
    def error_token(self):
        symbol = self._table.tokens[self._stack_idx - 1]
        expect = [self._to_token(num) for num in self._follows[symbol.token]]
        self.errors.append(symbol)
        print(f'[BOOP] SyntaxError: Unexpected token at ln {symbol.line}, col {symbol.col}')
        print(self.lexer.get_line(symbol.line - 1))
        print(' ' * (symbol.col - 1) + '^')
        print(f'Expected {", ".join(expect)}')
        # raise Exception()
    
    def parse(self, table: SymbolTable):
        if table == None: return
        
        start_time = time()
        self._table = table
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        self._stack = EMPTY
        intput = EMPTY # Debugging
        self.derivation = []
        self._stack_idx = 0
        finished = False
        k = 0
        
        # self.enable_syntax_checking = False
        if not self.enable_syntax_checking:
            print('Warning! Syntax checking disabled')
        
        while k < len(input_sequence) or self._stack:
            if finished: # Do a final reduction process
                while True:
                    result = self.find_rule(self._stack)                    
                    if not result: break

                    self.derivation.append(self._stack)  
                    self._reduce(result)
                    self.derivation.append(self._stack)
                    continue
                break

            if input_sequence: # Shift
                input = f' {input_sequence.pop(0)} '
                intput = self._to_token(int(input.strip()))
                
                if intput in IGNORE_TOKENS: continue
                if intput == 'ERROR_TOKEN':
                    self.error_token()
                
                self._stack += input
                self.derivation.append(self._stack)                                
                lookahead = input_sequence[0] if input_sequence else None
                
                k += 1 
                self._stack_idx += 1
            else:
                finished = True
            
            while True:
                result = self.find_rule(self._stack, input=input, lookahead=lookahead)              
                if not result: break
                self._int_map
                self._reduce(result)
                self.derivation.append(self._stack)
                input = EMPTY # Input is consumed
       
        if len(self._stack.strip().split()) == 1:
        
            print(f'[BOOP] Succesfully parsed file\nElapsed time: {time() - start_time}s')
            self.save_derivation()
                        
        else:
            """ Handle syntax errors
            """
            print(f'[BOOP] SyntaxError')
            
    def save_derivation(self):
        """ Save the derivations as a text file.
        """
        if not self.enable_derivation: return
        
        text = ''
        path = os.path.join(cwd, 'derivations', f'{os.path.splitext(os.path.basename(self.path))[0]}.txt')
                    
        for line in self.derivation:
            seq = []
            for num in line.split():
                seq.append(self._to_token(int(num.strip())))
            
            text += (f'{" ".join(seq)}\n')
            
        with codecs.open(path, 'w', encoding='utf-8') as file:
            file.write(f'Generated derivation\n\n')
            file.write(text)
