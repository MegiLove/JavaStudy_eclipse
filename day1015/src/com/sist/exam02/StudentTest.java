package com.sist.exam02;
import java.util.Scanner;
public class StudentTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int type2;
        String name;
        String number;
        String major;
        int grade;
        double credits;
        Student s1= new Student();
		Scanner sc= new Scanner(System.in);
		System.out.println("�л� �̸��� �Է��Ͻÿ�");
		name= sc.next();
		System.out.println("�й��� �Է��Ͻÿ�");
		number= sc.next();
		System.out.println("������ �Է��Ͻÿ�");
		major= sc.next();
		System.out.println("�г��� �Է��Ͻÿ�");
		grade= sc.nextInt();
		System.out.println("�̼� ������ �Է��Ͻÿ�");
		credits= sc.nextDouble();
		do{System.out.println("�л� ������ �����Ͻÿ� 1. �кλ� 2.���п���");
		type2= sc.nextInt();}while(type2!=1 && type2!=2);
		
		switch(type2) 
		{
		     case 1: System.out.println("�Ҽ� ���Ƹ��� �Է��ϼ���");
		             String club;
		             club= sc.next();
		             s1= new UnderGraduate(name, number, major, grade, credits, club);
		             break;
		             default:
		            	 String type;
		            	 double rate;
		            	 System.out.println("���� ������ �Է��ϼ���");
		            	 type= sc.next();
		            	 System.out.println("���б� ������ �Է��ϼ���");
		            	 rate= sc.nextDouble();
		            	 s1= new Graduate(name, number, major, grade, credits, type, rate);
		            	 
		
		}
		
		System.out.println(s1);
		/*UnderGraduate underGraduate= new UnderGraduate("ȫ�浿", "20211234", "��ǻ�Ͱ���", 1, 24.0, "��۴�");
		Graduate graduate= new Graduate("�̼���", "20211111", "�ΰ�����", 2, 15, "���� ����", 1);
		System.out.println(underGraduate);
		System.out.println(graduate);*/
	}

}
