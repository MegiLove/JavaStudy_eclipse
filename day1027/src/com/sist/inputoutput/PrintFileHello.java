package com.sist.inputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//문자단위의 출력을 위한 Writer의 후손중에
		//파일로 출력을 위한 FileWriter를 생성해보자
		
		try {
			FileWriter fw= new FileWriter("c:/myData/hello.txt");
			fw.write("나의 이름은 유하림이고\n");
			fw.write("나이는 25살이다");
			fw.close();
			System.out.println("파일을 생성하였습니다");
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		

	}

}
