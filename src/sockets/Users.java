package sockets;

public class Users {
	String userName;
	String port;
	public Users(String name, String port) {
		this.userName = name;
		this.port = port;
	}
	public String returnName() {
		return this.userName;
	}
	public void logInfo() {
		System.out.println("Username: " + this.userName + " on port: " + this.port);
	}

}
