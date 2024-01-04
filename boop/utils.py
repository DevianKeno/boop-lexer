
from boop.tokens import *

def isalpha(string: str) -> bool:
    """ Returns True if the string consists of only special characters, False otherwise or if empty.\n"""
    return bool(string) and all(char in ALPHABET for char in string)

def isdigit(string: str) -> bool:
    """ Returns True if the string consists of only special characters, False otherwise or if empty.\n"""
    return bool(string) and all(char in DIGIT for char in string)

def isspcl(string: str) -> bool:
    """ Returns True if the string consists of only special characters, False otherwise or if empty.\n"""
    return bool(string) and all(char in SPECIAL_CHARACTERS for char in string)

def isidentifier(string: str) -> bool:
    """ Returns True if the string is a valid identifier, False otherwise or if empty.\n
        A string is an identifier if it
        - starts with an alphabet (a-z, A-Z) or IDENTIFIER_STARTER_CHARMAP
        - does not start with a digit (0-9)\n
        An identifier may have trailing digits only after a valid starting character."""
    if not string: return False
    if not (isalpha(string[0]) or string[0] in IDENTIFIER_STARTER_CHARMAP): return False
    for char in string[1:]:
        if not (char in IDENTIFIER_CHARMAP): return False
    return True
