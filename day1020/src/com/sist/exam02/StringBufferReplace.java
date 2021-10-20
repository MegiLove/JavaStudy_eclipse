package com.sist.exam02;

public class StringBufferReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer data= new StringBuffer("hello korea");
		data.replace(0, 5, "hi");
		System.out.println(data);
		
		String oldString= "hello";
		String newString= "hi";
		
		int start= data.indexOf(oldString);
		int end= start+oldString.length();
		data.replace(start, end, newString);
	}

}
