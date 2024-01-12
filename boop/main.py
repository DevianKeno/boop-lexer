
import os
from lexer import Lexer

if __name__ == '__main__':
    cwd = os.getcwd()
    filename = 'code/complex.boop'
    filepath = os.path.join(cwd, filename)
    
    lexer = Lexer()
    lexer.open(filepath)
    lexer.parse()
    output = lexer.syntaxisize()
    
    