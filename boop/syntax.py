
from __future__ import annotations
import os
import re
import collections
from utils import *
from tokens.token import *
from tokens.tokens import *
from tokens.symboltable import *

cwd = os.getcwd()

CLOSURE_KLEENE = ASTERISK
CLOSURE_POSITIVE = PLUS
OPTIONAL = QUESTION_MARK

CLOSURES = {
    CLOSURE_KLEENE : 'KLEENE_CLOSURE',
    CLOSURE_POSITIVE : 'POSITIVE_CLOSURE',
    OPTIONAL : 'OPTIONAL'
}

def isrulename(string: str) -> bool:
    """ Returns True if the string is a valid rule name, False otherwise or if empty.\n
        - starts with an alphabet (a-z, A-Z)
        - has no special characters
        - not all caps
    """
    if not string: return False
    if string[0] not in ALPHABET: return False
    if str.isupper(string): return False
    return isalpha(string)

def istoken(string: str) -> bool:
    pass

def separate(input: str) -> list[str]:
    pattern = r'(\w+|[^\w\s])'
    return re.findall(pattern, input)

def separate_from_symbols(input: str) -> list[str]:    
    return re.findall(r'\b\w+\b|\'[^\']*\'', input)

class Syntaxer:
    """ 1. Convert tokens into integer representations.
        2. Check if the current token and preceding token is in valid rules.
    """
    class Rule:
        
        def __init__(self, name: str) -> None:
            self.name = name
            self.token_seq: list[int] = {}
            pass
        
        def set_next(self, string: str):
            
            pass
        pass
    
        def __repr__(self) -> str:
            return 'rule'
    
    def __init__(self) -> None:
        self.content: str = EMPTY
        self.tokens: dict[str, str] = {}
        self.rules = {}
        
        self._rulestrs: list[str] = EMPTY
        self._int_map = {}
        self._rule_sequences: dict[list[list[int]]] = {}
        self._sequences: dict[int, set[int]] = {}
        
        self._prev: str = EMPTY
        self._repr_idx: int = 0
        self._token_repr: dict[str, int] = {}
        
        self._parse_rules()
    
    def _init(self):
        
        pass
    
    def _token_to_int(self, string: str):
        """ Represent token as integer value.
        """
        self._token_repr.update({string, self._repr_idx})
        self._repr_idx += 1
        
    @property
    def token_repr_count(self) -> int:
        return len(self._token_repr)
    
    def _get_rule_seq(self, words: list[str]) -> list[int]:
        sequence = []
        
        for grammar in words:
            grammar = separate_from_symbols(grammar)
        
            for i, word in enumerate(grammar):
                sequence.append(self._int_map[word])
            return sequence
    
    def _init_tokens(self):
        pass
    
    def _preprocess_grammar(self):
        rules = self.content.split(';')
        
        """ Map tokens to integers.
        """
        for rule, value in TOKENS.items():
            self.tokens[value] = rule
            
        for rule, value in SPECIAL_CHARACTERS.items():
            self.tokens[value] = rule
            
        for rule, value in KEYWORDS.items():
            self.tokens[value] = rule
        
        for rule, value in OPERATORS.items():
            self.tokens[value] = rule
            
        for rule, value in DELIMITERS.items():
            self.tokens[value] = rule
        
        """ Separate individual rules.
        """
        for rule in rules:
            rule = rule.strip() # Remove new lines                        
            if rule.startswith("#") or rule.startswith('//') or not rule: continue # Disregard region markers and comments
            
            rule, content = map(str.strip, rule.split(':', 1))
            content = [word.strip() for word in content.split('|')] # Split OR, basically rules with two or more grammars(?)
            
            self.rules[rule] = content

        """ Create token-integer mapping.
        """
        for i in self.tokens:
            self._int_map[i] = len(self._int_map) + 1
        for i in self.rules:
            self._int_map[i] = len(self._int_map) + 1

        """ Create rule integer sequences mapping.
        """
        for rule, content in self.rules.items():
            self._rule_sequences[rule] = []
            
            for grammar in content: # content refers to the rules separated by '|'
                # Initialize values
                current_sequence = []
                
                """ This is just temporary. Ideally the closures should be taken into account.
                    This will be eventually changed to handle closures and optionals.
                """
                var = separate_from_symbols(grammar)               

                # Parse token sequence
                for i, word in enumerate(var):                        
                    if isrulename(word):
                        var = self._get_rule_seq(self.rules[word])
                        current_sequence.extend(var)
                    else:
                        current_sequence.append(self._int_map[word])

                self._rule_sequences[rule].append(current_sequence)
            
        """ Convert rule integer sequence mapping to individual sequences. 
        """
        for grammar_sequence in self._rule_sequences.values():
            for sequence in grammar_sequence:
                for i, int_id in enumerate(sequence):
                        if i + 1 < len(sequence):
                            self._sequences.setdefault(int_id, set()).add(sequence[i + 1])
                pass 
        
        """ Preferably save the contents of the self._sequences variable to a file.
            The preprocess should only run when the BNF is changed for performance. 
        """
        
        # #region Debugging only, can be removed
        # self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        # print()
        # #endregion
        
    def _parse_rules(self):
        path = os.path.join(cwd, 'boop/grammar/declarations.boop')
        
        with open(path, 'r', encoding='utf-8') as file:
            self.content = file.read()
            
        self._preprocess_grammar()
            
    def parse(self, table: SymbolTable):
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        
        for i, symbol in enumerate(input_sequence):
            if i + 1 >= len(input_sequence): break # end of input
            
            look_ahead = input_sequence[i + 1]
            possible_nexts: list[int] = self._sequences[symbol]   
            
            if look_ahead in possible_nexts:
                continue
            else:
                raise Exception("Syntax error")
        
        print("Successful parse") # pause debug
