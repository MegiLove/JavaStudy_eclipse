package com.sist.prog3;

public class BankAccount {
	double balance;
	double sum=0;
	public double deposit(double a) {		
		sum+=a;
		return sum;
	}

	public double withdraw(double a) throws NegativeBalanceException{		
		if(sum<a) {
			throw new NegativeBalanceException("인출금액이 잔액보다 큽니다");
		}else {
			sum-=a;
		}
		return sum;
	}

}
