package com.sist.exam02;

import java.util.Calendar;

public class PrintCalenderThisMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int date = today.get(Calendar.DATE);
        today.set(Calendar.DAY_OF_MONTH,1);
        int week = today.get(Calendar.DAY_OF_WEEK);
		int last = today.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(last);
		
		System.out.printf("%d년 %d월\n",year,month+1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
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
