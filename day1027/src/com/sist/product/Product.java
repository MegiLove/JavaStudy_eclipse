package com.sist.product;

import java.util.Random;

//�����ڿ� �Һ��ڰ� ������ ��ǰ Ŭ������ �����
public class Product {
	//����Ǵ� ��ǰ�� ������ ������� ����
	int number;
	
	//��ǰ�� ���� �����Ͽ����� �Һ��Ͽ����� �Ǻ��ϱ� ���� ����
	//�����ڰ� ���ο� ��ǰ�� �����ϸ� true�� ����
	//�Һ��ڰ� ��ǰ�� �Һ��ϸ� false�� ����
	public boolean isNew= false;
	
	//�����ڰ� ���ο� ��ǰ�� �����ϴ� �޼ҵ� ����
	//�����ڰ� ��ǰ�� �����ϰ� �ִ� ���ȿ��� �Һ��ڰ� ���� ���ϰ� �Ӱ迵������ ����
	public synchronized void makeNumber() {
		
		//���ο���ǰ(����)�� �����ϱ� ���� �Һ� �Ͼ ������ �����·� �ֵ��� �Ѵ�
		//�Һ��ڰ� ��ǰ�� �Һ��ϰ� isNew�� false�� �����ϰ� notify�� �����ָ� �ݺ����� Ż���Ѵ�
		while(isNew==true) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//���ο� ��ǰ(����)�� ������ ������
		Random r= new Random();
		number= r.nextInt(100); //��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ������==>"+number);
		isNew= true;			
		notify();				//������� �����带 �����ش�
	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ�
	public synchronized int getNumber() {
		//�����ڰ� ���ο� ��ǰ�� ������ ������ �����·� �ֵ��� �Ѵ�
		//�����ڰ� ���ο� ��ǰ�� �����ϰ� isNew�� true�� ��� notify()�� �ƿ��ָ� �ݺ����� Ż��
		while(isNew==false) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("�Һ��ڰ� ��ǰ �Һ���==>"+number);
		isNew= false;
		notify();
		return number;
	}
}
