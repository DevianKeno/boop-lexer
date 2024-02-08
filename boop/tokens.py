EMPTY = ''

DIGIT = '0123456789'
LOWER = 'abcdefghijklmnopqrstuvwxyz'
UPPER = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
ALPHABET = LOWER + UPPER
ALPHANUMERIC = LOWER + UPPER + DIGIT

#region Special characters
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
LEFT_PAREN = '('
RIGHT_PAREN = ')'
LEFT_BRACKET = '['
RIGHT_BRACKET = ']'
LEFT_BRACE = '{'
RIGHT_BRACE = '}'
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
#endregion

#region Math symbols
SQUARE_ROOT = '√'
MEAN = 'x' + SINGLE_QUOTE
PRODUCT_NOTATION = '∏'
SUMMATION = 'Σ'
PI_CHAR = 'π'
THETA = 'θ'
IMAGINARY = 'ι'
#endregion

#region Delimiters
END_STATEMENT = SEMICOLON
SINGLE_QUOTE_TRIPLE = SINGLE_QUOTE + SINGLE_QUOTE + SINGLE_QUOTE
DOUBLE_QUOTE_TRIPLE = DOUBLE_QUOTE  +DOUBLE_QUOTE + DOUBLE_QUOTE
COMMENT_SINGLE = HASH
COMMENT_START = FORWARD_SLASH + ASTERISK
COMMENT_END = ASTERISK + FORWARD_SLASH
DELIM_FUNC_RETURN = HYPHEN + RIGHT_ANGLED_BRACKET
DELIM_FIELD_RETURN = EQUALS + RIGHT_ANGLED_BRACKET
#endregion

ESCAPE_CHARACTER = BACKSLASH
ERROR_TOKEN = 'ERROR_TOKEN'

#region Keywords
ABSTRACT = 'abstract'
ALIAS = 'alias'
ASYNC = 'async'
AWAIT = 'await'
BASE = 'base'
BOOL = 'bool'
BREAK = 'break'
CASE = 'case'
CATCH = 'catch'
CHAR = 'char'
CHARACTER = 'character'
CLASS = 'class'
CONST = 'const'
CONT = 'cont'
CONTINUE = 'continue'
DEFAULT = 'default'
DELAYED = 'delayed'
DICT = 'dict'
DICTIONARY = 'dictionary'
DO = 'do'
DOUBLE = 'double'
ELSE = 'else'
ENUM = 'enum'
ENUMERATION = 'enumeration'
EVENT = 'event'
FALSE = 'false'
FLOAT = 'float'
FOR = 'for'
FOREACH = 'foreach'
FORMAT = 'format'
FORTIME = 'fortime'
FROM = 'from'
FUNC = 'func'
GET = 'get'
IF = 'if'
IMPORT = 'import'
INHERIT = 'inherit'
IN = 'in'
INT = 'int'
INTERFACE = 'interface'
LIST = 'list'
MILLISEC = 'millisec'
MODULE = 'module'
NULL = 'null'
OVERRIDE = 'override'
PRIVATE = 'private'
PROTECTED = 'protected'
PUBLIC = 'public'
RECUR = 'recur'
REF = 'ref'
REPEAT = 'repeat'
RETURN = 'return'
SECOND = 'second'
SET = 'set'
STATIC = 'static'
STRING = 'string'
STRUCT = 'struct'
SWITCH = 'switch'
THIS = 'this'
THROW = 'throw'
TIME = 'time'
TRUE = 'true'
TRY = 'try'
VAR = 'var'
VIRTUAL = 'virtual'
VOID = 'void'
WHILE = 'while'
WHERE = 'where'
#endregion

MAIN = 'main'

#region WHITESPACE
NEW_LINE = '\n'
CARRIAGE_RETURN = '\r'
TAB = '\t'
#endregion

TOKENS = {
    'IDENTIFIER': 'IDENTIFIER',
    'NUM_LITERAL': 'NUM_LITERAL',
    'NUM_SUFFIX': 'NUM_SUFFIX',
    'STRING_LITERAL': 'STRING_LITERAL',
    'ERROR_TOKEN': 'ERROR_TOKEN'
}

