package com.sist.exam04;

public class StringTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data= new String("æ»≥Á«œººø‰");
		String data2="æ»≥Á«œººø‰";
		System.out.println(data);
		System.out.println(data2);
		
		byte[]arr=data.getBytes();
		for(byte b:arr) {
			System.out.println(b);
		}
        
		String result= new String(arr);
		System.out.println(result);
	}

}
