package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemy extends GraphicObject {
	//���� x������ �����̴� ������ ���� ����
	//��ó������ ������ ������ �������� �����̵��� �ϱ� ���Ͽ� ������ �����Ѵ�
	int dx;
	int dy;
	public Enemy(String name) {
		super(name);
		//x=500;
		//y=0;
		Random r= new Random();	
		//��ó���� ���� ��ġ�� ������ �����Ѵ�
		x= r.nextInt(500);
		y= r.nextInt(300);
		
		//���� �̵���ΰ��� �����ÿ� ������ �����
		//�̵��ϴ� �ּҰ�: 10
		//�̵��ϴ� �ִ밪: 25
		//� ������ ���� 16���� ���� ���������ٰ� 10�� ���Ѵ�
		
			
		dx= r.nextInt()%16;
		dy= r.nextInt()%16;
		if(dx>=10) {
			dx+=10;
		}else {
			dx-=10;
		}
		
		if(dy>=10) {
			dy+=10;
		}else {
			dy-=10;
		}
		
		System.out.println("dx: "+dx);
		System.out.println("dy: "+dy);
	}
	
	public void update() {
		x+=dx;
		y+=dy;
		
		if(x<0 || x>500) {
			dx=dx*-1;
		}
		
		if(y<0 || y>300) {
			dy=dy*-1;
		}
		
		/*
		//���� ���ʳ��� �����ϸ� ���������� �̵���Ű�� ���� dx�� ����� �����
		if(x<0) {
			dx=10;
		}
		
		if(x>500) {
			dx=-10;
			
		if(y>=400) {
			dy=-10;
		}
		if(y<0) {
			dy=10;
		}
		*/
		}
	
	
	public void crush(Missile missile) {
		if(missile.x>=x && missile.x<=x+40 && missile.y>=y && missile.y<=y+40) {
			//System.out.println("���� �¾Ҿ��!");
			File file = new File("EXPLODE.WAV");
			try {
				// ����� ������ �о���� ���� �غ� �Ѵ�
				Clip clip = AudioSystem.getClip();
				// ����� ������ �о�´�
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
			} catch (Exception e) {

			}
			y=-1000;
		}
	}
}
