package com.sist.exam05;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockScissorPaperGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ǻ�Ϳ� ����ڰ� ���������� ������ �ϴ� ���α׷�
		Scanner sc= new Scanner(System.in);
		HashMap<Integer, String>map= new HashMap<Integer, String>();
		map.put(0, "����");
		map.put(1, "����");
		map.put(2, "��");
		
		Random r= new Random();
		int com= r.nextInt(3);
		
		System.out.println("0.���� 1.���� 2.��");
		System.out.println("�����ϼ���==> ");
		int user= sc.nextInt();
		System.out.println("��ǻ�ʹ� "+map.get(com)+"�� �������ϴ�");
		if(com==0) {
			if(user==0) {
				System.out.println("�����ϴ�");
			}
			else if(user==1) {
				System.out.println("�̰���ϴ�");
			}
			else if(user==2) {
				System.out.println("�����ϴ�");
			}
		}
		if(com==1) {
			if(user==0) {
				System.out.println("�����ϴ�");
			}
			else if(user==1) {
				System.out.println("�����ϴ�");
			}
			else if(user==2) {
				System.out.println("�̰���ϴ�");
			}
		}
		if(com==2) {
			if(user==0) {
				System.out.println("�̰���ϴ�");
			}
			else if(user==1) {
				System.out.println("�����ϴ�");
			}
			else if(user==2) {
				System.out.println("�����ϴ�");
			}
		}
	}

}
