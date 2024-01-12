
from __future__ import annotations
import os
from utils import *
from tokens.tokens import *

cwd = os.getcwd()

rules_path = 'boop.g4'

OPTIONAL = QUESTION_MARK
CLOSURE_KLEENE = ASTERISK
CLOSURE_POSITIVE = PLUS

def isrulename(string: str) -> bool:
    """ Returns True if the string is a valid rule name, False otherwise or if empty.\n
        - starts with an alphabet (a-z, A-Z)
        - does not start with a digit (0-9)\n
        An rule name may have trailing digits or underscores only after a valid starting character."""
    if not string: return False
    if not (isalpha(string[0]) or string[0]): return False
    for char in string[1:]:
        if not (char in IDENTIFIER_CHARMAP): return False
    return True

class Syntaxer:
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
        self._prev: str = EMPTY
        self._repr_itr: int = 0
        self._token_repr: dict[str, int] = {}
    
    def _init(self):
        
        pass
    
    def _token_to_int(self, string: str):
        """Represent token as integer value.
        """
        self._token_repr.update({string, self._repr_itr})
        self._repr_itr += 1
    
    def _init_tokens(self):
        pass
        
    def _read_rules(self):
        path = os.path.join(cwd, rules_path)
        with open (path, 'r', encoding='utf-8') as file:
            self.content = file.read()
    
    def _read(self):
        """Reads the rules file and converts all tokens into integer representations.
        """        
        for char in self.content:
            if char == SPACE:
                if self._prev.isupper(): # force token
                    self._token_to_int(self._prev)
                    return
                    
                if self._prev.islower(): # rule
                    return                
                
                if self._new_rule and not self._prev == EMPTY:
                    self._new_rule.set_next(self._token_repr[self._prev])
                return
            
            if char == CLOSURE_KLEENE:
                if self._prev:
                    pass
            
            if char == CLOSURE_POSITIVE:
                if self._prev:
                    pass
                
            if char == OPTIONAL:
                if self._prev:
                    pass        
            
            if self._new_rule:
                self._prev += char
                return
            
            if isalpha(char) or self._prev == EMPTY:
                if isalpha(self._prev) or isrulename(self._prev):
                    self._prev += char
                    return
                
            if char == COLON:
                self._new_rule = Syntaxer.Rule(name=self._prev)
                self._prev = EMPTY
                return
            
            if char == SEMICOLON:
                self.push_rule(rule=self._new_rule)
                self._prev = EMPTY
                return
            
        pass

    def push_rule(self, rule: Rule):
        pass
    
    def parse(self, table):
        
        # for table in table.token:
            
        #     pass
        pass

