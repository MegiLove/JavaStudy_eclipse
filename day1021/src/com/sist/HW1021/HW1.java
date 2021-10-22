package com.sist.HW1021;

import java.util.Random;
import java.util.TreeSet;

public class HW1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet set1 = new TreeSet();
		TreeSet set2 = new TreeSet();
		TreeSet set3 = new TreeSet();
		TreeSet set4 = new TreeSet();
		TreeSet set5 = new TreeSet();
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		Random r4 = new Random();
		Random r5 = new Random();

		while (set1.size() < 6 && set2.size() < 6 && set3.size() < 6 && set4.size() < 6 && set5.size() < 6) {
			set1.add(r1.nextInt(45) + 1);
			set2.add(r2.nextInt(45) + 1);
			set3.add(r3.nextInt(45) + 1);
			set4.add(r4.nextInt(45) + 1);
			set5.add(r5.nextInt(45) + 1);
		}
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		System.out.println(set4);
		System.out.println(set5);

	}

}
