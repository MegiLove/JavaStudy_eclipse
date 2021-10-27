package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemy extends GraphicObject {
	//적이 x축으로 움직이는 간격을 위한 변수
	//맨처음에는 오른쪽 끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정한다
	int dx;
	int dy;
	public Enemy(String name) {
		super(name);
		//x=500;
		//y=0;
		Random r= new Random();	
		//맨처음의 적의 위치도 난수로 설정한다
		x= r.nextInt(500);
		y= r.nextInt(300);
		
		//적의 이동경로값을 생성시에 난수로 만든다
		//이동하는 최소값: 10
		//이동하는 최대값: 25
		//어떤 난수를 만들어서 16으로 나눈 나머지에다가 10을 더한다
		
			
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
		//만약 왼쪽끝에 도달하면 오른쪽으로 이동시키기 위해 dx를 양수로 만든다
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
			//System.out.println("적이 맞았어요!");
			File file = new File("EXPLODE.WAV");
			try {
				// 오디오 파일을 읽어오기 위한 준비를 한다
				Clip clip = AudioSystem.getClip();
				// 오디오 파일을 읽어온다
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
			} catch (Exception e) {

			}
			y=-1000;
		}
	}
}
