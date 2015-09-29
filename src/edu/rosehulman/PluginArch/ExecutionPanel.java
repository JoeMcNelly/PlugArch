package edu.rosehulman.PluginArch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExecutionPanel extends JPanel {
	private static ExecutionPanel instance;

	private ExecutionPanel() {
		// TODO: set up real components
		// this is the panel plugins will draw stuff somehow
		super(new BorderLayout());
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
		this.add(panel, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.revalidate();
	}
}
