package edu.rosehulman.PluginArch;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExecutionPanel extends JPanel {
	private static ExecutionPanel instance;

	public ExecutionPanel() {
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
}
