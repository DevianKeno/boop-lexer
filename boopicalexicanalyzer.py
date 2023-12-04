from __future__ import annotations
import codecs
from tokens import *

__author__ = 'Gian Paolo B.'
DEFAULT_FILENAME = 'symbol_table.txt'
TABLE_COLUMN_WIDTH = 24

#TODO: unknown character

def isspcl(char: str) -> bool:
    """Return True if the string is a special character string, False otherwise.\n
    A string is special if all characters in the string are special characters and there is at least one character in the string."""
    if len(char) == 0: return False
    for c in char:
        if not c in SPECIAL_CHARACTERS:
            return False
    return True

class Boopicalexican:
    """Lexical analyzer for the BOOP language.
    
    This analyzer scans each character ...
    """
    class symbol:
        """Represents a lexeme and its corresponding token.
        """
        def __init__(self, lexeme: str, token: str) -> None:
            self.lexeme: str = lexeme
            self.token: str = token
                    
        def __repr__(self) -> str:
            return f'[\'{self.lexeme}\', \'{self.token}\']'
            
        def __str__(self) -> str:
            return f'[\'{self.lexeme}\', \'{self.token}\']'
    
    class SymbolTable:
        """Symbol table output of the Boopicalexican.
        """
        def __init__(self):
            self._rows: list[Boopicalexican.symbol] = []

        def add_symbol(self, symbol: Boopicalexican.symbol):
            if symbol == None:
                return
            self._rows.append(symbol)

        def add_symbols(self, symbols: list[Boopicalexican.symbol]):
            if symbols:
                self._rows.extend(symbols)

        def show(self):
            for symbol in self._rows:
                print(symbol)
                
        def get_info(self) -> str:
            return f"""Total symbols: {len(self._rows)}\n"""
        
        def __str__(self) -> str:
            string: str = ''
            for row in self._rows:
                string += f'{row.lexeme:<{TABLE_COLUMN_WIDTH}s} {row.token:<{TABLE_COLUMN_WIDTH}s}\n'
            return string

    def __init__(self):
        self.symbol_table = self.SymbolTable()
        self.tokenize_comments: bool = True
        """If to include the comment delimiters as tokens in the output table."""
        
        self._content: str = []
        self._lines: list[str] = []
        self._stack: list[Boopicalexican.symbol] = []
        self._prev: str = ''
        self._delim: str = ''
        self._literal_buffer: str = ''
        self._in_quotes: bool = False
        self._in_comments: bool = False
        """Flag if the lexer is currently in comments."""
        self._in_line_comment: bool = False
        """Flag for inline comments."""
        self._in_multi_comment: bool = False
        """Flag for multi-line comments."""
        
    def _add_stack(self, symbol: symbol):
        """Adds symbol to the stack.
        """
        if symbol == None: return
        self._stack.append(symbol)
        
    def _tokenize(self, lexeme: str) -> symbol:
        if lexeme.isalpha():
            if lexeme in KEYWORDS:
                return Boopicalexican.symbol(lexeme, 'KEYWORD')
            if lexeme in RESERVED_WORDS:
                return Boopicalexican.symbol(lexeme, 'RESERVED_WORD')
            if lexeme in ALIASES:
                return Boopicalexican.symbol(lexeme, 'ALIAS')      
            return Boopicalexican.symbol(lexeme, 'IDENTIFIER')
                  
        if lexeme.startswith(IDENTIFIER_STARTER_CHARMAP):
            return Boopicalexican.symbol(lexeme, 'IDENTIFIER')
            
        if lexeme.isdigit():
            return Boopicalexican.symbol(lexeme, 'NUM_LITERAL')
        
        if isspcl(lexeme):
            if lexeme in DELIMITERS:
                return (Boopicalexican.symbol(lexeme, DELIMITERS[self._prev]))
            
            if lexeme in OPERATORS:
                return (Boopicalexican.symbol(lexeme, OPERATORS[self._prev]))
                
            if lexeme in MATH_SYMBOLS:
                return Boopicalexican.symbol(lexeme, MATH_SYMBOLS[self._prev])
                
            if lexeme in SPECIAL_CHARACTERS:
                return Boopicalexican.symbol(lexeme, SPECIAL_CHARACTERS[self._prev])
            
        return None

    def _parse_delim(self, delim: str):
        """Parse delimiter functionalities.
        """
        self._delim = delim
        
        # Some lines here are useless due to refactoring
        match delim:
            case '//' | '/*' | '*/':
                match delim:
                    case '//':
                        self._in_comments = True    
                        self._in_line_comment = True    
                    case '/*':
                        self._in_comments = True    
                        self._in_multi_comment = True
                    case '*/':
                        self._in_comments = False    
                        self._in_multi_comment = False
                                
                if self.tokenize_comments:
                    self._add_stack(Boopicalexican.symbol(self._prev, DELIMITERS[self._prev]))
                    
            case '\n':
                if self._in_line_comment:
                    self._in_line_comment = False
                    
            case '\"':
                self._in_quotes = not self._in_quotes
                self._add_stack(Boopicalexican.symbol(self._prev, DELIMITERS[self._prev]))
                
            case _:
                self._add_stack(Boopicalexican.symbol(self._prev, DELIMITERS[self._prev]))
            
    def _add_buffer(self):
        if not self._prev:
            return
        self._add_stack(self.tokenize(self._prev))
        self._prev = ''
                
    def _parse_buffer(self, lexeme: str) -> symbol:
        return self.tokenize(lexeme)
            
    def _parse_char(self, char: str):
        """Parse character with the previous character (if there is one).
        """
        #region This needs cleaning :v
        if self._delim:
            if self._delim == '//':
                if char == '\n':
                    self._delim = ''
                    return
                return
            
            if self._delim == '/*':
                if self._prev and char == '/':
                    self._prev = ''
                    self._delim = ''
                    self._add_stack(Boopicalexican.symbol('*/', 'COMMENT_MULT_END'))
                    return
                elif char == '*':
                    self._prev += char
                    return
                else:
                    return
            
            if self._delim == '\"':
                if self._in_quotes:
                    if char == '\"':
                        self._in_quotes = not self._in_quotes
                        self._add_stack(Boopicalexican.symbol(self._literal_buffer, 'STRING_LITERAL'))
                        self._add_stack(Boopicalexican.symbol('\"', 'DOUBLE_QUOTE'))
                        self._literal_buffer = ''
                        self._delim = ''
                        return
                    self._literal_buffer += char
                    return
        #endregion
        
        if char == ' ': # is space
            self._add_buffer()
            return

        if char in WHITESPACE:
            return

        if char.isalpha() or char in IDENTIFIER_STARTER_CHARMAP:
            if self._prev.isalpha() or self._prev.startswith(IDENTIFIER_STARTER_CHARMAP) or self._prev == '':
                self._prev += char
                return
            
            if self._prev.isdigit():
                self._add_buffer()
                self._add_stack(Boopicalexican.symbol(char, 'NUM_SUFFIX'))
                return
        
        if char.isdigit():            
            if self._prev.isdigit() or self._prev == '':
                self._prev += char
                return
            
            if self._prev[0] in IDENTIFIER_STARTER_CHARMAP:
                self._prev += char
                return
            
        if isspcl(char):
            if isspcl(self._prev) or self._prev == '':
                self._prev += char
                
                if self._prev in DELIMITERS:
                    """Delimiters are parsed immediately."""
                    self._parse_delim(self._prev)
                    self._prev = ''
                    return
                if self._prev in OPERATORS:
                    return                    
                if self._prev in MATH_SYMBOLS:
                    return                    
                if self._prev in SPECIAL_CHARACTERS:
                    return
                
                self._prev = self._prev[:-1]
                self._add_buffer()
                self._parse_char(char)
                return
            
        self._add_buffer()
        self._prev += char
        return        
    
    def _parse_by_char(self):
        """Read file by character.
        """
        if not self._content:
            return
        
        for char in self._content:
            self._parse_char(char)
                            
        self.symbol_table.add_symbols(self._stack)
        return self._stack
    #region public    
    
    def open(self, filepath: str) -> bool:
        """Open a .boop file, and store its contents for further operations.\n
        Returns True upon no errors.
        """
        if not filepath.endswith(".boop"):
            raise Exception("Input file must be a type of .boop")
        
        f = codecs.open(filepath, 'r', 'utf-8')
        self._content = f.read()
        self._lines = f.readlines()
        f.close()
        return True
    
    def read(self, filepath: str) -> SymbolTable:        
        """Lexical analyze a .boop file.
        """
        if not self.open(filepath):
            return        
        return self.parse()
    
    def parse(self) -> SymbolTable:
        """Parse all lines of the file.\n
        Returns a SymbolTable object.
        """
        if not self._content:
            return
        self._parse_by_char()
        self.save()        
        return self.symbol_table    
        
    def tokenize(self, lexeme: str) -> symbol:
        """Check the lexeme if in valid tokens.\n
        Returns a SymbolObject if valid, returns None otherwise.
        """
        return self._tokenize(lexeme)
    
    def get_line(self, index: int) -> str:
        if not self._lines:
            return None
        return self._lines[index]
    
    def parse_index(self, index: int) -> SymbolTable:
        """Parse a line via index.
        """
        table = self.SymbolTable()
        table.add_symbols(self._parse_by_char(self.get_line(index)))
        return table
    
    def parse_string(self, line: str) -> SymbolTable:
        """Parse a single line of BOOP code.\n
        This is used when changes are made to one specific line of code, to avoid reading the whole file again.
        """
        table = self.SymbolTable()
        table.add_symbols(self._parse_by_char(line))
        return table
    
    def save(self, filename: str = DEFAULT_FILENAME):
        """Save the output SymbolTable to file.
        """
        file = open(filename, 'w')
        file.write(self.symbol_table.get_info())
        file.write(self.symbol_table.__str__())
        file.close()
    #endregion
    
if __name__ == '__main__':
    Lexer = Boopicalexican()
    # Change directory to your directory ;)
    # Lexer.open('D:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/test.boop')
    Lexer.open('D:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/complex.boop')
    Lexer.parse()
    Lexer.save()
    input()