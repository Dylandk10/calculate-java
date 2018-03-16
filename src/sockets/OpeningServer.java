package sockets;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	Users users = new Users("Main", "Main");

	public OpeningServer(int port) throws IOException {
		//create server box
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
	    TA.setCaretColor(Color.GREEN);
	    c.add(new JScrollPane(TA));
	    setVisible(true);
	    log(TA, "Server started...on port: " + port + " \n");
	    mainPort = port;
	    
	    TA.addKeyListener((KeyListener) new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						commandCheck();
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	}
	//connecting serve to client
	public void run() throws IOException {
	    try {
	        log(TA, "ServerSocket created. \nListering for connections... \n");
	       //serverSocket = new ServerSocket(mainPort);
	        
	        //loop threw and create users
	        int hold = 0;
	        for (int i = 1; i < 2; i++) {
	            conn = serverSocket.accept();
	            log(TA, "User " + i + " connected on port: " + conn.getLocalPort());
	            hold = i;
	        }
	        Users user = new Users("User" + Integer.toString(hold), Integer.toString(conn.getLocalPort()));
	        user.logInfo();
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
	//commands for server side jbox check users/ etc
	public void commandCheck() throws BadLocationException {
		int lines = TA.getLineCount() -1;
		int start = TA.getLineStartOffset(lines);
		int end = TA.getLineEndOffset(lines);
		String endLine = TA.getText().substring(start, end);
		if(endLine.equals("logusers")) {
			System.out.println("Logging users");
			ArrayList<String> us = users.returnUsers();
			for(int k = 0; k <= us.size(); k++) {
				if(k != -1) {
					log(TA, "Users: " + us.get(k));	
				}
			}
		}
//		String[] lines = TA.getText().split("\\n");
//		for(int i = 0; i < lines.length; i++) {
//			if(i == lines.length && )
//		}
	}
	
	//read files from client
	public void read() {
		//read outputstream
		try {
			owr = new DataInputStream((conn.getInputStream()));
			//owr = server.getInputStream();
			int character;
			while((character = owr.read()) != -1) {
				log(TA, Integer.toString(character));
				System.out.println(character);
			}
			conn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
