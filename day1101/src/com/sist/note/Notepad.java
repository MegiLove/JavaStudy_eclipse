package com.sist.note;

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
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.event.KeyListener;

public class Notepad extends JFrame implements ActionListener, KeyListener {

	public JTextArea ta = new JTextArea();
	JFileChooser jfc = new JFileChooser("c:/myData");
	JMenuBar jmb = new JMenuBar();
	String fileName = "";
	boolean isNew;
	File file;

	public Notepad() {
		this.setTitle("제목 없음");

		JScrollPane jsp = new JScrollPane(ta);
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
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);

		ta.addKeyListener(this);

		this.setSize(500, 500);
		this.add(ta);
		this.setVisible(true);

		ta.setText("안녕하세요");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		ta.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("새 파일")) {
			try {
				if (isNew == true) {
					int re = JOptionPane.showConfirmDialog(this, "저장하겠습니까?");
					
					switch(re) {
					case 0: saveFile();
							ta.setText("");
							this.setTitle("제목 없음");
							isNew= false;

					case 1:
							ta.setText("");
							this.setTitle("제목 없음");
							isNew= false;
							file= null;
							break;
							
					case 2: return;
					}
				}else {
					ta.setText("");
					this.setTitle("제목 없음");
					isNew= false;
					}
				
				
			} catch (Exception e2) {

			}
			
		}

		if (cmd.equals("열기")) {
			try {
				int ret = jfc.showOpenDialog(this);

				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다");
					return;
				} else {
					File inFile = jfc.getSelectedFile();
					FileReader fr = new FileReader(inFile);
					int ch;
					String c = "";
					ta.setText("");
					while ((ch = fr.read()) != -1) {
						c = c + (char) ch;
					}
					ta.append(c + "");

					fileName = inFile.getName();
					fileName = fileName.substring(0, fileName.indexOf("."));

					JOptionPane.showMessageDialog(this, "파일을 읽어왔습니다");

					setTitle(fileName);

					fr.close();
				}
			} catch (Exception e2) {

			}

			isNew = false;
		}

		if (cmd.equals("저장")) {
			saveFile(); }
	}

	public static void main(String[] args) {
		new Notepad();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		isNew = true;
	}

	public void saveFile() {
		int re=0;
		if (file == null) {
			re = jfc.showSaveDialog(this);
			if (re == 0) {
				file = jfc.getSelectedFile();
			}
		}

		
		try {
			if (re == 0) {
				File file = jfc.getSelectedFile();
				FileWriter fw = new FileWriter(file);

				fw.write(ta.getText());
				fileName = file.getName();
				fileName = fileName.substring(0, fileName.indexOf("."));

				setTitle(fileName);
				fw.close();

				JOptionPane.showMessageDialog(this, "파일로 저장하였습니다");

			}
		} catch (Exception e2) {
			System.out.println("예외발생: " + e2.getMessage());
		}

		isNew = false;
	}

}
