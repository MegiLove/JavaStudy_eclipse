package com.sist.prog3;

public class BankAccountTest extends BankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {BankAccount b1= new BankAccount();
			System.out.println(b1.deposit(1000)+"원입니다");
			System.out.println(b1.withdraw(2000)+"원입니다");
		}catch(NegativeBalanceException e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		
	}

}
