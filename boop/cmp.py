
from boop.lexer import Lexer
from boop.parser import Parser

class Compiler:
    
    def __init__(self):
        self.lexer = Lexer()
        self.parser = Parser()
        
        self.lexer.parser = self.parser
        self.parser.lexer = self.lexer
       
    def parse(self, filepath: str):
        symbol_table = self.lexer.parse(filepath)        
        self.parser.path = filepath
        self.parser.parse(symbol_table)