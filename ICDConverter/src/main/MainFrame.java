package main;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private MainPane mainPane;
	
	private int width;
	private int height;
	
	MainFrame() {
		
		super("ICDConverter");
		
		setResizable(false);
		setLayout(new BorderLayout());
		
		this.width = 200;
		this.height = 400;
		
		// (x, y)
		Dimension d = new Dimension(width, height);
		setSize(d);
		setPreferredSize(d);
		setMinimumSize(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPane = new MainPane(width, height);
		add(mainPane, BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
	}

}
