package com.sist.exam04;

import java.util.Scanner;

public class TeamTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String id;
		String password;
		System.out.println("id�� �Է��ϼ���");
		id = sc.next();
		System.out.println("password�� �Է��ϼ���");
		password = sc.next();

		if (id.equals("tiger") && password.equals("tiger1234")) {
			System.out.println("�α��ο� �����Ͽ����ϴ�");
		} else {
			System.out.println("�α��ο� �����Ͽ����ϴ�");

		}
	}

}
