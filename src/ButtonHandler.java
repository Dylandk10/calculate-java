
public class ButtonHandler {
	private String result = "";
	public String addResult(String incoming) {
		result += incoming;
		return result;
	}
	public void getResult() {
		System.out.println(this.result);
	}
	public String returnResult() {
		return result;
	}
	public void clearResult() {
		result = "";
	}
	public void clearAll() {
		Calculate calc = new Calculate();
		ToBinary tobi = new ToBinary();
		this.result = "";
		calc.clearAll();
		tobi.clearAll();
		
	}
}
