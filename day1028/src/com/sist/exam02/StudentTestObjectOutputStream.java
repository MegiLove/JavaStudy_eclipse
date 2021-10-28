package com.sist.exam02;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student lee= new Student("이건우", 100, 100, 100);
		
		try {//객체를 생성. 이 때 확장자는 텍스트파일이 아니니, .txt로 하지 않는다
			ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			
			//객체를 출력한다
			oos.writeObject(lee);
			
			//파일 사용이 끝났으니 파일을 닫아준다
			oos.close();
			
			System.out.println("파일이 생성되었습니다");
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}

}
