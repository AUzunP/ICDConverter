package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BottomPane extends JPanel{

	private static final long serialVersionUID = 1L;

	BottomPane(int width, int height){
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.4)));
		this.setPreferredSize(d);
		this.setBackground(Color.BLUE);
		
	}
	
}