KEYWORDS = {
    ABSTRACT: 'ABSTRACT',
    ALIAS: 'ALIAS',
    ASYNC: 'ASYNC',
    AWAIT: 'AWAIT',
    BASE: 'BASE',
    BOOL: 'BOOL',
    BREAK: 'BREAK',
    CASE: 'CASE',
    CATCH: 'CATCH',
    CHAR: 'CHAR',
    CLASS: 'CLASS',
    CONST: 'CONST',
    CONTINUE: 'CONTINUE',
    DEFAULT: 'DEFAULT',
    DELAYED: 'DELAYED',
    DICT: 'DICT',
    DO: 'DO',
    DOUBLE: 'DOUBLE',
    ELSE: 'ELSE',
    ENUM: 'ENUM',
    EVENT: 'EVENT',
    FALSE: 'FALSE',
    FLOAT: 'FLOAT',
    FOR: 'FOR',
    FOREACH: 'FOREACH',
    FORMAT: 'FORMAT',
    FORTIME: 'FORTIME',
    FROM: 'FROM',
    FUNC: 'FUNC',
    GET: 'GET',
    IF: 'IF',
    IMPORT: 'IMPORT',
    INHERIT: 'INHERIT',
    IN: 'IN',
    INT: 'INT',
    INTERFACE: 'INTERFACE',
    LIST: 'LIST',
    MAIN: 'MAIN',
    MILLISEC: 'MILLISEC',
    MODULE: 'MODULE',
    NULL: 'NULL',
    OVERRIDE: 'OVERRIDE',
    PRIVATE: 'PRIVATE',
    PROTECTED: 'PROTECTED',
    PUBLIC: 'PUBLIC',
    RECUR: 'RECUR',
    REF: 'REF',
    REPEAT: 'REPEAT',
    RETURN: 'RETURN',
    SECOND: 'SECOND',
    SET: 'SET',
    STATIC: 'STATIC',
    STRING: 'STRING',
    STRUCT: 'STRUCT',
    SWITCH: 'SWITCH',
    THIS: 'THIS',
    THROW: 'THROW',
    TIME: 'TIME',
    TRUE: 'TRUE',
    TRY: 'TRY',
    VAR: 'VAR',
    VIRTUAL: 'VIRTUAL',
    VOID: 'VOID',
    WHILE: 'WHILE',
    WHERE: 'WHERE',
}

RESERVED_WORDS = KEYWORDS

NOISE_WORDS = {
    CHARACTER : CHAR,
    CONTINUE: CONT,
    DICTIONARY: DICT,
    ENUMERATION: ENUM,
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
    LEFT_PAREN: 'LEFT_PAREN',
    RIGHT_PAREN: 'RIGHT_PAREN',
    LEFT_BRACKET: 'LEFT_BRACKET',
    RIGHT_BRACKET: 'RIGHT_BRACKET',
    LEFT_BRACE: 'LEFT_BRACE',
    RIGHT_BRACE: 'RIGHT_BRACE',
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
    SQUARE_ROOT: 'MATH_SQRT',
    MEAN: 'MATH_MEAN',
    PRODUCT_NOTATION: 'MATH_PRODN',
    SUMMATION: 'MATH_SUMMN',
    PI_CHAR: 'MATH_PI',
    THETA: 'MATH_THETA',
    IMAGINARY: 'MATH_IMAGI',
}

OPERATORS = {
    PERIOD: 'OP_DOT',
    EQUALS: 'OP_ASSIGN',
    PLUS: 'OP_ADD',
    HYPHEN: 'OP_SUB',
    ASTERISK: 'OP_MUL',
    FORWARD_SLASH: 'OP_DIV',
    FORWARD_SLASH + FORWARD_SLASH: 'OP_TRUEDIV',
    PERCENT: 'OP_MOD',
    CARET: 'OP_EXPO',
    ASTERISK + ASTERISK: 'OP_EXPO',
    PLUS + EQUALS: 'OP_ADD_ASSIGN',
    HYPHEN + EQUALS: 'OP_SUB_ASSIGN',
    ASTERISK + EQUALS: 'OP_MUL_ASSIGN',
    FORWARD_SLASH + EQUALS: 'OP_DIV_ASSIGN',
    
    PLUS + PLUS: 'UNARY_ADD',
    HYPHEN + HYPHEN: 'UNARY_SUB',
    
    LEFT_ANGLED_BRACKET: 'REL_LESS_THAN',
    RIGHT_ANGLED_BRACKET: 'REL_GREATER_THAN',
    LEFT_ANGLED_BRACKET + EQUALS: 'REL_LESS_OR_EQUAL',
    RIGHT_ANGLED_BRACKET + EQUALS: 'REL_GREATER_OR_EQUAL',
    EQUALS + EQUALS: 'REL_EQUALITY',
    EXCLAMATION_POINT + EQUALS: 'REL_NOT_EQUALS',
    AMPERSAND + AMPERSAND: 'LOGC_AND',
    VERTICAL_BAR + VERTICAL_BAR: 'LOGC_OR',
    EXCLAMATION_POINT: 'LOGC_NOT',
}

