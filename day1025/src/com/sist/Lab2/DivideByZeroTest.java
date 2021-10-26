package com.sist.Lab2;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("ù��° ����: ");
			number1 = sc.nextInt();

			System.out.print("�ι�° ����: ");
			number2 = sc.nextInt();
			if (number2 == 0)
			throw new DivideByZeroException("0���� ���� �� �����ϴ�");
			
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
