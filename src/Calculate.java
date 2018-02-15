
public class Calculate {
	String numberOne = "";
	String numberTwo = "";
	int recentTotal = 0;
	String operator = "";
	boolean watch = false;
	
	public void setOperator(String newOperator, String newNumber) {
		if(!watch) {
			this.operator = newOperator;
			this.numberOne = newNumber;
			this.watch = true;
		} else {
			this.numberTwo = newNumber;
			this.watch = false;
		}
	}
	public String getInitOne() {
		return this.numberOne;
	}
	public String getInitTwo() {
		return this.numberTwo;
	}
	public int calculate(String incomingTwo) {
		//convert the watch operator back
		this.watch = false;
		this.numberTwo = incomingTwo;
		if(numberOne == "") {
			numberOne = "0";
		}
		if(numberTwo == "") {
			numberTwo = "0";
		}
		System.out.println(operator);
		int numOne = Integer.parseInt(numberOne);
		int numTwo = Integer.parseInt(numberTwo);
		System.out.println(numOne);
		System.out.println(numTwo);
		switch (operator) {
		case "+":
			recentTotal = numOne + numTwo;
			break;
		case "-":
			recentTotal = numOne - numTwo;
			break;
		case "*":
			recentTotal = numOne * numTwo;
			break;
		case "/":
			if (numTwo == 0) {
				recentTotal = 0;
			} else {
			recentTotal = numOne / numTwo;
			break;
			}
		}
		System.out.println(recentTotal);
		return recentTotal;
	}

	//send the last total to become binary string
	public String toBinary() {
		ToBinary toBinary = new ToBinary();
		String sendOff = Integer.toString(this.recentTotal);
		String res = toBinary.decToBinaryString(sendOff);
		return res;
	}
	public String toHexidecimal() {
		ToHexadecimal hexDec = new ToHexadecimal();
		String sendIt = Integer.toString(this.recentTotal);
		String res = hexDec.decimalToHexadecimal(sendIt);
		return res;
	}
	public void clearAll() {
		this.numberOne = "";
		this.numberTwo = "";
		this.recentTotal = 0;
		this.operator = "";
		this.watch = false;
	}

}
