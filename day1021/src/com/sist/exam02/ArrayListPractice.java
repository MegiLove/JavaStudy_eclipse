package com.sist.exam02;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> score= new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
		for(int i=0; i<5; i++) {
		System.out.println("점수를 입력하세요");
		score.add(sc.nextInt());
		}
		System.out.println(score);
		int sum=0;
		for(int a:score) {
			sum+= a;
		}
		System.out.println(sum);
		
		int average= sum/5;
		System.out.println(average);

	}

}
