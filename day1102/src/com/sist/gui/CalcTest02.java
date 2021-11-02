package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class CalcTest02 extends JFrame implements ActionListener{

	//�� ���� �Է¹ޱ� ����, ����� ����ϱ� ���� �ؽ�Ʈ�ʵ带 �ɹ������� �����Ѵ�
	JTextField jtf;
	
	int num1;
	int num2;
	String op;
	
	public CalcTest02() {
		//�ؽ�Ʈ�ʵ� ��ü�� �����Ѵ�.�Ű������� ���� �� ���� ������ �� �ִ� ������ ���̴�
		jtf= new JTextField();
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,4));
		//16���� ��ư�� ǥ�õ� ���ڿ��� �迭�� ��´�
		String []arr= {
				"7","8","9","+",
				"4","5","6","-",
				"1","2","3","*",
				"0","C","=","/"
				};
		
		//��ư�迭�� �����Ѵ�
		JButton []btn= new JButton[arr.length];
		for(int i=0; i<btn.length; i++) {
			btn[i]= new JButton(arr[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		add(p,BorderLayout.CENTER);
		add(jtf,BorderLayout.NORTH);
		
		setSize(500,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		new CalcTest02();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ��ư�� ���ڸ� �о�´�
		String cmd= e.getActionCommand();
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num1)�� �����Ѵ�
			//� ������ �ؾ������� ����(op)�� �����Ѵ�
			//�׸��� ȭ���� ������ �����ش�
			num1=Integer.parseInt(jtf.getText());
			op=cmd;
			jtf.setText("");
			
		}else if(cmd.equals("=")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num2)�� �����Ѵ�
			//�׸��� op�� �������� ������ ���� num1�� num2�� �ش� ������ �����Ͽ� result�� ����Ѵ�
			num2=Integer.parseInt(jtf.getText());
			int sum=0;
			if(op.equals("+")) {
				sum=num1+num2;
				
			}
			else if(op.equals("-")) {
				sum=num1-num2;
				
			}
			else if(op.equals("*")) {
				sum=num1*num2;
				
			}
			else if(op.equals("/")) {
				sum=num1/num2;
				
			}
			jtf.setText(Integer.toString(sum));
		}else if(cmd.equals("C")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� �����
			jtf.setText("");
			
		}else {
			//������ ��ư�� ���ڸ� �ؽ�Ʈ�ʵ忡 ��� �����Ͽ� ����Ѵ�
			
			jtf.setText(jtf.getText()+cmd);
		}
		
	}

}
