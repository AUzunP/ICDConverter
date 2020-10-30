package main;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MainPanelCodes extends JPanel{

	private GridBagConstraints c;
	//TODO
	//THIS SHOULD BE RESET TO ZERO EACH TIME CLEAR BUTTON IS PRESSED ON BOTTOM PANEL
	private int currY = 0;
	
	MainPanelCodes() {
		
		setLayout(new GridBagLayout());
		
	}
	
	public void removeLabels() {
		
		this.removeAll();
		//must always call re-validate and repaint after remove or remove all
		this.revalidate();
		this.repaint();
		
		//reset the component gridY value
		currY = 0;
		
	}
	
	public void addCodeLabel(String code, ArrayList<String> diagnosis) {
		
		c = new GridBagConstraints();
		
		CodeLabel codeLabel = new CodeLabel(code, diagnosis);
		
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
	
}
