
public class ToHexadecimal {
	public String decimalToHexadecimal(String number) {
		int hold = Integer.parseInt(number);
		String result = Integer.toHexString(hold);
		this.printStringHex(result);
		return "0x" + result;
	}
	public void printStringHex(String res) {
		System.out.println(res);
	}
}
