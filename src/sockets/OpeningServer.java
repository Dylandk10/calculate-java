package sockets;
import java.net.*;
import java.io.*;

public class OpeningServer extends Thread {
	private ServerSocket serverSocket;
	Socket server;
	InputStream owr;
	
	public OpeningServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	//connecting serve to client
	public void run() {
		try {
			System.out.println("Waiting for client " + serverSocket.getLocalPort() + "...");
			server = serverSocket.accept();
			System.out.println("Server Connected to " + server.getRemoteSocketAddress());
			server.getKeepAlive();
		} catch (SocketTimeoutException s) {
			System.out.println("Server timed out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read() {
		//read outputstream
		try {
			owr = server.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				int character;
				while((character = owr.read()) != -1) {
					System.out.println("Message: " + character);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
