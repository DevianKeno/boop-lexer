import lexer

if __name__ == '__main__':
    Lexer = lexer.Lexer()
    # Change directory to your directory ;)
    Lexer.open('D:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/samples/complex.boop')
    Lexer.parse()