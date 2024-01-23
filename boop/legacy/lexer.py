from __future__ import annotations
from tokens import *

__author__ = "Gian Paolo B."

#TODO: unknown character
#TODO: string literals in quotes

class Boopicalexican:
    """Lexical analyzer module for the BOOP language.
    
    This analyzer first separates the content into lines, then it separates all lexemes that are space-separated,
    before parsing lexemes that are not.
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
            return f"""Total symbols: {len(self._rows)}\n
"""
                
        def to_str(self) -> str:
            string: str = ''
            for row in self._rows:
                string += f'{row}\n'
            return string

    def __init__(self):
        self._symbol_table = self.SymbolTable()
        self._contents: list[str] = []
        self._stack: list[Boopicalexican.symbol] = []
        self._buffer: Boopicalexican.symbol = None
        self._delim: str = ''
        self.tokenize_comments: bool = True
        """If to include the comment delimiters as tokens in the output table."""
        self._in_comments: bool = False
        """Flag if the lexer is currently in comments."""
        self._in_line_comment: bool = False
        """Flag for inline comments."""
        self._in_multi_comment: bool = False
        """Flag for multi-line comments."""
        self._in_quotes: bool = False
        self._compound_lexemes: list[str] = []
        """Compound lexemes represent lexemes that are not space-separated.\n
        e.g. 'MyFunction()->string;' where the lexemes should be ['MyFunction', '(', ')', '->', 'string', ';']."""
        self._prev: str = ''
        
    def _add_stack(self, symbol: symbol):
        """Adds symbol to the stack.
        """
        self._prev = ''
        self._stack.append(symbol)

    def _add_buffer_to_stack(self):
        if self._buffer:
            self._stack.append(self._buffer)  
            self._clear_buffer()

    def _set_buffer(self, symbol: symbol):
        self._buffer = symbol
            
    def _clear_buffer(self):
        self._buffer = None
        self._prev = ''
        pass
        
    def _clear_stack(self):
        self._compound_lexemes = []
        self._stack = []
    
    def _end_line(self):
        """Conclude line parsing, reset all flags that need to be reset.
        """
        self._in_line_comment = False
        self._symbol_table.add_symbols(self._stack)
        self._clear_stack()
        self._prev = ''
        
    def _check_comments(self):
        pass
    
    def _handle_delims(self, obj) -> bool:            
        if self._in_comments:
            if self._in_line_comment:
                return True
            
            # Search the current line for the delimiter
            if self._in_multi_comment:
                if not isinstance(obj, str): 
                    return True 
                if (index := self.find_delim(obj, '*/')) != -1:
                    self._done_comment()
                    self._parse_lexemes(obj[index:])
                return True

        return False
        
    def _parse_lexemes(self, obj: str | list[str]) -> list[symbol]:
        """Tokenizes lexemes from a string.\n
        Returns a list of symbols.
        """
        self._compound_lexemes = []
        
        if isinstance(obj, str):
            lexemes = obj.strip().split(' ')
        elif isinstance(obj, list):
            lexemes = obj
        else:
            raise Exception("Invalid argument!")
            
        for lexeme in lexemes:
            if self._handle_delims(lexeme):
                break
                        
            if symbol := self._tokenize(lexeme):
                self._stack.append(symbol)   
            
            # Parse compound lexemes 
            if self._compound_lexemes:
                self._parse_lexemes(self._compound_lexemes)
                
            if self._handle_delims(lexeme):
                break
            
        return self._stack
    
    def _done_comment(self):
        self._in_comments = False
                    
    def find_delim(self, string: str, delim: str) -> int:
        """Find the delimiter in the string.\n
        Returns the lowest index if found, returns -1 otherwise.
        """
        return string.find(delim)

    def _parse_delim(self, delim: str):
        """Parse delimiter functionalities.
        """
        self._flag_delim = True
        self._delim = delim
        
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

    def _parse_compound(self, string: str) -> list[str]:
        """Separate given string into lexemes of:
        - consecutive alphabet characters
        - consecutive alphabet characters that start with '_'
        - consecutive digits
        - each special character
        """
        compound_lexemes: list[str] = []
        _lexeme = ''
        
        for char in string:
            if char.isalpha() or char == '_' or (char.isalnum() and _lexeme.startswith('_')):
                _lexeme += char
                
            elif char.isdigit():
                _lexeme += char
                
            else:
                if _lexeme:
                    compound_lexemes.append(_lexeme)
                    _lexeme = ''
                compound_lexemes.append(char)
        
        if _lexeme:
            compound_lexemes.append(_lexeme)
            
        return compound_lexemes    
    
    def _parse_char(self, char: str):
        """Parse character with the previous character (if there is one).
        """
        if len(self._prev) >= MAX_OPERATOR_LENGTH:
            #TODO: handle logic
            pass
        
        self._prev += char
                    
        if self._prev in DELIMITERS:
            self._parse_delim(self._prev)
            self._clear_buffer()
            return
        
        if self._prev in OPERATORS:
            self._buffer = Boopicalexican.symbol(self._prev, OPERATORS[self._prev])
            return
        
        if self._prev in MATH_SYMBOLS:
            self._buffer = Boopicalexican.symbol(self._prev, MATH_SYMBOLS[self._prev])
            return
        
        # Unknown operators or delimiters be classified as special character nalang :D
        if self._prev in SPECIAL_CHARACTERS:
            self._buffer = Boopicalexican.symbol(self._prev, SPECIAL_CHARACTERS[self._prev])
            return

        self._add_buffer_to_stack()
        self._parse_char(char)
        return

    def _tokenize(self, lexeme: str) -> symbol | None:
        """Check if lexeme is in the list of valid tokens.\n
        Returns a symbol object if valid, returns None otherwise.
        """
        if len(lexeme) > 1:        
            self._add_buffer_to_stack()        
                    
            if lexeme.isdigit():
                return Boopicalexican.symbol(lexeme, 'num_literal')
            
            if lexeme.isalpha() or (lexeme.isalnum() and lexeme.startswith('_')):
                if self._in_quotes:
                    return Boopicalexican.symbol(lexeme, 'string_literal')
                
                if lexeme in KEYWORDS or lexeme in RESERVED_WORDS:
                    return Boopicalexican.symbol(lexeme, 'keyword')
                else:
                    return Boopicalexican.symbol(lexeme, 'identifier')    
                 
            # else lexeme may be a compound, which needs further parsing
            self._compound_lexemes = self._parse_compound(lexeme)
            return None
        else:
            if lexeme in SPECIAL_CHARACTERS:
                self._parse_char(lexeme)
                return None
            #TODO: handle unknown character
            return None
        
    #region public    
    def open(self, filepath: str):
        """Open a .boop file, and store its contents for further operations.
        """
        if not filepath.endswith(".boop"):
            print("Unsupported file extension.")
            return False
        
        with open(filepath) as file:
            self._contents = file.readlines()
            file.close()
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
        if not self._contents:
            return
        
        for line in self._contents:
            self._parse_lexemes(line)
            self._end_line()
            
        # self.save()
        return self._symbol_table
    
    def get_line(self, index: int) -> str:
        if not self._contents:
            return None
        return self._contents[index]
    
    def parse_line_by_index(self, index: int) -> list[symbol]:
        """Used to read a line via index.
        """
        if not self._contents:
            print("No content found.")
            return
        
        lexemes = self._contents[index].strip().split(' ')
        return self._parse_lexemes(lexemes)
    
    def parse_line(self, line: str) -> SymbolTable:
        """Parse a single line of BOOP code.\n
        This is used when changes are made to a specific line of code, to avoid reading the whole file again.
        """
        _table = self.SymbolTable()
        # Store space-separated lexemes into a list
        lexemes = line.strip().split(' ')
        _table.add_symbols(self._parse_lexemes(lexemes))
        return _table
    
    def save(self):
        file = open('symbol_table.txt', 'w')
        file.write(self._symbol_table.get_info())
        file.write(self._symbol_table.to_str())
        file.close()
        pass
    #endregion
    
if __name__ == '__main__':
    Lexer = Boopicalexican()
    # Change directory to your directory ;)    
    Lexer.open('D:/PUP/Documents/3rd year 1st sem/PPL/boopicalexan/test.boop')
    output = Lexer.parse()
    output.show()
    
    input()