
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UDPChatClient extends JFrame implements ActionListener{

		//서버가 보내오는 데이터를 계속하여 받기 위한 쓰레드 클래스를 만들어보자
		class ClientThread extends Thread{
			byte []data= new byte[100];
			public void run() {
				while(true) {
					try {
						//서버가 보내온 데이터를 수신한다
						is.read(data);
						
						//수신한 데이터를 문자열로 만든다
						String msg= new String(data);
						
						//수신한 문자열을 텍스트에리어에 추가한다
						jta.append(msg.trim()+"\n");
						
					} catch (Exception e) {
						System.out.println("예외발생: "+e.getMessage());
					}
					
				}
			} //end run
			
		} //end inner class
		
		//서버로부터 계속하여 수신된 메세지를 받기 위한 쓰레드 객체를 생성하고 가동한다
		ClientThread ct= new ClientThread();
		ct.start();
				
	}// end 생성자
	
	
	public static void main(String[] args) {
		String ip= args[0];
		String msg= args[1];
			
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			
			//목적지의 주소 ip를 갖고 InetAddress객체를 생성한다
			InetAddress addr= InetAddress.getByName(ip);
			
			//전송하고자 하는 문자열 msg를 byte형 배열로 만든다
			byte[]data=msg.getBytes();
			
			//UDP방식의 데이터전송단위 패킷을 생성한다
			DatagramPacket packet= new DatagramPacket(data, data.length, addr, 9002); 
			
			//DatagramSocket의 send메소드를 통해 데이터를 전송한다
			socket.send(packet);
			
			socket.close();
			
			new UDPChatClient();
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 텍스트필드의 내용을 서버로 보내도록 한다
			byte []data= jtf.getText().getBytes();
			os.write(data);
			
			//메세지를 전송하고 난 다음 메세지 입력을 위하여 텍스트필드를 깨끗이 지워준다
			jtf.setText("");
		} catch (Exception e2) {
			System.out.println("예외발생: "+e2.getMessage());
		}
	}


		
}
