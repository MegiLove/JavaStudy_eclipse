package com.sist.inputoutput;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputOutput {

	public static void main(String[] args)throws IOException  {
		  FileInputStream a = new FileInputStream("c:/myData/enemy.png");	        
	       
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        byte[] buff = new byte[1000];
	       
	        int cnt;       
	        while ((cnt = a.read(buff)) != -1 ){
	                             
	            b.write(buff,0,cnt);
	        }
	       
	        byte[] arr = b.toByteArray(); //��Ʈ���� ������ byte�迭�� ��ȯ�Ѵ�.
	        System.out.println("���� :" +arr.length);
	        System.out.println(arr);
	       
	        //System.out.write(buff, 0, arr.length);
}
}
