package com.chatclient.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatGUI extends JFrame {
	private JTextArea chatWindow;
	private JTextArea chatMessage;
	private JButton submitMessage;
	private JScrollPane scroll;
	private JScrollBar vertical;
	private Client client;
	
	public ChatGUI(Client client) {
		this.client = client;
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		
		cp.add(new JLabel("Java Chat"));
		
		chatWindow = new JTextArea();
		scroll = new JScrollPane(chatWindow);
		chatWindow.setEditable(false);
		scroll.setPreferredSize(new Dimension(200, 300));
		vertical = scroll.getVerticalScrollBar();
		//Hello
		cp.add(scroll);
		
		chatMessage = new JTextArea();
		chatMessage.setEditable(true);
		chatMessage.setPreferredSize(new Dimension(200, 24));
		cp.add(chatMessage);
		
		submitMessage = new JButton("Submit");
		cp.add(submitMessage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chat Client");
		setSize(500, 500);
	}
	
	public JTextArea getChatMessage() {
		return chatMessage;
	}

	public JButton getSubmitButton() {
		return submitMessage;
	}
	
	public void receiveMessage(String message) {
		this.chatWindow.append("\n" + message);
	}

	public void userSend(String message) {
		chatWindow.append("\n[" + client.getUserName() + "]: " + message);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				vertical.validate();
				vertical.setValue( vertical.getMaximum());
			}
		});
		
	}

}
