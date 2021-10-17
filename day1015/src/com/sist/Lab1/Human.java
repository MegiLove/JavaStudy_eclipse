package com.sist.Lab1;

public abstract class Human {
private String name;
private int age;

public Human(String name, int age) {
	this.name= name;
	this.age= age;
	System.out.println("Human 생성자 호출됨");
}

public Human() {
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

@Override
public String toString() {
	return "Human [name=" + name + ", age=" + age + "]";
	}

public abstract String getProfession();
	


}
