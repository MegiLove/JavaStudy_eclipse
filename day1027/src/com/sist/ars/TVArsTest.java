package com.sist.ars;

public class TVArsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account= new Account();
		
		Donor d1= new Donor("김수연", account);
		Donor d2= new Donor("김시아", account);
		Donor d3= new Donor("임상진", account);
		Donor d4= new Donor("윤태인", account);
		Donor d5= new Donor("정자영", account);
		
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("전체모금액: "+account.getBalance());
	}

}
