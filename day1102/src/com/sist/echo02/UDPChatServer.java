package com.sist.echo02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class UDPChatServer {

	// 1. UDP������� �����͸� �ְ� �ޱ����� DatagramSocket�� DatagramPacket�� �ɹ������� �����Ѵ�
	DatagramSocket socket;
	DatagramPacket packet;

	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//Ŭ���̾�Ʈ�κ��� ���ŵǴ� �����͸� ��� ���� Byte�� �迭�� ��Ŷ�� �����Ѵ�
			byte []data= new byte[100];
			packet= new DatagramPacket(data, data.length);
			
			//���Ѵ����·� Ŭ���̾�Ʈ�� ������ �����͸� �״�� �޾Ƹ��ϵ��� �Ѵ�
			while(true) {
				//Ŭ���̾�Ʈ�κ��� �����͸� �����Ѵ�
				//�޾ƿö��� �������� InetAddress�� ����ִ�
				socket.receive(packet);
				
				//Ŭ���̾�Ʈ�� ������ �����͸� ����� ����
				String msg= new String(data);
				System.out.println("���ŵ� ������:"+msg);
				
				//��Ŷ �ȿ� ��� ���������� InetAddress�� Ȯ���غ���
				InetAddress addr= packet.getAddress();
				System.out.println("���������� �ּ�:"+addr);
				
				//�� ��Ŷ�� �״�� �޾Ƹ��Ѵ�
				socket.send(packet);
				
				//���� �����͸� �����ϵ��� �迭�� ������ ����ش�
				Arrays.fill(data, (byte)0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new UDPChatServer();
	}
}
