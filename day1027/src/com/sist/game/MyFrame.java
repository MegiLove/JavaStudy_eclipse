package com.sist.game;

import javax.swing.JFrame;
//GUI프로그래밍에서 창을 만들기 위해서는 JFrame을 상속받는다
public class MyFrame extends JFrame {
	//생성자에서 
	public MyFrame() {
		setTitle("My Game"); //창의 제목을 설정한다
		add(new MyPanel()); //적, 미사일,우주선을 포함하는 Panel를 생성하여 프레임에 담는다
		setSize(500,500);	//프레임의 크기를 설정한다
		setVisible(true);	//프레임을 화면에 보이도록 설정한다
	}
	public static void main(String[] args) {
		new MyFrame();		//프레임을 생성한다
	}

}
