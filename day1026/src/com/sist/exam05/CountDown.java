package com.sist.exam05;

public class CountDown implements Runnable {

	public void run() {
		for (int i = 20; i > 0; i--) {
			System.out.println(i + "�� ���Դϴ�");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
