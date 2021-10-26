package com.sist.Lab1;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("첫번째 정수: ");
			number1 = sc.nextInt();

			System.out.print("두번째 정수: ");
			number2 = sc.nextInt();

			result = number1 / number2;
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("나누는 수는 0이 아니여야 하며, 두 수는 정수여야 합니다");
		} finally {
			System.out.println("작업완료");
		}

	}

}
