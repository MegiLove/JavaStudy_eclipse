package com.sist.Lab2;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	ArrayList<Card> list = new ArrayList<Card>();

	public void getCard(Card card) {
		list.add(card);
	}

	public void showCards() {
		System.out.println(list);
	}

	public int isOnePair() {
		String[] number = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int value = 2;
		for (int i = 0; i < number.length; i++) {
			map.put(number[i], value++);
		}
		int n=0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n= map.get(list.get(i).getNumber());	
				}
			}
		}
		return n;
	}
}
