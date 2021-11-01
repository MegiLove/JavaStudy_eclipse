package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			//�������� �����͸� ������� byte�� �迭�� �����
			//Sender�� �������� �����͸� �ޱ� ���Ͽ� DatagramPacket��ü�� �����Ѵ�
			byte []data= new byte[100];
			
			DatagramPacket packet= new DatagramPacket(data, data.length);
			
			//Sender�� �������� �����͸� ��� �ޱ� ���Ͽ� ���ѹݺ������� ǥ��
			while(true) {
				//DatagramSocket�� receive�޼ҵ带 ���� �����͸� �޴´�
				socket.receive(packet);
				
				//��¥�� �޾��� �����ʹ� byte�� �迭��(��Ŷ�� ���� �� �� �迭) data�� ������ִ�
				//�̰��� String�����ڸ� �̿��Ͽ� ���ڿ��� �����
				String msg= new String(data);
				System.out.println("���ŵ� ������: "+msg);
				
				Arrays.fill(data, (byte)0);
				
				socket.close();
			}
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
}
