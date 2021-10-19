package com.sist.exam04;
import java.util.Scanner;
public class PasswordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String password,password1;
	    do{
		System.out.println("암호를 입력하세요");
		password= sc.next();
		System.out.println("암호를 확인해주세요");
		password1= sc.next();
	    }while(password.length()<8 || password.length()>12);
		if(password.equals(password1)) {
			System.out.println("동일한 암호입니다");
		}else {
			System.out.println("동일한 암호가 아닙니다");
		}
		
	}

}
