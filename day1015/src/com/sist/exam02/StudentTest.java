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
		System.out.println("학생 이름을 입력하시오");
		name= sc.next();
		System.out.println("학번을 입력하시오");
		number= sc.next();
		System.out.println("전공을 입력하시오");
		major= sc.next();
		System.out.println("학년을 입력하시오");
		grade= sc.nextInt();
		System.out.println("이수 학점을 입력하시오");
		credits= sc.nextDouble();
		do{System.out.println("학생 유형을 선택하시오 1. 학부생 2.대학원생");
		type2= sc.nextInt();}while(type2!=1 && type2!=2);
		
		switch(type2) 
		{
		     case 1: System.out.println("소속 동아리를 입력하세요");
		             String club;
		             club= sc.next();
		             s1= new UnderGraduate(name, number, major, grade, credits, club);
		             break;
		             default:
		            	 String type;
		            	 double rate;
		            	 System.out.println("조교 유형을 입력하세요");
		            	 type= sc.next();
		            	 System.out.println("장학금 비율을 입력하세요");
		            	 rate= sc.nextDouble();
		            	 s1= new Graduate(name, number, major, grade, credits, type, rate);
		            	 
		
		}
		
		System.out.println(s1);
		/*UnderGraduate underGraduate= new UnderGraduate("홍길동", "20211234", "컴퓨터공학", 1, 24.0, "방송댄스");
		Graduate graduate= new Graduate("이순신", "20211111", "인공지능", 2, 15, "연구 조교", 1);
		System.out.println(underGraduate);
		System.out.println(graduate);*/
	}

}
