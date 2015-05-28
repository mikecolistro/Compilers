//----------------------------------------------------
// The following class is used to pinpoint locations 
// inside a source file
//----------------------------------------------------

package parser;

public class SrcLoc {
	private int    source_line;
	private int    source_col;
	
	private String source_file;
	public SrcLoc(int l,int c,String f) { source_line = l;source_col = c;source_file = f;}
	public String toString() { return source_file + ":" + source_line + ":" + source_col;}
}
