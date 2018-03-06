package sockets;
import java.net.*;
import java.io.*;

public class OpeningServer extends Thread {
	private ServerSocket serverSocket;
	
	public OpeningServer(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	//connecting serve to client
	public void run() {
		try {
			System.out.println("Waiting for client " + serverSocket.getLocalPort() + "...");
			Socket server = serverSocket.accept();
			System.out.println("Connected to " + server.getRemoteSocketAddress());
			server.close();
		} catch (SocketTimeoutException s) {
			System.out.println("Server timed out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
