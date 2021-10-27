package com.sist.game;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;

//��,�̻���, ���ּ��� ���ÿ� ���� �� �ִ� �г� Ŭ������ �����
//��, �гο� Ű���尡 �������� �̺�Ʈ�� ó���ϱ� ���Ͽ� keyListener�� �����Ѵ�
public class MyPanel extends JPanel implements KeyListener{
	
	//��,�̻���,���ּ��� �г��� �ɹ������� �����մϴ�
	
	//�������� ���� ����� ���� ArrayList�� �����
	
	ArrayList<Enemy> enemyList;
	SpaceShip spaceship;
	Missile missile;
	
	//�����ڿ� ��, �г��� �����ǰ� ���ÿ� �����Ͽ�
	public MyPanel() {
		super();
		this.addKeyListener(this); //�г��� Ű���� �̺�Ʈ�� ����Ѵ�
		this.requestFocus(); //�г��� Ű���� ��û�� �����Ѵ�	A
		setFocusable(true); //�г��� ��Ŀ���� �����Ѵ�		B
		//ȭ�鱸������߿� ���� Ű����κ��� �Է��� �޾Ƶ��̴� �뵵�� �ƴϱ� ������
		//Ű����κ��� �Է��� �޾Ƶ��̰� �Ϸ��� "�г�"�� �ϴ��� "��Ŀ��"�� �����ؾ� �Ѵ�
		
		//�������� ���� ��� ���� ArrayList��ü�� �����Ѵ�
		
		enemyList= new ArrayList<Enemy>();
		
		//���� 5�� ����� ����Ʈ�� ��´�
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		//enemy= new Enemy("enemy.png"); //�̹������ϸ��� ���� ��ü�� �����Ѵ�
		spaceship= new SpaceShip("spaceship.png");
		missile= new Missile("missile.png");
		
		//�г��� ��������� ��,�̻���, ���ּ��� ���� ����������(���ÿ�,�����ϰ�)�����̵��� �ϱ� ����
		//��Ƽ�����带 �����
		//��,�̻���,���ּ��� ���������� �����̰� �ϴ� ����� ���� �гο����� �ʿ��ϴ�
		//�̷� ���� Ŭ������ Ŭ���� �ȿ� �����
		//�̰��� inner class��� �Ѵ�
		
		class MyThread extends Thread{	//ThreadŬ������ ��ӹ޾� ��Ƽ�����带 �����Ѵ�
			public void run() {			//run�� �������̵��Ͽ� ���ÿ� �����ų ��ɾ ����
				while(true) {		//��� 3��ü�� �����̰� �ϱ� ���� while(true)�� ����Ѵ�
					
					missile.update();
					
					//����Ʈ�� ��� ���� ����ŭ �ݺ��Ͽ� ��ġ�� �����Ѵ�
					for(Enemy enemy:enemyList) {
						enemy.update();
						enemy.crush(missile);
					}
					
					//enemy.update(); //���� �����̰� �ϱ� ���� ���� ��ġ�� �����ϴ� �޼ҵ带 ȣ���Ѵ�
					//spaceship.update(); //���ּ��� Ű���尡 �����̴� �������� �� �� �������� ȣ�� �� �ʿ����
					
					//missile.update();
					
					//���� �̻��Ͽ� �¾Ҵ��� �Ǻ��Ͽ� ���ִ� �޼ҵ带 ȣ���Ѵ�
					//enemy.crush(missile);
					
					repaint(); //��,�̻���, ���ּ��� ����� ��ġ�� �ٽ� �׸��� ���� ��û�� �Ѵ�
								//ȭ�鿡 �׷����� �׷��ִ� �޼ҵ�� paintComponent�޼ҵ��̴�
								//����ڰ� ���� paintComponent�� ȣ���� ���� ����
								//repaint�� ȣ���Ͽ� paintComponent�� ���۽�ų �� �ִ�
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}// 3���� ���� ���������� �����̰� ���� ��Ƽ������ ��ü MyThread�� �����Ѵ�
		Thread t= new MyThread();
		//�����带 �����Ѵ�
		t.start();
	}
	//3���� ����� ��ġ�� �׷����� �ٽ� �׷��ش�
	//�гο� �׷����� ǥ���ϱ� ���� paintComponent�� �������̵��Ѵ�
	//�̸� �Ű������� ���޹��� Graphics�� �׷����� ǥ���ϱ� ���� �پ��� �޼ҵ���� �ִ�
	public void paint(Graphics g) {
		super.paint(g);
		//�������� ���� ����ִ� ����Ʈ�� ����ŭ �ݺ��Ͽ� ���� �ٽ� �׷��ش�
		for(Enemy enemy:enemyList) {
			enemy.draw(g);
		}
		//enemy.draw(g);
		spaceship.draw(g);
		missile.draw(g);		
	}
	//�гο��� Ű���尡 ��������
	public void keyPressed(KeyEvent event) {
		spaceship.keyPressed(event); //������ Ű�����̺�Ʈ�� ������ ���ּ��� �����Ѵ�
		missile.keyPressed(event, spaceship.x, spaceship.y);
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
