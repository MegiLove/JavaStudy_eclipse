package com.sist.chat;

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
public class ChatClient02 extends JFrame implements ActionListener{
	//��ȭ������ ����� �ؽ�Ʈ����� �ɹ������� �����
	JTextArea jta;
	
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 �ɹ������� �����
	JTextField jtf;
	
	InputStream is;
	OutputStream os;
	
	
	public ChatClient02() {
		jta= new JTextArea();
		jtf= new JTextField();
		
		JButton btn= new JButton("����");
		
		//��ư�� �̺�Ʈ�� ����Ѵ�
		btn.addActionListener(this);
		
		JPanel p= new JPanel();
		p.setLayout(new BorderLayout());
		p.add(jtf,BorderLayout.CENTER);
		p.add(btn,BorderLayout.EAST);
		
		JScrollPane jsp= new JScrollPane(jta);
		
		add(jsp,BorderLayout.CENTER);
		
		add(p, BorderLayout.SOUTH);
		
		setSize(600,400);
		
		setVisible(true);
		
		try {
			//2. ����� ���� ������ ������ ��û�Ѵ�
			Socket socket= new Socket("222.120.183.156", 9003);
			
			//������� ���� ��Ʈ���� �����Ѵ�
			is= socket.getInputStream();
			os= socket.getOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ������ ������
		class ClientThread implements Runnable{
			byte []data= new byte[100];
			public void run() {
				while(true) {
					try {
						//������ ������ �����͸� �����Ѵ�
						is.read(data);
						
						//������ �����͸� ���ڿ��� �����
						String msg= new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�
						jta.append(msg.trim()+"\n");
						
					} catch (Exception e) {
						System.out.println("���ܹ߻�: "+e.getMessage());
					}
					
				}
			} //end run
			
		} //end inner class
		
		//�����κ��� ����Ͽ� ���ŵ� �޼����� �ޱ� ���� ������ ��ü�� �����ϰ� �����Ѵ�
		ClientThread ct= new ClientThread();
		new Thread(ct).start();
		
		/*Thread t= new Thread(this);
		t.start();*/
	}// end ������
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient02();
		//start�� �����ڳ� main���� �� �� �����ϴ�
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �Ѵ�
			byte []data= jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� �� ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ�ʵ带 ������ �����ش�
			jtf.setText("");
		} catch (Exception e2) {
			System.out.println("���ܹ߻�: "+e2.getMessage());
		}
	}
	
	/* Runnable�� �̿��ϴ� ���
	//�����κ��� ���ŵ� �����͸� ��� �޵��� �Ѵ�
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
	*/
}
