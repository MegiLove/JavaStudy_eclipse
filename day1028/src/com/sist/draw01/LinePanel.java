package com.sist.draw01;
import javax.swing.JPanel;
import java.awt.Graphics;

public class LinePanel extends JPanel {

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(10,10,110,10);
	}
	
}
