package com.sist.product;

//�����ڸ� ���� Ŭ������ �����
public class Producer extends Thread {
	// ��ǰ�� ���� Ŭ������ �ɹ������� �����Ѵ�
	private Product product;

	// ������ ��ü �����ÿ� ��ǰ ��ü�� �Ű������� ���޹޾� �ɹ����� ��ǰ�� �ʱ�ȭ�Ѵ�
	public Producer(Product product) {
		this.product = product;
	}

	// ������ Ŭ������ ����Ͽ� ���ο� ��ǰ�� �����ϱ� ���� �޼ҵ带 ȣ���Ű�� ���Ͽ�
	// �����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵��Ͽ� ���ش�
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
