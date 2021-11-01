package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;
public class URLTestFrame extends JFrame implements ActionListener{
	
	JTextField jtf;	
	JTextArea jta;
	
	public URLTestFrame() {
		jtf= new JTextField(50);
		jta= new JTextArea();
		
		JButton btn= new JButton("읽어오기");
		
		JPanel p= new JPanel();
		
		p.add(jtf);
		p.add(btn);
		
		JScrollPane jsp= new JScrollPane(jta);
		
		add(p,BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800,600);
		
		setVisible(true);
		
		btn.addActionListener(this);
		
	}
	public static void main(String[] args) {
		
		new URLTestFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 인터넷주소를 읽어와서
			//인터넷 상의 문서객체를 생성한다
			URL url= new URL(jtf.getText());
			//문서의 내용을 읽어들이기 위한 스트림을 생성한다
			InputStream is= url.openStream();
			//한 번에 읽어들일 byte형의 배열을 만든다
			byte []data= new byte[100];
			//스트림을 통해 읽어 문자열을 다 모아놓을 변수를 만든다
			String str="";
			//스트림의 끝이 아닐 때까지 100바이트씩 읽어들인다
			while(is.read(data)!= -1) {
				//읽어들인 byte배열의 data를 문자열로 만들어 누적한다
				str+=new String(data, "utf-8");
				
				//배열을 다시 읽어들이기 전에 깨끗이 비워준다
				//byte형의 배열 data를 모두 0으로 초기화한다
				//숫자 0이 오면 자바는 int로 취급하기 때문에 byte로 형변환한다
				Arrays.fill(data, (byte)0);
			}
			//전체누적된 문자열 변수를 텍스트에리어에 출력한다
			jta.setText(str);
			//스트림을 닫아준다
			is.close();
			
		} catch (Exception ex) {
			System.out.println("예외발생: "+ex.getMessage());
		}
		
	}

}
