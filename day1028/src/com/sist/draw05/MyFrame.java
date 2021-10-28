package com.sist.draw05;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//MyFrame클래스 자신이 JMenuItem을 눌렀을 떄
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(600, 400);
		setVisible(true);
		setTitle("선 그리기");

		// 메뉴바를 생성한다
		JMenuBar jmb = new JMenuBar();

		// 주메뉴 파일을 생성한다
		JMenu mn_file = new JMenu("파일");

		// 부메뉴들을 생성한다
		JMenuItem file_new = new JMenuItem("새 파일");

		JMenuItem file_open = new JMenuItem("열기");

		JMenuItem file_save = new JMenuItem("저장");

		// 부메뉴들을 주 메뉴에 담는다
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);

		// 주메뉴를 메뉴바에 담는다
		jmb.add(mn_file);

		// 메뉴바를 프레임에 설정한다
		this.setJMenuBar(jmb);

		// 각각의 메뉴 아이템에 대하여
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
	}

	// 매개변수 ActionEvent의 getActionCommand()를 이용한다
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "가 눌러짐");
		if(cmd.equals("저장")) {
			try {
				//현재 화면에 그려진 모든 선들을 파일로 저장한다
				//현재 화면에 그려진 모든 선들의 정보는 LinePanel객체인 lp의 list에 담겨 있다
				//list객체를 통째로 파일로 출력하기 위해 ObjectOutputStream을 이용한다
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				//LinePanel객체의 맴버변수인 list를 파일로 출력한다
				oos.writeObject(lp.list);
				
				oos.close();
				
			} catch (Exception e2) {
				System.out.println("예외 발생: "+e2.getMessage());
			}
		}else if(cmd.equals("열기")) {
			//파일의 내용을 읽어 들여 LinePanel객체인 lp의 list에 저장하도록 한다
			//화면을 다시 그리게 하기 위하여 LinePanel 객체를 lp의 repaint를 호출한다
			try {
				//객체단위로 파일의 내용을 읽어들이기 위하여 ObjectInputStream객체를 생성한다
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//파일로 데이터를 읽어들여 LinePanel객체인 lp의 list에 담는다
				lp.list= (ArrayList<GraphicInfo>)ois.readObject();
				
				//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위해 repaint를 호출한다
				lp.repaint();
				
				//파일을 닫아준다
				ois.close();
								
			} catch (Exception e2) {
				System.out.println("예외발생: "+e2.getMessage());
			}
			}else if(cmd.equals("새파일")) {
		}
	}

}
