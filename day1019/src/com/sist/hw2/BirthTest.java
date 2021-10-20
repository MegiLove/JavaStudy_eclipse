package com.sist.hw2;
import java.util.Scanner;
public class BirthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String birth;
		System.out.println("주민번호를 입력하세요");
		birth = sc.next();
		if(birth.length()==14) {
			if(Integer.parseInt(birth.substring(2,4))>=1 &&Integer.parseInt(birth.substring(2,4))<=12) {
				if(birth.substring(7,8).equals("1") || birth.substring(7,8).equals("2")) {
					if(birth.substring(6,7).equals("-")) {
						System.out.println("비밀번호가 저장되었습니다");
					}
					else {
						System.out.println("잘못된 주민번호입니다");
					}
				}else {
					System.out.println("잘못된 주민번호입니다");
				}
			}else {
				System.out.println("잘못된 주민번호입니다");
			}
		}else {
			System.out.println("잘못된 주민번호입니다");
		}
	}

}
