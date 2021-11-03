package com.sist.db;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.*;

public class AllStudentGUI extends JFrame {
	JTextArea jta;
	
	public AllStudentGUI() {
		jta= new JTextArea();
		
		JButton btn = new JButton("����");
		add(jta, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);

		setSize(400, 300);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String sql= "select * from student";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					//���ڵ尡 �ִ� ��ŭ Ŀ���� �� �྿ �ű��
					ArrayList <String> arr= new ArrayList<String>();
					while(rs.next()) {
						String name= rs.getString(1);
						int kor=rs.getInt(2);
						int eng=rs.getInt(3);
						int math=rs.getInt(4);
						jta.append(name+","+kor+""+","+eng+""+","+math+""+"\n");
						
					}
					
					rs.close();
					stmt.close();
					conn.close();
					
				} catch (Exception ex) {
					System.out.println("���ܹ߻�: "+ex.getMessage());
				}
				
			}
			
		});
	}
	
	
	public static void main(String[] args) {
		new AllStudentGUI();

	}

}
