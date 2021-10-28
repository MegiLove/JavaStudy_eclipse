package com.sist.draw03;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class LinePanel extends JPanel implements MouseListener {
	int x1= 0;
	int y1= 0;
	int x2= 0;
	int y2= 0;
	
	public LinePanel() {
		//this의 의미는 마우스 이벤트가 발생하였을 때 이벤트 처리 담당객체가 자신 LinePanel이라는 의미
		addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(x1,y1,x2,y2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1= e.getX();
		y1= e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2= e.getX();
		y2= e.getY();
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
