package com.sist.exam05;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list= new ArrayList<String>();
		list.add("홍길동");
		list.add("서울");
		list.add("010-1234-1111");
		
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("이름", "홍길동");
		map.put("주소", "서울");
		map.put("전화번호", "010-1234-1111");
		
		System.out.println(list.get(1));
		//list로부터 주소를 출력하려면 인덱스로 접근
		
		System.out.println(map.get("주소"));
		//map에서 주소를 출력하려면 "주소"라는 키로 접근
	}

}
