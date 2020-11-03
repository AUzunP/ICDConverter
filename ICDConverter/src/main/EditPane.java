package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditPane extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CustomButton searchButton, addCodeButton, deleteCodeButton;
	public JTextField searchBar;
	public MiniPane addDiagnosis, removeDiagnosis, changeCode;
	
	EditPane() {
		//450 by 200
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createBevelBorder(1));
		
		addDiagnosis = new MiniPane("Add Diagnosis");
		removeDiagnosis = new MiniPane("Remove Diagnosis");
		changeCode = new MiniPane("Change Code");
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		
		add(addDiagnosis, c);
		
		c.anchor = GridBagConstraints.PAGE_END;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		
		add(removeDiagnosis, c);
		
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		
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
