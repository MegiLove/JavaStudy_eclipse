package com.sist.exam02;

public class DivTestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int a= Integer.parseInt(args[0]);
		int b= Integer.parseInt(args[1]);
		int div=a/b;
		System.out.println("���: "+div);
		}catch(ArithmeticException e){
			System.out.println("0���� ���� �� �����ϴ�");
		}catch(Exception e) {
			System.out.println("������ �� ���� �� ���� �����ϼ���");
		}finally {
			System.out.println("�۾��Ϸ�");
		}
	}

}
