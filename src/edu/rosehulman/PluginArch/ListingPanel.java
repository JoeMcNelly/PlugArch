package edu.rosehulman.PluginArch;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListingPanel extends JPanel {

	private StatusPanel statusPanel;
	private static ListingPanel instance;
	public ListingPanel() {
		statusPanel = StatusPanel.getInstance();
		// TODO: set up real components
		// list all of the plugins as buttons,
		// the buttons switch the active plugin
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("This is the listing panel"));

		int count = 0;

		File dir = new File("./plugins");
		File[] files = dir.listFiles();

		for (File file : files) {
			this.addToListPanel(file.getName());
			count++;
		}

		statusPanel.fireNewStatus(count + " Files Loaded.");

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

	public void addToListPanel(String s) {
		this.add(new JButton(s));
		this.revalidate();
		statusPanel.fireNewStatus("New file loaded: " + s);
	}

	public static ListingPanel getInstance() {
		if (instance == null)
		{
			instance = new ListingPanel();
		}
		return instance;
	}
}
