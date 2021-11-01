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
				//이 메소드는 연결을 요청한 클라이언트 통신을 하기위한 소켓객체를 반환한다
				//이러한 소켓을 데이터소켓이라고 한다
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속하였습니다");
				
				InputStream is= socket.getInputStream();
				OutputStream os= socket.getOutputStream();
				
				for(int i=1; i<=10; i++) {
					int n= r.nextInt(100);
					//난수를 클라이언트에게 출력한다
					System.out.println("서버가 난수 하나를 만들었습니다 "+n);
					
					os.write(n);
					
					Thread.sleep(100);
				}
				
				System.out.println("클라이언트에게 데이터를 모두 내보냈습니다");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}

}
