"""Lexical analyzer for the BOOP language.\n
This analyzer scans each character ..."""

from __future__ import annotations
from tokens import *
import os
import codecs
import time

__author__ = 'Gian Paolo B.'
OUTPUT_FILENAME = 'symbol_table'
ERROR_LOG_FILENAME = 'error_log'
OUTPUT_FILETYPE = '.txt'
TABLE_COLUMN_WIDTH = 48

def isspcl(string: str) -> bool:
    """Returns True if the string consists of only special characters, False otherwise or if empty.\n"""
    return bool(string) and all(char in SPECIAL_CHARACTERS for char in string)

def isidentifier(string: str) -> bool:
    """Returns True if the string is a valid identifier, False otherwise or if empty.\n
    A string is an identifier if it
    - starts with an alphabet (a-z, A-Z) or IDENTIFIER_STARTER_CHARMAP
    - does not start with a digit (0-9)\n
    An identifier may have trailing digits only after a valid starting character."""
    if not string: return False
    if not (string[0].isalpha() or string[0] in IDENTIFIER_STARTER_CHARMAP): return False
    for char in string[1:]:
        if not (char.isalnum() or char == '_'): return False
    return True

class Lexer:
    """Open a file with open('filepath'), then parse it with parse().\n
    This will output two files, a symbol_table-filename.txt and error_log-filename.txt.
    """
              
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
        
        def __init__(self, token: Lexer.Token, msg: str = None) -> None:
            self.msg: str = msg
            self.lexeme: str = token.lexeme
            self.token: str = token.token
            self.line: int = token.line
            self.col: int = token.col
        
        def __str__(self) -> str:
            return f'Invalid token in ln {self.line}, col {self.col}\n\t{self.msg}\n'            
        
    class SymbolTable:
        """Symbol table output of the Boopicalexican."""
        def __init__(self):
            self.tokens: list[Lexer.Token] = []
            self.valid_tokens: list[Lexer.Token] = []
            self.error_tokens: list[Lexer.Token] = []

        @property
        def token_count(self):
            return len(self.valid_tokens)
        
        @property
        def err_token_count(self):
            return len(self.error_tokens)

        def add_token(self, token: Lexer.Token):
            if token == None: return
            self.tokens.append(token)
            
            if isinstance(token, Lexer.Token):
                self.valid_tokens.append(token)                
            elif isinstance(token, Lexer.ErrorToken):
                self.error_tokens.append(token)
            return

        def add_symbols(self, symbols: list[Lexer.Token]):
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
            string: str = ''
            # string += f'Lexeme{"":<{TABLE_COLUMN_WIDTH}s}Token{"":<{TABLE_COLUMN_WIDTH}s}\n'
            for symbol in self.tokens:
                i = symbol.lexeme.rfind('\n')
                new_width = (TABLE_COLUMN_WIDTH + i + 1) if i != -1 else TABLE_COLUMN_WIDTH
                string += f'{symbol.lexeme:<{new_width}s}\t{symbol.token:<{TABLE_COLUMN_WIDTH}s}\n'                
            return string

    def __init__(self):
        self.symbol_table = self.SymbolTable()
        self.tokenize_comments: bool = True
        """If to include the comment delimiters as tokens in the output table."""        
        self.rootext: tuple[str, str] = (EMPTY, EMPTY)
        """Represents the filename [0] and file extension [1]."""
        
        self._content: str = []
        self._lines: list[str] = []
        self._stack: list[Lexer.Token] = []
        self._char_idx: int = 0
        self._line_idx: int = 1
        self._col_idx: int = 1
        self._prev: str = EMPTY
        self._delim: str = EMPTY
        self._string_buffer: str = EMPTY
        self._in_quotes: bool = False
        """Flag if the lexer is currently in quotes."""
        self._prev_quotes: bool = EMPTY
        self._quote_used: bool = False
        self._in_literal: bool = False
        self._in_raw_literal: bool = False
        self._escape_char: str = EMPTY
        self._in_comments: bool = False
        """Flag if the lexer is currently in comments."""
        self._in_line_comment: bool = False
        """Flag for inline comments."""
        self._in_multi_comment: bool = False
        """Flag for multi-line comments."""
        
    def _add_stack(self, symbol: Token):
        """Adds symbol to the stack."""
        if symbol == None: return
        self._stack.append(symbol)
        self._prev = EMPTY
        
    def _tokenize(self, lexeme: str) -> Token:
        if lexeme == EMPTY: return
        if lexeme.isalpha():
            if lexeme in KEYWORDS:
                return Lexer.Token(lexeme, 'KEYWORD')
            if lexeme in RESERVED_WORDS:
                return Lexer.Token(lexeme, 'RESERVED_WORD')
            if lexeme in ALIASES:
                return Lexer.Token(lexeme, 'ALIAS')
                  
        if lexeme.startswith(IDENTIFIER_STARTER_CHARMAP):
            return Lexer.Token(lexeme, 'IDENTIFIER')
        
        if lexeme.isdigit():
            return Lexer.Token(lexeme, 'NUM_LITERAL')
        
        if isspcl(lexeme):            
            if lexeme in DELIMITERS:
                return Lexer.Token(lexeme, DELIMITERS[lexeme])
            if lexeme in OPERATORS:
                return Lexer.Token(lexeme, OPERATORS[lexeme])
            if lexeme in SPECIAL_CHARACTERS:
                return Lexer.Token(lexeme, SPECIAL_CHARACTERS[lexeme])
            
        return Lexer.Token(lexeme, 'IDENTIFIER')

    def _set_delim(self, delim) -> str:
        """Set delimiter functionality for the lexer.\n"""
        if not delim in DELIMITERS: return

        match delim:
            case '//' | '/*':
                self._in_comments = True
                match delim:
                    case '//':
                        self._in_line_comment = True
                    case '/*':
                        self._in_multi_comment = True
                
                if self.tokenize_comments:
                    self._add_stack(Lexer.Token(delim, DELIMITERS[delim]))                
                self._delim = delim
            
            case '\'' | '\"':
                self._str_buffer = EMPTY
                self._in_literal = True
                self._in_quotes = True
                self._quote_used = delim
                self._prev_quotes = delim
                self._delim = delim
                self._prev = EMPTY
                        
            case _:
                self._add_stack(Lexer.Token(delim, DELIMITERS[delim]))

    def _add_buffer(self):
        if not self._prev: return
        self._set_delim(self._prev)
        self._add_stack(self._tokenize(self._prev))

    def _parse_delim(self, char: str):
        """Execution tree for parsing delimited content.\n
        Delimited content includes:
        - string and raw literals
        - single line and multi-line comments"""
        if self._in_comments:
            if self._in_line_comment:
                self._parse_comment(char)
                return                
            if self._in_multi_comment:
                self._parse_delimited_comment(char)
                return
        
        if self._in_quotes:
            if self._in_literal:
                self._parse_literal(char)
                return            
            if self._in_raw_literal:
                self._parse_raw_literal(char)
                return
    
    def _parse_comment(self, char: str):
        if char == NEW_LINE:
            self._in_comments = False
            self._in_line_comment = False
            self._prev = EMPTY
            self._delim = EMPTY
            return
       
    def _parse_delimited_comment(self, char: str):                            
        if char == ASTERISK:
            self._prev = char
            return
        
        elif char == FORWARD_SLASH and self._prev:
            self._in_comments = False
            self._in_multi_comment = False
            self._prev = EMPTY
            self._delim = EMPTY
            
            if self.tokenize_comments:
                self._add_stack(Lexer.Token(DELIM_COMMENT_END, DELIMITERS[DELIM_COMMENT_END]))  
            return
        
        else:
            self._prev = EMPTY
            return
    
    def _parse_literal(self, char: str):
        """Parse literal string quotes."""
        if self._escape_char:
            self._handle_escape_char(char)
            return
            
        if char == self._quote_used:
            if self._string_buffer:
                """If there is already a literal, this is an end quote."""
                self._add_stack(Lexer.Token(f'{self._quote_used}{self._string_buffer}{self._quote_used}', 'STRING_LITERAL'))
                self._reset_quote_flags()
                return
            else:
                """this MIGHT be for a raw string literal.
                """
                self._prev_quotes += char
                
                if self._prev_quotes in RAW_STRING_DELIMITER:
                    self._in_literal = False
                    self._in_raw_literal = True
                    self._delim = self._prev_quotes
                    self._prev_quotes = EMPTY
                return
        
        if self._is_escape_char(char):
            self._escape_char = char
            return
        
        if (char == NEW_LINE or char == CARRIAGE_RETURN):
            error_token = Lexer.Token(f'{self._quote_used}{self._string_buffer}', ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(Lexer.ErrorToken(error_token, Lexer.ErrorToken.NEWLINE_LITERAL))
            
            self._reset_quote_flags()
            return
        
        if len(self._prev_quotes) == 2:
            """Two quotes preceded by a character that is not quote, end quote."""
            self._add_stack(Lexer.Token(f'{self._quote_used}{self._string_buffer}{self._quote_used}', 'STRING_LITERAL'))
            self._reset_quote_flags()
            self._parse_char(char)
            return
        
        self._string_buffer += char
    
    def _parse_raw_literal(self, char: str):    
        """Parse raw string quotes."""    
        if char == self._quote_used:
            self._prev_quotes += char
            
            if self._prev_quotes in RAW_STRING_DELIMITER:
                """This is an end quote"""
                self._in_raw_literal = False
                
                self._add_stack(Lexer.Token(f'{self._prev_quotes}{self._string_buffer}{self._prev_quotes}', 'RAW_LITERAL'))
                self._reset_quote_flags()
                return
            return
                
        if self._prev_quotes:
            self._string_buffer += self._prev_quotes
            self._prev_quotes = EMPTY
        
        # New lines in the language are represented only by '\n'
        if char == CARRIAGE_RETURN: return
                
        self._string_buffer += char
    
    def _is_escape_char(self, char: str) -> bool:
        return True if char == ESCAPE_CHARACTER else False
    
    def _handle_escape_char(self, char: str):
        """Only true if prev character is an escape sequence character."""
        self._escape_char = self._escape_char + char
        
        if self._escape_char in ESCAPE_SEQUENCE:
            self._string_buffer += self._escape_char
        else:            
            error_token = Lexer.Token(f'{self._quote_used}{self._string_buffer}', ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(Lexer.ErrorToken(error_token, Lexer.ErrorToken.UNCLOSED_LITERAL))
            self._reset_quote_flags()
            error_token = Lexer.Token(self._escape_char, ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(Lexer.ErrorToken(error_token, Lexer.ErrorToken.INVALID_ESCAPE_SEQ))
                    
        self._escape_char = EMPTY

    def _push_literal(self, symbol: Token):
        if symbol == None: return
        self._add_stack(symbol)
        self._reset_quote_flags()
               
    def _reset_quote_flags(self):
        self._string_buffer = EMPTY
        self._in_quotes = False
        self._in_literal = False
        self._in_raw_literal = False
        self._quote_used = EMPTY
        self._prev_quotes = EMPTY
        self._delim = EMPTY        
                
    def in_delim(self) -> bool:
        """Returns True if the lexer is currently parsing delimited content, False otherwise."""
        return True if self._delim else False
            
    def _parse_char(self, char: str):
        """Parse character.\n
        This tries to append the current character to the previous character to check for n length operators,
        where n is n < MAX_OPERATOR_LENGTH."""
        if self.in_delim():
            self._parse_delim(char)
            return
        
        if char in SEPARATOR:
            self._add_buffer()
            if char == '\n':
                self._line_idx += 1
                self._col_idx = 0
            return

        if char in WHITESPACE: return
                    
        if (char.isalpha() or char in IDENTIFIER_STARTER_CHARMAP) and not char in SPECIAL_CHARACTERS:
            if self._prev.isalpha() or isidentifier(self._prev) or self._prev == EMPTY:
                """<alpha><alpha>"""
                self._prev += char
                return
            
            if self._prev.isdigit():
                """<digit><alpha>"""
                self._add_buffer()
                self._add_stack(Lexer.Token(char, 'NUM_SUFFIX'))
                return        
            
            if isspcl(self._prev):
                """<spcl><alpha>"""
                self._add_buffer()
                self._parse_char(char)
                return
            
        if char.isdigit():
            if self._prev.isdigit() or isidentifier(self._prev) or self._prev == EMPTY:
                """<digit><digit> | <identifier><digit>"""
                self._prev += char
                return
            
            if isspcl(self._prev):
                """<spcl><digit>"""
                self._add_buffer()
                self._prev += char
                return
        
        if isspcl(char):
            if isspcl(self._prev) or self._prev == EMPTY:
                """<spcl><spcl>"""
                self._prev += char
                operator = self._parse_spcl(self._prev)
                if not operator == None:
                    self._prev = operator
                    self._add_buffer()
                    self._parse_char(char)
                return
        
        if not char in SPECIAL_CHARACTERS:
            err_token = Lexer.Token(char, ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(Lexer.ErrorToken(err_token, Lexer.ErrorToken.INVALID_CHARACTER))
            return
        
        """'prev + char' is not a valid token.
        Get last valid and parse the current char."""
        self._add_buffer()
        self._parse_char(char)
        return
    
    def _parse_spcl(self, chars: str) -> bool:
        """Parses a special character of length n if in valid operators or delimiters.\n
        Returns None if chars is a valid symbol."""               
        if len(chars) > MAX_OPERATOR_LENGTH:
            self._prev = self._prev[:-1]
            self._add_buffer()
            self._parse_char(chars)
            return
        
        if chars in DELIMITERS: return None
        if chars in OPERATORS: return None
        if chars in SPECIAL_CHARACTERS: return None
        
        return chars[:-1]
    
    def _parse_by_char(self) -> list[Token]:
        """Read file by character."""
        if not self._content: return
        
        for char in self._content:
            self._parse_char(char)
            self._char_idx += 1
            self._col_idx += 1
                            
        self.symbol_table.add_symbols(self._stack)
        return self._stack
    
    #region public
    def open(self, filepath: str) -> bool:
        """Open a .boop file, and store its contents for further operations.\n
        Returns True upon no errors."""
        if not filepath.lower().endswith(".boop"):
            raise Exception("Input file must be a type of .boop")
        
        with codecs.open(filepath, 'r', encoding='utf-8') as file:
            self.rootext = os.path.splitext(os.path.basename(file.name))
            self._content = file.read()
            self._lines = file.readlines()
        return True
    
    def read(self, filepath: str) -> SymbolTable:        
        """Lexical analyze a .boop file."""
        if not self.open(filepath): return        
        return self.parse()
    
    def parse(self) -> SymbolTable:
        """Parse all lines of the file.\n
        Returns a SymbolTable object."""
        if not self._content: return
        
        self._start_time = time.time()
        self._parse_by_char()
        self._end_time = time.time()
        self.elapsed_time = self._end_time - self._start_time
        
        self.save_error_log()
        self.save_symbol_table()
        return self.symbol_table    
        
    def tokenize(self, lexeme: str) -> Token:
        """Check lexeme string if in valid tokens, where lexeme is not an empty string.\n
        Returns a Symbol object."""
        return self._tokenize(lexeme)
    
    def get_line(self, index: int) -> str:
        return None if not self._lines else self._lines[index]
    
    def parse_index(self, index: int) -> SymbolTable:
        """Parse a line via index."""
        table = self.SymbolTable()
        table.add_symbols(self._parse_by_char(self.get_line(index)))
        return table
    
    #TODO
    def parse_lines(self, range: tuple[int, int]) -> SymbolTable:
        """Parses lines from index to index."""
        if self._lines == None: return None
        pass
    
    def parse_string(self, line: str) -> SymbolTable:
        """Parse a single line of BOOP code.\n
        This is used when changes are made to one specific line of code, to avoid reading the whole file again."""
        table = self.SymbolTable()
        table.add_symbols(self._parse_by_char(line))
        return table
    
    def save_symbol_table(self, filename: str = OUTPUT_FILENAME):
        """Save the output SymbolTable to file."""
        if self.symbol_table == None: return
        with codecs.open(f'{filename}-{self.rootext[0]}{OUTPUT_FILETYPE}', 'w', encoding='utf-8') as file:
            file.write(self.symbol_table.get_info())
            file.write(f'Elapsed time: {self.elapsed_time} s\n\n')
            file.write(self.symbol_table.__str__())
        return    
    
    def save_error_log(self, filename: str = ERROR_LOG_FILENAME):
        """Save the error log to file."""
        if self.symbol_table == None: return
        with codecs.open(f'{filename}-{self.rootext[0]}{OUTPUT_FILETYPE}', 'w') as file:
            for s in self.symbol_table.error_tokens:
                file.write(s.__str__())
        return
    #endregion