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
		
		String yoil[] = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
		
		
		System.out.println(day);
		System.out.printf("����� %d�� %d�� %d��(%s) %d�� %d�� %d���Դϴ�\n",year,month,date,yoil[day],hours,minutes,seconds);
		
		System.out.println("---------------------------------------------");
		
		int birthYear=1995;
		int birthMonth=7;
		int birthDate=29;
		
		Date leeDate= new Date(birthYear-1900,birthMonth-1,birthDate);
		int day2= leeDate.getDay();
		System.out.printf("�̰ǿ찡 �¾ ���� %s�Դϴ�",yoil[day2]);
		
		
	}

}
