package com.sist.exam07;

public class CountDownTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown c1= new CountDown();
		CountDownEvent e1= new CountDownEvent(2, "������ġ �и�!!");
		c1.start();
		e1.start();
	}

}
