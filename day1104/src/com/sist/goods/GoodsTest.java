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
	JTextField jtf_no;		//��ǰ��ȣ�� �Է¹ޱ� ���� �Է»���
	JTextField jtf_item;	//��ǰ��
	JTextField jtf_qty;		//����
	JTextField jtf_price;	//����
	
	JTable table; 					//��� ��ǰ ����� ������ ���� ������� �����ֱ� ���� ���̺��� ����
	Vector colNames; 		//���̺��� Į���̸��� ���� ���͸� ����
	Vector<Vector> rowData; //���̺��� �����͸� ���� ���͸� ����
	public GoodsTest() {
		
		colNames= new Vector();
		colNames.add("��ǰ��ȣ");
		colNames.add("��ǰ��");
		colNames.add("��ǰ����");
		colNames.add("�ܰ�");
		
		rowData= new Vector<Vector>();
		Vector v1= new Vector();
		v1.add("1");
		v1.add("������");
		v1.add("10");
		v1.add("1500");
		Vector v2= new Vector();
		v2.add("2");
		v2.add("��Ǯ");
		v2.add("20");
		v2.add("700");
		
		rowData.add(v1);
		rowData.add(v2);
		
		//colNames���Ϳ� rowData���͸� ������ ������ ���� ȭ���� ���̺��� �����Ѵ�
		table=new JTable(rowData,colNames);
		
		JScrollPane jsp= new JScrollPane(table);
		
		jtf_no= new JTextField();
		jtf_item= new JTextField();
		jtf_qty= new JTextField();
		jtf_price= new JTextField();
		
		//�Է»��ڵ�� ������ �Է��ؾ��ϴ��� �����ϴ� �󺧵��� ��� ���� �г��� �����Ѵ�
		JPanel p= new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		//�󺧰� �Է»���(�ؽ�Ʈ�ʵ�)���� �гο� ���ʴ�� ��´�
		p.add(new JLabel("��ǰ��ȣ: "));
		p.add(jtf_no);
		p.add(new JLabel("��ǰ�̸�: "));
		p.add(jtf_item);
		p.add(new JLabel("��ǰ����: "));
		p.add(jtf_qty);
		p.add(new JLabel("��ǰ�ܰ�: "));
		p.add(jtf_price);
		
		JButton btn_add= new JButton("�߰�");
		JButton btn_list= new JButton("���");
		
		JPanel p2= new JPanel();
		p2.add(btn_add);
		p2.add(btn_list);
		
		//�Է»��ڵ��� �ִ� �гΰ� ��ư�� �ִ� �г��� �ϳ��� ��� ���� �г��� �����Ѵ�
		JPanel p_center= new JPanel();
		p_center.setLayout(new BorderLayout());
		p_center.add(p,BorderLayout.CENTER);
		p_center.add(p2,BorderLayout.SOUTH);
		
		add(p_center,BorderLayout.CENTER);
		add(jsp,BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�߰� ��ư�� ������ ����ڰ� �Է��� ��ǰ��ȣ,��ǰ�̸�,��ǰ����,��ǰ����
		//���� �����ͺ��̽� ���̺� �ڷḦ �߰��ϵ��� �Ѵ�
		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no= Integer.parseInt(jtf_no.getText());
				String item= jtf_item.getText();
				int qty= Integer.parseInt(jtf_qty.getText());
				int price= Integer.parseInt(jtf_price.getText());

				String sql="insert into goods values("+no+",'"+item+"',"+qty+","+price+")";
				System.out.println(sql);
				
				//finally������ ���� �� �� �ֵ��� �ٱ��� ����´�
				Connection conn=null;
				Statement stmt=null;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
					stmt=conn.createStatement(); 
					int re=stmt.executeUpdate(sql); 
					if(re==1) {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
						jtf_no.setText("");
						jtf_item.setText("");
						jtf_qty.setText("");
						jtf_price.setText("");
					}else {
						System.out.println("��ǰ��Ͽ� �����Ͽ����ϴ�");
					}
					
					
				} catch (Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}finally {
					try {
						if(stmt!=null) {
						stmt.close();
						}
						if(conn!=null) {
						conn.close();
						}
					} catch (Exception e2) {
						System.out.println("���ܹ߻�:"+e2.getMessage());
					}
					
				}
			}
			
		});
	}
	public static void main(String[] args) {
	new GoodsTest();	

	}

}
