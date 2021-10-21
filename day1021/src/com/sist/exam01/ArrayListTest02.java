package com.sist.exam01;

import java.util.ArrayList;

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
	
	public void sayHello() {
		System.out.println(name+"´Ô, ¾È³çÇÏ¼¼¿ä!");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list= new ArrayList();
		list.add(new Person("È«±æµ¿",20));
		list.add(new Person("ÀÌ¼ø½Å",40));
		list.add(new Person("À¯°ü¼ø",30));
		list.add("¾È³ç ÀÚ¹Ù");
		list.add(2021);
		
		for(int i=0; i<list.size() ;i++) {
			Object obj= list.get(i);
			System.out.println(obj);
			if(obj instanceof Person) {
				((Person)obj).sayHello();
			}
			//Person p= (Person)list.get(i);
			//p.sayHello();
		}
		
	}

}
