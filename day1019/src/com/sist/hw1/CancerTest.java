package com.sist.hw1;

import java.util.Scanner;
import java.util.Date;

public class CancerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		String name;
		String birth;
		System.out.println("�̸��� �Է��ϼ���");
		name = sc.next();
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		birth = sc.next();
		int thisYear = today.getYear();
		int age = thisYear - Integer.parseInt(birth.substring(0, 2));				
		if (age >= 40 && age < 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("2")) {
			System.out.println(name + "���� ����ϰ��� ������Դϴ�. �ϰ��� �׸��� ����, ����, �����, �ڱþ��Դϴ�");
		}
		if (age >= 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("2")) {
			System.out.println(name + "���� ����ϰ��� ������Դϴ�.�ϰ��� �׸��� ����, ����, �����,�����,�ڱþ��Դϴ�");
		}
		if (age >= 40 && age < 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("1")) {
			System.out.println(name + "���� ����ϰ��� ������Դϴ�. �ϰ��� �׸��� ����, �����Դϴ�");
		}
		if (age >= 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("1")) {
			System.out.println(name + "���� ����ϰ��� ������Դϴ�.�ϰ��� �׸��� ����, ����, ������Դϴ�");
		}

		if (age < 40 || thisYear % 2 != (age + 1) % 2) {
			System.out.println(name+"���� ����ϰ��� ����ڰ� �ƴմϴ�");
		}
	}

}
