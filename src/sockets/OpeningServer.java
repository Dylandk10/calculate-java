package sockets;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.*;

//parts of this is taken from stack overflow .. read me contains credit 
public class OpeningServer extends JFrame {
	private ServerSocket serverSocket;
	Socket server;
	//InputStream owr;
	DataInputStream owr;
	private Socket conn;
	private JTextArea TA;
	private JPanel panel1;
	private final int mainPort;
	public OpeningServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(new Dimension(400, 300));
	    Container c = getContentPane();
	    c.setBackground(Color.BLACK);
	    TA = new JTextArea();
	    TA.setEditable(true);
	    TA.setBackground(Color.BLACK);
	    TA.setForeground(Color.GREEN);
	    c.add(new JScrollPane(TA));
	    setVisible(true);
	    log(TA, "Server started. \n");
	    mainPort = port;
	}
	//connecting serve to client
	public void run() throws IOException {
	    try {
	        log(TA, "ServerSocket created. \n Listering for connections... \n");
	       //serverSocket = new ServerSocket(mainPort);

	        for (int i = 1; i < 2; i++) {
	            conn = serverSocket.accept();
	            log(TA, "User " + i + " connected");
	        }
	    } catch (IOException ioe) {
	        System.out.println(ioe);
	    }
	    
	}
	public void log(JTextArea txt, String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                txt.append(message);
            }});
	}
	
	//not working for reading bits!!
	public void read() {
		//read outputstream
		try {
			owr = new DataInputStream((server.getInputStream()));
			//owr = server.getInputStream();
			int character;
			while((character = owr.readInt()) != -1) {
				log(TA, Integer.toString(character));
				System.out.println(character);
			}
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
