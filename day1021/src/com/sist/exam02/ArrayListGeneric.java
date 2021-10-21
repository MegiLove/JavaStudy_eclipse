package com.sist.exam02;

import java.util.ArrayList;
import java.util.Date;
public class ArrayListGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList list= new ArrayList();
		list.add(100);
		list.add("È«±æµ¿");
		list.add(26.7);
		list.add(new Date());
		list.add(true);
		System.out.println(list);
		
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("È«±æµ¿");
		list2.add("À¯°ü¼ø");
		System.out.println(list2);
		
		ArrayList<String> list3= new ArrayList<String>();
		list3.add(100+"");
		list3.add("È«±æµ¿");
		list3.add(26.7+"");
		list3.add(new Date()+"");
		list3.add(true+"");
		System.out.println(list3);
		
		ArrayList<Integer> list4= new ArrayList<Integer>();
		list4.add(50);
		list4.add(60);
		
		System.out.println(list4);
	}

}
