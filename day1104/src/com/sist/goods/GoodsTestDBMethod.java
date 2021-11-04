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
	JTextField jtf_no; // ��ǰ��ȣ�� �Է¹ޱ� ���� �Է»���
	JTextField jtf_item; // ��ǰ��
	JTextField jtf_qty; // ����
	JTextField jtf_price; // ����

	JTable table; // ��� ��ǰ ����� ������ ���� ������� �����ֱ� ���� ���̺��� ����
	Vector colNames; // ���̺��� Į���̸��� ���� ���͸� ����
	Vector<Vector> rowData; // ���̺��� �����͸� ���� ���͸� ����

	// �����ͺ��̽��� �����Ͽ� goods���̺��� ��� ��ǰ�� �о�ͼ�
	// ���̺� ����ϴ� �޼ҵ带 ����

	public void addGoods(int no,String item,int qty,int price) {

		String sql = "insert into goods values(" + no + ",'" + item + "'," + qty + "," + price + ")";
		System.out.println(sql);

		// finally������ ���� �� �� �ֵ��� �ٱ��� ����´�
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			stmt = conn.createStatement();
			int re = stmt.executeUpdate(sql);
			if (re == 1) {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
				jtf_no.setText("");
				jtf_item.setText("");
				jtf_qty.setText("");
				jtf_price.setText("");

				printGoods();
			} else {
				System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
			}

		} catch (Exception ex) {
			System.out.println("���ܹ߻�:" + ex.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println("���ܹ߻�:" + e2.getMessage());
			}

		}
	}

	public void printGoods() {

		// ���ο� ��ǰ�� ����Ͽ� ����Ͽ� ȣ��� �� ������
		// rowData�� ���� ������ ����ش�

		rowData.clear();

		// �����ͺ��̽��� �����Ͽ� ������ ��ɾ�
		String sql = "select * from goods order by no";

		// �����ͺ��̽� ���ῡ �ʿ��� �������� �̸� �����Ѵ�
		Connection conn = null; // DB���� ������ ���� ����
		Statement stmt = null; // �����ͺ��̽� ����� �����ϱ� ���� ����
		ResultSet rs = null; // �о�� �����͸� ������� ����

		try {
			// 1. jdbc����̹��� �޸𸮷� �ε��Ѵ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db������ �����Ѵ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			// 3. statement��ü�� �����Ѵ�
			stmt = conn.createStatement();
			// 4. �����ͺ��̽� ����� �����Ѵ�
			rs = stmt.executeQuery(sql);

			// 5. ��ó���� �Ѵ�
			// �˻��� �ڷᰡ �ִ¸�ŭ �ݺ������Ͽ� �� �྿ �о�ͼ� �װ��� ���ͷ� �����
			// �� ���͸� ���̺��� �ڷḦ ���� rowData�� ��´�
			// ResultSet�� ������� Ư�� ���ڵ带 ����Ű�� Ŀ���� �ִ�
			// �� Ŀ���� �� �྿ �Ű��ִ� �޼ҵ尡 next()�̴�
			// �޼ҵ�� ������ ���ڵ尡 �־ ���������� �Ű����� true�� ��ȯ�ϰ�
			// ������ ���ڵ尡 ���̻� ���� �Ű����� ������ false�� ��ȯ�Ѵ�
			// �׷��� ���� ResultSet�� ����� ��� �о ó���Ϸ��� ������ ���� while���� �̿��Ѵ�
			while (rs.next()) {
				// ���� Ŀ���� �ٶ󺸰� �ִ� ���ڵ��� �Ӽ� ���� �о���� ���ؼ��� �ڷ����� ����
				// get~()�� ����Ѵ�
				// �÷��� ���� ���ڿ��̶�� getString(), ������� getInt()�� ����Ѵ�
				// �̶� �Ű������� �÷��� �Ű������� �÷��̸��� ���ڿ��� �����Ѵ�
				// ���⼭ �ε����� 1���� �����Ѵ�
				int no = rs.getInt(1);
				String item = rs.getString(2);
				int qty = rs.getInt(3);
				int price = rs.getInt(4);

				// ���͸� �ϳ� ����� �� ���Ϳ� no,item,qty,price�� ��´�
				Vector v1 = new Vector();
				v1.add(no);
				v1.add(item);
				v1.add(qty);
				v1.add(price);
				// �� ���͸� rowData�� ��´�
				rowData.add(v1);

				// �ٲ� �������� ���̺��� �ٽ� �׸���
				// ó�� ���̺��� ���� ������ rowData���Ͱ� ����־���
				// ���߿� ���̺��� �������� rowData�� �ٲ��ڷḦ �����ϱ� ���ؼ���
				// updateUI�� ȣ���ؾ� �Ѵ�
				table.updateUI();
			}
		} catch (Exception e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
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
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("��ǰ����");
		colNames.add("�ܰ�");

		rowData = new Vector<Vector>();

		// colNames���Ϳ� rowData���͸� ������ ������ ���� ȭ���� ���̺��� �����Ѵ�
		table = new JTable(rowData, colNames);

		JScrollPane jsp = new JScrollPane(table);

		jtf_no = new JTextField();
		jtf_item = new JTextField();
		jtf_qty = new JTextField();
		jtf_price = new JTextField();

		// �Է»��ڵ�� ������ �Է��ؾ��ϴ��� �����ϴ� �󺧵��� ��� ���� �г��� �����Ѵ�
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 2));

		// �󺧰� �Է»���(�ؽ�Ʈ�ʵ�)���� �гο� ���ʴ�� ��´�
		p.add(new JLabel("��ǰ��ȣ: "));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�: "));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����: "));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�: "));
		p.add(jtf_price);

		JButton btn_add = new JButton("�߰�");
		JButton btn_list = new JButton("���");

		JPanel p2 = new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);

		// �Է»��ڵ��� �ִ� �гΰ� ��ư�� �ִ� �г��� �ϳ��� ��� ���� �г��� �����Ѵ�
		JPanel p_center = new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p, BorderLayout.CENTER);
		p_center.add(p2, BorderLayout.SOUTH);

		add(p_center, BorderLayout.CENTER);
		add(jsp, BorderLayout.SOUTH);

		setSize(800, 600);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��Ϲ�ư�� ������
		// �����ͺ��̽��� �����Ͽ� ��� ��ǰ����� �о�ͼ� ���̺� ����ϴ� �޼ҵ带 ȣ���Ѵ�
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printGoods();

			}

		});

		// �߰� ��ư�� ������ ����ڰ� �Է��� ��ǰ��ȣ,��ǰ�̸�,��ǰ����,��ǰ����
		// ���� �����ͺ��̽� ���̺� �ڷḦ �߰��ϵ��� �Ѵ�
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
