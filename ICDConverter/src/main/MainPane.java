package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainPane extends JPanel{
	
	private BottomPane bottomPane;
	private TopPane topPane;
	private CustomButton convertButton;
	
	MainPane(int width, int height) {
		
		setLayout(new BorderLayout());
		
		Dimension d = new Dimension(width, height);
		this.setPreferredSize(d);
		this.setBackground(Color.GREEN);
		
		//inserting top and bottom panes
		bottomPane = new BottomPane(width, height);
		add(bottomPane, BorderLayout.SOUTH);
		
		topPane = new TopPane(width, height);
		add(topPane, BorderLayout.NORTH);
		
		//inserting button
		convertButton = new CustomButton();
		add(convertButton, BorderLayout.CENTER);
		
		//convertButton action
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		
	}
	
}
