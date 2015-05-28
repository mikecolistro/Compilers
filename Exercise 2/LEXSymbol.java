package parser;

import java_cup.runtime.Symbol;

public class LEXSymbol extends Symbol {

	protected String my_text;
	
	public LEXSymbol(int t,int l,int r,String txt) {
		super(t,l,r);
		my_text = txt;
	}
	
	public LEXSymbol(int t,int l,int r,Object o,String txt) {
		super(t,l,r,o);
		my_text = txt;
	}
	
	public String toString() {
		return "'" +  my_text + "'";
	}
}
