package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TCPChatClient extends JFrame implements ActionListener,Runnable{
	//대화내용을 출력할 텍스트에리어를 맴버변수로 만든다
	JTextArea jta;
	
	//내가 대화내용을 입력할 텍스트필드를 맴버변수로 만든다
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	
	public TCPChatClient() {
		jta= new JTextArea();
		jtf= new JTextField(50);
		
		JButton btn= new JButton("전송");
		
		//버튼에 이벤트를 등록한다
		btn.addActionListener(this);
		
		JPanel p= new JPanel();
		p.add(jtf);
		p.add(btn);
		
		JScrollPane jsp= new JScrollPane(jta);
		
		add(jsp,BorderLayout.CENTER);
		
		add(p, BorderLayout.SOUTH);
		
		setSize(600,400);
		
		setVisible(true);
		
		try {
			//통신을 위해 서버에 접속을 요청한다
			Socket socket= new Socket("192.168.0.11", 9003);
			
			//입출력을 위한 스트림을 생성한다
			is= socket.getInputStream();
			os= socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//서버가 보내오는 데이터를 계속하여 받기 위한 쓰레드 클래스를 만들어보자
		class ClientThread extends Thread{
			byte []data= new byte[100];
			public void run() {
				while(true) {
					try {
						//서버가 보내온 데이터를 수신한다
						is.read(data);
						
						//수신한 데이터를 문자열로 만든다
						String msg= new String(data);
						
						//수신한 문자열을 텍스트에리어에 추가한다
						jta.append(msg.trim()+"\n");
						
					} catch (Exception e) {
						System.out.println("예외발생: "+e.getMessage());
					}
					
				}
			} //end run
			
		} //end inner class
		
		//서버로부터 계속하여 수신된 메세지를 받기 위한 쓰레드 객체를 생성하고 가동한다
		ClientThread ct= new ClientThread();
		ct.start();
		
		Thread t= new Thread(this);
		t.start();
	}// end 생성자
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPChatClient();
		//start는 생성자나 main에서 둘 다 가능하다
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 텍스트필드의 내용을 서버로 보내도록 한다
			byte []data= jtf.getText().getBytes();
			os.write(data);
			
			//메세지를 전송하고 난 다음 메세지 입력을 위하여 텍스트필드를 깨끗이 지워준다
			jtf.setText("");
		} catch (Exception e2) {
			System.out.println("예외발생: "+e2.getMessage());
		}
	}
	
	//서버로부터 수신된 데이터를 계속 받도록 한다
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte []data= new byte[100];
		while(true) {
			try {
				is.read(data);
				String msg= new String(data);
				msg= msg.trim();
				jta.append(msg+"\n");
			} catch (Exception e) {
				// TODO: handle exception
			}//end catch
			
		}//end while
		
	}//end run
}
