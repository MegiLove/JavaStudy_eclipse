package com.sist.exam05;

public class CountDownTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown c1= new CountDown();
		Thread t= new Thread(c1);
		c1.run();
	}

}
