package com.sist.exam02;

public class Person extends Thread {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 1; i <= 10; i++) {
			System.out.println("�ȳ� " + name + "==>" + i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {

			}
		}

	}
}
