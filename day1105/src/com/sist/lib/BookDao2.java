package com.sist.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class BookDao2 {
		   
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
		
	
	
	public int insertBook(BookVo b) {
	      int re = -1;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql = "insert into book values(?,?,?,?)";
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, b.getNo());
	         pstmt.setString(2, b.getName());
	         pstmt.setString(3, b.getComp());
	         pstmt.setInt(4, b.getPrice());
	         
	         re = pstmt.executeUpdate();
	      } catch (Exception e) {
	         System.out.println("예외발생:"+e.getMessage());
	      }finally {
	         try {
	            if(conn != null) {
	               conn.close();
	            }
	            if(pstmt != null) {
	               pstmt.close();
	            }
	         } catch (Exception e) {
	            // TODO: handle exception
	         }
	      }
	      return re;
	   }
	
	public int updateBook(BookVo b) {
        int re = -1;
        String sql = "update book set name=?,comp=?,price=? where no=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           String url = "jdbc:oracle:thin:@localhost:1521:XE";
           String user = "c##sist";
           String pwd="sist";
           conn = DriverManager.getConnection(url, user, pwd);
           
           
           pstmt = conn.prepareStatement(sql);
           

        
           
           pstmt.setString(1, b.getName());
           pstmt.setString(2, b.getComp());
           pstmt.setInt(3, b.getPrice());
           pstmt.setInt(4, b.getNo());
           
     
           re =pstmt.executeUpdate();
           
           //나머지 일처리를 한다.
           if(re == 1) {
              System.out.println("상품수정에 성공하였습니다.");
              
           }else {
              System.out.println("상품수정에 실패하였습니다.");
           }
           
        }catch (Exception e) {
           System.out.println("예외발생:"+e.getMessage());
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
        return re;
     }
	public int deleteBook(int no) {
		int re = -1;
		String sql="delete book where no=?";
		
		Connection  conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist" );
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
						
			re = pstmt.executeUpdate();
		
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
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
		
		return re;
	}

}
