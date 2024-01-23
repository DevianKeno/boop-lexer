
from __future__ import annotations
import os
import re
import collections
from boop.utils import *
from boop.token import *
from boop.tokens import *
from boop.symboltable import *

cwd = os.getcwd()

CLOSURE_KLEENE = ASTERISK
CLOSURE_POSITIVE = PLUS
OPTIONAL = QUESTION_MARK

CLOSURES = {
    CLOSURE_KLEENE : 'KLEENE_CLOSURE',
    CLOSURE_POSITIVE : 'POSITIVE_CLOSURE',
    OPTIONAL : 'OPTIONAL'
}

def isnonterminal(string: str) -> bool:
    """ Returns True if the string is a non-terminal, False otherwise or if empty.\n
        A non-terminal is represented by a rule name that
        - starts with an alphabet (a-z, A-Z)
        - has no special characters
        - not all caps
    """
    if not string: return False
    if string[0] not in ALPHABET: return False
    if str.isupper(string): return False
    return isalpha(string)

def separate_from_symbols(input: str) -> list[str]:
    return re.findall(r'\b\w+\b|\'[^\']*\'', input)

class Parser:
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
        
        self._firsts: dict[str, set] = {}
        self._follows: dict[str, set] = {}
        self._lasts: dict[str, set] = {}
        self._rulestrs: list[str] = EMPTY
        self._int_map = {}
        self._nonterminal_int_seq: dict[str, str] = {}
        self._sequences: dict[int, set] = {}
        
        self._prev: str = EMPTY
        self._repr_idx: int = 0
        self._token_repr: dict[str, int] = {}
        
        self._init()
    
    def _init(self):        
        self._preprocess()
    
    def _token_to_int(self, string: str):
        """ Represent token as integer value.
        """
        self._token_repr.update({string, self._repr_idx})
        self._repr_idx += 1
        
    @property
    def token_repr_count(self) -> int:
        return len(self._token_repr)

    # def _get_sequence(self, token: str) -> list[int]:                                
    #     if isnonterminal(token):
    #         return self._create_rule_int_sequence(token)
    #     else:
    #         return self._int_map[token]

    def _init_tokens(self):
        pass
    
    def _to_sequence(self, rule):
        pass
    
    def _powerlist(self, to: list, by: list[list]) -> list[list]:
        
        if isinstance(by, list[list]):
            new_seq = [to.copy() for _ in range(len(by))]
            for i, sequence in enumerate(by):
                new_seq[i].extend(sequence)
            to = new_seq
        elif isinstance(by, list):
            for sequence in enumerate(to):
                sequence.append(by)
        elif isinstance(by, int):
            sequence.append(by)
            
        return to
        
    def _preprocess_rules(self):
        rules = self.content.split(';')
        
        # Map tokens to integers
        for nonterminal, value in TOKENS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in SPECIAL_CHARACTERS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in KEYWORDS.items():
            self.tokens[value] = nonterminal
        
        for nonterminal, value in OPERATORS.items():
            self.tokens[value] = nonterminal
            
        for nonterminal, value in DELIMITERS.items():
            self.tokens[value] = nonterminal
        
        # Separate individual rules
        for nonterminal in rules:
            nonterminal = nonterminal.strip() # Remove new lines                        
            if nonterminal.startswith("#") or nonterminal.startswith('//') or not nonterminal: continue # Disregard region markers and comments
            
            nonterminal, rules = map(str.strip, nonterminal.split(':', 1))
            rules = [word.strip() for word in rules.split('|')] # Split OR, basically rules with two or more grammars(?)
            
            self.rules[nonterminal] = rules

        # Create token-integer mapping
        for i in self.tokens:
            self._int_map[i] = len(self._int_map) + 1
        for i in self.rules:
            self._int_map[i] = len(self._int_map) + 1

        """ Sets
        """
        # Get FIRST
        # for nonterminal in self.rules.keys():
        #     self._firsts[nonterminal] = self._get_firsts(nonterminal)            

        # # Get FOLLOW
        # for nonterminal in self.rules.keys():
        #     self._get_follows(nonterminal)   
            
        # # Get LAST
        # for nonterminal in self.rules.keys():
        #     self._lasts[nonterminal] = self._get_lasts(nonterminal)

        # Create rule integer sequences mapping
        # for nonterminal, rules in self.rules.items():            
        #     for rule in rules:
        #         if not (token_sequence := separate_from_symbols(rule)):
        #             raise Exception(f"[GrammarError]: A rule cannot be empty.")

        #         for i, token in enumerate(token_sequence):  
        #             if (i + 1) >= len(token_sequence):
        #                 break
                    
        #             from_set = set()
        #             to_set = set()
        #             from_ = token
        #             to = token_sequence[i + 1]
                    
        #             if isnonterminal(from_):
        #                 from_set.update(self._lasts[from_])
        #             else:
        #                 from_set.add(self._to_int(from_))
                        
        #             if isnonterminal(to):
        #                 to_set.update(self._firsts[to])
        #             else:
        #                 to_set.add(self._to_int(to))

        #             self._add_sequence(from_set, to_set)
                    
        # Create rule int sequencing
        for nonterminal in self.rules.keys():            
            self._parse_nonterminal(nonterminal)
                    
        #region Debugging only, can be removed
        self._sequences = {k: v for k, v in sorted(self._sequences.items(), key=lambda item: item[0])}
        #endregion
        
    def _parse_nonterminal(self, nonterminal: str):
        if not nonterminal in self.rules:            
            raise Exception(f"[GrammarError]: Unknown non-terminal [{nonterminal}]")
        
        rules = self.rules[nonterminal]
        
        for i, rule in enumerate(rules):
            result = self._rule_to_int_seq(rule)
            self._nonterminal_int_seq[f'{nonterminal}_{i}'] = result
        
    def _rule_to_int_seq(self, rule: str) -> str:                       
        if not (token_sequence := separate_from_symbols(rule)):
            raise Exception(f"[GrammarError]: A rule cannot be empty.")
        
        sequence = ''
        for token in token_sequence:    
            sequence += f'{(self._to_int(token))}' + ' '
                
        return sequence    
    
    # def _get_lasts(self, rulename: str):
    #     """ Retrieve the rule's "LAST" tokens. 
    #     """
    #     if not (content := self.rules[rulename]): # Check if rule exists
    #         raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
        
    #     lasts = set()
        
    #     for grammar in content:
    #         lasts.update(self._parse_grammar_lasts(grammar))
            
    #     return lasts
    
    # def _parse_grammar_lasts(self, grammar: str):
    #     if not (token_sequence := separate_from_symbols(grammar)):
    #         raise Exception(f"[GrammarError]: A rule cannot be empty.")
            
    #     result = set()
    #     last_token = token_sequence[-1]
                    
    #     if isnonterminal(last_token):
    #         result.update(self._get_lasts(last_token))
    #         pass
    #     else:
    #         result.add(self._to_int(last_token))
        
    #     return result

    def _parse_rule(self, rulename: str) -> set:                        
        if not (content := self.rules[rulename]):
            raise Exception(f"[GrammarError]: There is no such rule [{rulename}]")
        
        sequences = set()
        for grammar in content: # content refers to a list of grammars separated by '|'           
            self._parse_grammar(grammar)
                        
        return sequences
            
    # def _get_firsts(self, rulename: str) -> set:
    #     """ Retrieve the rule's "FIRST" tokens. 
    #     """
    #     if not (content := self.rules[rulename]): # Check if rule exists
    #         raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
        
    #     firsts = set()
        
    #     for grammar in content:
    #         firsts.update(self._parse_grammar_firsts(grammar))
            
    #     return firsts
    
    # def _get_follows(self, rulename: str) -> set:  
    #     """ Retrieve the rule's "FOLLOW" tokens. 
    #     """
    #     if not (content := self.rules[rulename]): # Check if rule exists
    #         raise Exception(f"[GrammarError]: No such rule [{rulename}] exists.")
        
    #     follows = set()
        
    #     for grammar in content:
    #         self._parse_grammar_follows(grammar)
        
    #     return follows
    
    # def _parse_grammar_follows(self, grammar: str):
    #     if not (token_sequence := separate_from_symbols(grammar)):
    #         raise Exception(f"[GrammarError]: A rule cannot be empty.")
                
    #     for i, token in enumerate(token_sequence):
    #         if not isnonterminal(token): continue # Only non-terminals have FOLLOW sets
    #         result = set()
            
    #         if (i + 1) < len(token_sequence): # Check if there is next token
    #             next_token = token_sequence[i + 1]
                
    #             if isnonterminal(next_token):
    #                 result.update(self._firsts[next_token])
    #             else:
    #                 result.add(self._to_int(next_token))
                
    #             self._follows.setdefault(token, set()).update(result)
    
    def _to_int(self, token: str) -> int:
        if result := self._int_map[token]:
            return result
        raise Exception(f"[GrammarError]: Unknown token [{token}].")
    
    # def _to_token(self, value: int) -> Token:
    #     return "unimplemeneted hjaha"
    
    # def _parse_grammar_firsts(self, grammar: str) -> set:
    #     if not (token_sequence := separate_from_symbols(grammar)):
    #         raise Exception(f"[GrammarError]: A rule cannot be empty.")
        
    #     result = set()
        
    #     if isnonterminal(token_sequence[0]):
    #         result.update(self._get_firsts(token_sequence[0]))
    #     else:
    #         result.add(self._to_int(token_sequence[0]))
        
    #     return result
    
    # def _parse_grammar(self, grammar: str) -> set:        
    #     # This is just temporary. Ideally, the closures should also be taken into account
    #     # This will be eventually changed to handle closures and optionals
    #     if not (token_sequence := separate_from_symbols(grammar)):
    #         raise Exception(f"[GrammarError]: A rule cannot be empty.")
                
    #     sequence = set()
    #     for i, token in enumerate(token_sequence):
            
    #         if len(token_sequence) == 1:
    #             if isnonterminal(token):
    #                 return self._firsts[token]
    #             else:
    #                 pass
            
    #         if (i + 1) < len(token_sequence): # Check if there is still next token                
    #             from_ = self._to_int(token)
                    
    #             if isnonterminal(token): # Get firsts                    
    #                 self._add_sequence(from_, self._firsts[token])
    #             else: # is token
    #                 to = set()
    #                 to.add(self._to_int(token_sequence[i + 1]))
    #                 self._add_sequence(from_, to)
    #         else: # There is just one token
    #             pass
                            
    #     return sequence
    
    # def _add_sequence(self, from_: int | set, to: set):
    #     if isinstance(from_, int):
    #         self._sequences.setdefault(from_, set()).update(to)
    #     elif isinstance(from_, set):
    #         for i in from_:
    #             self._sequences.setdefault(i, set()).update(to)
                
    def _parse_token(self, token: str) -> list[int]:
        """ 
        """        
        
    def _preprocess(self):
        path = os.path.join(cwd, 'boop/grammar/declarations.boop')
        
        with open(path, 'r', encoding='utf-8') as file:
            self.content = file.read()
            
        self._preprocess_rules()
        
    def find_rule(self, key: str) -> tuple[bool, str, int, int]:
        # This is fucked up, needs optimizing
        for nonterminal, sequence in self._nonterminal_int_seq.items():            
            if not (index := key.find(sequence)) == -1:
                return (True, nonterminal, index, len(sequence))
        return (False, None, None, None)
    
    def parse(self, table: SymbolTable):
        if table == None: return
        
        input_sequence = [self._int_map[token.token] for token in table.tokens]
        stack = ''
        
        buffer = False
        finished = False
        j = 0
        while j < len(input_sequence) or stack:
            if finished:
                break
            # Shift
            if input_sequence:
                stack += f'{input_sequence.pop(0)} '
                j += 1
            else:
                finished = True
                
            # Keep reducing until it's not possible anymore       
            while True:
                result = self.find_rule(stack)
                
                if result[0]:
                    
                    i = result[2]
                    n = result[3]
                    
                    buffer = True
                    # Remove substring at index i of length n
                    stack = stack[:i] + stack[i + n:]
                    # Insert substring at index i of length n            
                    stack = stack[:i ] + f'{self._to_int(result[1][:-2])} ' + stack[i:] 
                else:
                    if buffer:
                        # Remove substring at index i of length n
                        stack = stack[:i] + stack[i + n:]
                        # Insert substring at index i of length n            
                        stack = stack[:i ] + f'{self._to_int(result[1][:-2])} ' + stack[i:] 
                        
                    break

        if len(stack.strip().split()) == 1:
            print('Successful parse')
        else:
            print('Syntax error')
            
        print()
                
        
