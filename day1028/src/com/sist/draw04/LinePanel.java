package com.sist.draw04;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class LinePanel extends JPanel implements MouseListener {
	int x1= 0;
	int y1= 0;
	int x2= 0;
	int y2= 0;
	
	ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		
		list= new ArrayList<GraphicInfo>();
		
		//this의 의미는 마우스 이벤트가 발생하였을 때 이벤트 처리 담당객체가 자신 LinePanel이라는 의미
		addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println("다시 그려줍니다!");
		//g.drawLine(x1,y1,x2,y2);
		
		//리스트에 담긴 모든 선을 그려준다
		for(GraphicInfo info:list) {
			g.drawLine(info.getX1(),info.getY1(), info.getX2(),info.getY2());
		}
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
		//하나의 선이 완성될 때의 리스트 선의 시작점x,y 끝점 x,y를 갖고 있는 GraphicInfo객체를 
		//생성하여 리스트에 담는다 
		list.add(new GraphicInfo(x1,y1,x2,y2));
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
