package com.sist.draw07;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;
public class LinePanel extends JPanel implements MouseListener {
	int x1= 0;
	int y1= 0;
	int x2= 0;
	int y2= 0;
	
	//���� �׸� ������, ���� �׸� ������, �簢���� �׸� �������� ���� �ɹ������� �����
	//��: 0
	//��: 1
	//�簢��: 2
	int drawType;
	
	Color drawColor;
	
	ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		
		list= new ArrayList<GraphicInfo>();
		
		//this�� �ǹ̴� ���콺 �̺�Ʈ�� �߻��Ͽ��� �� �̺�Ʈ ó�� ��簴ü�� �ڽ� LinePanel�̶�� �ǹ�
		addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println("�ٽ� �׷��ݴϴ�!");
		//g.drawLine(x1,y1,x2,y2);
		
		//����Ʈ�� ��� ��� ���� �׷��ش�
		for(GraphicInfo info:list) {
			x1=info.getX1();
			y1= info.getY1();
			x2= info.getX2();
			y2=info.getY2();
			
			int width= x2-x1;
			int height=y2-y1;
			
			g.setColor(info.getDrawColor());
			
			switch(info.getDrawType()) {
			case 0: g.drawLine(x1,y1,x2,y2);break;
			case 1: g.drawRect(x1,y1,width,height);break;
			case 2:  g.drawOval(x1,y1,width,height);break;
			}
			
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
		//�ϳ��� ���� �ϼ��� ���� ����Ʈ ���� ������x,y ���� x,y�� ���� �ִ� GraphicInfo��ü�� 
		//�����Ͽ� ����Ʈ�� ��´� 
		list.add(new GraphicInfo(x1,y1,x2,y2,drawType,drawColor));
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
