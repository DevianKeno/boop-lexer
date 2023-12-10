import boopicalexicalanalyzer as boop_lexer

if __name__ == '__main__':
    Lexer = boop_lexer.Lexer()
    # Change directory to your directory ;)
    Lexer.open('D:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/code samples/abs.boop')
    Lexer.parse()