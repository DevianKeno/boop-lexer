""" Lexical analyzer for the BOOP language.\n
    This analyzer scans each character ...
"""
from __future__ import annotations
import os
import codecs
import time
from boop.config import *
from boop.parser import *
from boop.token import *
from boop.tokens import *
from boop.symboltable import *
from boop.utils import *

__author__ = 'Gian Paolo B.'
cwd = os.getcwd()

class Lexer:
    """ Parse files with parse(filepath).\n
    """  
    def __init__(self):
        self.symbol_table = SymbolTable()
        self.tokenize_keywords: bool = True
        self.tokenize_comments: bool = True
        """If to include the comment delimiters as tokens in the output table."""
        self.rootext: tuple[str, str] = (EMPTY, EMPTY)
        """Represents the filename [0] and file extension [1]."""
        self.syntaxer = Parser()
        
        self._allow_external_files: bool = False
        self._content: str = []
        self._lines: list[str] = []
        self._stack: list[Token] = []
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
        if lexeme == EMPTY or lexeme == None: return
        
        if isalpha(lexeme):
            if lexeme in KEYWORDS:
                return Token(lexeme, KEYWORDS[lexeme] if self.tokenize_keywords else 'KEYWORD')
            if lexeme in RESERVED_WORDS:
                return Token(lexeme, 'RESERVED_WORD')
            # if lexeme in ALIASES:
            #     return Token(lexeme, 'ALIAS')
            if lexeme in NOISE_WORDS: # This is useless
                token = NOISE_WORDS[lexeme]                
                self._add_stack(Token(token, KEYWORDS[token]))
                return Token(lexeme[len(token):], 'NOISE_WORD')
                          
        if isidentifier(lexeme):
            return Token(lexeme, 'IDENTIFIER')
        
        if isdigit(lexeme):
            return Token(lexeme, 'NUM_LITERAL')
        
        if isspcl(lexeme):            
            if lexeme in DELIMITERS:
                return Token(lexeme, DELIMITERS[lexeme])
            if lexeme in OPERATORS:
                return Token(lexeme, OPERATORS[lexeme])
            if lexeme in SPECIAL_CHARACTERS:
                return Token(lexeme, SPECIAL_CHARACTERS[lexeme])
        
        return Token(lexeme, 'UNIDENTIFIED')

    def _set_delim(self, delim) -> str:
        """ Set delimiter functionality for the lexer.\n
        """
        if not delim in DELIMITERS: return

        match delim:
            case '#' | '/*':
                self._in_comments = True
                match delim:
                    case '#':
                        self._in_line_comment = True
                    case '/*':
                        self._in_multi_comment = True
                
                if self.tokenize_comments:
                    self._add_stack(Token(delim, DELIMITERS[delim]))                
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
                self._add_stack(Token(delim, DELIMITERS[delim]))

    def _add_buffer(self):
        if not self._prev: return
        self._set_delim(self._prev)
        self._add_stack(self._tokenize(self._prev))

    def _parse_delim(self, char: str):
        """ Execution tree for parsing delimited content.\n
            Delimited content includes:
            - string and raw string literals
            - single line and multi-line comments
        """
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
                self._add_stack(Token(COMMENT_END, DELIMITERS[COMMENT_END]))  
            return
        
        else:
            self._prev = EMPTY
            return
    
    def _parse_literal(self, char: str):
        """ Parse literal string quotes.
        """
        if self._escape_char:
            self._handle_escape_char(char)
            return
            
        if char == self._quote_used:            
            if self._string_buffer:
                """ If there is already a literal, this is an end quote.
                """
                self._add_stack(Token(f'{self._quote_used}{self._string_buffer}{self._quote_used}', 'STRING_LITERAL'))
                self._reset_quote_flags()
                return
            else:
                """ this MIGHT be for a raw string literal.
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
        
        if char == NEW_LINE:
            error_token = Token(f'{self._quote_used}{self._string_buffer}', ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(ErrorToken(error_token, ErrorToken.NEWLINE_LITERAL))            
            self._reset_quote_flags()
            return
        
        if len(self._prev_quotes) == 2:
            """ Two quotes preceded by a character that is not a quote, end quote.
            """
            self._add_stack(Token(f'{self._quote_used}{self._string_buffer}{self._quote_used}', 'STRING_LITERAL'))
            self._reset_quote_flags()
            self._parse_char(char)
            return
        
        self._string_buffer += char
    
    def _parse_raw_literal(self, char: str):    
        """ Parse raw string quotes.
        """    
        if char == self._quote_used:
            self._prev_quotes += char
            
            if self._prev_quotes in RAW_STRING_DELIMITER:
                """ This is an end quote
                """
                self._in_raw_literal = False
                
                self._add_stack(Token(f'{self._prev_quotes}{self._string_buffer}{self._prev_quotes}', 'RAW_LITERAL'))
                self._reset_quote_flags()
                return
            return
                
        if self._prev_quotes:
            self._string_buffer += self._prev_quotes
            self._prev_quotes = EMPTY
        
        # New lines in BOOP are represented only by '\n'
        if char == CARRIAGE_RETURN: return
                
        self._string_buffer += char
    
    def _is_escape_char(self, char: str) -> bool:
        return True if char == ESCAPE_CHARACTER else False
    
    def _handle_escape_char(self, char: str):
        """ Only true if prev character is an escape sequence character.
        """
        self._escape_char += char
        
        if self._escape_char in ESCAPE_SEQUENCES:
            self._string_buffer += self._escape_char
        else:            
            # error_token = Token(f'{self._quote_used}{self._string_buffer}', ERROR_TOKEN, self._line_idx, self._col_idx)
            # self._add_stack(ErrorToken(error_token, ErrorToken.UNCLOSED_LITERAL))
            # self._reset_quote_flags()
            
            error_token = Token(self._escape_char, ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(ErrorToken(error_token, ErrorToken.INVALID_ESCAPE_SEQ))
                    
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
        """ Returns True if the lexer is currently parsing delimited content, False otherwise.
        """
        return True if self._delim else False
            
    def _parse_char(self, char: str):
        """ Parse character.\n
            This tries to append the current character to the previous character to check for n length operators,
            where n is n < MAX_OPERATOR_LENGTH.
        """        
        if self.in_delim():
            self._parse_delim(char)
            return
        
        if char in SEPARATOR:
            self._add_buffer()
            return

        if char in WHITESPACE: return
                            
        if (isalpha(char) or char in IDENTIFIER_STARTER_CHARMAP) and not char in MATH_SYMBOLS:
            
            if isalpha(self._prev) or isidentifier(self._prev) or self._prev == EMPTY:
                """<alpha><alpha> | <alpha><underscore>"""
                self._prev += char
                return
            
            if isdigit(self._prev):
                """<digit><alpha>"""
                self._add_buffer()
                self._add_stack(Token(char, 'NUM_SUFFIX'))
                return        
            
            if isspcl(self._prev):
                """<spcl><alpha>"""
                self._add_buffer()
                self._parse_char(char)
                return
            
        if isdigit(char):
            if isdigit(self._prev) or isidentifier(self._prev) or self._prev == EMPTY:
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
            err_token = Token(char, ERROR_TOKEN, self._line_idx, self._col_idx)
            self._add_stack(ErrorToken(err_token, ErrorToken.INVALID_CHARACTER))
            return
        
        """ 'prev + char' is not a valid token.
            Get last valid and parse the current char.
        """
        self._add_buffer()
        self._parse_char(char)
        return
    
    def _parse_spcl(self, chars: str) -> bool:
        """ Parses a special character of length n if in valid operators or delimiters.\n
            Returns None if chars is a valid symbol.
        """               
        if len(chars) > MAX_OPERATOR_LENGTH:
            self._prev = self._prev[:-1]
            self._add_buffer()
            self._parse_char(chars)
            return
        
        if chars in DELIMITERS or chars in OPERATORS or chars in MATH_SYMBOLS or chars in SPECIAL_CHARACTERS:
            return None
        
        return chars[:-1]
    
    def _update_lncol(self, char: str):
        if char == NEW_LINE:
            self._line_idx += 1
            self._col_idx = 1
        elif not char == CARRIAGE_RETURN:
            self._col_idx += 1
    
    def _parse(self) -> list[Token]:
        for char in self._content:
            self._parse_char(char)
            self._update_lncol(char)

        self.symbol_table.add_symbols(self._stack)
        return self._stack
    
    #UNUSED
    def _parse_ln(self, line: str) -> list[Token]:
        if line == EMPTY or line == None: return
        self._stack = []
        _col_idx = 1
        for char in line:
            self._parse_char(char)
            _col_idx += 1
        return self._stack
    
    """ Public methods
    """
    #region
    def open(self, filepath: str) -> bool:
        """ Open a .boop file, and store its contents for further operations.\n
            Returns True upon no errors.
            """
        if not self._allow_external_files:
            if not filepath.lower().endswith(".boop"):
                raise Exception("Input file must be a type of .boop")

        with codecs.open(filepath, 'r', encoding='utf-8') as file:
            self.rootext = os.path.splitext(os.path.basename(file.name))
            self._content = file.read()
            self._lines = self._content.split('\r\n')
        return True
        
    def parse(self, path: str) -> SymbolTable | None:
        """ Perform lexical analysis on all lines of the file.
            This will output two files, a symbol_table-filename.txt and error_log-filename.txt.\n
            Returns a SymbolTable object if a file is successfully parsed, None otherwise.
        """
        if self.open(path):       
            self._start_time = time.time()
            self._parse()
            self.elapsed_time = time.time() - self._start_time
            
            self.save_error_log()
            self.save_symbol_table()        
            return self.symbol_table
        return None
    
    def syntaxisize(self) -> None:
        """ Perform syntax analysis.
        """
        if self.symbol_table == None: return
        
        self.syntaxer.parse(self.symbol_table)
    
    def tokenize(self, lexeme: str) -> Token:
        """Check lexeme string if in valid tokens.\n
        Returns a Token object."""
        return self._tokenize(lexeme)
    
    def allow_external_files(self, allow: bool) -> None:
        """ Whether to allow non .boop files.
        """
        self._allow_external_files = allow
    
    def get_line(self, index: int) -> str:
        """ Returns a line from the current open file. Returns None if no file has been opened yet.
        """
        return '' if not self._lines else self._lines[index]
        
    def save_symbol_table(self):
        """ Save the SymbolTable as text file.
        """
        if self.symbol_table == None: return
        
        path = os.path.join(cwd, 'tables', f'{self.rootext[0]}.txt')
        
        with codecs.open(path, 'w', encoding='utf-8') as file:
            file.write(self.symbol_table.get_info())
            file.write(f'Elapsed time: {self.elapsed_time} s\n\n')
            file.write(self.symbol_table.__str__())
        return    
    
    def save_error_log(self):
        """ Save the error logs as text file.
        """
        if self.symbol_table == None: return
        
        path = os.path.join(cwd, 'logs', f'{self.rootext[0]}.txt')
        
        with codecs.open(path, 'w', encoding='utf-8') as file:
            for s in self.symbol_table.error_tokens:
                line = self.get_line(s.line - 1)
                indic = f'\t{line}\n\t{" " * (s.col - 1) + "^"}'                
                file.write(s.__str__() + indic + '\n')
        return
    
    #TODO
    #UNUSED
    def parse_index(self, index: int) -> SymbolTable:
        """Leximize a line via its index.\n
        Returns a SymbolTable object."""
        table = SymbolTable()
        table.add_symbols(self._parse_ln(self.get_line(index)))
        return table
    
    #UNUSED
    def parse_lines(self, range: tuple[int, int]) -> SymbolTable:
        """Parse lines from index to index."""
        if self._lines == None: return None
    
    #UNUSED
    def parse_string(self, line: str) -> SymbolTable:
        """Parse a single line of BOOP code.\n
        Used when changes are made to one specific line of code, to avoid reading the whole file again."""
        st = SymbolTable()
        st.add_symbols(self._parse_ln(line))
        return st
    #endregion
    
    
    
    
    
    
    
    
    
    
    
    
    
    