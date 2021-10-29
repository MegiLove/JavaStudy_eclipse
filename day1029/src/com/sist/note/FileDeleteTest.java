package com.sist.note;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		
		File file= new File("c:/myData/lee.txt");
		
		file.delete();
		System.out.println("삭제하였습니다");
	}

}
