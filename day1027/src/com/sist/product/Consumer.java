package com.sist.product;

public class Consumer extends Thread {

	// ��ǰ�� ���� Ŭ������ �ɹ������� �����Ѵ�
	// �� ��ǰ ��ü�� �����ڰ� �����ִ� ��ǰ�� ������ ��ü�̴�==> ���� ��ǰ�� �����ڿ����� �ϰ� �ִ�
	private Product product;

	public Consumer(Product product) {
		this.product = product;
	}

	public void run() {
		//�ݺ������Ͽ� 10���� ��ǰ�� ����ϵ��� �Ѵ�
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
