package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest02 extends JFrame {
	
	public GridLayoutTest02() {
		//�������� 5�� 3���� �׸��� ���̾ƿ����� �����Ѵ�
		setLayout(new GridLayout(5,4));
		
		//�ݺ����� �̿��Ͽ� 15���� ��ư�� �����Ͽ� �����ӿ� ��ƺ���
		for(int i=1; i<=20; i++) {
			add(new JButton("��ư"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutTest02();
	}

}
