package com.sist.exam05;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class FestivalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list= new ArrayList<Double>();
		int i;
		double score;
		Scanner sc= new Scanner(System.in);
		for(i=0; i<10; i++) {
		System.out.println("심사위원들의 점수를 입력하세요 (0.0~10.0)");
		score= sc.nextDouble();
		list.add(score);
		}
		
		Collections.sort(list);	
		list.remove(list.get(0));
		list.remove(list.get(8));
		System.out.println(list);
	}

}
