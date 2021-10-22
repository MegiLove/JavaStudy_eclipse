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
		System.out.println("문장을 입력해주세요");
		data = sc.nextLine(); //공백포함해서 받기 위해 nextLine을 사용
		System.out.println(data);
		
		StringTokenizer st= new StringTokenizer(data);
		TreeMap<String,Integer> map= new TreeMap<String, Integer>();
		
		while(st.hasMoreTokens()) {
			String word= st.nextToken(); //입력문장으로부터 분리한 단어만큼 반복실행한다
			Integer cnt= map.get(word);  //분리한 단어를 하나씩 끄집어 내온다
			if(cnt== null) {             //map으로 그 단어의 빈도수를 끄집어 내온다
				map.put(word, 1);		 //만약 그 단어가 map에 없다면
			}else {						//빈도수를 1로 설정하여 map에 추가한다
				map.put(word, cnt+1);	//그렇지 않다면(이미 그 단어가 map에 있다면)
			}							//그 빈도수에 +1한 값으로 다시 설정한다
		}
		//map에 있는 자료만큼 반복수행하기 위해map의 모든 key목록을 읽어온다
		
		Set<String>keyList= map.keySet(); 
		
		//set자체에는 반복수행 기능이 없다. 그래서 set자료를 하나씩 끄집어오기 위해
		//iterator를 만들어야 한다
		Iterator<String> iter= keyList.iterator();
		
		
		//단어별 빈도수가 담겨 있는 map의 key목록을 담고 있는 이터레이터의 데이터가 있는 만큼 반복실행한다
		while(iter.hasNext()) {
			String word=iter.next(); //이터레이터로부터 데이터를 꺼내오면 단어이다. 그 단어는 map의 key이다
			int cnt=map.get(word);   //map으로부터 그 단어key의 빈도수value를 꺼내온다
			System.out.printf("%20s======> %d\n",word,cnt);
		}

	}

}


