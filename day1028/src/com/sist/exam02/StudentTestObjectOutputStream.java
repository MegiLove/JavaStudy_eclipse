package com.sist.exam02;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student lee= new Student("�̰ǿ�", 100, 100, 100);
		
		try {//��ü�� ����. �� �� Ȯ���ڴ� �ؽ�Ʈ������ �ƴϴ�, .txt�� ���� �ʴ´�
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			
			//��ü�� ����Ѵ�
			oos.writeObject(lee);
			
			//���� ����� �������� ������ �ݾ��ش�
			oos.close();
			
			System.out.println("������ �����Ǿ����ϴ�");
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}

}
