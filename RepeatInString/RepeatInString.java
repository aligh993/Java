// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

public class RepeatInString {
    public static int StringInString(String one, String two) {
    	if ((one == null || one == "") || (two == null || two == "")) {
    		System.out.println(0);
    	}
    	else {
    		int count = 0, fromIndex = 0;
            while ((fromIndex = one.indexOf(two, fromIndex)) != -1 ){
                count++;
                fromIndex++;
            }
        	System.out.println(count);
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	StringInString("salam", "sal");
    	StringInString("golgoli", "gol");
    	StringInString("sasasas", "sas");
    	StringInString(null, null);
    	StringInString("", "");
    	StringInString("", null);
    	StringInString(null, "");
    }
}