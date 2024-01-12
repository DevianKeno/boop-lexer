 
class Token:
    """Represents a lexeme and its corresponding token."""
    def __init__(self, lexeme: str, token: str, line: int = None, col: int = None) -> None:
        self.lexeme: str = lexeme
        self.token: str = token
        self.line: int = line
        self.col: int = col
                
    def __repr__(self) -> str:
        return f'[\'{self.lexeme}\', \'{self.token}\']'
        
    def __str__(self) -> str:
        return f'[\'{self.lexeme}\', \'{self.token}\']'

class ErrorToken:
    """Represents an error token."""
    
    #region Errors
    INVALID_CHARACTER = """Invalid character"""
    INVALID_ESCAPE_SEQ = """Invalid escape sequence"""
    UNCLOSED_LITERAL = """Unclosed string literal"""
    NEWLINE_LITERAL = """New line in string literals are not allowed"""
    #endregion
    
    def __init__(self, token: Token, msg: str = None) -> None:
        self.msg: str = msg
        self.lexeme: str = token.lexeme
        self.token: str = token.token
        self.line: int = token.line
        self.col: int = token.col
    
    def __str__(self) -> str:
        return f'[ErrorToken]: Invalid token in ln {self.line}, col {self.col}\n\t{self.msg}\n'        