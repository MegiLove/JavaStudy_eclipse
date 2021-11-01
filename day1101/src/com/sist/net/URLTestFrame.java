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
		
		JButton btn= new JButton("�о����");
		
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
			//����ڰ� �Է��� ���ͳ��ּҸ� �о�ͼ�
			//���ͳ� ���� ������ü�� �����Ѵ�
			URL url= new URL(jtf.getText());
			//������ ������ �о���̱� ���� ��Ʈ���� �����Ѵ�
			InputStream is= url.openStream();
			//�� ���� �о���� byte���� �迭�� �����
			byte []data= new byte[100];
			//��Ʈ���� ���� �о� ���ڿ��� �� ��Ƴ��� ������ �����
			String str="";
			//��Ʈ���� ���� �ƴ� ������ 100����Ʈ�� �о���δ�
			while(is.read(data)!= -1) {
				//�о���� byte�迭�� data�� ���ڿ��� ����� �����Ѵ�
				str+=new String(data, "utf-8");
				
				//�迭�� �ٽ� �о���̱� ���� ������ ����ش�
				//byte���� �迭 data�� ��� 0���� �ʱ�ȭ�Ѵ�
				//���� 0�� ���� �ڹٴ� int�� ����ϱ� ������ byte�� ����ȯ�Ѵ�
				Arrays.fill(data, (byte)0);
			}
			//��ü������ ���ڿ� ������ �ؽ�Ʈ����� ����Ѵ�
			jta.setText(str);
			//��Ʈ���� �ݾ��ش�
			is.close();
			
		} catch (Exception ex) {
			System.out.println("���ܹ߻�: "+ex.getMessage());
		}
		
	}

}
