package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import converter.ICDDictionary;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private MainPane mainPane;
	
	private int width;
	private int height;
	
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
	
	public void enterButtonFunction() {
		
		if (!(mainPane.topPane.textField.getText().trim().equals(""))) {
			//ensures that text field is not an empty string or just white space
			System.out.println("Enter clicked");
			
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
				System.out.println("Code does not exist...");
			}
			
		}
			
	}

}
