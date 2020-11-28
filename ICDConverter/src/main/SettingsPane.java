package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EtchedBorder;

public class SettingsPane extends JPanel{

	private static final long serialVersionUID = 1L;
	public CustomButton settingsButton, dictionaryButton, editButton;
	
	SettingsPane(int width, int height) {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		Dimension d = new Dimension(width, ((int)((double)height*.1)));
		setPreferredSize(d);
		setMinimumSize(d);
		setBackground(Color.WHITE);
		
		settingsButton = new CustomButton("Settings");
		dictionaryButton = new CustomButton("Dictionary");
		editButton = new CustomButton("Edit");
				
		add(settingsButton, BorderLayout.WEST);
		add(dictionaryButton, BorderLayout.CENTER);
		add(editButton, BorderLayout.EAST);
		
	}
	
}
