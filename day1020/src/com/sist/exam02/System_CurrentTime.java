package com.sist.exam02;

public class System_CurrentTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long data= System.currentTimeMillis();
		
		System.out.println(data);
		
		long data2= 1634715446799l;
		Date date= new Date(data2);

	}

}
