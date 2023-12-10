
from __future__ import annotations
import os
from utils import *
from lexer import Lexer

cwd = os.getcwd()

class Semantics:
    
    class Rule:
        
        def __init__(self, name: str) -> None:
            self.name = name
            self.tokens: list[Lexer.Token]
            pass
        
        def add(self):
            pass
        pass
    
    def __init__(self) -> None:
        self.content: str = EMPTY
        self._prev: str = EMPTY
        pass
    
    def _init_tokens(self):
        pass
    
    def _read_rules(self):
        path = os.path.join(cwd, 'boop.g4')
        with open (path, 'r', encoding='utf-8') as file:
            self.content = file.read()
        pass
    
    def _read(self):
        
        for char in self.content:
            
            if isalpha(char) or self._prev == EMPTY:
                if isalpha(self._prev) or isidentifier(self._prev):
                    self._prev += char
                    return
                
            if char == COLON:
                self._new_rule = Semantics.Rule(self._prev)
                return
            
            if char == SEMICOLON:
                self._new_rule.add(self._prev)
                return
                
                
            
                
            
            
        pass
    
    def parse(self, table: Lexer.SymbolTable):
        
        
        pass
    
    pass

