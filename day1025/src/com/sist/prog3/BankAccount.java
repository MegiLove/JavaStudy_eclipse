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
			throw new NegativeBalanceException("����ݾ��� �ܾ׺��� Ů�ϴ�");
		}else {
			sum-=a;
		}
		return sum;
	}

}
