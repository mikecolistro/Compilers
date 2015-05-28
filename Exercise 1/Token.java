

public class Token {
	public enum Label { 	
		EOF,DIVIDE,GTEQ,LBRACKET,UMINUS,SMALLER,LPAREN,GREATER,SEMI,MINUS,RPAREN,
		NOT,AND,OR,COMMA,CLASS,PBRACKET,TBOOL,DOTDOT,PLUS,ASSIGN,IF,ID,DOT,RETURN,
		RBRACKET,NEW,error,SELF,NUMBER,MOD,NEQ,TVOID,TIMES,TINT,COLON,ELSE,LBRACE,
		WHILE,EQL,SMEQ,RBRACE,EXTENDS,COMMENT,FOR
	};
	Label thislabel;
	int  thisline;
	int  thiscol;
	Object thisval;
	
	public Token(Label t,int l,int c) {
		thislabel = t;
		thisline = l;
		thiscol = c;
		thisval = null;
	}
	
	public Token(Label t,int l,int c,Object v) {
		thislabel = t;
		thisline = l;
		thiscol = c;
		thisval = v;		
	}
	
	public Token(Label t) {
		thislabel = t;
		thisline = -1;
		thiscol = -1;
		thisval = null;		
	}
		
	public String toString() {
		switch(thislabel) {
		case EOF: return "eof";
		case DIVIDE: return "/";
		case GTEQ: return ">=";
		case LBRACKET: return "[";
		case UMINUS: return "-";
		case SMALLER: return "<";
		case LPAREN: return "(";
		case GREATER: return ">";
		case SEMI: return ";";
		case MINUS: return "-";
		case RPAREN: return ")";
		case NOT: return "!";
		case AND: return "&&";
		case OR: return "||";
		case COMMA: return ",";
		case CLASS: return "class";
		case PBRACKET: return "[]";
		case TBOOL: return "bool";
		case DOTDOT: return "..";
		case PLUS: return "+";
		case ASSIGN: return ":=";
		case IF: return "if";
		case ID: return "id = " + thisval.toString() + "";
		case DOT: return ".";
		case RETURN: return "return";
		case RBRACKET: return "]";
		case NEW: return "new";
		case error: return "error";
		case SELF: return "self";
		case NUMBER: return "number = " + thisval.toString() + "";
		case MOD: return "%";
		case NEQ: return "!=";
		case TVOID: return "void";
		case TIMES: return "*";
		case TINT: return "int";
		case COLON: return ":";
		case ELSE: return "else";
		case LBRACE: return "{";
		case WHILE: return "while";
		case EQL: return "==";
		case SMEQ: return "<=";
		case RBRACE: return "}";
		case EXTENDS: return "extends";
		case COMMENT: return "comment";
		case FOR: return "for";
		}
		return "<<invalid token>>";		
	}
}
