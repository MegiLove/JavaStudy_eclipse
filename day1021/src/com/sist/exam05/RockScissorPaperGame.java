package com.sist.exam05;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockScissorPaperGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//컴퓨터와 사용자가 가위바위보 게임을 하는 프로그램
		Scanner sc= new Scanner(System.in);
		HashMap<Integer, String>map= new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		Random r= new Random();
		int com= r.nextInt(3);
		
		System.out.println("0.가위 1.바위 2.보");
		System.out.println("선택하세요==> ");
		int user= sc.nextInt();
		System.out.println("컴퓨터는 "+map.get(com)+"를 내었습니다");
		if(com==0) {
			if(user==0) {
				System.out.println("비겼습니다");
			}
			else if(user==1) {
				System.out.println("이겼습니다");
			}
			else if(user==2) {
				System.out.println("졌습니다");
			}
		}
		if(com==1) {
			if(user==0) {
				System.out.println("졌습니다");
			}
			else if(user==1) {
				System.out.println("비겼습니다");
			}
			else if(user==2) {
				System.out.println("이겼습니다");
			}
		}
		if(com==2) {
			if(user==0) {
				System.out.println("이겼습니다");
			}
			else if(user==1) {
				System.out.println("졌습니다");
			}
			else if(user==2) {
				System.out.println("비겼습니다");
			}
		}
	}

}
