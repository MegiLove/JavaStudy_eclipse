package com.sist.exam01;

public class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	public void sayHello() {
		for(int i=1; i<=10; i++) {
			System.out.println("�ȳ� "+name+"==>"+i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				
			}
		}
	}
}
