package com.sist.exam02;
import java.util.Calendar;
public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GregorianCalendar today= GregorianCalendar();
		int year=today.get(Calendar.YEAR);
		int month= today.get(Calendar.MONTH);
		int date= today.get(Calendar.DAY_OF_MONTH);
		
		System.out.printf("������ %d�� %d�� %d���Դϴ�",year,month+1,date);
		
	}

}
