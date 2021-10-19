package com.sist.exam04;
import java.util.Scanner;
public class StringEqualsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		System.out.println("이메일을 입력하세요");
		String mail;
		mail= sc.next();
		
		if(mail.indexOf("@")==-1) {
			System.out.println("올바른 이메일이 아닙니다");
		}else {
			System.out.println("정확한 이메일입니다");
		}
	}

}
