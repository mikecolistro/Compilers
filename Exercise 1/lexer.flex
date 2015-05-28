
package lexer;

%%
   
/* -----------------Options and Declarations Section----------------- */
  
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

/*
  Turn line counting and column counting on. 
  Use the member variables yyline, yycolumn respectively.
*/
%line
%column

/*
CUP compatibility mode 
*/
/* %cup */

%function nextToken
%type Token
%eofval{

 /* FILL IN code on how you handle the EOF goes here */
System.out.println("Token: eof");
System.exit(0);
%eofval}
%eofclose

/*
  Declarations
  
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   


%}
   
/*
  Macro Declarations
  
  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.  
  
*/

/* FILL IN Macro Declarations as needed */

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
whitespace =  \t\r\n
integer	= 0|[1-9][0-9]*
seperator = ;
binaryOperators	= \+|\-|\*|\/|<=|>=|==|\!=|<|>|\&\&|\|\||\!
dot = \.|\.\.
comma 	= ,
brackets = \[\]|\[|\]|\{|\}|\(|\)
int = (int) 
bool =  (bool)
void = (void)
while = (while)
if = (if)
else = (else)
for = (for)
self = (self)
class  = (class)
extends	= (extends)
new = (new)
return = (return)
identifiers = [a-zA-Z_0-9]*
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*


%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   
   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. You can make new states as needed. */
 
 <YYINITIAL> {
    
    /* FILL IN token regular expressions */
	
	{whitespace}                   { /* ignore */ }
	{integer}    {System.out.println("Token:num = " + yytext());}
	{seperator}   {System.out.println("Token:;");}
	{binaryOperators}     {System.out.println("Token: " + yytext());}
	{dot}     {System.out.println("Token:.");}
	{comma}   {System.out.println("Token:,");}
	{brackets}   {System.out.println("Token: " + yytext());}
	{int}    {System.out.println("Token:int");}
	{bool}   {System.out.println("Token:bool");}
	{void}   {System.out.println("Token:void");}
	{while}  {System.out.println("Token:while");}
	{if}   {System.out.println("Token:if");}
	{else}   {System.out.println("Token:else");}
	{for}   {System.out.println("Token:for");}
	{self}   {System.out.println("Token:self");}
	{class}  {System.out.println("Token:class");}
	{extends}   {System.out.println("Token:extends");}
	{new}	{System.out.println("Token:new");}
	{return} {System.out.println("Token:return");}
	{identifiers}   {System.out.println("Token:id = " + yytext());}
	{Comment} {System.out.println("Token:comment = " + yytext());}
	}

/* More states can be declared here as needed */

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */

[^]                    { /* FILL IN action */ }
