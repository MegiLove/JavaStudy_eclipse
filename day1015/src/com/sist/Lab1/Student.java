package com.sist.Lab1;

public class Student extends Human {
String major;

public Student(String name, int age, String major) {
	super(name, age);
	this.major = major;
	System.out.println("Student 생성자 호출됨");
}

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public String getMajor() {
	return major;
}

public void setMajor(String major) {
	this.major = major;
}

@Override
public String toString() {
	return "Student [major=" + major + ", name=" + this.getName() + ", age=" + this.getAge() + "]";
}

public String getProfession() {
	return major;
}

}
