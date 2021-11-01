
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class UDPChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte []data= new byte[100];
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			//�������� �����͸� ������� byte�� �迭�� �����
			//Sender�� �������� �����͸� �ޱ� ���Ͽ� DatagramPacket��ü�� �����Ѵ�
			
			
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
			// TODO: handle exception
		}
	}

}
