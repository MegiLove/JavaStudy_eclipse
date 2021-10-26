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
				System.out.println("값을 입력해주세요");
				arr[i] = sc.nextDouble();
				sum += arr[i];
				avg = sum / arr.length;
			}
			System.out.println(avg);
		} catch (ArithmeticException e) {
			System.out.println("배열의 데이터가 하나도 없습니다");

		} catch (NegativeArraySizeException e) {
			System.out.println("배열의 크기는 음수가 될 수 없다");

		} catch (NullPointerException e) {
			System.out.println("배열이 생성되지 않았습니다");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스 범위를 넘었습니다");
		}

	}

}

//Arithmetic: 배열의 길이가 0일 때
//Negative: 배열 크기가 음수일때
