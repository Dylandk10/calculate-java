package sockets;
import java.net.*;
import java.io.*;

public class OpeningServer extends Thread {
	private ServerSocket serverSocket;
	Socket server;
	
	public OpeningServer(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	//connecting serve to client
	public void run() {
		try {
			System.out.println("Waiting for client " + serverSocket.getLocalPort() + "...");
			server = serverSocket.accept();
			System.out.println("Server Connected to " + server.getRemoteSocketAddress());
			server.close();
		} catch (SocketTimeoutException s) {
			System.out.println("Server timed out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean recNum(int num) {
		try {
			if(server.isConnected()) {
				server.sendUrgentData(num);
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
