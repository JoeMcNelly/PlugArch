package edu.rosehulman.PluginArch;

import java.awt.Color;
import java.io.File;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListingPanel extends JPanel {

	private StatusPanel statusPanel;
	private static ListingPanel instance;
	private HashMap<String, JButton> mapOfButtons; 
	public ListingPanel() {
		statusPanel = StatusPanel.getInstance();
		mapOfButtons = new HashMap<String, JButton>();
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
	
	public void removeFromListPanel(String fileName) {
		this.remove(mapOfButtons.get(fileName));
		this.revalidate();
	}

	public static ListingPanel getInstance() {
		if (instance == null)
		{
			instance = new ListingPanel();
		}
		return instance;
	}
}
