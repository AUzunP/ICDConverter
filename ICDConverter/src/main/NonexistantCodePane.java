package main;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NonexistantCodePane extends JPanel{

	private static final long serialVersionUID = 1L;
	public CustomButton cancelButton;
	public CustomButton addToDictionaryButton;
	private JTextArea errorText;
	
	private JLabel enterDiagnosisLabel;
	public JTextField enterDiagnosis;
	private JLabel enterCodeLabel;
	public JTextField enterCode;
	
	NonexistantCodePane(int width, int height, String errorTextString) {
		
		setLayout(new GridLayout(7, 0));
		setBorder(BorderFactory.createEtchedBorder(1));
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
		errorText = new JTextArea(errorTextString);
		errorText.setEditable(false);
		errorText.setRows(2);
		//text wrap around
		errorText.setLineWrap(true);
		//wrap around so words don't get cut off
		errorText.setWrapStyleWord(true);
		errorText.setBorder(BorderFactory.createBevelBorder(1));
		
		cancelButton = new CustomButton();
		cancelButton.setBorder(BorderFactory.createEtchedBorder(1));
		cancelButton.setText("Cancel");
		
		addToDictionaryButton = new CustomButton();
		addToDictionaryButton.setBorder(BorderFactory.createEtchedBorder(1));
		addToDictionaryButton.setText("Add to Dictionary");
		
		enterDiagnosisLabel = new JLabel();
		enterDiagnosisLabel.setText("Enter Diagnosis");
		enterDiagnosisLabel.setBorder(BorderFactory.createEtchedBorder(1));
		
		enterDiagnosis = new JTextField();
		
		enterCodeLabel = new JLabel();
		enterCodeLabel.setText("Enter Code");
		enterCodeLabel.setBorder(BorderFactory.createEtchedBorder(1));
		
		enterCode = new JTextField();
		
		add(errorText);
		add(enterDiagnosisLabel);
		add(enterDiagnosis);
		add(enterCodeLabel);
		add(enterCode);
		add(addToDictionaryButton);
		add(cancelButton);
	}
	
}
