package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p= new Person("홍길동");
		Person p2= new Person("유관순");
		Person p3= new Person("이순신");
		p3.setPriority(10);
		//최고우선순위를 설정하였다고 반드시 일이 가장 먼저 끝나는 건 아니다
		//가급적 빨리 끝내달라고 응급성을 설정하는 것이다
		
		p.start();
		p2.start();
		p3.start();
		
		//kim,hong,lee 쓰레드가 모두 끝날 때까지 대기시킨다
		try {
			p.join();
			p2.join();
			p3.join();
		}catch(Exception e) {
			
		}
		
		
		System.out.println(p.getPriority());
		System.out.println(p2.getPriority());
		System.out.println(p3.getPriority());
	}

}
