package com.sist.exer7;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.6);
		list.add(70.2);
		list.add(36.4);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------------------------------------");

		for (double a : list) {
			System.out.println(a);
		}

		System.out.println("------------------------------------------");
		Iterator<Double> listIterator= list.iterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		
	}
}
