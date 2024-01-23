
from __future__ import annotations
import os
import re
import collections
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
    pattern = re.compile(r'([()+*?]|\b\w+\b)')
    var = [match.group() for match in pattern.finditer(input)]
    return var

class Parser:
    """ 1. Convert tokens into integer representations.
        2. Check if the current token and preceding token is in valid rules.
    """
    class Rule:
        
        def __init__(self, name: str) -> None:
            self.name = name
            self.token_seq: list[int] = {}
            pass
        
        def set_next(self, string: str):
            
            pass
        pass
    
        def __repr__(self) -> str:
            return 'rule'
    
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
        path = os.path.join(cwd, 'boop/grammar/declarations.boop')
        
        with open(path, 'r', encoding='utf-8') as file:
            self.content = file.read()
            
        self._preprocess_rules()
    
    def _preprocess_rules(self):
        rules = self.content.split(';')
        
        # Map tokens to integers
        for nonterminal, value in TOKENS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in SPECIAL_CHARACTERS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in KEYWORDS.items():
            self.tokens[value] = nonterminal
        
        for nonterminal, value in OPERATORS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in DELIMITERS.items():
            self.tokens[value] = nonterminal
        
        # Separate individual rules
        for nonterminal in rules:
            nonterminal = nonterminal.strip() # Remove new lines                        
            if nonterminal.startswith("#") or nonterminal.startswith('//') or not nonterminal: continue # Disregard region markers and comments
            
            nonterminal, rules = map(str.strip, nonterminal.split(':', 1))
            rules = [word.strip() for word in rules.split('|')] # Split OR, basically rules with two or more grammars(?)
            
            self.rules[nonterminal] = rules

        # Create token-integer mapping
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
                    var = "  ".join(seq.split()[:-1])
                    new_list.append(f' {var} ' if var else '') # Minus the previous token
                sequences = new_list
                continue
            
            for j, s in enumerate(sequences):
                sequences[j] = sequences[j] + f' {self._to_int(token)} '
            continue
            # if token == LEFT_PAREN:
            #     result = self._parse_subrule(lhs, token_sequence, i + 1)                
            #     result = self._rule_to_int_seq(lhs, self.subrules[result[0]])
            #     continue
                                
            # if token == CLOSURE_KLEENE:
            #     continue
                
            # if token == CLOSURE_POSITIVE:
            #     continue
                
            # if token == OPTIONAL:
            #     continue                       
        return sequences
   
    def _to_int(self, token: str) -> int:
        if result := self._int_map[token]:
            return result
        raise Exception(f"[GrammarError]: Unknown token [{token}].")
    
    def _to_token(self, value: int) -> str:
        if value == None or value == EMPTY: return
        if result := self._token_map[value]:
            return result
        raise Exception(f"[GrammarError]: Unknown int mapping [{value}].")
    
    def find_rule(self, key: str) -> tuple[bool, str, int, int]:
        # This is fucked up, needs optimizing
        matches = []
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            # Check if a substring exists as rhs in any rule
            if not (index := key.find(rhs)) == -1:
                matches.append((True, nonterminal, index, len(rhs)))
                
                continue       
        return matches
    
    def match_rule(self, key: str) -> tuple[bool, str, int, int]:
        """ Returns the nearest production rules given an input.
        """
        # This is fucked up, needs optimizing
        matches = []
        for nonterminal, rhs in self._nonterminal_int_seq.items():
            # Check if a substring exists as rhs in any rule
            if not (index := rhs.find(key)) == -1:
                matches.append((True, nonterminal, index, len(rhs)))
                
                continue       
        return matches
    
    def parse(self, table: SymbolTable):
        if table == None: return
        
        tree = ''
        
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        stack = ''
        stack_view = ''
        
        self.buffer = None
        finished = False
        j = 0
        while j < len(input_sequence) or stack:
            if finished:
                break
            
            # if (j + 1) < len(input_sequence):
            #     look_ahead = f' {input_sequence[j + 1]} '
            
            # Shift
            if input_sequence:
                var = f' {input_sequence.pop(0)} '
                stack += var
                ### DEBUG
                stack_view = self._to_token(int(var.strip()))
                ###
                
                j += 1
            else:
                finished = True
                
            # Keep reducing until it's not possible anymore       
            while True:
                result = self.find_rule(stack)
                
                if not result: break
                
                if len(result) == 1:
                    result = result[0]
                    i = result[2]
                    n = result[3]
                    # Remove substring at index i of length n
                    stack = stack[:i] + stack[i + n:]
                    # Insert substring at index i of length n            
                    stack = stack[:i ] + f' {self._to_int(result[1][:-4])} ' + stack[i:]
                    continue
                
                elif len(result) >= 1:            
                    # How do I check the most appropriate production rule to choose here haha
                    
                    #????        
                    result = result[0]
                    i = result[2]
                    n = result[3]
                    # Remove substring at index i of length n
                    stack = stack[:i] + stack[i + n:]
                    # Insert substring at index i of length n            
                    stack = stack[:i ] + f' {self._to_int(result[1][:-4])} ' + stack[i:]
                    continue

        if len(stack.strip().split()) == 1:
            print('Successful parse')
        else:            
            # result = self.match_rule(stack)
            # var = self._nonterminal_int_seq[result[-1][1]]
            
            # stack = stack.split()
            # var = var.split()            
            # difference = [item for item in var if item not in stack][0]
            # expect = self._to_token(int(difference))
            # print(f'[SyntaxError]: Expected \'{expect}\'')
            print(f'[SyntaxError]')
            
        print()
                
        
