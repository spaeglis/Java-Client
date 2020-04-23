package com.chatclient.main;

import java.awt.event.*;
import javax.swing.*;

public class ClientUI {
	//private String hostname;
	//private int port;
	private UserNameGUI userGUI;
	private ChatGUI chatGUI;
	
	public ClientUI(String hostname, int port) {
		//this.hostname = hostname;
		//this.port = port;
		
		userGUI = new UserNameGUI();
		Client client = new Client(hostname, port, this);
		chatGUI = new ChatGUI(client);
		client.execute();
		
		userGUI.getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				client.setUserName(userGUI.getUserNameField().getText());
				client.sendMessage(userGUI.getUserNameField().getText());
				changeWindow(client);
			}
		});
		
		chatGUI.getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				client.sendMessage(chatGUI.getChatMessage().getText());
				chatGUI.userSend(chatGUI.getChatMessage().getText());
				//chatGUI.receiveMessage(client.getUserName(), chatGUI.getChatMessage().getText());
				chatGUI.getChatMessage().setText("");
			}
		});
		
		userGUI.setVisible(true);
	}
	
	public void changeWindow(Client client) {
		userGUI.setVisible(false);
		chatGUI.setVisible(true);
	}

	public static void main(String[] args) {
		if (args.length < 2) return;
		
		String hostname = args[0];
		int port = Integer.parseInt(args[1]);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ClientUI(hostname, port);
			}
		});

	}

	public void receiveMessage(String text) {
		chatGUI.receiveMessage(text);
		
	}

}
