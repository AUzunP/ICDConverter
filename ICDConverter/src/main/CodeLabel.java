package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import converter.ICDCode;

public class CodeLabel extends JPanel{
	
	private JLabel codeText;
	private JTextField allDiagnosis;
	
	CodeLabel(ICDCode code, int diagXSize) {
		//TODO
		//Kinda messy bro idk, clean this up
		
		int codeX = 50;
		int codeY = 50;
		
		int diagX = diagXSize - 50;
		int diagY = codeY;
		
		//code size
		Dimension d = new Dimension(codeX, codeY);
		
		codeText = new JLabel(code.getCode());
		
		codeText.setPreferredSize(d);
		codeText.setMinimumSize(d);
		codeText.setMaximumSize(d);
		
		codeText.setHorizontalAlignment(SwingConstants.CENTER);
		codeText.setVerticalAlignment(SwingConstants.CENTER);
		
		String diagnosisToString = "";
		
		for (int i = 0; i < code.returnDiagnosis().size(); i++) {
			diagnosisToString += code.returnDiagnosis().get(i) + ", ";
		}
		
		diagnosisToString = diagnosisToString.substring(0, diagnosisToString.length() - 2);
		//System.out.println(diagnosisToString);
		
		allDiagnosis = new JTextField(diagnosisToString);
		allDiagnosis.setEditable(false);
		
		//diagnosisScrollPane size
		d = new Dimension(diagX, diagY);
		
		JScrollPane diagnosisScrollPane = new JScrollPane(allDiagnosis);
		
		diagnosisScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		diagnosisScrollPane.setBorder(BorderFactory.createBevelBorder(1));
		//change look of scroll bar
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		diagnosisScrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		
		diagnosisScrollPane.setPreferredSize(d);
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(1));
		
		add(codeText, BorderLayout.CENTER);
		add(diagnosisScrollPane, BorderLayout.EAST);
		
	}
	
}
