
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Driver {
	String[] my_args;
	public static void main(String[] args) {
		Driver d = new Driver(args);
		d.run();
	}
	
	public Driver(String[] args) {
		my_args = args;
	}
	
	public void run() {
		System.out.println("scanning [" + my_args[0] + "]");
		try {
			FileReader fr = new FileReader(new File(my_args[0]));
			Lexer l = new Lexer(fr);
			Token s = null ;
			try {				
				do{
					s = l.nextToken();
					System.out.println("Token: " + s.toString());
				} while (s.thislabel != Token.Label.EOF);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
