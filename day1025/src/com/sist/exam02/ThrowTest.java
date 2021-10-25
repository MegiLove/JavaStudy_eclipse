package com.sist.exam02;

public class ThrowTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int a=4/0;
		예외 상황이 되면 자동으로 예외객체가 생성이 된다
		그러나 다음과 같이 강제로 예외를 발생시킬 수 있다
		*/
		throw new ArithmeticException();
	}

}
