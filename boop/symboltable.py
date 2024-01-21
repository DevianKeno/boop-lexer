
from boop.config import *
from boop.token import *
from boop.tokens import *

class SymbolTable:
    """ Symbol table output of the Boopicalexican.
    """
    def __init__(self):
        self.tokens: list[Token] = []
        self.valid_tokens: list[Token] = []
        self.error_tokens: list[Token] = []

    @property
    def token_count(self):
        return len(self.valid_tokens)
    
    @property
    def err_token_count(self):
        return len(self.error_tokens)

    def add_token(self, token: Token):
        if token == None: return
        self.tokens.append(token)
        
        if isinstance(token, Token):
            self.valid_tokens.append(token)                
        elif isinstance(token, ErrorToken):
            self.error_tokens.append(token)
        return

    def add_symbols(self, symbols: list[Token]):
        for s in symbols:
            if s == None: continue
            self.tokens.append(s)
            if not s.token == ERROR_TOKEN:
                self.valid_tokens.append(s)
            else:
                self.error_tokens.append(s)

    def show(self):
        for symbol in self.tokens: print(symbol)
            
    def get_info(self) -> str:
        return f"""Valid tokens count: {self.token_count}\nError tokens count: {self.err_token_count}\n"""
    
    def __str__(self) -> str:
        string: str = EMPTY
        # string += f'Lexeme{"":<{TABLE_COLUMN_WIDTH}s}Token{"":<{TABLE_COLUMN_WIDTH}s}\n'
        for symbol in self.tokens:
            i = symbol.lexeme.rfind('\n')
            new_width = (TABLE_COLUMN_WIDTH + i + 1) if i != -1 else TABLE_COLUMN_WIDTH
            string += f'{symbol.lexeme:<{new_width}s}\t{symbol.token:<{TABLE_COLUMN_WIDTH}s}\n'                
        return string