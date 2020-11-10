package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.ICDDictionary;

public class EditPane extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CustomButton searchButton, addCodeButton, deleteCodeButton;
	public JTextField searchBar;
	public MiniPane addDiagnosis, removeDiagnosis, changeCode;
	public MainPanelCodes searchedCode;
	
	EditPane(ICDDictionary mainDictionary) {
		//450 by 200
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createBevelBorder(1));
		
		addDiagnosis = new MiniPane("Add Diagnosis");
		removeDiagnosis = new MiniPane("Remove Diagnosis");
		changeCode = new MiniPane("Change Code");
		
		//SEARCHED CODE
		Dimension d = new Dimension(300, 70);
		searchedCode = new MainPanelCodes();
		searchedCode.changeDiagXSize(350);
		searchedCode.setPreferredSize(d);
		searchedCode.setMinimumSize(d);
		searchedCode.setMaximumSize(d);
		
		//ADD CODE BUTTON
		d = new Dimension(100, 35);
		addCodeButton = new CustomButton("ADD CODE");
		addCodeButton.setPreferredSize(d);
		addCodeButton.setMinimumSize(d);
		addCodeButton.setMaximumSize(d);
		
		//DELETE CODE BUTTON
		d = new Dimension(100, 35);
		deleteCodeButton = new CustomButton("DELETE CODE");
		deleteCodeButton.setPreferredSize(d);
		deleteCodeButton.setMinimumSize(d);
		deleteCodeButton.setMaximumSize(d);
		
		//SEARCH BAR
		d = new Dimension(350, 30);
		searchBar = new JTextField("Enter diagnosis/code to search...");
		searchBar.setPreferredSize(d);
		searchBar.setMinimumSize(d);
		searchBar.setMaximumSize(d);
		
		//SEARCH BUTTON
		d = new Dimension(100, 30);
		searchButton = new CustomButton("SEARCH");
		searchButton.setPreferredSize(d);
		searchButton.setMinimumSize(d);
		searchButton.setMaximumSize(d);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		//SEARCH BAR
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		
		add(searchBar, c);
		
		//SEARCH BUTTON
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 0;
		
		add(searchButton, c);
		
		//CODE LABEL
		c.anchor = GridBagConstraints.LINE_START;
		//c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 1;
		
		add(searchedCode, c);
		
		//ADD CODE BUTTON
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 1;
		
		add(addCodeButton, c);
		
		//DELETE CODE BUTTON
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 2;
		
		add(deleteCodeButton, c);
		
		//ADD DIAGNOSIS
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 3;
		
		add(addDiagnosis, c);
		
		//REMOVE DIAGNOSIS
		c.anchor = GridBagConstraints.PAGE_END;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 3;
		
		add(removeDiagnosis, c);
		
		//CHANGE CODE
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.gridx = 2;
		c.gridy = 3;
		
		add(changeCode, c);
		
	}

	public class MiniPane extends JPanel{
		//Class for the small 3 panels at the bottom
		private static final long serialVersionUID = 1L;
		
		public JLabel label;
		public CustomButton button;
		public JTextField field;
		
		MiniPane(String labelText) {
			
			setLayout(new BorderLayout());
			
			setBorder(BorderFactory.createBevelBorder(1));
			
			label = new JLabel(labelText);
			button = new CustomButton("OK");
			field = new JTextField();
			
			Dimension d = new Dimension(100, 20);
			label.setPreferredSize(d);
			
			d = new Dimension(50, 20);
			button.setPreferredSize(d);
			
			d = new Dimension(80, 20);
			field.setPreferredSize(d);
			
			add(label, BorderLayout.NORTH);
			add(field, BorderLayout.WEST);
			add(button, BorderLayout.CENTER);
			
		}
		
	}
	
}
