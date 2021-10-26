package com.sist.exam07;



public class CountDownEvent extends Thread{
	int time;
	String message;
	
	public CountDownEvent(int time, String message) {
		super();
		this.time = time;
		this.message = message;
		for (int i = time; i > 0; i--) {						
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

}
