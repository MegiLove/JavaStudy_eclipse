package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//���ڴ����� ����� ���� Writer�� �ļ��߿�
		//���Ϸ� ����� ���� FileWriter�� �����غ���
		
		try {
			FileWriter fw= new FileWriter("c:/myData/hello.txt");
			fw.write("���� �̸��� ���ϸ��̰�\n");
			fw.write("���̴� 25���̴�");
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�");
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
		

	}

}
