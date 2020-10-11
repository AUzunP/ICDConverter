package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class BottomPane extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CustomButton clearButton;

	BottomPane(int width, int height){
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.4)));
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		clearButton = new CustomButton("Clear");
		this.add(clearButton, BorderLayout.SOUTH);
		
		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Clear clicked");
			}
			
		});
		
	}
	
}
