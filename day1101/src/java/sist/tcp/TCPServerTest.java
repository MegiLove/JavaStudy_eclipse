package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {

	public static void main(String[] args) {
		
		Random r= new Random();
		
		try {
			ServerSocket server= new ServerSocket(9001);
			
			while(true) {
				//�� �޼ҵ�� ������ ��û�� Ŭ���̾�Ʈ ����� �ϱ����� ���ϰ�ü�� ��ȯ�Ѵ�
				//�̷��� ������ �����ͼ����̶�� �Ѵ�
				Socket socket = server.accept();
				System.out.println("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�");
				
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				
				for(int i=1; i<=10; i++) {
					int n= r.nextInt(100);
					//������ Ŭ���̾�Ʈ���� ����Ѵ�
					System.out.println("������ ���� �ϳ��� ��������ϴ� "+n);
					
					os.write(n);
					
					Thread.sleep(100);
				}
				
				System.out.println("Ŭ���̾�Ʈ���� �����͸� ��� �����½��ϴ�");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}

}
