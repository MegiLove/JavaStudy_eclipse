package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String userName = "c##madang";
	private String passWord = "madang";
	
	int bookid;
	String bookname;
	String publisher;
	int price;
	
	//���ǻ���� �Ű������� ���޹޾� �ش� ���ǻ��� ��� ������ �˻��Ͽ� Arraylist�� ��ȯ�ϴ� �޼ҵ带 ����
	public ArrayList<BookVO> searchBook(String publisher){
		ArrayList<BookVO> list= new ArrayList<BookVO>();
		String sql= "select * from book where publisher=?";
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				bookid= rs.getInt(1);
				bookname= rs.getString(2);
				publisher= rs.getString(3);
				price= rs.getInt(4);
				BookVO b= new BookVO();
				b.setBookid(bookid);
				b.setBookname(bookname);
				b.setPublisher(publisher);
				b.setPrice(price);
				list.add(b);
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
				
				if(rs!= null) {
					rs.close();
				}
			} catch (Exception e2) {
				System.out.println("���ܹ߻�: " + e2.getMessage());
			}
		}
		
		return list;
	}
}
