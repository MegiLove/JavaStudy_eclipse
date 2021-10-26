package com.sist.Lab2;

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
			if (number2 == 0)
			throw new DivideByZeroException("0으로 나눌 수 없습니다");
			
			result = quotient(number1, number2);
			System.out.println(result);
		} catch (DivideByZeroException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int quotient(int numerator, int denominator) throws DivideByZeroException {
		
		return numerator / denominator;
	}
}
