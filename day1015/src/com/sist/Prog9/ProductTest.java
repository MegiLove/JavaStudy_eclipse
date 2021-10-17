package com.sist.Prog9;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p1= new Product("상추", 2000);
		System.out.println(p1);
		
		DiscountProduct d1= new DiscountProduct("포도",3000,10);
		System.out.println(d1);
		
		System.out.println(p1.getPrice());
		System.out.println(d1.getPrice());
	}

}
