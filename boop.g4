grammar boop;


LOWER: [a-z]+;
UPPER: [A-Z]+;
DIGIT: [0-9]+ ;
SPECIAL
    : ' ' | '.'
    ;
MATH: '√'
    ;

// Keywords
ABSTRACT   : 'abstract';
ALIAS      : 'alias';
BASE       : 'base';
BOOL       : 'bool';
BREAK      : 'break';
CASE       : 'case';
CATCH      : 'catch';
CHAR       : 'char';
CLASS      : 'class';
CONST      : 'const';
CONSTANT   : 'constant';
CONTINUE   : 'continue';
DEFAULT    : 'default';
DICT       : 'dict';
DICTIONARY : 'dictionary';
DO         : 'do';
DOUBLE     : 'double';
ELSE       : 'else';
ENUM       : 'enum';
ENUMERATION: 'enumeration';
EVENT      : 'event';
FALSE      : 'false';
FLOAT      : 'float';
FOR        : 'for';
FOREACH    : 'foreach';
FORMAT     : 'format';
FOR_TIME   : 'fortime';
FROM       : 'from';
FUNC       : 'func';
GET        : 'get';
IF         : 'if';
IMPORT     : 'import';
INHERIT    : 'inherit';
INT        : 'int';
INTERFACE  : 'interface';
LIST       : 'list';
MILLISEC   : 'millisec';
MODULE     : 'module';
NULL       : 'null';
OVERRIDE   : 'override';
PRIVATE    : 'private';
PROTECTED  : 'protected';
PUBLIC     : 'public';
RECUR      : 'recur';
REF        : 'ref';
RETURN     : 'return';
SECOND     : 'second';
SET        : 'set';
STATIC     : 'static';
STRING     : 'string';
STRUCT     : 'struct';
SWITCH     : 'switch';
THIS       : 'this';
THROW      : 'throw';
TIME       : 'time';
TRUE       : 'true';
TRY        : 'try';
VIRTUAL    : 'virtual';
VOID       : 'void';
WHILE      : 'while';
WHERE      : 'where';

ANGLD_L: '<';
ANGLD_R: '>';
BRCKT_L: '[';
BRCKT_R: ']';
COLON: ':';
COMMA: ',';
CURLY_L: '{';
CURLY_R: '}';
EQUALS: '=';
PAREN_L: '(';
PAREN_R: ')';
RET_TYPE: '->';
SEMICOLON: ';';

END_STMNT: SEMICOLON;
UNDERSCORE : '_' ;
OP_EQUALITY: EQUALS;
INHERITS: COLON | INHERIT;

CHARACTER
    : UPPER | LOWER | DIGIT | SPECIAL | MATH
    ;

Identifier_Start_Character
    : UNDERSCORE
    | UPPER | LOWER
    ;

Identifier_Character
    : UPPER | LOWER | DIGIT
    ;

identifier
    : Identifier_Start_Character Identifier_Character*
    ;

modifiers
    : access_modifier
    | access_modifier access_modifier
    ;

access_modifier
    : PUBLIC | PRIVATE | PROTECTED
    ;

data_primitive
    : INT | CHAR | FLOAT | DOUBLE | STRING
    ;

data_ref : identifier ;

dataType
    : data_primitive
    | data_ref
    ;

value
    : 's'
    ;

constant
    : value
    ;

varDeclaration
    : modifiers? dataType identifier END_STMNT
    | modifiers? dataType identifier OP_EQUALITY expression END_STMNT
    ;

statement
    : expression+
    ;

expression
    : constant
    | identifier
    | functionCall
    ;

block
    :
    ;

functionParam
    : dataType identifier
    ;

functionParams
    : functionParam (',' functionParam)+
    ;

functionBody
    : CURLY_L block CURLY_R
    ;

typeParameters
    : ANGLD_L dataType (COMMA dataType)* ANGLD_R
    ;

functionHeading
    : modifiers?
    FUNC identifier typeParameters functionParams functionBody
    ;

functionArgs
    : expression+
    ;

functionCall
    : identifier PAREN_L functionArgs? PAREN_R
    ;

classBody
    : CURLY_L varDeclaration* CURLY_R
    ;

classHeading
    : modifiers? CLASS identifier (INHERITS identifier)? interfaceSignature? classBody
    ;

interfaceSignature
    : PAREN_L identifier (COMMA identifier)* PAREN_R
    ;

moduleBody
    : CURLY_L classHeading* CURLY_R
    ;

moduleHeading
    : MODULE identifier moduleBody
    ;

keyword
    : ABSTRACT    | ALIAS       | BASE       | BOOL        | BREAK
    | CASE        | CATCH       | CHAR       | CLASS       | CONST
    | CONSTANT    | CONTINUE    | DEFAULT    | DICT        | DICTIONARY
    | DO          | DOUBLE      | ELSE       | ENUM        | ENUMERATION
    | EVENT       | FALSE       | FLOAT      | FOR         | FOREACH
    | FORMAT      | FOR_TIME    | FROM       | FUNC        | GET
    | IF          | IMPORT      | INHERIT    | INT         | INTERFACE
    | LIST        | MILLISEC    | MODULE     | NULL        | OVERRIDE
    | PRIVATE     | PROTECTED   | PUBLIC     | RECUR       | REF
    | RETURN      | SECOND      | SET        | STATIC      | STRING
    | STRUCT      | SWITCH      | THIS       | THROW       | TIME
    | TRUE        | TRY         | VIRTUAL    | VOID        | WHILE
    | WHERE
    ;

operator
    :
    ;

token
    : identifier
    | keyword
    | operator
    ;
