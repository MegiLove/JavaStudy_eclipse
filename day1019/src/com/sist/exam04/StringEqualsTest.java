package com.sist.exam04;
import java.util.Scanner;
public class StringEqualsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		System.out.println("�̸����� �Է��ϼ���");
		String mail;
		mail= sc.next();
		
		if(mail.indexOf("@")==-1) {
			System.out.println("�ùٸ� �̸����� �ƴմϴ�");
		}else {
			System.out.println("��Ȯ�� �̸����Դϴ�");
		}
	}

}
