package com.sist.goos02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GoodsDao {
	//������ ��ǰ��ȣ, ��ǰ�̸�, ����, ������ �Ű������� ���޹޾� �����ͺ��̽��� �����ϴ� �޼ҵ带 ����
		public void updateGoods(int no,String item,int qty, int price) {
			//String sql = "update goods set item='"+item+"', qty="+qty+", price="+price+" where no="+no;
			String sql = "update goods set item=?,qty=?,price=? where no=?";
			Connection conn = null;
			//Statement stmt = null;
			//sql��ɾ�ȿ� ?�� �ִ� ��� Statement�� �ļ�Ŭ������ PreparedStatement�� �̿��մϴ�.
			PreparedStatement pstmt = null;
			try {
				//1. jdbc����̹��� �޸𸮷� �ε��Ѵ�.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. DB ������ �����Ѵ�.
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "c##sist";
				String pwd="sist";
				conn = DriverManager.getConnection(url, user, pwd);
				
				//3. Statement ��ü�� �����Ѵ�.
				//stmt = conn.createStatement();
				//PreparesStatement �����ÿ� ?�� �ִ� �̸� �������� ��ɾ �Ű������� �����ؾ� �մϴ�.
				pstmt = conn.prepareStatement(sql);
				
				//PerparedStatement ��ü�� �������� �ʴ� ?�� ���ʴ�� ���� �����ؾ� �մϴ�.
				pstmt.setString(1,item);
				pstmt.setInt(2, qty);
				pstmt.setInt(3, price);
				pstmt.setInt(4, no);
				
				//4. �����ͺ��̽� ����� �����Ѵ�
				//PreparedStatement ��ü �����ÿ� �̹� sql�� ���޵Ǿ���
				//�׸��� ������ ������ ?���� ����� �����̱⶧���� 
				//executeUpdate�Ҷ��� sql�� �������� �ʾƾ� �մϴ�.
				//���� ���⼭ �Ű������� sql�� �����ϰ� �Ǹ� ?�� ���� �������� �ʴ� ���·� ����� �����ϰ� �˴ϴ�.
				int re =pstmt.executeUpdate();
				
				//������ ��ó���� �Ѵ�.
				if(re == 1) {
					System.out.println("��ǰ������ �����Ͽ����ϴ�.");
					
				}else {
					System.out.println("��ǰ������ �����Ͽ����ϴ�.");
				}
				
			}catch (Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		
		
		//������ ��ǰ��ȣ�� �Ű������� ���޹޾� �ش��ǰ�� �����ͺ��̽��� �����ϴ� �޼ҵ带 ����
		public void deleteGoods(int no){
			//String sql = "delete goods where no="+no;
			String sql = "delete goods where no=?";
			Connection conn = null;
			//Statement stmt = null;		
			PreparedStatement pstmt = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				//stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				
				int re = pstmt.executeUpdate();
				if(re == 1) {
					System.out.println("��ǰ�� �����Ͽ����ϴ�.");					
				}else {
					System.out.println("������ �����Ͽ����ϴ�.");
				}
			}catch (Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
		
		//�߰��� ��ǰ��ȣ,��ǰ��, ����,�ܰ��� �Ű������� ���޹޾� �����ͺ��̽� �߰��ϴ� �޼ҵ带 ����
		public void insertGoods( int no, String item, int qty, int price  ){
			//String sql = "insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
			String sql = "insert into goods values(?,?,?,?)";
			
			//finally ������ ������ �� �ֵ��� Connection�� Statement
			//������ try�� �ٱ��� �����ؿ�
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement pstmt = null;
			
			try {
				//1. jdbc����̹��� �޸𸮷� �ε��Ѵ�.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2. DB������ �����Ѵ�.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
				
				//3. �����ͺ��̽� ����� ������ �� �ִ� Statement ��ü�� �����մϴ�.
				//stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				pstmt.setString(2, item);
				pstmt.setInt(3, qty);
				pstmt.setInt(4, price);
				
				//4. �����ͺ��̽� ����� �����մϴ�.
				int re = pstmt.executeUpdate();			
				
				if(re ==1) {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");					
				}else {
					System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�.");
				}		
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}finally {
				
				try {
					//5. ����ߴ� �ڿ����� �ݾ��ݴϴ�.						
					if(pstmt != null) {
						pstmt.close();
					}
					
					if(conn != null) {
						conn.close();
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		}
		
		
		
}
