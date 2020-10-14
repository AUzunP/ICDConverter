package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class TopPane extends JPanel{

	private static final long serialVersionUID = 1L;
	public JTextField textField;
	//private JScrollPane scrollPane;
	public CustomButton enterButton;

	TopPane(int width, int height) {
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.15)));
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		textField = new JTextField();
		this.add(textField, BorderLayout.CENTER);
		
		//UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		//scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		
		//this.add(scrollPane, BorderLayout.CENTER);
		
		enterButton = new CustomButton("Enter");
		this.add(enterButton, BorderLayout.SOUTH);
		
	}
	
}
