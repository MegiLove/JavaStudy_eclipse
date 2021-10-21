package com.sist.exam02;

import java.util.ArrayList;

public class ArrayListForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr= {10,20,30,40};
		for(int a:arr) {
			System.out.println(a);
		}
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		for(int a: list) {
			System.out.println(a);
		}
	}

}
