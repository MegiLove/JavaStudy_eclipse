package com.sist.game;

import javax.swing.JFrame;
//GUI���α׷��ֿ��� â�� ����� ���ؼ��� JFrame�� ��ӹ޴´�
public class MyFrame extends JFrame {
	//�����ڿ��� 
	public MyFrame() {
		setTitle("My Game"); //â�� ������ �����Ѵ�
		add(new MyPanel()); //��, �̻���,���ּ��� �����ϴ� Panel�� �����Ͽ� �����ӿ� ��´�
		setSize(500,500);	//�������� ũ�⸦ �����Ѵ�
		setVisible(true);	//�������� ȭ�鿡 ���̵��� �����Ѵ�
	}
	public static void main(String[] args) {
		new MyFrame();		//�������� �����Ѵ�
	}

}