# Currently unused
BOOLEAN_OPERATORS = {
    EQUALS + EQUALS: 'LOGC_EQUALS',
    AMPERSAND + AMPERSAND: 'LOGC_AND',
    VERTICAL_BAR + VERTICAL_BAR: 'LOGC_OR',
    EXCLAMATION_POINT: 'LOGC_NOT',
    EXCLAMATION_POINT + EQUALS: 'LOGC_NOT_EQUALS',
}

MATH_SYMBOLS = {
    SQUARE_ROOT: 'MATH_SQRT',
    MEAN: 'MATH_MEAN',
    PRODUCT_NOTATION: 'PRODUCT_NOTATION',
    SUMMATION: 'SUMMATION',
    PI_CHAR: 'PI_CHAR',
    THETA: 'THETA',
    IMAGINARY: 'IMAGINARY'
}

ESCAPE_SEQUENCES = {
    ESCAPE_CHARACTER + SINGLE_QUOTE: 'SINGLE_QUOTE',
    ESCAPE_CHARACTER + DOUBLE_QUOTE: 'DOUBLE_QUOTE',
    ESCAPE_CHARACTER + BACKSLASH: 'BACKSLASH',
    ESCAPE_CHARACTER + 'n': 'NEW_LINE',
    ESCAPE_CHARACTER + 'r': 'CARRIAGE_RETURN',
    ESCAPE_CHARACTER + 't': 'TAB',
    ESCAPE_CHARACTER + 'b': 'BACKSPACE',
}

DELIMITERS = {
    COMMA: 'COMMA',
    COLON: 'COLON',
    END_STATEMENT: 'END_STATEMENT',
    LEFT_PAREN: 'LEFT_PAREN',
    RIGHT_PAREN: 'RIGHT_PAREN',
    LEFT_BRACKET: 'LEFT_BRACKET',
    RIGHT_BRACKET: 'RIGHT_BRACKET',
    LEFT_BRACE: 'LEFT_BRACE',
    RIGHT_BRACE: 'RIGHT_BRACE',
    LEFT_ANGLED_BRACKET: 'LEFT_ANGLED_BRACKET',
    RIGHT_ANGLED_BRACKET: 'RIGHT_ANGLED_BRACKET',
    SINGLE_QUOTE: 'SINGLE_QUOTE',
    DOUBLE_QUOTE: 'DOUBLE_QUOTE',
    SINGLE_QUOTE_TRIPLE: 'SINGLE_QUOTE_TRIPLE',
    DOUBLE_QUOTE_TRIPLE: 'DOUBLE_QUOTE_TRIPLE',
    COMMENT_SINGLE: 'COMMENT_SINGLE',
    COMMENT_START: 'COMMENT_START',
    COMMENT_END: 'COMMENT_END',
    DELIM_FUNC_RETURN: 'DELIM_FUNC_RETURN',
    DELIM_FIELD_RETURN: 'DELIM_FIELD_RETURN',
}

RAW_STRING_DELIMITER = {
    SINGLE_QUOTE + SINGLE_QUOTE + SINGLE_QUOTE: 'DELIM_SINGLE_QUOTE_TRIPLE',
    DOUBLE_QUOTE + DOUBLE_QUOTE + DOUBLE_QUOTE: 'DELIM_DOUBLE_QUOTE_TRIPLE',
}

SEPARATOR = {
    SPACE: 'SPACE',
    CARRIAGE_RETURN: 'CARRIAGE_RETURN',
    NEW_LINE: 'NEW_LINE',
    TAB: 'TAB',
}

WHITESPACE = {
    CARRIAGE_RETURN: 'CARRIAGE_RETURN',
    NEW_LINE: 'NEW_LINE',
    TAB: 'TAB',
}