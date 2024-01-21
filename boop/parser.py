
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

def isrulename(string: str) -> bool:
    """ Returns True if the string is a valid rule name, False otherwise or if empty.\n
        - starts with an alphabet (a-z, A-Z)
        - has no special characters
        - not all caps
    """
    if not string: return False
    if string[0] not in ALPHABET: return False
    if str.isupper(string): return False
    return isalpha(string)

def istoken(string: str) -> bool:
    pass

def separate(input: str) -> list[str]:
    pattern = r'(\w+|[^\w\s])'
    return re.findall(pattern, input)

def separate_from_symbols(input: str) -> list[str]:
    return re.findall(r'\b\w+\b|\'[^\']*\'', input)

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
        
        self._firsts: dict[str, set] = {}
        self._rulestrs: list[str] = EMPTY
        self._int_map = {}
        self._rule_int_sequences: dict[str, list[int]] = {}
        self._sequences: dict[int, set] = {}
        
        self._prev: str = EMPTY
        self._repr_idx: int = 0
        self._token_repr: dict[str, int] = {}
        
        self._preprocess()
    
    def _init(self):
        
        pass
    
    def _token_to_int(self, string: str):
        """ Represent token as integer value.
        """
        self._token_repr.update({string, self._repr_idx})
        self._repr_idx += 1
        
    @property
    def token_repr_count(self) -> int:
        return len(self._token_repr)
    
    def _get_rule_int_sequence(self, rulename: str) -> list[list[int]]:
        sequence = []
        
        for i, grammar in enumerate(self.rules[rulename]):
            sequence.append([])
            for j, word in enumerate(separate_from_symbols(grammar)):
                sequence[i].append(self._int_map[word])
                
        return sequence
    
    def _get_sequence(self, token: str) -> list[int]:                                
        if isrulename(token):
            return self._get_rule_int_sequence(token)
        else:
            return self._int_map[token]

    
    def _init_tokens(self):
        pass
    
    def _to_sequence(self, rule):
        pass
    
    def _powerlist(self, to: list, by: list[list]) -> list[list]:
        
        if isinstance(by, list[list]):
            new_seq = [to.copy() for _ in range(len(by))]
            for i, sequence in enumerate(by):
                new_seq[i].extend(sequence)
            to = new_seq
        elif isinstance(by, list):
            for sequence in enumerate(to):
                sequence.append(by)
        elif isinstance(by, int):
            sequence.append(by)
            
        return to
        
    def _preprocess_rules(self):
        rules = self.content.split(';')
        
        # Map tokens to integers
        for rule, value in TOKENS.items():
            self.tokens[value] = rule
            
        for rule, value in SPECIAL_CHARACTERS.items():
            self.tokens[value] = rule
            
        for rule, value in KEYWORDS.items():
            self.tokens[value] = rule
        
        for rule, value in OPERATORS.items():
            self.tokens[value] = rule
            
        for rule, value in DELIMITERS.items():
            self.tokens[value] = rule
        
        # Separate individual rules
        for rule in rules:
            rule = rule.strip() # Remove new lines                        
            if rule.startswith("#") or rule.startswith('//') or not rule: continue # Disregard region markers and comments
            
            rule, content = map(str.strip, rule.split(':', 1))
            content = [word.strip() for word in content.split('|')] # Split OR, basically rules with two or more grammars(?)
            
            self.rules[rule] = content

        # Create token-integer mapping
        for i in self.tokens:
            self._int_map[i] = len(self._int_map) + 1
        for i in self.rules:
            self._int_map[i] = len(self._int_map) + 1

        # Get rule firsts
        for rule in self.rules.keys():
            self._firsts[rule] = self._get_firsts(rule)            

        # Create rule integer sequences mapping
        for rule in self.rules.keys():
             self._parse_rule(rule)
            
        var = self._sequences
        print()
            # for grammar in content: # content refers to the rules separated by '|'
            #     var = self._parse_grammar(grammar)
                
            #     self._rule_int_sequences.append(var)
                # current_sequence = [self._int_map[token_sequence[0]]]
                # # Parse token sequence
                # for i, token in enumerate(token_sequence):
                    
                #     self._parse_token(token)
                    
                    
                #     if isrulename(token):
                #         if not self.rules[token]:                            
                #             raise Exception(f"[GrammarError]: No grammar defined for rule [{token}]")
                                                
                #         # Check if rule already exists as an integer sequence
                #         if token not in self._rule_seq_dict:
                #             var = self._get_rule_int_sequence(token)                                                
                            
                            
                            
                #         # current_sequence = self._powerlist(current_sequence, self._rule_seq_dict[token])                                
                                                
                #     else:
                #         if (i + 1) < len(token_sequence):
                #             current_sequence.append(self._int_map[token_sequence[i + 1]])
                    
                # if current_sequence: # Append if not empty sequence
                #     self._rule_int_sequences.append(current_sequence)
            
        # """ Convert rule integer sequence mapping to individual sequences. 
        # """
        # for grammar_sequence in self._rule_sequences.values():
        #     for token_sequence in grammar_sequence:
        #         for i, token in enumerate(token_sequence):
        #                 if i + 1 < len(token_sequence):
        #                     self._sequences.setdefault(token, set()).add(token_sequence[i + 1])
        #         pass 
                
        #region Debugging only, can be removed
        self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        print()
        #endregion

    def _parse_rule(self, rulename: str) -> set:                        
        if not (content := self.rules[rulename]):
            raise Exception(f"[GrammarError]: There is no such rule [{rulename}]")
        
        sequences = set()
        for grammar in content: # content refers to a list of grammars separated by '|'           
            sequences = sequences | self._parse_grammar(grammar)
                        
        return sequences
            
    def _get_firsts(self, rulename: str) -> list:
        """ Retrieve the rule's "first" tokens. 
        """
        if not (content := self.rules[rulename]): # Check if rule exists
            raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
        
        firsts = set()
        
        for grammar in content:
            firsts = firsts | self._parse_grammar_firsts(grammar)
            
        return firsts
    
    def _to_int(self, token: str) -> int:
        if result := self._int_map[token]:
            return result
        raise Exception(f"[GrammarError]: No token [{token}].")        
    
    def _parse_grammar_firsts(self, grammar: str) -> set:
        if not (token_sequence := separate_from_symbols(grammar)):
            raise Exception(f"[GrammarError]: A rule cannot be empty.")
        
        result = set()
        
        if isrulename(token_sequence[0]):
            result = result | self._get_firsts(token_sequence[0])
        else:
            result.add(self._to_int(token_sequence[0]))
        
        return result
    
    def _parse_grammar(self, grammar: str) -> set:        
        
        # This is just temporary. Ideally, the closures should also be taken into account
        # This will be eventually changed to handle closures and optionals
        if not (token_sequence := separate_from_symbols(grammar)):
            raise Exception(f"[GrammarError]: A rule cannot be empty.")
                
        sequence = set()
        for i, token in enumerate(token_sequence):
            
            if len(token_sequence) == 1:
                if isrulename(token):
                    return self._firsts[token]
                else:
                    pass
            
            if (i + 1) < len(token_sequence): # Check if there is still next token                
                from_ = self._to_int(token)
                    
                if isrulename(token): # Get firsts                    
                    self._add_sequence(from_, self._firsts[token])
                else: # is token
                    to = set()
                    to.add(self._to_int(token_sequence[i + 1]))
                    self._add_sequence(from_, to)
            else: # There is just one token
                pass
                            
        return sequence
    
    def _add_sequence(self, from_, to):
        var = self._sequences.setdefault(from_, set())
        self._sequences[from_] = var | to
    
    def _parse_token(self, token: str) -> list[int]:
        """ 
        """        
        
    def _preprocess(self):
        path = os.path.join(cwd, 'boop/grammar/declarations.boop')
        
        with open(path, 'r', encoding='utf-8') as file:
            self.content = file.read()
            
        self._preprocess_rules()
            
    def parse(self, table: SymbolTable):
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        
        for i, symbol in enumerate(input_sequence):
            if i + 1 >= len(input_sequence): break # end of input
            
            look_ahead = input_sequence[i + 1]
            possible_nexts: list[int] = self._sequences[symbol]   
            
            if look_ahead in possible_nexts:
                continue
            else:
                raise Exception("Syntax error")
        
        print("Successful parse") # pause debug
