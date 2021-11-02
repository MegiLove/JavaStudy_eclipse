
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;

//������ �ѹ��� �������� Ŭ���̾�Ʈ�� ��ȭ�� �����ϵ���(�޾Ƹ�)�ϱ� ���Ͽ�
//Ŭ���̾�Ʈ�� ����Ͽ� ��ȭ�� �ְ� �޴� ����� ������� �����Ѵ�
class ServerThread extends Thread{
	
	//��û�� Ŭ���̾�Ʈ�� ����� ������ �ɹ������� �����Ѵ�
	Socket socket;
	
	//����� Ŭ���̾�Ʈ�� �����͸� �ְ����� ��Ʈ���� �����Ѵ�
	InputStream is;
	OutputStream os;
	
	//������ �����Ͱ� ��� �迭�� �����Ѵ�
	byte []data= new byte[100];
	
	public ServerThread(Socket socket) {
		this.socket= socket;
		try {
			is= this.socket.getInputStream();
			os= this.socket.getOutputStream();
		}catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
	
	public void run() {
		//Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ��ޱ� ���� �ݺ����� �̿��Ѵ�
		while(true) {
			try{is.read(data);
			String msg= new String(data);
			System.out.println("���ŵ� ������: "+ msg.trim());
			
			//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ��Ѵ�
			//os.write(data);
			
			//������ ��� Ŭ���̾�Ʈ�鿡�� �����͸� ����ϰ��� �Ѵ�
			sendAll(data);
			
			//���� ���ŵ� �����͸� ���Ͽ� �迭�� ����ش�
			Arrays.fill(data, (byte)0);
			}catch (Exception e) {
				System.out.println("���ܹ߻�: "+e.getMessage());
			}//end catch
		}//end while
	}//end run
	
	public void sendAll(byte []data) throws Exception {
		
		//��� Ŭ���̾�Ʈ���� ��Ƶ� list�κ��� data�� �ϳ��� ���������� �װ��� ServerThread�ڷ����̴�
		for(ServerThread t:ChatServer.list) {
			//������ ServerThread���� ������ Ŭ���̾�Ʈ���� ������ ����� ���� ��Ʈ���� �ִ�
			//�� ��Ʈ���� ���Ͽ� �����͸� ��������
			t.os.write(data);
		
		}
		
	}
}//end class

public class ChatServer {
	
	//��û�� Ŭ���̾�Ʈ���� ��� ��Ƶα� ���� ArrayList�� �����
	//ArrayList�� ��� �ڷ����� ����� ��û�� �� ���� Ŭ���̾�Ʈ�� ����Ͽ� ��ȭ�� �ְ��޴� �������� ServerThread�� ��´�
	public static ArrayList<ServerThread> list= new ArrayList<ServerThread>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ��� ���� byte�� �迭�� ��´�
		byte data[]= new byte[100];
		
		try {
			//1. ServerSocket�� ���� ������ �����Ѵ�
			ServerSocket server= new ServerSocket(9003);
			
			//2. ���Ѵ����·� Ŭ���̾�Ʈ�� ������ ��ٸ���
			while(true) {
				//3. Ŭ���̾�Ʈ�� ��û�� �����Ѵ�
				Socket socket= server.accept();
				
				//����� Ŭ���̾�Ʈ�� ��ȭ�� �ְ��ޱ� ���� �����尴ü�� �����ϰ� �����带 �����Ѵ�
				ServerThread thread= new ServerThread(socket);
				thread.start();
				
				//������ ��� Ŭ���̾�Ʈ�� ����� ����ϴ� ��ü�� ��� �α� ���� ����Ʈ�� ��´�
				list.add(thread);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}