package com.sist.draw07;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sist.draw07.GraphicInfo;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Color;
//MyFrame클래스 자신이 JMenuItem을 눌렀을 떄
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	//저장할 파일명과 열어올 파일명을 선택할 수 있도록 하는 JFileChooser를 맴버변수로 선언한다
	JFileChooser jfc;
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		
		jfc= new JFileChooser("c:/myData");
		jcc= new JColorChooser();
		
		// 메뉴바를 생성한다
		JMenuBar jmb = new JMenuBar();

		// 주메뉴 파일을 생성한다
		JMenu mn_file = new JMenu("파일");

		JMenu mn_file2 = new JMenu("그리기도구");
		
		JMenu mn_file3 = new JMenu("그리기색상");

		// 부메뉴들을 생성한다
		JMenuItem file_new = new JMenuItem("새 파일");

		JMenuItem file_open = new JMenuItem("열기");

		JMenuItem file_save = new JMenuItem("저장");

		JMenuItem file_draw1 = new JMenuItem("선");

		JMenuItem file_draw2 = new JMenuItem("사각형");

		JMenuItem file_draw3 = new JMenuItem("원");
		
		JMenuItem color_red = new JMenuItem("빨강");
		JMenuItem color_blue = new JMenuItem("파랑");
		JMenuItem color_green = new JMenuItem("초록");
		JMenuItem color_other = new JMenuItem("다른 색상");

		// 부메뉴들을 주 메뉴에 담는다
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);

		mn_file2.add(file_draw1);
		mn_file2.add(file_draw2);
		mn_file2.add(file_draw3);
		
		mn_file3.add( color_red);
		mn_file3.add( color_blue);
		mn_file3.add( color_green);
		mn_file3.add( color_other);

		// 주메뉴를 메뉴바에 담는다
		jmb.add(mn_file);
		jmb.add(mn_file2);
		jmb.add(mn_file3);		

		// 메뉴바를 프레임에 설정한다
		this.setJMenuBar(jmb);

		// 각각의 메뉴 아이템에 대하여
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_draw1.addActionListener(this);
		file_draw2.addActionListener(this);
		file_draw3.addActionListener(this);
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);			
		
		setSize(600, 400);
		setVisible(true);
		setTitle("선 그리기");
	}

	// 매개변수 ActionEvent의 getActionCommand()를 이용한다
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// System.out.println(cmd + "가 눌러짐");
		if (cmd.equals("저장")) {
			try {	
				System.out.println("저장합니다");
				//어디에 어떤이름으로 저장할지 선택하도록 JFileChooser dialogue를 띄운다
				int re=jfc.showSaveDialog(this);
				
				//저장하기 다이얼로그에서 저장을 누를 수도 있고 취소를 누를수도 있다
				//저장을 누르면 0이 반환되고 ,취소를 누르면 1이 반환된다
				if(re==0) {
					//다이얼로그에서 선택한 파일을 갖고 온다
					File file= jfc.getSelectedFile();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(lp.list);
					oos.close();
				}
				
				
				
				// 현재 화면에 그려진 모든 선들을 파일로 저장한다
				// 현재 화면에 그려진 모든 선들의 정보는 LinePanel객체인 lp의 list에 담겨 있다
				// list객체를 통째로 파일로 출력하기 위해 ObjectOutputStream을 이용한다

				// LinePanel객체의 맴버변수인 list를 파일로 출력한다
				

			} catch (Exception e2) {
				System.out.println("예외 발생: " + e2.getMessage());
			}
		} else if (cmd.equals("열기")) {
			// 파일의 내용을 읽어 들여 LinePanel객체인 lp의 list에 저장하도록 한다
			// 화면을 다시 그리게 하기 위하여 LinePanel 객체를 lp의 repaint를 호출한다
			try {
				System.out.println("열어옵니다");
				int rx=jfc.showOpenDialog(this);
				if(rx==0) {
				File file= jfc.getSelectedFile();
				// 객체단위로 파일의 내용을 읽어들이기 위하여 ObjectInputStream객체를 생성한다
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				lp.list= (ArrayList<GraphicInfo>)ois.readObject();
				lp.repaint();
				ois.close();
				}
				

			} catch (Exception e2) {
				System.out.println("예외발생: " + e2.getMessage());
			}
		} else if (cmd.equals("새 파일")) {
			System.out.println("새파일");
			//this.remove(lp);
			//this.add(lp = new LinePanel());
			//사용자가 그린 그래픽이 담겨있는 리스트를 모두 지워요
			lp.list.clear();
			//그래픽을 그리는 판넬을 다시 그린다
			lp.repaint();
			
		} else if (cmd.equals("선")) {
			lp.drawType=0;
		} else if (cmd.equals("사각형")) {
			lp.drawType=1;
		} else if (cmd.equals("원")) {
			lp.drawType=2;
		}  else if (cmd.equals("빨강")) {
			lp.drawColor=Color.RED;
		} else if (cmd.equals("파랑")) {
			lp.drawColor=Color.BLUE;
		} else if (cmd.equals("초록")) {
			lp.drawColor=Color.GREEN;
		}else if (cmd.equals("다른 색상")) {
			Color color=jcc.showDialog(this, "그리기 색상", Color.RED);
			System.out.println("선택한 색상:"+color);
			if(color!=null) {
				lp.drawColor= color;
			}
		}
	}

}
