package com.sist.inputoutput;

import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) {
		try {
			FileReader fr= new FileReader("c:/myData/hello.txt");
			int ch;
			while((ch=fr.read())!=-1) {
			System.out.print((char)ch);
			}
			fr.close();			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		
	}
}
