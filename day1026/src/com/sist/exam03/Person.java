package com.sist.exam03;

public class Person implements Runnable {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("¾È³ç," + name + "==>" + i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {

			}
		}
	}

}
