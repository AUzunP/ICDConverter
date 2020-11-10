package main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import converter.ICDDictionary;

public class DictionaryPane extends JPanel{

	private static final long serialVersionUID = 1L;

	public CustomButton okButton = new CustomButton();
	public MainPanelCodes dictionaryPaneCodeField = new MainPanelCodes();
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel dictionaryLabel = new JLabel();
	
	DictionaryPane(ICDDictionary mainDictionary) {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEtchedBorder(1));
		
		for (int i = 0; i < mainDictionary.codesList.size(); i++) {
			//System.out.println(mainDictionary.codesList.get(i).getCode());
			//System.out.println(mainDictionary.codesList.get(i).returnDiagnosis().toString());
		}
		
		dictionaryPaneCodeField = new MainPanelCodes();
		okButton = new CustomButton("OK");
		scrollPane = new JScrollPane(dictionaryPaneCodeField);
		dictionaryLabel = new JLabel("Dictionary");
		
		//Customize scroll bar
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.WHITE));
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		
		add(dictionaryLabel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(okButton, BorderLayout.SOUTH);
		
		//Populate dictionaryPaneCodeField
		for (int i = 0; i < mainDictionary.codesList.size(); i++) {
			
//			dictionaryPaneCodeField.addCodeLabel(mainDictionary.codesList.get(i).getCode(), 
//					mainDictionary.codesList.get(i).returnDiagnosis());
			
			dictionaryPaneCodeField.addCodeLabel(mainDictionary.codesList.get(i));
			
		}
		
	}
	
}
