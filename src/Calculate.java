
public class Calculate {
	String numberOne = "";
	String numberTwo = "";
	int recentTotal = 0;
	String operator = "";
	public void init(String newNumber) {
		if(operator == "") {
			this.numberOne = newNumber;
		} else {
			this.numberTwo = newNumber;
		}

	}
	public void setOperator(String newOperator) {
		this.operator = newOperator;
	}
	public String getInitOne() {
		return this.numberOne;
	}
	public String getInitTwo() {
		return this.numberTwo;
	}
	public int calculate() {
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
		}
		System.out.println(recentTotal);
		return recentTotal;
	}

	//send the last total to become binary string
	public void toBinary() {
		ToBinary toBinary = new ToBinary();
		String sendOff = Integer.toString(this.recentTotal);
		toBinary.decide(sendOff);
	}

}
