package com.sist.exam04;
import java.util.Scanner;
public class PasswordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String password,password1;
	    do{
		System.out.println("��ȣ�� �Է��ϼ���");
		password= sc.next();
		System.out.println("��ȣ�� Ȯ�����ּ���");
		password1= sc.next();
	    }while(password.length()<8 || password.length()>12);
		if(password.equals(password1)) {
			System.out.println("������ ��ȣ�Դϴ�");
		}else {
			System.out.println("������ ��ȣ�� �ƴմϴ�");
		}
		
	}

}
