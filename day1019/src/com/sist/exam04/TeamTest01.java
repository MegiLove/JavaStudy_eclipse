package com.sist.exam04;
import java.util.Scanner;
public class TeamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String mail;
		System.out.println("�̸����� �Է��ϼ���");
		mail= sc.next();
		String mail1=mail.substring(0,mail.lastIndexOf("@"));
		
		System.out.println(mail1);
	}

}
