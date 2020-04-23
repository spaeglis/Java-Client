package com.chatclient.main;

import java.awt.*;
import javax.swing.*;

public class UserNameGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField userNameField;
	private JButton userNameSubmit;
	
	public UserNameGUI() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		cp.add(new JLabel("Enter username: "));
		
		userNameField = new JTextField();
		userNameField.setEditable(true);
		userNameField.setPreferredSize(new Dimension(200, 24));;
		cp.add(userNameField);
		
		userNameSubmit = new JButton("Submit");
		cp.add(userNameSubmit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chat Client");
		setSize(300, 100);
	}
	
	public JButton getSubmitButton() {
		return userNameSubmit;
	}
	
	public JTextField getUserNameField() {
		return userNameField;
	}

}
