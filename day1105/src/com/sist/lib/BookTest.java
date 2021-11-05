package com.sist.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import com.sist.member.MemberVo;

public class BookTest extends JFrame {
	public void printBook() {
		rowData.clear();
		ArrayList<BookVo> list = dao.listBook();
		for (BookVo m : list) {
			Vector v = new Vector();
			v.add(m.getNo());
			v.add(m.getName());
			v.add(m.getComp());
			v.add(m.getPrice());
			rowData.add(v);

		}
		table.updateUI();
	}
	
	public BookTest() {
		btn_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printBook();
			}

		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookTest();
	}
}
