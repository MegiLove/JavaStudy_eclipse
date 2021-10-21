package com.sist.exam01;
import java.util.LinkedHashSet;
public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set= new LinkedHashSet();
		set.add("사과");
		set.add("수박");
		set.add("딸기");
		System.out.println(set);
		set.add("바나나");
		set.add("사과");
		System.out.println(set);
	}
}
