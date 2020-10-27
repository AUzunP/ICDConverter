package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CustomDialog extends JDialog{

	private JPanel mainPanel;
	public CustomButton okButton;
	private JLabel errorLabel;
	
	CustomDialog(JFrame frame, String text) {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		okButton = new CustomButton();
		okButton.setText("OK");
		
		errorLabel = new JLabel(text, SwingConstants.CENTER);
		
		mainPanel.add(errorLabel, BorderLayout.CENTER);
		mainPanel.add(okButton, BorderLayout.SOUTH);
		
		Dimension d = new Dimension(275, 100);
		
		this.setMinimumSize(d);
		this.setUndecorated(true);
		
		this.add(mainPanel);
		
	}
	
	public void changeErrorText(String errorText) {
		errorLabel.setText(errorText);
	}
	
}
