package com.sist.product;

import java.util.Random;

//생산자와 소비자가 공유할 제품 클래스를 만든다
public class Product {
	//생산되는 제품을 임의의 정수라고 하자
	int number;
	
	//제품을 새로 생산하였는지 소비하였는지 판별하기 위한 변수
	//생산자가 새로운 제품을 생산하면 true를 설정
	//소비자가 제품을 소비하면 false를 설정
	public boolean isNew= false;
	
	//생산자가 새로운 제품을 생성하는 메소드 정의
	//생산자가 제품을 생산하고 있는 동안에는 소비자가 접근 못하게 임계영역으로 설정
	public synchronized void makeNumber() {
		
		//새로운제품(정수)를 생산하기 전에 소비가 일어날 때까지 대기상태로 있도록 한다
		//소비자가 제품을 소비하고 isNew에 false를 설정하고 notify로 깨워주면 반복문을 탈출한다
		while(isNew==true) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//새로운 제품(정수)는 난수로 만들어보자
		Random r= new Random();
		number= r.nextInt(100); //제품 생산
		System.out.println("생산자가 새로운 제품 생성함==>"+number);
		isNew= true;			
		notify();				//대기중인 쓰레드를 깨워준다
	}
	
	//소비자가 사용할 제품을 소비하기 위한 메소드
	public synchronized int getNumber() {
		//생산자가 새로운 제품을 생산할 때까지 대기상태로 있도록 한다
		//생산자가 새로운 제품을 생산하고 isNew에 true를 담고 notify()로 꺠워주면 반복문을 탈출
		while(isNew==false) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("소비자가 제품 소비함==>"+number);
		isNew= false;
		notify();
		return number;
	}
}
