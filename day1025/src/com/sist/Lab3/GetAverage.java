package com.sist.Lab3;

import java.util.Scanner;

public class GetAverage {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			double arr[] = new double[-10];
			double sum = 0;
			double avg = 0;
			for (int i = 0; i < arr.length; i++) {
				System.out.println("���� �Է����ּ���");
				arr[i] = sc.nextDouble();
				sum += arr[i];
				avg = sum / arr.length;
			}
			System.out.println(avg);
		} catch (ArithmeticException e) {
			System.out.println("�迭�� �����Ͱ� �ϳ��� �����ϴ�");

		} catch (NegativeArraySizeException e) {
			System.out.println("�迭�� ũ��� ������ �� �� ����");

		} catch (NullPointerException e) {
			System.out.println("�迭�� �������� �ʾҽ��ϴ�");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� �ε��� ������ �Ѿ����ϴ�");
		}

	}

}

//Arithmetic: �迭�� ���̰� 0�� ��
//Negative: �迭 ũ�Ⱑ �����϶�
