package com.sist.exam04;

public class StringBufferTest {
    
	
	public static void pro(String str) {
		System.out.println("ó���ϴ� ���ڿ���"+str+"�Դϴ�");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer data= new StringBuffer("hello");
		data.append("korea");
		
		System.out.println(data);
		
		pro(new String(data));
		
		String r= new String(data);
		pro(r);
	}

}
