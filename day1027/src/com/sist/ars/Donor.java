package com.sist.ars;

public class Donor extends Thread {
	private Account tvArs;
	private String name;
	public Donor(String name,Account tvArs) {
		this.name=name;
		this.tvArs= tvArs;
	}
	
	public void run() {
		for(int i=1; ;i++) {
			if(tvArs.getBalance()>=100000) {
				break;
			}
			tvArs.deposit(1000);
			System.out.println(name+"�̰�"+i+"��° �ӱ��Ͽ����ϴ�");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
