package edu.rosehulman.PluginArch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StatusPanel extends JPanel{

	private JLabel statusText;
	private StringBuilder sb;
	private static StatusPanel instance;
	
	private StatusPanel() {
		super(new BorderLayout());
		this.add(new JLabel("Status:"),BorderLayout.NORTH);
		sb = new StringBuilder();
		statusText = new JLabel(welcomeStatus());
//		statusText.setText(welcomeStatus());
//		statusText.setWrapStyleWord(true);
//		statusText.setEditable(false);
		JScrollPane scroll = new JScrollPane(statusText);
		this.add(scroll,BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	public void fireNewStatus(String status) {
		statusText.setText(status);
	}
	
	private String welcomeStatus(){
		StringBuilder aSB = new StringBuilder();
		aSB.append("Welcome");
		aSB.append('\n');
		aSB.append('\n');
		return aSB.toString();
	}
	
	
	public static StatusPanel getInstance(){
		if (instance == null){
			instance = new StatusPanel();
		}
		return instance;
	}
}
