package com.sist.exam03;

import com.sist.exam02.Person;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p= new Person("홍길동");
		Person p2= new Person("유관순");
		/*Thread t= new Thread(p);
		Thread t2= new Thread(p2);
		t.start();
		t2.start();
		*/
		new Thread(p).start();
		new Thread(p2).start();
	}

}
