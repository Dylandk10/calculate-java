package sockets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocket {
	Thread thread;
	Socket client;
	public void run() throws InterruptedException {
		//socket connection...
		final int port = 8080;
		final String serverName = "localhost";
		try {
			thread = new OpeningServer(port);
			client = new Socket(serverName, port);
			thread.start();
			System.out.println("Client connect to " + client.getRemoteSocketAddress());
			client.getKeepAlive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//output stream is buggy need to fix...
	public boolean sendData(int num) {
		boolean result;
		try {
			OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
			osw.write(num);
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = false;
		return result;
	}
}
