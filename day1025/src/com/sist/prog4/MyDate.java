package com.sist.prog4;

import java.util.StringTokenizer;

public class MyDate {
	
	public MyDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyDate(String str) throws IllegalArgumentException{
		if(str==null)throw new IllegalArgumentException("전달된 문자열이 없습니다");
		StringTokenizer st= new StringTokenizer(str,"/");
		int year,month,date;
		
		year= Integer.parseInt(st.nextToken());
		month= Integer.parseInt(st.nextToken());
		date= Integer.parseInt(st.nextToken());
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		
		
	}

	
}


