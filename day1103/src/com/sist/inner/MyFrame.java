package com.sist.inner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼에 대한 이벤트 처리를 위해서는 ActionListener 인터페이스를 구현해야 한다
//만약, MyFrame자신이 ActionListener 인터페이스를 구현하게 되면
//하나의 actionPerformed메소드에서 모든 버튼의 이벤트처리를 해야한다
//일일이 누가 눌러졌는지 판단하는 if가 복잡해질 수 있다
//그래서 버튼 하나당 일처리 담당객체를 이름없는 inner 클래스로 만들어 처리한다

public class MyFrame extends JFrame {
	public MyFrame() {
		JButton btn01 = new JButton("남자");
		JButton btn02 = new JButton("여자");
		setLayout(new FlowLayout());

		add(btn01);
		add(btn02);

		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn01.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("남자입니다");
			}

		});
		btn02.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("여자입니다");
			}

		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
