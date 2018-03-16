package sockets;
import java.util.ArrayList;

public class Users {
	String userName;
	String portAddress;
	//make second class for array methods...
	public ArrayList<String>userArray = new ArrayList<String>();
	public Users(String name, String port) {
		this.userName = name;
		this.portAddress = port;
		addUser(name);
	}
	public void logInfo() {
		System.out.println("Username: " + this.userName + " User port: " + this.portAddress);
		System.out.println(userArray);
	}
	//push to logged users
	public ArrayList<String> addUser(String newUser) {
		userArray.add(newUser);
		return userArray;
	}
	public ArrayList<String> returnUsers() {
		return userArray;
	}
}
