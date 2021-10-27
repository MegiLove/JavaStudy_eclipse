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
			System.out.println(name+"이가"+i+"번째 임금하였습니다");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
