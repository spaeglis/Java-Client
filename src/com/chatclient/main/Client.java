package com.chatclient.main;

import java.io.*;
import java.net.*;

public class Client {
	
	private String hostname;
	private int port;
	private String userName;
	private WriteThread writeThread;
	private ClientUI clientUI;
	
	public Client(String hostname, int port, ClientUI clientUI) {
		this.hostname = hostname;
		this.port = port;
		this.clientUI = clientUI;
	}
	
	public void execute() {
		//this.userName = userName;
		
		try {
			Socket socket = new Socket(hostname, port);
			
			System.out.println("Connected to chat server");
			new ReadThread(socket, this).start();
			writeThread = new WriteThread(socket, this);
			
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}
	}
	
	void setUserName(String userName) {
		this.userName = userName;
	}
	
	String getUserName() {
		return this.userName;
	}

	public void sendMessage(String text) {
		writeThread.sendMessage(text);
		
	}
	
	public void receiveMessage(String text) {
		clientUI.receiveMessage(text);
	}

}
