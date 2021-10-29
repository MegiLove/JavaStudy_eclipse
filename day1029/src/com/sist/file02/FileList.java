package com.sist.file02;

import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
public class FileList extends JFrame implements MouseListener,ActionListener {
JList<String> list;
JTextArea jta;
String path= "c:/myData";
	public FileList() {
		
		//C:\javaStudy\day1015
		File dir= new File(path);
		//디렉토리(폴더)도 File객체로 만든다
		
		//디렉토리안에 있는 모든 파일, 디렉토리이름의 목록을 배열로 갖고온다
		String []arr= dir.list();
		
		//배열안의 내용으로 JList를 만든다
		list= new JList<String>(arr);
		
		//JList에 이벤트를 등록한다
		
		list.addMouseListener(this);
		
		//JList도 JTextArea와 마찬가지로 프레임에 담지 않고 JScrollPane로 감싸서 담아야 한다
		JScrollPane jsp_list= new JScrollPane(list);
		
		//add(jsp_list);
		
		
		jta= new JTextArea();
		JScrollPane jsp_area= new JScrollPane(jta);
		
		//"삭제"를 위한 버튼을 만든다
		JButton btn_delete= new JButton("삭제");
		
		//버튼에 대한 이벤트를 등록한다
		btn_delete.addActionListener(this);
		
		add(jsp_list,BorderLayout.WEST);
		add(jsp_area,BorderLayout.CENTER);
		add(btn_delete,BorderLayout.SOUTH);
		
		//add(list);
		setSize(800,600);
		setVisible(true);
	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String fileName= list.getSelectedValue();
		
		try {
			//선택한 파일이름과 파일이 있는 경로를 합쳐서 File객체 혹은 String으로 만들어
			//파일을 읽기 위한 스트림을 생성한다
			
			FileReader fr= new FileReader(path+"/"+fileName);
			
			//파일의 내용을 모두 읽어와 누적하기 위한 문자열 변수를 만들고 초기화한다
			String data="";
			int ch;
			while(true) {
				ch=fr.read();
				if(ch==-1) {
					break;
				}
				data= data+(char)ch;
			}	
			
			jta.setText(data);
			
			fr.close();
			
		} catch (Exception e2) {
			System.out.println("예외발생: "+e2.getMessage());
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("삭제버튼을 눌렀습니다");
		String fileName= list.getSelectedValue();
		File file= new File(path+"/"+fileName);
		
		file.delete();
		
		jta.setText("");
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다");	
	}
	
	
}
