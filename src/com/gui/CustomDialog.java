package com.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomDialog extends guiCustoms{
	Font gothamBookBold,gothamLight;
	JFrame f;
	JLabel head, message;
	JButton cancel, confirm;
	JDialog customPane;
	//CustomDialog for confirmation dialogs that proceeds to a new content
	public CustomDialog(String headContent, String messageContent, JPanel parentPane, JPanel childPane,JPanel newPane,String buttonContentCancel, String buttonContentConfirm, Color confirmColor) {
		try {
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBold.ttf"));
			gothamLight = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamLight.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBookBold); 
			ge.registerFont(gothamLight);
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		f = new JFrame();
		customPane = new JDialog (f,true);
		customPane.getContentPane().setBackground(customPaneColor);
		customPane.setLayout(null);
		customPane.setUndecorated(true);
		customPane.setBounds(393,222,500,250);
		
		head = new JLabel(headContent);
		head.setFont(gothamBookBold.deriveFont(Font.PLAIN,28));
		head.setForeground(Color.WHITE);
		head.setBounds(20,20,500,56);
		customPane.add(head);
		
		message = new JLabel(messageContent);
		message.setFont(gothamLight.deriveFont(Font.PLAIN,16));
		message.setForeground(Color.WHITE);
		message.setBounds(20,60,500,56);
		customPane.add(message);
			
		cancel = new JButton(buttonContentCancel);
		cancel.setFont(gothamLight.deriveFont(Font.PLAIN,16));
		cancel.setBackground(customPaneColor);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancel.setBorderPainted(false);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(260,175,105,48);
		cancel.setFocusable(false);
		customPane.add(cancel);
		
		confirm = new JButton(buttonContentConfirm);
		confirm.setFont(gothamLight.deriveFont(Font.PLAIN,16));
		confirm.setBackground(confirmColor);
		confirm.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		confirm.setForeground(Color.WHITE);
		confirm.setBorderPainted(false);
		confirm.setBounds(375,175,105,48);
		confirm.setFocusable(false);
		customPane.add(confirm);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customPane.dispose();
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				newPane.setPreferredSize(new Dimension(1280, 720));
				newPane.setBounds(0, 0, 1280, 720);
				
				parentPane.add(newPane);
				childPane.setVisible(false);
				customPane.dispose();
				newPane.setVisible(true);
			}
		});
		
		customPane.setPreferredSize(new Dimension(500, 250));
		customPane.setLocationRelativeTo(parentPane);
		customPane.setVisible(true);
	}
	
	//CustomDialog for Exceptions
	public CustomDialog(String headContent, String messageContent, JPanel parentPane, String buttonContentConfirm, Color confirmColor) {
		try {
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBold.ttf"));
			gothamLight = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamLight.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBookBold); 
			ge.registerFont(gothamLight);
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		f = new JFrame();
		customPane = new JDialog (f,true);
		customPane.getContentPane().setBackground(customPaneColor);
		customPane.setLayout(null);
		customPane.setUndecorated(true);
		customPane.setBounds(393,222,500,250);
		
		head = new JLabel(headContent);
		head.setFont(gothamBookBold.deriveFont(Font.PLAIN,28));
		head.setForeground(Color.WHITE);
		head.setBounds(20,20,500,56);
		customPane.add(head);
		
		message = new JLabel(messageContent);
		message.setFont(gothamLight.deriveFont(Font.PLAIN,16));
		message.setForeground(Color.WHITE);
		message.setBounds(20,60,500,56);
		customPane.add(message);
		
		confirm = new JButton(buttonContentConfirm);
		confirm.setFont(gothamLight.deriveFont(Font.PLAIN,16));
		confirm.setBackground(confirmColor);
		confirm.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		confirm.setForeground(Color.WHITE);
		confirm.setBorderPainted(false);
		confirm.setBounds(375,175,105,48);
		confirm.setFocusable(false);
		customPane.add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customPane.dispose();
			}
		});
		
		customPane.setPreferredSize(new Dimension(500, 250));
		customPane.setLocationRelativeTo(parentPane);
		customPane.setVisible(true);
	}
}
