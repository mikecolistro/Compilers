

package bonus6;

import java.util.ArrayList;
import java.util.regex.*;
/**
 *
 * @author Michael
 */
public class Bonus6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> iplist = new ArrayList<String>();
        iplist.add("192.102.100");
        iplist.add("a.b.c.d");
        iplist.add("1.2.3.800");
        iplist.add("1.2.3");
        iplist.add("192.168.1.1");
        iplist.add("10.10.10.10");
        iplist.add("127.0.0.1");
        String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        
        for(int i = 0; i < iplist.size();i++){
            boolean matches = Pattern.matches(IPADDRESS_PATTERN, iplist.get(i));
            if (matches){
                System.out.println(iplist.get(i) + " is valid");
            }
            else{
                System.out.println(iplist.get(i) + " is invalid");
            }
    
        }
    }
    
}
