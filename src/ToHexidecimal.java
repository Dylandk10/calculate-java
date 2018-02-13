
public class ToHexidecimal {
	public String decimalToHexidecimal(String number) {
		int hold = Integer.parseInt(number);
		String result = Integer.toHexString(hold);
		this.printStringHex(result);
		return "0x" + result;
	}
	public void printStringHex(String res) {
		System.out.println(res);
	}
}
