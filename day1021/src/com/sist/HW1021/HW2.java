package com.sist.HW1021;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class HW2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("������ �Է����ּ���");
		data = sc.nextLine(); //���������ؼ� �ޱ� ���� nextLine�� ���
		System.out.println(data);
		
		StringTokenizer st= new StringTokenizer(data);
		TreeMap<String,Integer> map= new TreeMap<String, Integer>();
		
		while(st.hasMoreTokens()) {
			String word= st.nextToken(); //�Է¹������κ��� �и��� �ܾŭ �ݺ������Ѵ�
			Integer cnt= map.get(word);  //�и��� �ܾ �ϳ��� ������ ���´�
			if(cnt== null) {             //map���� �� �ܾ��� �󵵼��� ������ ���´�
				map.put(word, 1);		 //���� �� �ܾ map�� ���ٸ�
			}else {						//�󵵼��� 1�� �����Ͽ� map�� �߰��Ѵ�
				map.put(word, cnt+1);	//�׷��� �ʴٸ�(�̹� �� �ܾ map�� �ִٸ�)
			}							//�� �󵵼��� +1�� ������ �ٽ� �����Ѵ�
		}
		//map�� �ִ� �ڷḸŭ �ݺ������ϱ� ����map�� ��� key����� �о�´�
		
		Set<String>keyList= map.keySet(); 
		
		//set��ü���� �ݺ����� ����� ����. �׷��� set�ڷḦ �ϳ��� ��������� ����
		//iterator�� ������ �Ѵ�
		Iterator<String> iter= keyList.iterator();
		
		
		//�ܾ �󵵼��� ��� �ִ� map�� key����� ��� �ִ� ���ͷ������� �����Ͱ� �ִ� ��ŭ �ݺ������Ѵ�
		while(iter.hasNext()) {
			String word=iter.next(); //���ͷ����ͷκ��� �����͸� �������� �ܾ��̴�. �� �ܾ�� map�� key�̴�
			int cnt=map.get(word);   //map���κ��� �� �ܾ�key�� �󵵼�value�� �����´�
			System.out.printf("%20s======> %d\n",word,cnt);
		}

	}

}


