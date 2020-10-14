package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class BottomPane extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CustomButton clearButton;
	public JScrollPane scrollPane;
	public JTextArea codeField;

	BottomPane(int width, int height){
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.65)));
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		
		clearButton = new CustomButton("Clear");
		this.add(clearButton, BorderLayout.SOUTH);
		
		codeField = new JTextArea();
		codeField.setEditable(false);
		
		scrollPane = new JScrollPane(codeField);
		
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());

		this.add(scrollPane, BorderLayout.CENTER);
		
	}
	
}
