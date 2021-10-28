package com.sist.draw02;
import javax.swing.JPanel;
import java.awt.Graphics;

public class LinePanel extends JPanel {
	int x1= 10;
	int y1= 10;
	int x2= 300;
	int y2= 300;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(x1,y1,x2,y2);
	}
	
}
