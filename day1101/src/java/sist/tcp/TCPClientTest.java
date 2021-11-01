package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) {
		try {
			//1. ������ ����� ��û�Ѵ�
			Socket socket= new Socket("192.168.0.11", 9001);
			//Socket socket= new Socket("127.0.0.1", 9001);
			//Socket socket= new Socket("localhost", 9001);
			
			//2. ������ ���Ͽ� �����͸� �ְ� ���� ��Ʈ���� �����Ѵ�
			InputStream is= socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			
			for(int i=1; i<=10; i++) {
				int n= is.read();
				System.out.println("�����κ��� ���ŵ� ������: "+n);
				Thread.sleep(200);
			}
			
			is.close();
			os.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());

		}
	}

}
