package com.sist.exam01;

public class SetPriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p= new Person("ȫ�浿");
		Person p2= new Person("������");
		Person p3= new Person("�̼���");
		p3.setPriority(10);
		//�ְ�켱������ �����Ͽ��ٰ� �ݵ�� ���� ���� ���� ������ �� �ƴϴ�
		//������ ���� �����޶�� ���޼��� �����ϴ� ���̴�
		
		p.start();
		p2.start();
		p3.start();
		
		//kim,hong,lee �����尡 ��� ���� ������ ����Ų��
		try {
			p.join();
			p2.join();
			p3.join();
		}catch(Exception e) {
			
		}
		
		
		System.out.println(p.getPriority());
		System.out.println(p2.getPriority());
		System.out.println(p3.getPriority());
	}

}
