package com.sist.product;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ǰ ��ü�� �����Ѵ�
		Product p1= new Product();
		//������ ������ ��ü�� �����Ѵ�
		Producer pro= new Producer(p1);
		//�Һ��� ������ ��ü�� �����Ѵ�
		Consumer con= new Consumer(p1);
		//�����ڿ� �Һ��ڸ� �����Ѵ�
		pro.start();
		con.start();
	}

}
