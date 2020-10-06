package main;

import javax.swing.SwingUtilities;

public class App {
	
	public static void main(String[] args) {
		//TODO
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}
}
