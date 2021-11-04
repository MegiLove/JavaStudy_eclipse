package com.sist.goods;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class GoodsTestDBMethod extends JFrame {
	JTextField jtf_no; // 상품번호를 입력받기 위한 입력상자
	JTextField jtf_item; // 상품명
	JTextField jtf_qty; // 수량
	JTextField jtf_price; // 가격

	JTable table; // 모든 상품 목록을 엑셀과 같은 모양으로 보여주기 위한 테이블을 선언
	Vector colNames; // 테이블의 칼럼이름을 위한 벡터를 선언
	Vector<Vector> rowData; // 테이블의 데이터를 위한 벡터를 선언

	// 데이터베이스에 연결하여 goods테이블의 모든 상품을 읽어와서
	// 테이블에 출력하는 메소드를 정의

	public void addGoods(int no,String item,int qty,int price) {

		String sql = "insert into goods values(" + no + ",'" + item + "'," + qty + "," + price + ")";
		System.out.println(sql);

		// finally에서도 둘을 볼 수 있도록 바깥에 써놓는다
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if (re == 1) {
				System.out.println("상품등록에 성공하였습니다");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");

				printGoods();
			} else {
				System.out.println("상품등록에 실패하였습니다");
			}

		} catch (Exception ex) {
			System.out.println("예외발생:" + ex.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("예외발생:" + e2.getMessage());
			}

		}
	}

	public void printGoods() {

		// 새로운 상품을 등록하여 계속하여 호출될 수 있으니
		// rowData를 먼저 깨끗이 비워준다

		rowData.clear();

		// 데이터베이스에 연결하여 실행할 명령어
		String sql = "select * from goods order by no";

		// 데이터베이스 연결에 필요한 변수들을 미리 선언한다
		Connection conn = null; // DB서버 연결을 위한 변수
		Statement stmt = null; // 데이터베이스 명령을 실행하기 위한 변수
		ResultSet rs = null; // 읽어온 데이터를 담기위한 변수

		try {
			// 1. jdbc드라이버를 메모리로 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db서버에 연결한다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			// 3. statement객체를 생성한다
			stmt = conn.createStatement();
			// 4. 데이터베이스 명령을 실행한다
			rs = stmt.executeQuery(sql);

			// 5. 일처리를 한다
			// 검색한 자료가 있는만큼 반복실행하여 한 행씩 읽어와서 그것을 벡터로 만들어
			// 그 벡터를 테이블의 자료를 위한 rowData에 담는다
			// ResultSet의 결과에서 특정 레코드를 가리키는 커서가 있다
			// 이 커서를 한 행씩 옮겨주는 메소드가 next()이다
			// 메소드는 다음의 레코드가 있어서 성공적으로 옮겨지면 true를 반환하고
			// 다음에 레코드가 더이상 없어 옮겨지지 않으면 false를 반환한다
			// 그래서 보통 ResultSet의 결과를 모두 읽어서 처리하려면 다음과 같이 while문을 이용한단
			while (rs.next()) {
				// 현재 커서가 바라보고 있는 레코드의 속성 값을 읽어오기 위해서는 자료형에 따라
				// get~()을 사용한다
				// 컬럼의 값이 문자열이라면 getString(), 정수라면 getInt()를 사용한다
				// 이때 매개변수로 컬럼의 매개변수나 컬럼이름을 문자열로 전달한다
				// 여기서 인덱스는 1부터 시작한다
				int no = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);

				// 벡터를 하나 만들고 그 벡터에 no,item,qty,price를 담는다
				Vector v1 = new Vector();
				v1.add(no);
				v1.add(item);
				v1.add(qty);
				v1.add(price);
				// 그 벡터를 rowData에 담는다
				rowData.add(v1);

				// 바뀐 내용으로 테이블을 다시 그린다
				// 처음 테이블을 만들 때에는 rowData벡터가 비어있었다
				// 나중에 테이블의 데이터인 rowData에 바뀐자료를 적용하기 위해서는
				// updateUI를 호출해야 한다
				table.updateUI();
			}
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	public GoodsTestDBMethod() {

		colNames = new Vector();
		colNames.add("상품번호");
		colNames.add("상품명");
		colNames.add("상품수량");
		colNames.add("단가");

		rowData = new Vector<Vector>();

		// colNames벡터와 rowData벡터를 가지고 엑셀과 같은 화면의 테이블을 생성한다
		table = new JTable(rowData, colNames);

		JScrollPane jsp = new JScrollPane(table);

		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();

		// 입력상자들과 무엇을 입력해야하는지 설명하는 라벨들을 담기 위한 패널을 생성한다
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 2));

		// 라벨과 입력상자(텍스트필드)들을 패널에 차례대로 담는다
		p.add(new JLabel("상품번호: "));
		p.add(jtf_no);
		p.add(new JLabel("상품이름: "));
		p.add(jtf_item);
		p.add(new JLabel("상품수량: "));
		p.add(jtf_qty);
		p.add(new JLabel("상품단가: "));
		p.add(jtf_price);

		JButton btn_add = new JButton("추가");
		JButton btn_list = new JButton("목록");

		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);

		// 입력상자들이 있는 패널과 버튼이 있는 패널을 하나로 담기 위한 패널을 생성한다
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);

		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);

		setSize(800, 600);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 목록버튼을 누르면
		// 데이터베이스를 연결하여 모든 상품목록을 읽어와서 테이블에 출력하는 메소드를 호출한다
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printGoods();

			}

		});

		// 추가 버튼을 누르면 사용자가 입력한 상품번호,상품이름,상품수량,상품가격
		// 으로 데이터베이스 테이블에 자료를 추가하도록 한다
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(jtf_no.getText());
				String item = jtf_item.getText();
				int qty = Integer.parseInt(jtf_qty.getText());
				int price = Integer.parseInt(jtf_price.getText());
				
				addGoods(no,item,qty,price);
			}

		});
	}

	public static void main(String[] args) {
		new GoodsTestDBMethod();

	}

}
