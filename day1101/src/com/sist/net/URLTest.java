package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url= new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			//������ ������ �о���̱� ���� ��Ʈ���� �����Ѵ�
			InputStream is= url.openStream();
			//�� ���� �о���� byte���� �迭�� �����
			byte []data= new byte[100];
			//��Ʈ���� ���� �о� ���ڿ��� �� ��Ƴ��� ������ �����
			String str="";
			//��Ʈ���� ���� �ƴ� ������ 100����Ʈ�� �о���δ�
			while(is.read(data)!= -1) {
				//�о���� byte�迭�� data�� ���ڿ��� ����� �����Ѵ�
				str+=new String(data, "utf-8");
			}
			//��ü������ ���ڿ� ������ ����Ѵ�
			System.out.println(str);
			//��Ʈ���� �ݾ��ش�
			is.close();
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}

	}

}
