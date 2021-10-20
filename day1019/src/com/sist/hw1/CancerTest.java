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
		System.out.println("이름을 입력하세요");
		name = sc.next();
		System.out.println("주민번호를 입력하세요");
		birth = sc.next();
		int thisYear = today.getYear();
		int age = thisYear - Integer.parseInt(birth.substring(0, 2));				
		if (age >= 40 && age < 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("2")) {
			System.out.println(name + "님은 무료암검진 대상자입니다. 암검진 항목은 위암, 간암, 유방암, 자궁암입니다");
		}
		if (age >= 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("2")) {
			System.out.println(name + "님은 무료암검진 대상자입니다.암검진 항목은 위암, 간암, 대장암,유방암,자궁암입니다");
		}
		if (age >= 40 && age < 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("1")) {
			System.out.println(name + "님은 무료암검진 대상자입니다. 암검진 항목은 위암, 간암입니다");
		}
		if (age >= 50 && thisYear % 2 == (age + 1) % 2 && birth.substring(7, 8).equals("1")) {
			System.out.println(name + "님은 무료암검진 대상자입니다.암검진 항목은 위암, 간암, 대장암입니다");
		}

		if (age < 40 || thisYear % 2 != (age + 1) % 2) {
			System.out.println(name+"님은 무료암검진 대상자가 아닙니다");
		}
	}

}
