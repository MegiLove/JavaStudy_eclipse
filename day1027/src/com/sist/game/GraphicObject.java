package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;

public class GraphicObject {
	BufferedImage img= null; //화면에 그림을 표현하기 위한 객체
	int x=0, y=0; //그림이 출력될 위치
	
	//생성시에 그래픽이미지 파일을 매개변수로 전달받음
	public GraphicObject(String name) {
		//매개변수로 전달받은 파일명으로 BufferedImage객체를 생성한다
		try {
		img= ImageIO.read(new File(name));
		}catch(Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}	
	}
	//그래픽이미지의 위치를 갱신하기 위한 메소드이며 자식클래스들이 재정의할 것이다
	public void update() {}
	//변경된 위치에 이미지를 다시 그리기 위한 메소드
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);
	}
	//적, 미사일, 우주선 세개의 객체들이 오버라이딩할 것
	public void keyPressed(KeyEvent event) {}
}
