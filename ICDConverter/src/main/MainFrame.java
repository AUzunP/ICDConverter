package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import converter.ICDDictionary;

public class MainFrame extends JFrame{

	//TODO
	//Line 130
	//Must format entered information from diagnosis and code before submitting into dictionary
	//Ensure that information in corresponding text fields are viable, throw error if not and then ask
	//for re-input
	
	private static final long serialVersionUID = 1L;

	private MainPane mainPane;
	
	private int width;
	private int height;
	
	private JFrame newCodeFrame;
	
	private CustomDialog errorBox;
	
	public ICDDictionary mainDictionary;
	
	MainFrame() throws IOException {
		
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
		
		//{{Top pane enter button logic
		
		mainPane.topPane.enterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				enterButtonFunction();
			}
			
		});
		
		Action enterButtonKeyPress = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			//When enter is pressed when focus is on textField, enter customButton is clicked
		    public void actionPerformed(ActionEvent e) {
		    	enterButtonFunction();
		    }
		    
		};

		mainPane.topPane.textField.addActionListener(enterButtonKeyPress);
		
		//}}
		
		//{{Bottom pane clear button logic
		
		mainPane.bottomPane.clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainPane.bottomPane.codeField.setText("");
				System.out.println("Clear clicked");
			}
			
		});
		//}}
		
		mainDictionary = new ICDDictionary();
		
		this.pack();
		this.setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	
	private void createNewCodeFrame(String errorTextString) {
		//new code frame sprung from entering an invalid diagnosis 
		
		newCodeFrame = new JFrame("New Code");
		Dimension newD = new Dimension(200, 250);
		newCodeFrame.setPreferredSize(newD);
		newCodeFrame.setResizable(false);
		newCodeFrame.setLayout(new BorderLayout());
		newCodeFrame.setUndecorated(true);
		newCodeFrame.pack();
		newCodeFrame.setLocationRelativeTo(null);
		
		NonexistantCodePane newCodePane = new NonexistantCodePane(100, 200, errorTextString);
		
		newCodeFrame.add(newCodePane, BorderLayout.CENTER);
		
		//{{Cancel button logic
		newCodePane.cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel button clicked");
				//closes newCodeFrame on cancel button click
				newCodeFrame.dispatchEvent(new WindowEvent(newCodeFrame, WindowEvent.WINDOW_CLOSING));
				//set parent JFrame to enabled
				setEnabled(true);
			}
			
		});
		//}}
		
		//{{Add to dictionary button logic
		newCodePane.addToDictionaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String diagnosis = newCodePane.enterDiagnosis.getText();
				String code = newCodePane.enterCode.getText();
				
				System.out.println("Add to dictionary button clicked");
				System.out.println("Diagnosis: " + diagnosis + "\nCode: " + code);
				
				if (viableEntry(diagnosis, code)) {
					formatEntries(diagnosis, code);
					
					//MUST FORMAT INFORMATION FROM DIAGNOSIS AND CODE BEFORE SUBMITTING TO DICTIONARY
//					try {
//						mainDictionary.appendDictionary(diagnosis, true);
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					newCodeFrame.dispatchEvent(new WindowEvent(newCodeFrame, WindowEvent.WINDOW_CLOSING));
					setEnabled(true);
				}
				
			}
			
		});
		//}}
		
	}
	
	private boolean viableEntry(String diagnosis, String code) {
		
		//Deny conditions:
		//Empty code or diagnosis text field
		//Second character of code must be a number
		//...?

		errorBox = new CustomDialog(newCodeFrame, "PLACEHOLDER");
		errorBox.setLocationRelativeTo(newCodeFrame);
		
		errorBox.okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				newCodeFrame.setEnabled(true);
				errorBox.setVisible(false);
			}
			
		});
		
		if (code.equals("") || diagnosis.equals("")) {
			newCodeFrame.setEnabled(false);
			errorBox.changeErrorText("Can't have empty diagnosis or code.");
			errorBox.setVisible(true);
			return false;
		}
		
		if (!(Character.isDigit(code.charAt(1)))) {
			newCodeFrame.setEnabled(false);
			errorBox.changeErrorText("Second character of code must be a number.");
			errorBox.setVisible(true);
			return false;
		}
		
		return true;
	}
	
	private String formatEntries(String diagnosis, String code) {
		
		String formattedEntry = "";
		List<String> allDiagnosis = new ArrayList<String>();
		
		diagnosis = diagnosis.toUpperCase();
		code = code.toUpperCase();
		
		//separate string by commas into List
		allDiagnosis = Arrays.asList(diagnosis.split(","));
		
		//remove white space from start and end
		for (int i = 0; i < allDiagnosis.size(); i++) {
			allDiagnosis.set(i, (allDiagnosis.get(i).trim()));
		}
		
		formattedEntry += code;
		formattedEntry += "{";
		
		for (int i = 0; i < allDiagnosis.size(); i++) {
			formattedEntry += allDiagnosis.get(i) + ", ";
		}
		
		//remove last comma and white space
		formattedEntry = formattedEntry.substring(0, (formattedEntry.length()-2));
		formattedEntry += "}";
		
		System.out.println(formattedEntry);
		
		return formattedEntry;
	}
	
	public void enterButtonFunction() {
		
		if (!(mainPane.topPane.textField.getText().trim().equals(""))) {
			//ensures that text field is not an empty string or just white space
			//System.out.println("Enter clicked");
			
			String enteredDiagnosis = mainPane.topPane.textField.getText();
			enteredDiagnosis = enteredDiagnosis.toUpperCase();
			
			String returnedCode = mainDictionary.searchList(enteredDiagnosis);
			
			if (returnedCode != null) {
				
				mainPane.topPane.textField.setText("");
				mainPane.topPane.textField.requestFocus();
				String currentText = mainPane.bottomPane.codeField.getText();		
				mainPane.bottomPane.codeField.setText(currentText + enteredDiagnosis + 
						" --------- " + returnedCode + "\n");
				
			} else {
				//System.out.println("Code does not exist...");

				createNewCodeFrame(enteredDiagnosis + " is not associated with an existing code. ");
				
				newCodeFrame.setVisible(true);
				setEnabled(false);
			}
			
		}
			
	}

}
