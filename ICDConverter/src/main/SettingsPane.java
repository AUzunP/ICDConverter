package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class SettingsPane extends JPanel{

	SettingsPane(int width, int height) {
		
		Dimension d = new Dimension(width, height);
		this.setPreferredSize(d);
		this.setBackground(Color.MAGENTA);
		
	}
	
}
