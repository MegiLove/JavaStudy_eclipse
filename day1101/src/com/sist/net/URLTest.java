package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url= new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			//문서의 내용을 읽어들이기 위한 스트림을 생성한다
			InputStream is= url.openStream();
			//한 번에 읽어들일 byte형의 배열을 만든다
			byte []data= new byte[100];
			//스트림을 통해 읽어 문자열을 다 모아놓을 변수를 만든다
			String str="";
			//스트림의 끝이 아닐 때까지 100바이트씩 읽어들인다
			while(is.read(data)!= -1) {
				//읽어들인 byte배열의 data를 문자열로 만들어 누적한다
				str+=new String(data, "utf-8");
			}
			//전체누적된 문자열 변수를 출력한다
			System.out.println(str);
			//스트림을 닫아준다
			is.close();
			
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}

	}

}
