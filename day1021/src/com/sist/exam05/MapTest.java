package com.sist.exam05;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list= new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("����");
		list.add("010-1234-1111");
		
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("�̸�", "ȫ�浿");
		map.put("�ּ�", "����");
		map.put("��ȭ��ȣ", "010-1234-1111");
		
		System.out.println(list.get(1));
		//list�κ��� �ּҸ� ����Ϸ��� �ε����� ����
		
		System.out.println(map.get("�ּ�"));
		//map���� �ּҸ� ����Ϸ��� "�ּ�"��� Ű�� ����
	}

}
