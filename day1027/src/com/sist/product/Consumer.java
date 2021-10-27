package com.sist.product;

public class Consumer extends Thread {

	// 제품을 위한 클래스를 맴버변수로 선언한다
	// 이 제품 객체는 생산자가 갖고있는 제품과 동일한 객체이다==> 서로 제품을 공유자원으로 하고 있다
	private Product product;

	public Consumer(Product product) {
		this.product = product;
	}

	public void run() {
		//반복실행하여 10개의 제품을 사용하도록 한다
		for(int i=1; i<=10; i++) {
			product.getNumber();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
