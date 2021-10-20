package com.sist.exam02;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date today= new Date();
		int year= today.getYear()+1900;
		int month= today.getMonth()+1;
		int date= today.getDate();
		int hours= today.getHours();
		int minutes= today.getMinutes();
		int seconds= today.getSeconds();
		int day= today.getDay();
		
		String yoil[] = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		
		
		System.out.println(day);
		System.out.printf("현재는 %d년 %d월 %d일(%s) %d시 %d분 %d초입니다\n",year,month,date,yoil[day],hours,minutes,seconds);
		
		System.out.println("---------------------------------------------");
		
		int birthYear=1995;
		int birthMonth=7;
		int birthDate=29;
		
		Date leeDate= new Date(birthYear-1900,birthMonth-1,birthDate);
		int day2= leeDate.getDay();
		System.out.printf("이건우가 태어난 날은 %s입니다",yoil[day2]);
		
		
	}

}
