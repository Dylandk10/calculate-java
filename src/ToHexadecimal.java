
public class ToHexadecimal {
	public String decimalToHexadecimal(String number) {
		int hold = Integer.parseInt(number);
		String result = Integer.toHexString(hold);
		this.printStringHex(result);
		return "0x" + result;
	}
	public String binaryToHexadecimal(String number) {
		String[] stringArr = number.split(" ");
		String hexReturn = "";
		for(int i = 0; i < stringArr.length; i++) {
			if(i >= 2) {
				System.out.println(i);
				hexReturn = "Enter Valid Bianry";
			} else {
				int hold = Integer.parseInt(number, 2);
				hexReturn  = Integer.toString(hold, 16);
			}
		}
		return hexReturn;
		
	}
	public void printStringHex(String res) {
		System.out.println(res);
	}
}
