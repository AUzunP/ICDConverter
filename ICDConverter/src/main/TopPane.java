package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class TopPane extends JPanel{

	private static final long serialVersionUID = 1L;

	TopPane(int width, int height) {
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.4)));
		this.setPreferredSize(d);
		this.setBackground(Color.RED);
		
	}
	
}
