import os
from boop.lexer import Lexer
from boop.parser import Parser

# Setup file path
cwd = os.getcwd()
filename = 'code/complex.boop'
filepath = os.path.join(cwd, filename)
    
if __name__ == '__main__':    
    lexer = Lexer()
    # lexer.allow_external_files(True)
    # lexer.tokenize_keywords = False
    output = lexer.parse(filepath)
    
    # parser = Parser()
    # parser.parse(output)
    