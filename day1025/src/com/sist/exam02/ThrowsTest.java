package com.sist.exam02;

public class ThrowsTest {
	
	public static void div(int a,int b) throws ArithmeticException {
		int r=a/b;
		System.out.println("������ ���: "+r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		div(4,0);
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�");
		}
	}

}