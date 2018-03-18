package sockets;

public class Users {
	String userName;
	String port;
	UserArray<String> usArray = new UserArray<String>();
	public Users(String name, String port) {
		this.userName = name;
		this.port = port;
		usArray.push(name);
	}
	public void logInfo() {
		System.out.println("Username: " + this.userName + " on port: " + this.port);
	}

}
