package main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private BottomPane bottomPane;
	private TopPane topPane;
	private CustomButton convertButton;
	
	private int width;
	private int height;
	
	MainFrame() {
		super("ICDConverter");
		
		setLayout(new BorderLayout());
		
		this.width = 200;
		this.height = 400;
		
		// (x, y)
		Dimension d = new Dimension(width, height);
		setSize(d);
		setMinimumSize(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//inserting top and bottom panes
		bottomPane = new BottomPane(width, height);
		add(bottomPane, BorderLayout.SOUTH);
		
		topPane = new TopPane(width, height);
		add(topPane, BorderLayout.NORTH);
		
		//inserting button
		convertButton = new CustomButton();
		add(convertButton, BorderLayout.CENTER);
		
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
