import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToBinary {
    String result = "";
    int result1 = 0;
    //main method to decide if the incoming is hex or decimal
    public boolean decide(String incomingNumber) {
    	//regex to ensure that only A-F can be used exept for x.
    	final String reg = "[g-zG-Z&&[^xX]]+";
    	Pattern pattern = Pattern.compile(reg);
    	Matcher matcher = pattern.matcher(incomingNumber);
    		if(incomingNumber.length() == 0 || matcher.find()) {
    			System.out.println("Must enter a valid hexadecimal or decical number...");
    			return false;
    		}
    		else if(incomingNumber.indexOf("0x") == -1) {
    			//this.decToBinaryString(incomingNumber);
    			return true;
    		} else {
    			//this.convertStringHex(incomingNumber);
    			return true;
    		}
    }
    //convert hex string to binary string
    public String convertStringHex(String str) {
    	System.out.println("Hexform: " + str);
	if(str.indexOf("0x") != -1) {
	    String[] ch = str.split("x"); 
	    for(int i = 0; i < ch.length; i++) {
		int num = Integer.parseInt(ch[i], 16);
		result = Integer.toBinaryString(num);
		this.printString("binary form: " + result); 
	    }
	} else {
	    result = result;
	}
	return result;
    }
    //take in hex number return hexnumber
    public int convertIntHex(int hexForm) {
    	int result = 0;
    		System.out.println(hexForm);
    		String holdHex = Integer.toString(hexForm);
    		System.out.println(holdHex);
    		if (holdHex.indexOf("0x") != -1) {
    			String[] holdCh = holdHex.split("x");
    			for(int j = 0; j < holdHex.length(); j++) {
    				int hexNum = Integer.parseInt(holdCh[j], 16);
    				result = Integer.bitCount(hexNum);
    				this.printInt(result);
    			}
    		}
    		return result;
    }
    //convert dec to binary...
    public String decToBinaryString(String number) {
    		int hold = Integer.parseInt(number);
    		String result = Integer.toBinaryString(hold);
    		this.printString(result);
    		return result;
    }
    //return a integer for easier manipulation 
    public int getNumber(String string) {
    		result1 = Integer.parseInt(string);
    		return result1;
    }
    //show string of binary number
    public void printString(String stringResult) {
    	System.out.print(stringResult);
    }
    public void printInt(int intResult) {
    		System.out.println(intResult);
    }
    public void clearAll() {
        this.result = "";
        this.result1 = 0;
    }
}
