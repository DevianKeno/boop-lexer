import os
from lexer import Lexer
from syntax import Syntaxer

if __name__ == '__main__':
    # Setup file path
    cwd = os.getcwd()
    filename = 'code/test.boop'
    filepath = os.path.join(cwd, filename)
    
    lexer = Lexer()
    # lexer.allow_external_files(True)
    output = lexer.parse(filepath)
    # output = lexer.syntaxisize()
    
    syntaxer = Syntaxer()
    syntaxer.parse(output)
    