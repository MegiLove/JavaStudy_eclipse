
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

		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ������ ������
		class ClientThread extends Thread{
			byte []data= new byte[100];
			public void run() {
				while(true) {
					try {
						//������ ������ �����͸� �����Ѵ�
						is.read(data);
						
						//������ �����͸� ���ڿ��� �����
						String msg= new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰��Ѵ�
						jta.append(msg.trim()+"\n");
						
					} catch (Exception e) {
						System.out.println("���ܹ߻�: "+e.getMessage());
					}
					
				}
			} //end run
			
		} //end inner class
		
		//�����κ��� ����Ͽ� ���ŵ� �޼����� �ޱ� ���� ������ ��ü�� �����ϰ� �����Ѵ�
		ClientThread ct= new ClientThread();
		ct.start();
				
	}// end ������
	
	
	public static void main(String[] args) {
		String ip= args[0];
		String msg= args[1];
			
		try {
			DatagramSocket socket= new DatagramSocket(9002);
			
			//�������� �ּ� ip�� ���� InetAddress��ü�� �����Ѵ�
			InetAddress addr= InetAddress.getByName(ip);
			
			//�����ϰ��� �ϴ� ���ڿ� msg�� byte�� �迭�� �����
			byte[]data=msg.getBytes();
			
			//UDP����� ���������۴��� ��Ŷ�� �����Ѵ�
			DatagramPacket packet= new DatagramPacket(data, data.length, addr, 9002); 
			
			//DatagramSocket�� send�޼ҵ带 ���� �����͸� �����Ѵ�
			socket.send(packet);
			
			socket.close();
			
			new UDPChatClient();
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �Ѵ�
			byte []data= jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� �� ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ�ʵ带 ������ �����ش�
			jtf.setText("");
		} catch (Exception e2) {
			System.out.println("���ܹ߻�: "+e2.getMessage());
		}
	}


		
}