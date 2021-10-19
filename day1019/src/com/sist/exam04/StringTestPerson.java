package com.sist.exam04;

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class StringTestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cnt=0;
		Person []arr= {
				new Person("tiger",20),
				new Person("Lion",21),
				new Person("Tiger",23),
				new Person(" Tiger",23),
				new Person("kim",25)
		};
		
		for(Person p:arr) {		
			if(p.getName().trim().equalsIgnoreCase("tiger")) {
				cnt=cnt+1;
			}
		}
		
		System.out.println(cnt);
	}

}
