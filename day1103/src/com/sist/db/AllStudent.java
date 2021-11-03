package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllStudent {
	
	public static void main(String[] args) {
		try {
			String sql= "select * from student";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			//레코드가 있는 만큼 커서를 한 행씩 옮긴다
			while(rs.next()) {
				String name= rs.getString(1);
				int kor=rs.getInt(2);
				int eng=rs.getInt(3);
				int math=rs.getInt(4);
				System.out.println(name+","+kor+","+eng+","+math);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}

	}

}
