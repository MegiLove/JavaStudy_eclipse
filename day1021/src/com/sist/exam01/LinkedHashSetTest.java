package com.sist.exam01;
import java.util.LinkedHashSet;
public class LinkedHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet set= new LinkedHashSet();
		set.add("���");
		set.add("����");
		set.add("����");
		System.out.println(set);
		set.add("�ٳ���");
		set.add("���");
		System.out.println(set);
	}
}
