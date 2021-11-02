
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;

//서버가 한번에 여러명의 클라이언트와 대화가 가능하도록(메아리)하기 위하여
//클라이언트와 계속하여 대화를 주고 받는 기능은 쓰레드로 구현한다
class ServerThread extends Thread{
	
	//요청한 클라이언트와 연결된 소켓을 맴버변수로 선언한다
	Socket socket;
	
	//연결된 클라이언트와 데이터를 주고받을 스트림을 선언한다
	InputStream is;
	OutputStream os;
	
	//실제로 데이터가 담길 배열을 선언한다
	byte []data= new byte[100];
	
	public ServerThread(Socket socket) {
		this.socket= socket;
		try {
			is= this.socket.getInputStream();
			os= this.socket.getOutputStream();
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
	
	public void run() {
		//클라이언트와 계속하여 데이터를 주고받기 위해 반복문을 이용한다
		while(true) {
			try{is.read(data);
			String msg= new String(data);
			System.out.println("수신된 데이터: "+ msg.trim());
			
			//클라이언트로부터 수신된 데이터를 그대로 메아리한다
			//os.write(data);
			
			//접속한 모든 클라이언트들에게 데이터를 방송하고자 한다
			sendAll(data);
			
			//다음 수신될 데이터를 위하여 배열을 비워준다
			Arrays.fill(data, (byte)0);
			}catch (Exception e) {
				System.out.println("예외발생: "+e.getMessage());
			}//end catch
		}//end while
	}//end run
	
	public void sendAll(byte []data) throws Exception {
		
		//모든 클라이언트들을 담아둔 list로부터 data를 하나씩 끄집어내어오면 그것은 ServerThread자료형이다
		for(ServerThread t:ChatServer.list) {
			//각각의 ServerThread에는 연결한 클라이언트에게 데이터 출력을 위한 스트림이 있다
			//그 스트림을 통하여 데이터를 내보낸다
			t.os.write(data);
		
		}
		
	}
}//end class

public class ChatServer {
	
	//요청한 클라이언트들을 모두 담아두기 위한 ArrayList를 만든다
	//ArrayList에 담는 자료형은 통신을 요청한 한 명의 클라이언트와 계속하여 대화를 주고받는 쓰레드인 ServerThread를 담는다
	public static ArrayList<ServerThread> list= new ArrayList<ServerThread>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클라이언트로부터 수신된 데이터를 담기 위해 byte의 배열을 담는다
		byte data[]= new byte[100];
		
		try {
			//1. ServerSocket을 통해 서버를 가동한다
			ServerSocket server= new ServerSocket(9003);
			
			//2. 무한대기상태로 클라이언트의 접속을 기다린다
			while(true) {
				//3. 클라이언트의 요청을 수락한다
				Socket socket= server.accept();
				
				//연결된 클라이언트와 대화를 주고받기 위한 쓰레드객체를 생성하고 쓰레드를 가동한다
				ServerThread thread= new ServerThread(socket);
				thread.start();
				
				//접속한 모든 클라이언트와 통신을 담당하는 객체를 담아 두기 위한 리스트에 담는다
				list.add(thread);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
