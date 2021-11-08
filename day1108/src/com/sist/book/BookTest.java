package com.sist.book;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sist.dept.DeptDAO;
import com.sist.dept.DeptVO;

public class BookTest extends JFrame {

	
	JTable table;
	Vector colNames;
	Vector<Vector> rowData;
	
	BookDao dao;
	
	public BookTest() {
		dao= new BookDao();	
	
	colNames= new Vector();
	colNames.add("도서번호");
	colNames.add("도서명");
	colNames.add("출판사명");
	colNames.add("이상미디어");
	
	rowData= new Vector<Vector>();
	
	table = new JTable(rowData,colNames);
		
	JButton btn_list= new JButton("목록");
	
	JScrollPane jsp= new JScrollPane(table);
	
	add(btn_list, BorderLayout.NORTH);
	add(jsp, BorderLayout.CENTER);
	
	setSize(600,400);
	setVisible(true);
	
	
	btn_list.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<BookVO> list= dao.searchBook("대한미디어");
			rowData.clear();
			for(BookVO b: list) {
				Vector v= new Vector();
				v.add(b.getBookid());
				v.add(b.getBookname());
				v.add(b.getPublisher());
				v.add(b.getPrice());
				rowData.add(v);
			}
			
			table.updateUI();
			
		}
		
	});
	
	
	}
	
	
	public static void main(String[] args) {
		new BookTest();
	
	}

}
