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

	//두 수를 입력받기 위한, 결과를 출력하기 위한 텍스트필드를 맴버변수로 선언한다
	JTextField jtf;
	
	int num1;
	int num2;
	String op;
	
	public CalcTest02() {
		//텍스트필드 객체를 생성한다.매개변수의 값은 한 번에 보여줄 수 있는 글자의 수이다
		jtf= new JTextField();
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,4));
		//16개의 버튼에 표시될 문자열을 배열에 담는다
		String []arr= {
				"7","8","9","+",
				"4","5","6","-",
				"1","2","3","*",
				"0","C","=","/"
				};
		
		//버튼배열을 선언한다
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
		//눌러진 버튼의 글자를 읽어온다
		String cmd= e.getActionCommand();
		if(cmd.equals("+")||cmd.equals("-")||cmd.equals("*")||cmd.equals("/")) {
			//지금 화면에 보이고 있는 숫자를 변수(num1)에 저장한다
			//어떤 연산을 해야할지를 변수(op)에 저장한다
			//그리고 화면을 깨끗이 지워준다
			num1=Integer.parseInt(jtf.getText());
			op=cmd;
			jtf.setText("");
			
		}else if(cmd.equals("=")) {
			//지금 화면에 보이고 있는 숫자를 변수(num2)에 저장한다
			//그리고 op에 연산자의 종류에 따라 num1과 num2를 해당 연산을 수행하여 result에 출력한다
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
			//지금 화면에 보이고 있는 숫자를 지운다
			jtf.setText("");
			
		}else {
			//눌러진 버튼의 글자를 텍스트필드에 계속 누적하여 출력한다
			
			jtf.setText(jtf.getText()+cmd);
		}
		
	}

}
