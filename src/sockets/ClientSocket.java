package sockets;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
	Thread thread;
	Socket client;
	public void run() {
		//socket connection...
		final int port = 8080;
		final String serverName = "localhost";
		try {
			thread = new OpeningServer(port);
			client = new Socket(serverName, port);
			thread.start();
			System.out.println("Client connect to " + client.getRemoteSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
