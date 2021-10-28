package com.sist.exam02;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		
		try {
			//객체단위로 입력을 위한 ObjectInputStream의 객체를 생성한다
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//파일로부터 객체를 읽어 들여 객체참조변수에 저장한다
			Student lee= (Student)ois.readObject();
			
			//객체의 정보를 출력해준다
			System.out.println("이름: "+lee.getName());
			System.out.println("국어: "+lee.getKor());
			System.out.println("영어: "+lee.getEng());
			System.out.println("수학: "+lee.getMath());
			
			ois.close();
			
			System.out.println("파일이 생성되었습니다");
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}

}
