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

	// 1. UDP방식으로 데이터를 주고 받기위한 DatagramSocket과 DatagramPacket을 맴버변수로 선언한다
	DatagramSocket socket;
	DatagramPacket packet;

	public UDPChatServer() {
		try {
			socket = new DatagramSocket(9005);
			
			//클라이언트로부터 수신되는 데이터를 담기 위한 Byte의 배열과 패킷을 생성한다
			byte []data= new byte[100];
			packet= new DatagramPacket(data, data.length);
			
			//무한대기상태로 클라이언트가 보내온 데이터를 그대로 메아리하도록 한다
			while(true) {
				//클라이언트로부터 데이터를 수신한다
				//받아올때는 보낸측의 InetAddress가 담겨있다
				socket.receive(packet);
				
				//클라이언트가 보내온 데이터를 출력해 보자
				String msg= new String(data);
				System.out.println("수신된 데이터:"+msg);
				
				//패킷 안에 담긴 보내온측의 InetAddress를 확인해보자
				InetAddress addr= packet.getAddress();
				System.out.println("보내온측의 주소:"+addr);
				
				//그 패킷을 그대로 메아리한다
				socket.send(packet);
				
				//다음 데이터를 수신하도록 배열을 깨끗이 비워준다
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
