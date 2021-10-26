package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;

public class GraphicObject {
	BufferedImage img= null; //ȭ�鿡 �׸��� ǥ���ϱ� ���� ��ü
	int x=0, y=0; //�׸��� ��µ� ��ġ
	
	//�����ÿ� �׷����̹��� ������ �Ű������� ���޹���
	public GraphicObject(String name) {
		//�Ű������� ���޹��� ���ϸ����� BufferedImage��ü�� �����Ѵ�
		try {
		img= ImageIO.read(new File(name));
		}catch(Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}	
	}
	//�׷����̹����� ��ġ�� �����ϱ� ���� �޼ҵ��̸� �ڽ�Ŭ�������� �������� ���̴�
	public void update() {}
	//����� ��ġ�� �̹����� �ٽ� �׸��� ���� �޼ҵ�
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);
	}
	//��, �̻���, ���ּ� ������ ��ü���� �������̵��� ��
	public void keyPressed(KeyEvent event) {}
}
