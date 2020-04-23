package com.chatclient.main;

import java.io.*;
import java.net.*;
import java.util.*;

public class WriteThread extends Thread {
	private PrintWriter writer;
	private Socket socket;
	private Client client;
	
	public WriteThread(Socket socket, Client client) {
		this.socket = socket;
		this.client = client;
		
		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error getting output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void sendMessage(String text) {
		writer.println(text);
		
	}
}
