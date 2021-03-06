package edu.rosehulman.PluginArch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.rosehulman.reasource.JarLoader;

public class ListingPanel extends JPanel {

	private StatusPanel statusPanel;
	private static ListingPanel instance;
	private static ExecutionPanel executionPanel;
	private HashMap<String, JButton> mapOfButtons; 
	private ListingPanel() {
		statusPanel = StatusPanel.getInstance();
		executionPanel = ExecutionPanel.getInstance();
		mapOfButtons = new HashMap<String, JButton>();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("This is the listing panel"));

		int count = 0;

		File dir = new File("./plugins");
		File[] files = dir.listFiles();

		for (File file : files) {
			this.addToListPanel(file.getName());
			count++;
		}

		statusPanel.fireNewStatus(count + " Files Loaded.\n");

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

	public void addToListPanel(String s) {
		JButton button = new JButton(s.substring(0, s.length()-4));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JarLoader loader = new JarLoader("./plugins/"+s);
				String newString = s.substring(0, s.length()-4);
				Class clazz;
				try {
					clazz = loader.loadClass(newString,true);
					Object o = clazz.newInstance();
					if(o instanceof PluginClass){
						PluginClass pluginClass = (PluginClass) o;
						executionPanel.setPanel(pluginClass.setup());
						
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		this.add(button);
		this.revalidate();
		statusPanel.fireNewStatus("New file loaded: " + s + "\n");
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
