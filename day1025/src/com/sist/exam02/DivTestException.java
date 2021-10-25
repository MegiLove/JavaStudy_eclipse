package com.sist.exam02;

public class DivTestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int div=a/b;
		System.out.println("결과: "+div);
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다");
		}catch(Exception e) {
			System.out.println("나누기 할 정수 두 수를 전달하세요");
		}finally {
			System.out.println("작업완료");
		}
	}

}
