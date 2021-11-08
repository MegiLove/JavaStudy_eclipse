package com.sist.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//DAO: Database Access Object
//데이터베이스 테이블에 접근하여 자료를 추가, 읽기, 수정, 삭제를 담당하는 객체
public class DeptDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String userName = "c##sist";
	private String passWord = "sist";

	public int insert(DeptVO d) {
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				System.out.println("예외발생: " + e2.getMessage());

			}
		}
		return re;
	}

	public int update(DeptVO d) {
		int re = -1;
		String sql = "update dept set dname=?,dloc=? where dno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getDloc());
			pstmt.setInt(3, d.getDno());
			re=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("예외발생: " + e2.getMessage());

			}
		}
		return re;
	}

	public int delete(int dno) {
		int re = -1;
		String sql = "delete dept where dno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dno);
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("예외발생: " + e2.getMessage());

			}
		}
		return re;
	}

	public ArrayList<DeptVO> listAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//ResultSet에 읽어온 모든 레코드들을 list에 담는다
			while(rs.next()) {
				int dno= rs.getInt(1);
				String dname= rs.getString(2);
				String dloc= rs.getString(3);
				DeptVO d= new DeptVO();
				d.setDno(dno);
				d.setDname(dname);
				d.setDloc(dloc);			
				list.add(new DeptVO(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		} finally {
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
