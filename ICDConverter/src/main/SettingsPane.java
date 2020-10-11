package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SettingsPane extends JPanel{

	private static final long serialVersionUID = 1L;
	private CustomButton settingsButton, dictionaryButton, saveButton;
	
	SettingsPane(int width, int height) {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		Dimension d = new Dimension(width, ((int)((double)height*.1)));
		setPreferredSize(d);
		setBackground(Color.WHITE);
		
		//Buttons
		//{{
		settingsButton = new CustomButton("Settings");
		dictionaryButton = new CustomButton("Dictionary");
		saveButton = new CustomButton("Save");
		
		add(settingsButton, BorderLayout.WEST);
		add(dictionaryButton, BorderLayout.CENTER);
		add(saveButton, BorderLayout.EAST);
		
		settingsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Settings clicked");
			}
			
		});
		
		dictionaryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Dictionary clicked");
			}
			
		});
		
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Save clicked");
			}
			
		});
		//}}
		
	}
	
}
