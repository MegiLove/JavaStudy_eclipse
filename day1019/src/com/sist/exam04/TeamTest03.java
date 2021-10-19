package com.sist.exam04;

import java.util.Scanner;

public class TeamTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String id;
		String password;
		System.out.println("id를 입력하세요");
		id = sc.next();
		System.out.println("password를 입력하세요");
		password = sc.next();

		if (id.equals("tiger") && password.equals("tiger1234")) {
			System.out.println("로그인에 성공하였습니다");
		} else {
			System.out.println("로그인에 실패하였습니다");

		}
	}

}
