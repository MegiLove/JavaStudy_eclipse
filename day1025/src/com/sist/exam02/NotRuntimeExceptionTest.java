package com.sist.exam02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotRuntimeExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*try {
		FileWriter fw= new FileWriter("c:/work_day1025/hello.txt");
		fw.write("�ȳ��ϼ���");
		fw.close();
		}
		catch(IOException e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}*/
		
		try {
			FileReader fr= new FileReader("c:/work_day1025/hello.txt");
			int ch;
			while((ch=fr.read())!=-1) {
				System.out.print((char)ch);
			}
			fr.close();
		}catch(Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}

}
