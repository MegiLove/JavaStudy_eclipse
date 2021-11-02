package com.sist.echo02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener {
	// ��ȭ������ ����� �ؽ�Ʈ����� �ɹ������� �����
	JTextArea jta;

	// ���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 �ɹ������� �����
	JTextField jtf;

	DatagramSocket socket;
	DatagramPacket packet;

	public UDPChatClient() {
		// �ɹ��������� �����Ѵ�
		jta = new JTextArea();
		jtf = new JTextField(50);

		// "����"�� ���� ��ư�� �����Ѵ�
		JButton btn = new JButton("����");

		// ���۹�ư�� �̺�Ʈ�� ����Ͽ� �ؽ�Ʈ�ʵ忡 �Է��� ������ ������ �����ϰ� �ʹ�
		btn.addActionListener(this);

		// �ؽ�Ʈ�ʵ�� ��ư�� ���� ���������̳��� �г��� �����Ѵ�
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);

		// �ؽ�Ʈ����� ��ũ���� ǥ���ϴ� ��ũ���Ұ�ü�� �����Ѵ�
		JScrollPane jsp = new JScrollPane(jta);

		// �������� ����� �ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ ��´�
		add(jsp, BorderLayout.CENTER);

		add(p, BorderLayout.SOUTH);

		// �������� ũ�⸦ �����Ѵ�
		setSize(600, 400);

		// ȭ�鿡 �����ֵ��� �����Ѵ�
		setVisible(true);

		try {
			// �����͸� �ְ� �ޱ� ���� �޼ҵ带 ���� �ִ� DatagramSocket��ü�� �����Ѵ�
			socket = new DatagramSocket();
		} catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}

		// �����κ��� �����͸� ����Ͽ� �����ϱ� ���� ������ Ŭ������ innerŬ������ �����
		class ClientThread implements Runnable {
			DatagramPacket packet;
			byte[] data = new byte[100];

			public void run() {

				// �����͸� �����ϱ� ���� ��Ŷ�� ���� �����Ѵ�
				packet = new DatagramPacket(data, data.length);

				// ����Ͽ� �����κ��� �����͸� �����ϵ��� �Ѵ�
				while (true) {
					try {
						socket.receive(packet);

						// �����κ��� ���ŵ� �����Ͱ� �ִ� �迭�� ������ ���ڿ��� �����
						String msg = new String(data);

						// ���ŵ� ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�
						jta.append(msg.trim() + "\n");

						// ���� ������ ������ ���Ͽ� �迭�� �����ش�
						Arrays.fill(data, (byte) 0);

					} catch (Exception e) {
						System.out.println("���ܹ߻�:" + e.getMessage());
					} // end catch
				} // end while

			}// end run
		}// end inner class
		
		//������ ��ü�� �����ϰ� �����带 �����Ѵ�
		new Thread(new ClientThread()).start();
		
	}// end ������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UDPChatClient();
		// start�� �����ڳ� main���� �� �� �����ϴ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// ����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ���ڿ��� ���� �´�
			String msg = jtf.getText();

			// UDP������� �����͸� �������� ��Ŷ�� �����ؾ� �Ѵ�
			// �׷��� �� ���ڿ��� byte[]�迭�� ������ �Ѵ�
			byte[] data = msg.getBytes();

			// �������� �ּҸ� ���� InetAddress��ü�� �����Ѵ�
			InetAddress addr = InetAddress.getByName("192.168.0.11");

			int port = 9005;

			// �����͸� ���� ��Ŷ�� �����Ѵ�
			packet = new DatagramPacket(data, data.length, addr, port);

			// ������ �����͸� �����Ѵ�
			socket.send(packet);

		} catch (Exception e2) {
			System.out.println("���ܹ߻�: " + e2.getMessage());
		}
	}

}
