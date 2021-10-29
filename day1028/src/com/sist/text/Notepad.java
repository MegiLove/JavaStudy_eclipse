package com.sist.text;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Notepad extends JFrame implements ActionListener {

	public JTextArea ta = new JTextArea();
	JFileChooser jfc = new JFileChooser("c:/myData");
	JMenuBar jmb = new JMenuBar();
	String fileName = "";

	public Notepad() {
		this.setTitle("제목 없음");
		
		
		
		JScrollPane jsp= new JScrollPane(ta);
		add(jsp);

		JMenu mn_file = new JMenu("파일");

		JMenuItem file_new = new JMenuItem("새 파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		

		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		

		jmb.add(mn_file);

		this.setJMenuBar(jmb);
		//매개변수 이벤트처리담당객체를 전달해야하는데, 이 클래스는 자신이 처리하도록 하기 위하여
		//this를 전달한다
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		this.setSize(500, 500);
		this.add(ta);
		this.setVisible(true);
		
		ta.setText("안녕하세요");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ta.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("새 파일")) {
			try {			
				ta.setText("");
				 this.setTitle("제목 없음");
			} catch (Exception e2) {

			}

		}
		
		if (cmd.equals("열기")) {
			try {
				int ret= jfc.showOpenDialog(this);
				
				if(ret!=JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다");
					return;
				}else {
					File inFile= jfc.getSelectedFile();
					/*BufferedReader in;
					in= new BufferedReader(new FileReader(inFile));
	                String c;
	                ta.setText("");
	                while ((c = in.readLine()) != null) {
	                    ta.append(c + "\r\n");
	                }
	                in.close();*/
					FileReader fr= new FileReader(inFile);
					int ch;
					String c="";
					ta.setText("");
					while((ch=fr.read())!=-1) {
						c=c+(char)ch;				
					}
					ta.append(c+"");
					
					fileName= inFile.getName();
					fileName= fileName.substring(0, fileName.indexOf("."));
					
					JOptionPane.showMessageDialog(this,"파일을 읽어왔습니다");
					
					setTitle(fileName);

					fr.close();
				}
			} catch (Exception e2) {

			}
			
		}
		
		if (cmd.equals("저장")) {
			//매개변수 this는 이 다이얼로그를 어떤 프레임위에서 띄울것인지를 전달한다
			//현재 이 프레임 Notepad에서 띄우라는 의미로 객체자신을 의미하는 this를 전달한다
			//showSaveDialog에서 사용하즌 저장, 취소를 누를 수 있다
			//취소를 눌렀는데 파일저장하는 명령어를 처리하면 곤란하다
			//그래서 이 메소드는 저장을 누르면 0을 반환하고 취소를 누르면 1을 반환한다
			//그 반환하는 값은 변수에 담아 그 값에 따라 처리를 다르게 할 수 있다
			int re=jfc.showSaveDialog(this);			
			File file= jfc.getSelectedFile();	        
			try {
				if(re==0) {
				
					/* BufferedWriter out = null;
                   File file = new File(fileName);
                   file=jfc.getSelectedFile(fileName);
				   out = new BufferedWriter(new FileWriter(file));
				   char[] data = ta.getText().toCharArray();
				   for(char ch : data) {
		             out.write(ch);
				   }
	               this.setTitle(file.getName());
	               out.close();*/
					
					FileWriter fw= new FileWriter(file);
					//텍스트에리어에 쓰여진 내용을 읽어와서 파일로 출력한다
					fw.write(ta.getText());
					fileName= file.getName();
					fileName= fileName.substring(0, fileName.indexOf("."));
					
					setTitle(fileName);
					fw.close();
					
					JOptionPane.showMessageDialog(this,"파일로 저장하였습니다");
					
					
				}
			} catch (Exception e2) {//예외변수이름과 이벤트변수이름이 다르게 변경해준다
				System.out.println("예외발생: "+e2.getMessage());
			}
		}
		
	}

	public static void main(String[] args) {
		new Notepad();
	}

}
