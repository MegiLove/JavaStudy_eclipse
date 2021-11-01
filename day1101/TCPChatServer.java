

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte []data= new byte[100];
		try {
			//1. ServerSocket�� ���� ������ �����Ѵ�
			ServerSocket server= new ServerSocket(9003);
			
			//2. ���Ѵ����·� Ŭ���̾�Ʈ�� ������ ��ٸ���
			while(true) {
				//3. �����Ѵ�
				Socket socket= server.accept();
				
				//���� ��ü�� ���� �����͸� �ְ���� ��Ʈ���� �����Ѵ�
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				
				//Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ�ޱ� ���� �ݺ����� �̿��Ѵ�
				while(true) {
					is.read(data);
					String msg= new String(data);
					System.out.println("���ŵ� ������: "+ msg.trim());
					
					//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�
					os.write(data);
					
					//���� ���ŵ� �����͸� ���Ͽ� �迭�� ����ش�
					Arrays.fill(data, (byte)0);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
