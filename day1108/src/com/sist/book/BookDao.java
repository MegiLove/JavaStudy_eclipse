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
	
	//출판사명을 매개변수로 전달받아 해당 출판사의 모든 도서를 검색하여 Arraylist로 반환하는 메소드를 정의
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
			System.out.println("예외발생: " + e.getMessage());
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
				System.out.println("예외발생: " + e2.getMessage());
			}
		}
		
		return list;
	}
}
