package com.sist.HW1;

import java.util.Calendar;
import java.util.Scanner;
public class PrintCalendarThisMonth2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc= new Scanner(System.in);
		int year;
		int month;
		Calendar today = Calendar.getInstance();
		System.out.println("�⵵�� �Է��ϼ���");
		year= sc.nextInt();
		System.out.println("���� �Է��ϼ���");
		month= sc.nextInt();
		today.set(Calendar.YEAR,year);
		today.set(Calendar.MONTH,month-1);
        today.set(Calendar.DAY_OF_MONTH,1);
        int week = today.get(Calendar.DAY_OF_WEEK);
		int last = today.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(last);
		
		System.out.printf("%d�� %d��\n",year,month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i=1; i<week; i++) {
			System.out.print(" \t");
		}
		for(int i=1; i<=last; i++) {
			
			System.out.print(i+"\t");
			if((week+i-1)%7==0) {
				System.out.println();
			}
		}

	}

}

