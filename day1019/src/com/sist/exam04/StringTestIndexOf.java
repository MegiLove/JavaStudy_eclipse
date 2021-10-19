package com.sist.exam04;

public class StringTestIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String data= new String("Returns the index within this string of the first occurrence of the substring");
	   int index= data.indexOf("the");
	   System.out.println(index);
	   
	   int index2= data.indexOf("the",9);
	   System.out.println(index2);
	   
	   int index3= data.indexOf("hello");
	   System.out.println(index3);
	   
	   int index4= data.indexOf('e');
	   System.out.println(index3);
	}

}
