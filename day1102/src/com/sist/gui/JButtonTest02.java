package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {
	
	public JButtonTest02() {
		JButton btn01= new JButton("��ư01");
		JButton btn02= new JButton("��ư02");
		
		add(btn01);
		add(btn02);
		
		setSize(400,300);
		setVisible(true);
		
		//â�� ���� �� ���α׷��� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//�츮�� ���� JButtonTest�� �� JFrame�̴�
		//�� ���� �����̸� f�� ���� �� �ʿ䰡 ����
		//��ü�� �����ϱ⸸ �ص� �ȴ�
		new JButtonTest02();
		
	}

}
