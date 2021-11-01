package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			//보내오는 데이터를 담기위한 byte의 배열을 만든다
			//Sender가 보내오는 데이터를 받기 위하여 DatagramPacket객체를 생성한다
			byte []data= new byte[100];
			
			DatagramPacket packet= new DatagramPacket(data, data.length);
			
			//Sender가 보내오는 데이터를 계속 받기 위하여 무한반복문으로 표현
			while(true) {
				//DatagramSocket의 receive메소드를 통해 데이터를 받는다
				socket.receive(packet);
				
				//진짜로 받아진 데이터는 byte의 배열인(패킷을 만들 때 준 배열) data에 담아져있다
				//이것을 String생성자를 이용하여 문자열로 만든다
				String msg= new String(data);
				System.out.println("수신된 데이터: "+msg);
				
				Arrays.fill(data, (byte)0);
				
				socket.close();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
