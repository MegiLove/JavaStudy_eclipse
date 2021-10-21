package com.sist.HW2;
import java.util.HashMap;
public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,String> map= new HashMap<String,String>();
		map.put("이름:","유하림");
		map.put("전화번호","01012345678");
		map.put("주소", "서울시 강남구 서교동");
		map.put("이름:","이민행");
		
		System.out.println(map);
	}

}
