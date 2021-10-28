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

//MyFrameŬ���� �ڽ��� JMenuItem�� ������ ��
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(600, 400);
		setVisible(true);
		setTitle("�� �׸���");

		// �޴��ٸ� �����Ѵ�
		JMenuBar jmb = new JMenuBar();

		// �ָ޴� ������ �����Ѵ�
		JMenu mn_file = new JMenu("����");

		// �θ޴����� �����Ѵ�
		JMenuItem file_new = new JMenuItem("�� ����");

		JMenuItem file_open = new JMenuItem("����");

		JMenuItem file_save = new JMenuItem("����");

		// �θ޴����� �� �޴��� ��´�
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);

		// �ָ޴��� �޴��ٿ� ��´�
		jmb.add(mn_file);

		// �޴��ٸ� �����ӿ� �����Ѵ�
		this.setJMenuBar(jmb);

		// ������ �޴� �����ۿ� ���Ͽ�
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
	}

	// �Ű����� ActionEvent�� getActionCommand()�� �̿��Ѵ�
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "�� ������");
		if(cmd.equals("����")) {
			try {
				//���� ȭ�鿡 �׷��� ��� ������ ���Ϸ� �����Ѵ�
				//���� ȭ�鿡 �׷��� ��� ������ ������ LinePanel��ü�� lp�� list�� ��� �ִ�
				//list��ü�� ��°�� ���Ϸ� ����ϱ� ���� ObjectOutputStream�� �̿��Ѵ�
				ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				//LinePanel��ü�� �ɹ������� list�� ���Ϸ� ����Ѵ�
				oos.writeObject(lp.list);
				
				oos.close();
				
			} catch (Exception e2) {
				System.out.println("���� �߻�: "+e2.getMessage());
			}
		}else if(cmd.equals("����")) {
			//������ ������ �о� �鿩 LinePanel��ü�� lp�� list�� �����ϵ��� �Ѵ�
			//ȭ���� �ٽ� �׸��� �ϱ� ���Ͽ� LinePanel ��ü�� lp�� repaint�� ȣ���Ѵ�
			try {
				//��ü������ ������ ������ �о���̱� ���Ͽ� ObjectInputStream��ü�� �����Ѵ�
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//���Ϸ� �����͸� �о�鿩 LinePanel��ü�� lp�� list�� ��´�
				lp.list= (ArrayList<GraphicInfo>)ois.readObject();
				
				//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���� repaint�� ȣ���Ѵ�
				lp.repaint();
				
				//������ �ݾ��ش�
				ois.close();
								
			} catch (Exception e2) {
				System.out.println("���ܹ߻�: "+e2.getMessage());
			}
			}else if(cmd.equals("������")) {
		}
	}

}
