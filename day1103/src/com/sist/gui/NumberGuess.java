package com.sist.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class NumberGuess extends JFrame implements ActionListener {
	
	JTextField jtf;
	
	JTextField result;
	
	int num;
	public NumberGuess() {
		
		Random r= new Random();
		num=r.nextInt(100)+1;
		
		jtf= new JTextField(10);
		result= new JTextField("���⿡ ����� ��Ÿ���ϴ�");
		
		setLayout(new FlowLayout());
		
		add(new JLabel("���ڸ� �����ϼ���"));
		add(jtf);
		add(result);
		
		JButton btn01= new JButton("�ٽ� �ѹ�");
		JButton btn02= new JButton("����");
		add(btn01);
		add(btn02);
		
		setSize(300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//â�� ũ�⸦ �������� ���ϵ��� �����Ѵ�
		setResizable(false);
		
		btn01.addActionListener(this);
		btn02.addActionListener(this);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGuess();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ٽ� �� �� ��ư�� ������ ���� ��ư�� ������ �� �޼ҵ尡 �����Ѵ�
		//�׷��� � ��ư�� ���������� �Ǵ��ϱ� ���� �Ű����� ActionEvent�� getActioncommand�� �̿�
		
		String cmd= e.getActionCommand();
		if(cmd.equals("�ٽ� �ѹ�")) {
			//��ǻ�Ͱ� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� �������� �Ǻ��Ѵ�
			//����ڰ� �Է��� ���ڸ� ���� �´�
			int user= Integer.parseInt(jtf.getText());

			//���Ͽ� ����� ����Ѵ�
			if(user==num) {
				result.setText("�����Դϴ�");
				result.setBackground(Color.GREEN);
			}else if(user>num) {
				result.setText("���ڰ� Ů�ϴ�");
				jtf.setText("");
				result.setBackground(Color.RED);
			}else {
				result.setText("���ڰ� �۽��ϴ�");
				jtf.setText("");
				result.setBackground(Color.RED);
			}
			
			
		}else if(cmd.equals("����")) {
			System.exit(0);
		}
	}

}
