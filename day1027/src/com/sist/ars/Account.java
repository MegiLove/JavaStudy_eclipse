package com.sist.ars;

public class Account {
	private int balance;
	public synchronized void deposit(int amount) {
		balance+=amount;
	}
	public int getBalance() {
		return balance;
	}
}
