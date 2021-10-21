package com.sist.HW2;
import java.util.HashSet;
public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet <String> set= new HashSet<String>();
		
		set.add("a");
		set.add("b");
		set.add("b");
		set.add("c");
		
		System.out.println(set);
		System.out.println(set.size());
		
		

	}

}
