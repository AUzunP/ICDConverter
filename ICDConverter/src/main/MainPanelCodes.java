package main;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import converter.ICDCode;

public class MainPanelCodes extends JPanel{

	private GridBagConstraints c;
	//TODO
	//THIS SHOULD BE RESET TO ZERO EACH TIME CLEAR BUTTON IS PRESSED ON BOTTOM PANEL
	private int currY = 0;
	//set to 200 for both the main panel and dictionary, but can change it to another value for EditPane
	public int diagXSize = 200;
	
	MainPanelCodes() {
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEtchedBorder(1));
		
	}
	
	public void removeLabels() {
		
		this.removeAll();
		//must always call re-validate and repaint after remove or remove all
		this.revalidate();
		this.repaint();
		
		//reset the component gridY value
		currY = 0;
		
	}
	
	public void addCodeLabel(ICDCode code) {
		
		c = new GridBagConstraints();
		
		CodeLabel codeLabel = new CodeLabel(code, diagXSize);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = currY;
		c.anchor = GridBagConstraints.PAGE_START;
		
		add(codeLabel, c);
		
		System.out.println("HERE");
		
		currY++;
		this.revalidate();
		this.repaint();
		
	}
	
	public void changeDiagXSize(int diagXSize) {
		this.diagXSize = diagXSize;
	}
	
}
