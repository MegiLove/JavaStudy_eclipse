package com.sist.prog4;

public class MyDateTest extends MyDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {MyDate d1= new MyDate(null);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
