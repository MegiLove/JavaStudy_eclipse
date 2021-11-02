package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02() {
		JButton btn01= new JButton("버튼01");
		JButton btn02= new JButton("버튼02");
		
		add(btn01);
		add(btn02);
		
		setSize(400,300);
		setVisible(true);
		
		//창을 닫을 때 프로그램도 같이 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame이다
		//이 때는 변수이름 f를 굳이 줄 필요가 없다
		//객체를 생성하기만 해도 된다
		new JButtonTest02();
		
	}

}
