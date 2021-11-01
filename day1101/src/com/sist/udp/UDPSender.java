package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		String ip= args[0];
		String msg= args[1];
			
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			
			//�������� �ּ� ip�� ���� InetAddress��ü�� �����Ѵ�
			InetAddress addr= InetAddress.getByName(ip);
			
			//�����ϰ��� �ϴ� ���ڿ� msg�� byte�� �迭�� �����
			byte[]data=msg.getBytes();
			
			//UDP����� ���������۴��� ��Ŷ�� �����Ѵ�
			DatagramPacket packet= new DatagramPacket(data, data.length, addr, 9002); 
			
			//DatagramSocket�� send�޼ҵ带 ���� �����͸� �����Ѵ�
			socket.send(packet);
			
			socket.close();
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
}
