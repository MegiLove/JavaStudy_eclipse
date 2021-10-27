package com.sist.product;

//생산자를 위한 클래스를 만든다
public class Producer extends Thread {
	// 제품을 위한 클래스를 맴버변수로 선언한다
	private Product product;

	// 생산자 객체 생성시에 제품 객체를 매개변수로 전달받아 맴버변수 제품을 초기화한다
	public Producer(Product product) {
		this.product = product;
	}

	// 생산자 클래스는 계속하여 새로운 제품을 생성하기 위한 메소드를 호출시키기 위하여
	// 쓰레드가 해야하는 일을 run메소드를 오버라이딩하여 써준다
	public void run() {
		for(int i=1; i<=10; i++) {
			product.makeNumber();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
