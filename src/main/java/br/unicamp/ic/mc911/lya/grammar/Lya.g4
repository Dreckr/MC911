grammar Lya;

fragment Character : .;

fragment LINECOMMENT : '//';
fragment OPENCOMMENT : '/*';
fragment CLOSECOMMENT : '*/';

DIGIT : [0-9] ;
WS : [ \t\r\n]+ -> skip;

Nl :  '\r'? '\n';
BlockComment :  OPENCOMMENT Character*?  CLOSECOMMENT Nl -> skip;
LineComment: LINECOMMENT Character*? Nl -> skip;

// Lexer

COMMA : ',';
COLON : ':';
SEMICOLON : ';';
UNDERSCORE : '_';
EQUALS : '=';
SINGLEQUOTE : '\'';
DOUBLEQUOTE : '\"';
LPARENS : '(' ;
RPARENS : ')';
LBRACKET : '[' ;
RBRACKET : ']';

ARROW : '->';
STRINGCONCAT : '&';


// Arithmetic operators
PLUS : '+';
MINUS : '-';
TIMES : '*';
DIVIDE : '/';
MODULO : '%';

// Relational operators
AND : '&&';
OR : '||';
NOT : '!' ;
EQ : '==' ;
NEQ : '!=' ;
LT : '<' ;
LE : '<=' ;
GT : '>' ;
GE : '>=' ;

// Reserved words
ARRAY : 'array';
BY : 'by';
CHARS : 'chars';
DCL : 'dcl';
DO : 'do';
DOWN : 'down';
ELSE : 'else';
ELSIF : 'elseif';
END : 'end';
EXIT : 'exit';
FI : 'fi';
FOR : 'for';
IF : 'if';
IN : 'in';
LOC : 'loc';
TYPE : 'type';
OD : 'od';
PROC : 'proc';
REF : 'ref';
RESULT : 'result';
RETURN : 'return';
RETURNS : 'returns';
SYN : 'syn';
THEN : 'then';
TO : 'to';
WHILE : 'while';

// Predefined words
BOOL : 'bool';
CHAR : 'char';
FALSE : 'false';
INT : 'int';
LENGTH : 'length';
LOWER : 'lower';
NULL : 'null';
NUM : 'num';
PRED : 'pred';
PRINT : 'print';
READ : 'read';
SUCC : 'succ';
TRUE : 'true';
UPPER : 'upper';

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]*;
CharLiteral : '\'' Character? '\'';
StringLiteral : '\"' Character*? '\"';

