package com.sist.exam06;



public class CountDownEvent extends Thread{
	int time;
	String message;
	
	public CountDownEvent(int time, String message) {
		super();
		this.time = time;
		this.message = message;
		for (int i = time; i > 0; i--) {
			
			System.out.println(i + "�� ���Դϴ�");
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownEvent e1= new CountDownEvent(15, "�ȳ�");
		e1.start();
	}

}
