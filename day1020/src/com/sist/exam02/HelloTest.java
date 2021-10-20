package com.sist.exam02;
import java.util.Scanner;
public class HelloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		String a;
		System.out.println("hello를 입력하세요");
		a= sc.next();
		
		a=a.replace("hello","안녕");
		System.out.println(a);
		
	}

}
