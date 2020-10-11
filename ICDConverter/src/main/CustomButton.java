package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

//Custom button that can change color upon hover and click

public class CustomButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	
	private Color pressedBackgroundColor;
	private Color hoverBackgroundColor;
	
	public CustomButton() {
		this(null);
	}
	
	public CustomButton(String text) {
		super(text);
		super.setContentAreaFilled(false);
		this.setFocusPainted(false);
	}
	
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.setColor(Color.WHITE);
		} else if (getModel().isRollover()){
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(getBackground());
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	public void setContentAreaFilled(boolean b) {
	}
	
	public Color getHoverBackgroundColor() {
		return hoverBackgroundColor;
	}
	
	public void setHoverBackgroundColor(Color hoverBackgroundColor) {
		this.hoverBackgroundColor = hoverBackgroundColor;
	}
	
	public Color getPressedBackGroundColor() {
		return pressedBackgroundColor;
	}
	
	public void setPressedBackgroundColor(Color pressedBackgroundColor) {
		this.pressedBackgroundColor = pressedBackgroundColor;
	}
	
}
