package com.sist.Lab1;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Human h1= new Human("����",18);
		Human h2= new Human("����",21);
		Human h3= new Human("���",50);
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);*/
		
		Student s1= new Student("����", 21, "��ǻ��");
		Student s2= new Student("����", 22, "�濵");
		Student s3= new Student("����", 24, "����");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1.getProfession());
	}

}
