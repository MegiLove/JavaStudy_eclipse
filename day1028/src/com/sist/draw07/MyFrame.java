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
//MyFrameŬ���� �ڽ��� JMenuItem�� ������ ��
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	//������ ���ϸ�� ����� ���ϸ��� ������ �� �ֵ��� �ϴ� JFileChooser�� �ɹ������� �����Ѵ�
	JFileChooser jfc;
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		
		jfc= new JFileChooser("c:/myData");
		jcc= new JColorChooser();
		
		// �޴��ٸ� �����Ѵ�
		JMenuBar jmb = new JMenuBar();

		// �ָ޴� ������ �����Ѵ�
		JMenu mn_file = new JMenu("����");

		JMenu mn_file2 = new JMenu("�׸��⵵��");
		
		JMenu mn_file3 = new JMenu("�׸������");

		// �θ޴����� �����Ѵ�
		JMenuItem file_new = new JMenuItem("�� ����");

		JMenuItem file_open = new JMenuItem("����");

		JMenuItem file_save = new JMenuItem("����");

		JMenuItem file_draw1 = new JMenuItem("��");

		JMenuItem file_draw2 = new JMenuItem("�簢��");

		JMenuItem file_draw3 = new JMenuItem("��");
		
		JMenuItem color_red = new JMenuItem("����");
		JMenuItem color_blue = new JMenuItem("�Ķ�");
		JMenuItem color_green = new JMenuItem("�ʷ�");
		JMenuItem color_other = new JMenuItem("�ٸ� ����");

		// �θ޴����� �� �޴��� ��´�
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

		// �ָ޴��� �޴��ٿ� ��´�
		jmb.add(mn_file);
		jmb.add(mn_file2);
		jmb.add(mn_file3);		

		// �޴��ٸ� �����ӿ� �����Ѵ�
		this.setJMenuBar(jmb);

		// ������ �޴� �����ۿ� ���Ͽ�
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
		setTitle("�� �׸���");
	}

	// �Ű����� ActionEvent�� getActionCommand()�� �̿��Ѵ�
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// System.out.println(cmd + "�� ������");
		if (cmd.equals("����")) {
			try {	
				System.out.println("�����մϴ�");
				//��� ��̸����� �������� �����ϵ��� JFileChooser dialogue�� ����
				int re=jfc.showSaveDialog(this);
				
				//�����ϱ� ���̾�α׿��� ������ ���� ���� �ְ� ��Ҹ� �������� �ִ�
				//������ ������ 0�� ��ȯ�ǰ� ,��Ҹ� ������ 1�� ��ȯ�ȴ�
				if(re==0) {
					//���̾�α׿��� ������ ������ ���� �´�
					File file= jfc.getSelectedFile();
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(lp.list);
					oos.close();
				}
				
				
				
				// ���� ȭ�鿡 �׷��� ��� ������ ���Ϸ� �����Ѵ�
				// ���� ȭ�鿡 �׷��� ��� ������ ������ LinePanel��ü�� lp�� list�� ��� �ִ�
				// list��ü�� ��°�� ���Ϸ� ����ϱ� ���� ObjectOutputStream�� �̿��Ѵ�

				// LinePanel��ü�� �ɹ������� list�� ���Ϸ� ����Ѵ�
				

			} catch (Exception e2) {
				System.out.println("���� �߻�: " + e2.getMessage());
			}
		} else if (cmd.equals("����")) {
			// ������ ������ �о� �鿩 LinePanel��ü�� lp�� list�� �����ϵ��� �Ѵ�
			// ȭ���� �ٽ� �׸��� �ϱ� ���Ͽ� LinePanel ��ü�� lp�� repaint�� ȣ���Ѵ�
			try {
				System.out.println("����ɴϴ�");
				int rx=jfc.showOpenDialog(this);
				if(rx==0) {
				File file= jfc.getSelectedFile();
				// ��ü������ ������ ������ �о���̱� ���Ͽ� ObjectInputStream��ü�� �����Ѵ�
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				lp.list= (ArrayList<GraphicInfo>)ois.readObject();
				lp.repaint();
				ois.close();
				}
				

			} catch (Exception e2) {
				System.out.println("���ܹ߻�: " + e2.getMessage());
			}
		} else if (cmd.equals("�� ����")) {
			System.out.println("������");
			//this.remove(lp);
			//this.add(lp = new LinePanel());
			//����ڰ� �׸� �׷����� ����ִ� ����Ʈ�� ��� ������
			lp.list.clear();
			//�׷����� �׸��� �ǳ��� �ٽ� �׸���
			lp.repaint();
			
		} else if (cmd.equals("��")) {
			lp.drawType=0;
		} else if (cmd.equals("�簢��")) {
			lp.drawType=1;
		} else if (cmd.equals("��")) {
			lp.drawType=2;
		}  else if (cmd.equals("����")) {
			lp.drawColor=Color.RED;
		} else if (cmd.equals("�Ķ�")) {
			lp.drawColor=Color.BLUE;
		} else if (cmd.equals("�ʷ�")) {
			lp.drawColor=Color.GREEN;
		}else if (cmd.equals("�ٸ� ����")) {
			Color color=jcc.showDialog(this, "�׸��� ����", Color.RED);
			System.out.println("������ ����:"+color);
			if(color!=null) {
				lp.drawColor= color;
			}
		}
	}

}
