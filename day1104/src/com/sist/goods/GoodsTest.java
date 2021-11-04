package com.sist.goods;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
public class GoodsTest extends JFrame {
	JTextField jtf_no;		//상품번호를 입력받기 위한 입력상자
	JTextField jtf_item;	//상품명
	JTextField jtf_qty;		//수량
	JTextField jtf_price;	//가격
	
	JTable table; 					//모든 상품 목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames; 		//테이블의 칼럼이름을 위한 벡터를 선언
	Vector<Vector> rowData; //테이블의 데이터를 위한 벡터를 선언
	public GoodsTest() {
		
		colNames= new Vector();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("상품수량");
		colNames.add("단가");
		
		rowData= new Vector<Vector>();
		Vector v1= new Vector();
		v1.add("1");
		v1.add("색종이");
		v1.add("10");
		v1.add("1500");
		Vector v2= new Vector();
		v2.add("2");
		v2.add("딱풀");
		v2.add("20");
		v2.add("700");
		
		rowData.add(v1);
		rowData.add(v2);
		
		//colNames벡터와 rowData벡터를 가지고 엑셀과 같은 화면의 테이블을 생성한다
		table=new JTable(rowData,colNames);
		
		JScrollPane jsp= new JScrollPane(table);
		
		jtf_no= new JTextField();
		jtf_item= new JTextField();
		jtf_qty= new JTextField();
		jtf_price= new JTextField();
		
		//입력상자들과 무엇을 입력해야하는지 설명하는 라벨들을 담기 위한 패널을 생성한다
		JPanel p= new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//라벨과 입력상자(텍스트필드)들을 패널에 차례대로 담는다
		p.add(new JLabel("상품번호: "));
		p.add(jtf_no);
		p.add(new JLabel("상품이름: "));
		p.add(jtf_item);
		p.add(new JLabel("상품수량: "));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가: "));
		p.add(jtf_price);
		
		JButton btn_add= new JButton("추가");
		JButton btn_list= new JButton("목록");
		
		JPanel p2= new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		//입력상자들이 있는 패널과 버튼이 있는 패널을 하나로 담기 위한 패널을 생성한다
		JPanel p_center= new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//추가 버튼을 누르면 사용자가 입력한 상품번호,상품이름,상품수량,상품가격
		//으로 데이터베이스 테이블에 자료를 추가하도록 한다
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no= Integer.parseInt(jtf_no.getText());
				String item= jtf_item.getText();
				int qty= Integer.parseInt(jtf_qty.getText());
				int price= Integer.parseInt(jtf_price.getText());

				String sql="insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
				System.out.println(sql);
				
				//finally에서도 둘을 볼 수 있도록 바깥에 써놓는다
				Connection conn=null;
				Statement stmt=null;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					stmt=conn.createStatement(); 
					int re=stmt.executeUpdate(sql); 
					if(re==1) {
						System.out.println("상품등록에 성공하였습니다");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
					}else {
						System.out.println("상품등록에 실패하였습니다");
					}
					
					
				} catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}finally {
					try {
						if(stmt!=null) {
						stmt.close();
						}
						if(conn!=null) {
						conn.close();
						}
					} catch (Exception e2) {
						System.out.println("예외발생:"+e2.getMessage());
					}
					
				}
			}
			
		});
	}
	public static void main(String[] args) {
	new GoodsTest();	

	}

}
