package com.sist.exam02;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		
		try {
			//��ü������ �Է��� ���� ObjectInputStream�� ��ü�� �����Ѵ�
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//���Ϸκ��� ��ü�� �о� �鿩 ��ü���������� �����Ѵ�
			Student lee= (Student)ois.readObject();
			
			//��ü�� ������ ������ش�
			System.out.println("�̸�: "+lee.getName());
			System.out.println("����: "+lee.getKor());
			System.out.println("����: "+lee.getEng());
			System.out.println("����: "+lee.getMath());
			
			ois.close();
			
			System.out.println("������ �����Ǿ����ϴ�");
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}

}
