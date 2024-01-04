EMPTY = ''
       
ALPHABET = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'
DIGIT = '0123456789'
       
SPACE = ' '
PERIOD = '.'
COMMA = ','
COLON = ':'
SEMICOLON = ';'
BACKTICK = '`'
TILDE = '~'
AT_SIGN = '@'
QUESTION_MARK = '?'
EXCLAMATION_POINT = '!'
DOLLAR = '$'
HASH = '#'
CARET = '^'
ASTERISK = '*'
PERCENT = '%'
AMPERSAND = '&'
PARENTHESIS_OPEN = '('
PARENTHESIS_CLOSE = ')'
BRACKET_OPEN = '['
BRACKET_CLOSE = ']'
BRACE_OPEN = '{'
BRACE_CLOSE = '}'
LEFT_ANGLED_BRACKET = '<'
RIGHT_ANGLED_BRACKET = '>'
PLUS = '+'
EQUALS = '='
HYPHEN = '-'
UNDERSCORE = '_'
VERTICAL_BAR = '|'
FORWARD_SLASH = '/'
BACKSLASH = '\\'
SINGLE_QUOTE = '\''
DOUBLE_QUOTE = '\"'

MAX_OPERATOR_LENGTH = 3
MAX_DELIMITER_LENGTH = 3

#region Special characters
#endregion 

#region Math symbols
SQUARE_ROOT = '√'
MEAN = 'x̅'
PRODUCT_NOTATION = '∏'
SUMMATION = 'Σ'
PI_CHAR = 'π'
THETA = 'θ'
IMAGINARY = 'ι'
#endregion

#region Delimiters
ESCAPE_CHARACTER = BACKSLASH
DELIM_END_STATEMENT = SEMICOLON
DELIM_PAREN_L = '('
DELIM_PAREN_R = ')'
DELIM_BRACKET_L = '['
DELIM_BRACKET_R = ']'
DELIM_BRACE_L = '{'
DELIM_BRACE_R = '}'
DELIM_ANGLED_BRACKET_L = '<'
DELIM_ANGLED_BRACKET_R = '>'
DELIM_TYPE_RETURN = '->'
DELIM_RETURN = '=>'
DELIM_COMMENT_SINGLE = '//'
DELIM_COMMENT_START = '/*'
DELIM_COMMENT_END = '*/'
#endregion

ERROR_TOKEN = 'ERROR_TOKEN'

#region Keywords
ABSTRACT = 'abstract'
ALIAS = 'alias'
BASE = 'base'
#endregion

#region WHITESPACE
NEW_LINE = '\n'
CARRIAGE_RETURN = '\r'
TAB = '\t'
#endregion

KEYWORD = {
    ABSTRACT: 'KEYWORD',
    ALIAS: 'KEYWORD',
    BASE: 'KEYWORD'
}

KEYWORDS = {
    'abstract' : 'KEYWORD',
    'alias' : 'KEYWORD',
    'base': 'BASE',
    'bool': 'BOOL',
    'break': 'BREAK',
    'case': 'CASE',
    'catch': 'CATCH',
    'char': 'CHAR',
    'class': 'CLASS',
    'const': 'CONST',
    'constant': 'CONSTANT',
    'continue': 'CONTINUE',
    'default': 'DEFAULT',
    'dict': 'DICT',
    'dictionary': 'DICTIONARY',
    'do': 'DO',
    'double': 'DOUBLE',
    'else': 'ELSE',
    'enum': 'ENUM',
    'enumeration': 'ENUMERATION',
    'event': 'EVENT',
    'false': 'FALSE',
    'float': 'FLOAT',
    'for': 'FOR',
    'foreach': 'FOREACH',
    'format': 'FORMAT',
    'fortime': 'FORTIME',
    'from': 'FROM',
    'func': 'FUNC',
    'get': 'GET',
    'if': 'IF',
    'import': 'IMPORT',
    'inherit': 'INHERIT',
    'int': 'INT',
    'interface': 'INTERFACE',
    'list': 'LIST',
    'millisec': 'MILLISEC',
    'module': 'MODULE',
    'null': 'NULL',
    'override': 'OVERRIDE',
    'private': 'PRIVATE',
    'protected': 'PROTECTED',
    'public': 'PUBLIC',
    'recur': 'RECUR',
    'ref': 'REF',
    'return': 'RETURN',
    'second': 'SECOND',
    'set': 'SET',
    'static': 'STATIC',
    'string': 'STRING',
    'struct': 'STRUCT',
    'switch': 'SWITCH',
    'this': 'THIS',
    'throw': 'THROW',
    'time': 'TIME',
    'true': 'TRUE',
    'try': 'TRY',
    'virtual': 'VIRTUAL',
    'void': 'VOID',
    'while': 'WHILE',
    'where': 'WHERE'
}

RESERVED_WORDS = {
    
}

ALIASES = {
    'and' : '&&',
    'character' : 'CHAR',
    'dictionary' : 'DICT',
    'f' : 'FORMAT',
    'function': 'FUNCTION',
    'inherits' : 'INHERIT',
    'integer' : 'INT',
    'not' : '!',
    'or' : '||',
}

IDENTIFIER_STARTER_CHARMAP = '_'
IDENTIFIER_CHARMAP = '_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'

