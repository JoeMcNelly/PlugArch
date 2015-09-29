package edu.rosehulman.PluginArch;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static ExecutionPanel execPan;
	private static StatusPanel statPan;
	private static ListingPanel listPan;

	private Application() {
		execPan = new ExecutionPanel();
		statPan = StatusPanel.getInstance();
		listPan = ListingPanel.getInstance();

	}
	public static void main(String[] args) {
		Thread watcher = new Thread(new DirectoryWatcher());
		watcher.start();
		Application frame = new Application();
		
		BorderLayout layout = new BorderLayout();
		JPanel base = new JPanel(layout);
		frame.add(base);
		base.add(statPan, BorderLayout.SOUTH);
		base.add(listPan, BorderLayout.WEST);
		base.add(execPan, BorderLayout.CENTER);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	


}
