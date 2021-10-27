package com.sist.product;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//제품 객체를 생성한다
		Product p1= new Product();
		//생산자 쓰레드 객체를 생성한다
		Producer pro= new Producer(p1);
		//소비자 쓰레드 객체를 생성한다
		Consumer con= new Consumer(p1);
		//생산자와 소비자를 가동한다
		pro.start();
		con.start();
	}

}
