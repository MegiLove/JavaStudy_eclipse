package com.sist.exam01;
import java.util.TreeSet;
import java.util.Random;
public class AutoLottoUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet set= new TreeSet();
		Random r= new Random();
		
		while(set.size()<6) {
			set.add(r.nextInt(45)+1);
		}
		System.out.println(set);

	}

}
