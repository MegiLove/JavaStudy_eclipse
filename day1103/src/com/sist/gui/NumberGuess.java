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
		result= new JTextField("여기에 결과가 나타납니다");
		
		setLayout(new FlowLayout());
		
		add(new JLabel("숫자를 추측하세요"));
		add(jtf);
		add(result);
		
		JButton btn01= new JButton("다시 한번");
		JButton btn02= new JButton("종료");
		add(btn01);
		add(btn02);
		
		setSize(300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//창의 크기를 변경하지 못하도록 설정한다
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
		//다시 한 번 버튼을 눌러도 종료 버튼을 눌러도 이 메소드가 동작한다
		//그래서 어떤 버튼이 눌러졌는지 판단하기 위해 매개변수 ActionEvent의 getActioncommand를 이용
		
		String cmd= e.getActionCommand();
		if(cmd.equals("다시 한번")) {
			//컴퓨터가 생각하고 있는 난수와 사용자가 입력한 숫자가 동일한지 판별한다
			//사용자가 입력한 숫자를 갖고 온다
			int user= Integer.parseInt(jtf.getText());

			//비교하여 결과를 출력한다
			if(user==num) {
				result.setText("정답입니다");
				result.setBackground(Color.GREEN);
			}else if(user>num) {
				result.setText("숫자가 큽니다");
				jtf.setText("");
				result.setBackground(Color.RED);
			}else {
				result.setText("숫자가 작습니다");
				jtf.setText("");
				result.setBackground(Color.RED);
			}
			
			
		}else if(cmd.equals("종료")) {
			System.exit(0);
		}
	}

}
