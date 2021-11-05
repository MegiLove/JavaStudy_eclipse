package com.sist.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.goos03.GoodsVo;
import com.sist.member.MemberVo;

public class BookDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##sist";
	String pwd = "sist";
	
	public ArrayList<BookVo> listBook(){
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book order by no";
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, user, pwd);
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				int no= rs.getInt(1);
				String name=rs.getString(2);
				String comp= rs.getString(3);
				int price= rs.getInt(4);			
				
				list.add(new BookVo(no,name,comp,price));
			}
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}finally {
			
				try {
					if (pstmt != null) {
						pstmt.close();
					}

					if (conn != null) {
						conn.close();
					}
					if (rs != null) {
						rs.close();
					}
			} catch (Exception e2) {
				System.out.println("예외발생:" + e2.getMessage());
			}
		}
		return list;
	}
}
