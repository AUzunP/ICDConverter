package main;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		super("ICDConverter");
		
		setLayout(new BorderLayout());
		
		// (x, y)
		setSize(600, 600);
		setMinimumSize(new Dimension(1200, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
