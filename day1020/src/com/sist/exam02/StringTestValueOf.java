package com.sist.exam02;

public class StringTestValueOf {

	public static void pro(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//���� ���� ��� �޼ҵ�� String�� �Ű������� ���� �޼ҵ尡 �ִٰ� ����
		int data= 2021;
		//������ ������ data�� ���� pro�� ȣ���ؾ� �ϴ� ��Ȳ�̶�� ��������
		//pro�� String�� �Ű������� ���� ������ �ٷ� ȣ���� ���� ����
		//data�� String���� ��ȯ�ؾ� �Ѵ�
		//pro(data);
		pro(String.valueOf(data));
		pro(data+"");
	}

}
