package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPane extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BottomPane bottomPane;
	private TopPane topPane;
	private SettingsPane settingsPane;
	
	MainPane(int width, int height) {
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createBevelBorder(1));
		
		topPane = new TopPane(width, height);
		bottomPane = new BottomPane(width, height);
		settingsPane = new SettingsPane(width, height);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.anchor = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		
		add(settingsPane, c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		
		add(topPane, c);
		
		c.anchor = GridBagConstraints.PAGE_END;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		
		add(bottomPane, c);
		
	}
	
}
