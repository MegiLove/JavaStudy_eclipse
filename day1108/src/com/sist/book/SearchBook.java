package com.sist.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class SearchBook {
	
	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String sql= "select * from book where publisher=? order by price desc ";
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String userName="c##madang";
		String passWord="madang";
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String keyword="";
		System.out.print("검색할 출판사명을 입력하시오==>");
		keyword= sc.next();
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, userName, passWord);
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs= pstmt.executeQuery();
			int bookid=0;
			String bookname="";
			String publisher="";
			int price=0;
			System.out.println("도서번호\t도서명\t출판사명\t가격");
			while(rs.next()) {
				bookid= rs.getInt(1);
				bookname= rs.getString(2);
				publisher= rs.getString(3);
				price= rs.getInt(4);
				System.out.println(bookid+"\t"+bookname+"\t"+publisher+"\t"+price);
			}
			
			
		} catch (Exception e) {
			System.out.println("예외발생: "+ e.getMessage());
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
				System.out.println("예외발생: "+ e2.getMessage());
			}
		}
	}

}
