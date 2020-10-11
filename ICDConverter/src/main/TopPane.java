package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class TopPane extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private CustomButton enterButton;

	TopPane(int width, int height) {
		
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		//set width same size as MainFrame, set height to 40% of height
		Dimension d = new Dimension(width, ((int)((double)height*.4)));
		this.setPreferredSize(d);
		this.setBackground(Color.LIGHT_GRAY);
		
		this.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		enterButton = new CustomButton("Enter");
		this.add(enterButton, BorderLayout.SOUTH);
		
		enterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Enter clicked");
			}
			
		});
		
	}
	
}