SPECIAL_CHARACTERS = {
    SPACE: 'SPACE',
    PERIOD: 'PERIOD',
    COMMA: 'COMMA',
    BACKTICK: 'BACKTICK',
    TILDE: 'TILDE',
    AT_SIGN: 'AT_SIGN',
    QUESTION_MARK: 'QUESTION_MARK',
    EXCLAMATION_POINT: 'EXCLAMATION_POINT',
    DOLLAR: 'DOLLAR',
    HASH: 'HASH',
    CARET: 'CARET',
    ASTERISK: 'ASTERISK',
    PERCENT: 'PERCENT',
    AMPERSAND: 'AMPERSAND',
    PARENTHESIS_OPEN: 'PARENTHESIS_OPEN',
    PARENTHESIS_CLOSE: 'PARENTHESIS_CLOSE',
    BRACKET_OPEN: 'BRACKET_OPEN',
    BRACKET_CLOSE: 'BRACKET_CLOSE',
    BRACE_OPEN: 'BRACE_OPEN',
    BRACE_CLOSE: 'BRACE_CLOSE',
    LEFT_ANGLED_BRACKET: 'LEFT_ANGLED_BRACKET',
    RIGHT_ANGLED_BRACKET: 'RIGHT_ANGLED_BRACKET',
    PLUS: 'PLUS',
    EQUALS: 'EQUALS',
    HYPHEN: 'HYPHEN',
    UNDERSCORE: 'UNDERSCORE',
    VERTICAL_BAR: 'VERTICAL_BAR',
    FORWARD_SLASH: 'FORWARD_SLASH',
    BACKSLASH: 'BACKWARD_SLASH',
    COLON: 'COLON',
    SEMICOLON: 'SEMICOLON',
    SINGLE_QUOTE: 'SINGLE_QUOTE',
    DOUBLE_QUOTE: 'DOUBLE_QUOTE',
    
    # Math symbols
    SQUARE_ROOT: 'SQUARE',
    MEAN: 'MEAN',
    PRODUCT_NOTATION: 'PRODUCT_NOTATION',
    SUMMATION: 'SUMMATION',
    PI_CHAR: 'PI',
    THETA: 'THETA',
    IMAGINARY: 'IMAGINARY',
}

OPERATORS = {
    '.': 'DOT',
    '=': 'EQUALITY_OP',
    '+': 'PLUS_OP',
    '-': 'MINUS_OP',
    '*': 'MULT_OP',
    '/': 'DIV_OP',
    '%': 'MODULUS_OP',
    '^': 'EXPONENT',
    '**': 'EXPONENT',
    '+=': 'ADD_ASSIGN',
    '-=': 'MINUS_ASSIGN',
    '*=': 'MULT_ASSIGN',
    '/=': 'DIV_ASSIGN',
    '++': 'INCREMENT',
    '--': 'DECREMENT',
    '==': 'LOGICAL_EQUALS',
    '&&': 'LOGICAL_AND',
    '||': 'LOGICAL_OR',
    '!': 'LOGICAL_NOT',
    '!=': 'LOGICAL_NOT_EQUALS',
}

# Currently unused
BOOLEAN_OPERATORS = {
    '==': 'LOGICAL_EQUALS',
    '&&': 'LOGICAL_EQUALS',
    '||': 'LOGICAL_OR',
    '!': 'LOGICAL_NOT',
    '!=': 'LOGICAL_NOT_EQUALS',
}

MATH_SYMBOLS = {
    
    SQUARE_ROOT: 'SQUARE_ROOT',
    MEAN: 'MEAN',
    PRODUCT_NOTATION: 'PRODUCT_NOTATION',
    SUMMATION: 'SUMMATION',
    PI_CHAR: 'PI_CHAR',
    THETA: 'THETA',
    IMAGINARY: 'IMAGINARY'
}

ESCAPE_SEQUENCE = {
    "\\'": 'SINGLE_QUOTE',
    '\\"': 'DOUBLE_QUOTE',
    '\\\\': 'BACKSLASH',
    '\\n': 'NEW_LINE',
    '\\r': 'CARRIAGE_RETURN',
    '\\t': 'TAB',
    '\\b': 'BACKSPACE',
    '\\0': 'NULL_CHAR',
}

DELIMITERS = {
    COMMA: 'COMMA',
    COLON: 'COLON',
    SEMICOLON: 'END_STATEMENT',
    '(': 'PARENTHESIS_START',
    ')': 'PARENTHESIS_END',
    '[': 'BRACKET_START',
    ']': 'BRACKET_END',
    '{': 'BRACE_START',
    '}': 'BRACE_END',
    '<': 'LEFT_ANGLE_BRACKET',
    '>': 'RIGHT_ANGLE_BRACKET',
    '\'': 'SINGLE_QUOTE',
    '\"': 'DOUBLE_QUOTE',
    '\'\'\'': 'SINGLE_QUOTE_TRIPLE',
    '\"\"\"': 'DOUBLE_QUOTE_TRIPLE',
    '//': 'COMMENT_DELIM',
    '/*': 'COMMENT_MULT_START',
    '*/': 'COMMENT_MULT_END',
    '->': 'RETURN_TYPE_DELIM',
    '=>': 'RETURN',
}

RAW_STRING_DELIMITER = {
    '\'\'\'': 'SINGLE_QUOTE_TRIPLE',
    '\"\"\"': 'DOUBLE_QUOTE_TRIPLE',
}

SEPARATOR = {
    ' ': 'SPACE',
    '\r': 'CARRIAGE_RETURN',
    '\n': 'NEW_LINE',
    '\t': 'TAB',
}

WHITESPACE = {
    '\r': 'CARRIAGE_RETURN',
    NEW_LINE: 'NEW_LINE',
    '\t': 'TAB',
    '\v': 'V_TAB',
}