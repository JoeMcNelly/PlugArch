package edu.rosehulman.PluginArch;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExecutionPanel extends JPanel {
	private static ExecutionPanel instance;

	private ExecutionPanel() {
		// TODO: set up real components
		// this is the panel plugins will draw stuff somehow
		this.add(new JLabel("This is the execution panel"));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

	public static ExecutionPanel getInstance() {
		if (instance == null) {
			instance = new ExecutionPanel();
		}
		return instance;
	}
	public void setPanel(JPanel panel){
		this.removeAll();
		this.add(panel, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.revalidate();
	}
}
