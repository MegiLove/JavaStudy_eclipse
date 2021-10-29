package com.sist.file;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FileList extends JFrame {
JList<String> list;

	public FileList() {
		//JList의 목록으로 사용할 배열을 만든다
		String []arr= {"사과","포도","수박","딸기","사과","포도","수박","딸기","사과","포도","수박","딸기","사과","포도","수박","딸기"};
		list= new JList<String>(arr);
		
		JScrollPane jsp_list= new JScrollPane(list);
		add(jsp_list);
		
		add(list);
		
		setSize(400,300);
		setVisible(true);
	}
}
