package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest extends JFrame implements ActionListener{

	//�� ���� �Է¹ޱ� ����, ����� ����ϱ� ���� �ؽ�Ʈ�ʵ带 �ɹ������� �����Ѵ�
	JTextField jtf01;
	JTextField jtf02;
	JTextField jtf03;
	
	public CalcTest() {
		//�ؽ�Ʈ�ʵ� ��ü�� �����Ѵ�.�Ű������� ���� �� ���� ������ �� �ִ� ������ ���̴�
		jtf01= new JTextField(10);
		jtf02= new JTextField(10);
		jtf03= new JTextField(10);
		
		//�������� ���̾ƿ������ FlowLayout���� �����Ѵ�
		setLayout(new FlowLayout());
		
		//���ʴ�� �󺧰� ��ư�� �����Ѵ�
		add(new JLabel("��1:")); //���� ȭ�鿡 ���̱⸸ �ϸ� �Ǵ� �̸��� �� �ʿ�� ����
		add(jtf01);
		add(new JLabel("��2:"));
		add(jtf02);
		JButton btnadd= new JButton("���ϱ�");
		add(btnadd);
		add(new JLabel("���:"));
		add(jtf03);
		
		setSize(500,200);
		setVisible(true);
		
		//��ư�� �̺�Ʈ�� ����Ѵ�
		//�Ű������� �����ϴ� ���� ��ư�� �������� �� ��ó���ϴ� ��簴ü�� �ٷ� CalcTest�ڽ��̶�� ���̴�
		btnadd.addActionListener(this);
	}
	
	public static void main(String[] args) {
		
		new CalcTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�ؽ�Ʈ�ʵ� jtf01�� jtf02�� ���� ���� �о�;� �Ѵ�
		int num1=Integer.parseInt(jtf01.getText());
		int num2=Integer.parseInt(jtf02.getText());
		int sum=num1+num2;
		jtf03.setText(Integer.toString(sum));
		
		
		
	}

}
