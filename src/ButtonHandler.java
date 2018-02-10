
public class ButtonHandler {
	private String result = "";
	public String addResult(String incoming) {
		result += incoming;
		this.getResult();
		return result;
	}
	public void getResult() {
		System.out.println(this.result);
	}
}
