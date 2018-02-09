
public class Calculate {
	int numberOne = 0;
	int numberTwo = 0;
	int recentTotal = 0;
	public void init(int numberOne, int numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}
	public int add() {
		recentTotal = this.numberOne + this.numberTwo;
		return recentTotal;
	}
	public int subtract() {
		recentTotal = this.numberOne - this.numberTwo;
		return recentTotal;
	}
	public int divide() {
		if(this.numberTwo != 0) {
			recentTotal = this.numberOne / this.numberTwo;
			return recentTotal;
		} else {
			return 0;
		}
	}
	public int multiply() {
		recentTotal = this.numberOne * this.numberTwo;
		return recentTotal;
	}
	//send the last total to become binary string
	public void toBinary() {
		ToBinary toBinary = new ToBinary();
		String sendOff = Integer.toString(this.recentTotal);
		toBinary.decide(sendOff);
	}

}
