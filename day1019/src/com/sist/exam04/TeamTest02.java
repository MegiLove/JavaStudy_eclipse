package com.sist.exam04;
import java.util.Scanner;
public class TeamTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String sen;
		int cnt=0;
		System.out.println("영문 문장을 입력하세요");
		sen= sc.next();
		for(int i=0; i<sen.length();i++) {
			if(sen.substring(i,i+1).equals("o")) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
