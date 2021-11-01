

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
			//1. ServerSocket을 통해 서버를 가동한다
			ServerSocket server= new ServerSocket(9003);
			
			//2. 무한대기상태로 클라이언트의 접속을 기다린다
			while(true) {
				//3. 수락한다
				Socket socket= server.accept();
				
				//소켓 객체를 통해 데이터를 주고받을 스트림을 생성한다
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				
				//클라이언트와 계속하여 데이터를 주고받기 위해 반복문을 이용한다
				while(true) {
					is.read(data);
					String msg= new String(data);
					System.out.println("수신된 데이터: "+ msg.trim());
					
					//클라이언트로부터 수신된 데이터를 그대로 메아리한다
					os.write(data);
					
					//다음 수신될 데이터를 위하여 배열을 비워준다
					Arrays.fill(data, (byte)0);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
