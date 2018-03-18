package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocket {
	OpeningServer thread;
	Socket client;
	public void run() throws InterruptedException {
		//socket connection...
		final int port = 8080;
		final String serverName = "localhost";
		try {
			thread = new OpeningServer(port);
			client = new Socket(serverName, port);
			thread.run();
			System.out.println("Client connect to " + client.getRemoteSocketAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//output stream is buggy need to fix...
	public boolean sendData(int num) {
		boolean result;
		try {
			//OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
			DataOutputStream osw = new DataOutputStream(client.getOutputStream());
			osw.writeInt(num);
			osw.flush();
			osw.close();
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = false;
		return result;
	}
	public void close() {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
