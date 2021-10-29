package com.sist.file03;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;

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
JList<Vector<String>> list;
JTextArea jta;
String path= "c:/myData";
//JList�� �����͸� ���� ���͸� �����Ѵ�
Vector vector;

//���͸� �����Ѵ�


	public FileList() {
		
	vector= new Vector<String>();
	
		//C:\javaStudy\day1015
		File dir= new File(path);
		//���丮(����)�� File��ü�� �����
		
		//���丮�ȿ� �ִ� ��� ����, ���丮�̸��� ����� �迭�� ����´�
		String []arr= dir.list();
		
		for(String str:arr) {
			vector.add(str);
		}

		//������ �������� JList�� �����
		list= new JList<Vector<String>>(vector);
		
		//JList�� �̺�Ʈ�� ����Ѵ�
		
		list.addMouseListener(this);
		
		//JList�� JTextArea�� ���������� �����ӿ� ���� �ʰ� JScrollPane�� ���μ� ��ƾ� �Ѵ�
		JScrollPane jsp_list= new JScrollPane(list);
		
		//add(jsp_list);
		
		
		jta= new JTextArea();
		JScrollPane jsp_area= new JScrollPane(jta);
		
		//"����"�� ���� ��ư�� �����
		JButton btn_delete= new JButton("����");
		
		//��ư�� ���� �̺�Ʈ�� ����Ѵ�
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
		int idx= list.getSelectedIndex();
		String fileName= (String)vector.get(idx);
		System.out.println(fileName);
		
		try {
			//������ �����̸��� ������ �ִ� ��θ� ���ļ� File��ü Ȥ�� String���� �����
			//������ �б� ���� ��Ʈ���� �����Ѵ�
			
			FileReader fr= new FileReader(path+"/"+fileName);
			
			//������ ������ ��� �о�� �����ϱ� ���� ���ڿ� ������ ����� �ʱ�ȭ�Ѵ�
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
			System.out.println("���ܹ߻�: "+e2.getMessage());
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
		System.out.println("������ư�� �������ϴ�");
		int idx= list.getSelectedIndex();
		String fileName= (String)vector.get(idx);		
		File file= new File(path+"/"+fileName);
		
		file.delete();
		
		jta.setText("");
		
		//������ ���ϸ���� �ٽ� �о�ͼ� Vector�� ������ �ٲٰ�
		//JList�� �ٽ� �׸����� ��û�Ѵ�
		File dir= new File(path);
		String []arr= dir.list();
		
		//���͸� ������ ����� �ٽ� �о�� ���ϸ���� ����ش�
		vector.clear();
		for(String f:arr) {
			vector.add(f);
		}
		
		//JList�� ����� �ٲ� ������ �������� �ٽ� �׷��ֵ��� ��û�ؾ��Ѵ�
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�");
		
		
	}
	
	
}