UnterminatedBlockComment :  OPENCOMMENT Character*?  Nl { System.out.println("Unterminated comment"); } -> skip;
UnterminatedStringLiteral : '"' Character*? ~["] { System.out.println("Unterminated string"); } -> skip;

// Parser

program : statement+;
statement : declaration_statement
             | synonym_statement
             | newmode_statement
             | procedure_statement
             | action_statement;

declaration_statement : DCL declaration_list SEMICOLON;
declaration_list : declaration ( COMMA declaration )*;
declaration : identifier_list modo initialization?;
initialization :  assignment_symbol expression;
identifier_list : IDENTIFIER ( COMMA IDENTIFIER )*;

synonym_statement : SYN synonym_list SEMICOLON;
synonym_list : synonym_definition ( COMMA synonym_definition )*;
synonym_definition : identifier_list modo? EQUALS constant_expression;
constant_expression : expression;

newmode_statement : TYPE newmode_list SEMICOLON;
newmode_list : mode_definition ( COMMA mode_definition )*;
mode_definition : identifier_list EQUALS modo;
modo :  mode_name
        | discrete_mode
        | reference_mode
        | composite_mode;
discrete_mode :  integer_mode
                 | boolean_mode
                 | character_mode;
mode_name : IDENTIFIER;
integer_mode :  INT;
boolean_mode :  BOOL;
character_mode : CHAR;
discrete_mode_name : IDENTIFIER;
literal_range : lower_bound COLON upper_bound;
upper_bound : expression;
lower_bound : expression;
reference_mode : REF modo;
composite_mode : string_mode | array_mode;
string_mode : CHARS LBRACKET string_length RBRACKET;
string_length : integer_literal; // integer_literal_expression
array_mode : ARRAY LBRACKET index_mode ( COMMA index_mode )* RBRACKET element_mode;
index_mode : discrete_mode | literal_range;
element_mode : modo;

//location :  location_name
//            | dereferenced_reference
//            | string_element
//            | string_slice
//            | array_element // location -> array_element -> array_location -> location causes left recursion
//            | array_slice // location -> array_slice -> array_location -> location causes left recursion
//            | call_action;
location :  simple_location
            | array_location;
simple_location : location_name
            | dereferenced_reference
            | string_element
            | string_slice
            | call_action;
location_name: IDENTIFIER; // added
dereferenced_reference : primitive_value ARROW;
string_element : string_location LBRACKET start_element RBRACKET;
start_element : integer_expression;
string_slice : string_location LBRACKET left_element COLON right_element RBRACKET;
string_location : IDENTIFIER;
left_element : integer_expression;
right_element : integer_expression;
array_element : LBRACKET expression_list RBRACKET; // changed
expression_list : expression ( COMMA expression )*;
array_slice : LBRACKET lower_bound COLON upper_bound RBRACKET; // changed
array_location : simple_location array_location_range+; // changed
array_location_range : array_element | array_slice; // added
primitive_value :  (literal | array_primitive_value) parenthesized_expression?; // changed

literal : integer_literal
          | boolean_literal
          | character_literal
          | empty_literal
          | character_string_literal;
integer_literal :  digit_sequence;
digit_sequence : ( DIGIT | UNDERSCORE )+;
boolean_literal : FALSE | TRUE;
character_literal : CharLiteral;
empty_literal : NULL;
character_string_literal : StringLiteral;

value_array_element : LBRACKET expression_list RBRACKET; // changed
value_array_slice : LBRACKET lower_bound COLON upper_bound RBRACKET; // changed
array_primitive_value_complement : value_array_element | value_array_slice; // added
array_primitive_value : literal array_primitive_value_complement+; // changed
parenthesized_expression : LPARENS expression RPARENS;
expression : operand0 | conditional_expression;
conditional_expression :  IF boolean_expression then_expression else_expression FI
                          | IF boolean_expression then_expression elsif_expression else_expression FI;
boolean_expression : expression;
then_expression : THEN expression;
else_expression : ELSE expression;
elsif_expression :  ELSIF boolean_expression then_expression
                    | elsif_expression ELSIF boolean_expression then_expression;

operand0 :  operand1
            | operand0 operator1 operand1;
operator1 :  relational_operator
             | membership_operator;
relational_operator :  AND | OR | NOT | EQ | NEQ | GT | GE | LT | LE;
membership_operator : IN;
operand1 :  operand2
            | operand1 operator2 operand2;
operator2 : arithmetic_additive_operator
             | string_concatenation_operator;
arithmetic_additive_operator : PLUS | MINUS;
string_concatenation_operator : STRINGCONCAT;
operand2 :  operand3
            | operand2 arithmetic_multiplicative_operator operand3;
arithmetic_multiplicative_operator :  TIMES | DIVIDE | MODULO;
operand3 :  monadic_operator? operand4
            | integer_literal;
monadic_operator : MINUS | NOT;
operand4 :  location | referenced_location | primitive_value;
referenced_location : ARROW location;

action_statement : ( label_id COLON )? action SEMICOLON;
label_id : IDENTIFIER;
action :  bracketed_action
          | assignment_action
          | call_action
          | exit_action
          | return_action
          | result_action;
bracketed_action : if_action | do_action;
assignment_action : location assigning_operator expression;
assigning_operator : closed_dyadic_operator? assignment_symbol;
closed_dyadic_operator :  arithmetic_additive_operator
                          | arithmetic_multiplicative_operator
                          | string_concatenation_operator;

assignment_symbol : EQUALS;
if_action : IF boolean_expression then_clause else_clause? FI;
then_clause : THEN ( action_statement )*;
else_clause : ELSE ( action_statement )*
               | ELSIF boolean_expression then_clause else_clause?;

do_action : DO ( control_part SEMICOLON )? ( action_statement )* OD;
control_part : for_control while_control?
                | while_control;
for_control : FOR iteration;
iteration : step_enumeration | range_enumeration;
step_enumeration : loop_counter assignment_symbol
    start_value step_value? DOWN? end_value;
loop_counter : IDENTIFIER;
start_value : discrete_expression;
step_value : BY integer_expression;
end_value : TO discrete_expression;
discrete_expression : expression;
integer_expression : expression; // added
range_enumeration : loop_counter DOWN? IN discrete_mode;
while_control : WHILE boolean_expression;

call_action :  builtin_call | procedure_call;
procedure_call : procedure_name LPARENS parameter_list? RPARENS;
parameter_list : parameter ( COMMA parameter )*;
parameter : expression;
exit_action : EXIT label_id;
return_action : RETURN result?;
result_action : RESULT result;
result : expression;
builtin_call : builtin_name LPARENS parameter_list? RPARENS;
builtin_name : NUM | PRED | SUCC | UPPER | LOWER | LENGTH | READ | PRINT;

procedure_name : label_id; // added
procedure_statement : procedure_name COLON procedure_definition SEMICOLON;
procedure_definition :
 PROC LPARENS formal_parameter_list? RPARENS result_spec? SEMICOLON
 ( statement )* END;
formal_parameter_list : formal_parameter ( COMMA formal_parameter )*;
formal_parameter :    identifier_list parameter_spec;
parameter_spec :  modo parameter_attribute?;
parameter_attribute : LOC;
result_spec : RETURNS LPARENS modo result_attribute? RPARENS;
result_attribute : LOC;
