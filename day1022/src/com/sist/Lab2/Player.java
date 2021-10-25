package com.sist.Lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.HashSet;
import java.util.TreeSet;

public class Player {

	String[] number = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public TreeSet<Integer> pairList = new TreeSet<Integer>();

	ArrayList<Card> list = new ArrayList<Card>();

	public Player() {
		int value = 2;
		for (int i = 0; i < number.length; i++) {
			map.put(number[i], value++);
		}
	}

	public void getCard(Card card) {
		list.add(card);
	}

	public int pairProcess(String player) {
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// i��° ī���� ���ڿ� j��° ī���� ���ڰ� �������� �Ǻ��Ѵ�
				if (list.get(i).getNumber().equals(list.get(j).getNumber())) {
					// ������ ī���� ����(���ڿ��̴�)�� �ش��ϴ� ������ map���κ��� �̾ƿ´�
					n = map.get(list.get(i).getNumber());
					// ���� �̷�� ���ڸ� pairList�� ��´�
					pairList.add(n);

				}
			}
		}
		System.out.println(pairList);

		Iterator<Integer> iter = pairList.iterator();

		if (pairList.size() == 3) {
			System.out.println(player+"�� ������Դϴ�");
			iter.next();
			n = iter.next() + iter.next();
		} else if (pairList.size() == 2) {
			System.out.println(player+"�� ������Դϴ�");
			n = iter.next() + iter.next();
		} else if (pairList.size() == 1) {
			System.out.println(player+"�� ������Դϴ�");
			n = iter.next();
		}
		return n;
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
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getNumber().equals(list.get(j).getNumber())) {
					n = map.get(list.get(i).getNumber());
				}
			}
		}
		return n;
	}


	/*
	 * public boolean isTwoPair() { String[] number = { "2", "3", "4", "5", "6",
	 * "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" }; HashMap<String,
	 * Integer> map = new HashMap<String, Integer>(); int value = 2; for (int i = 0;
	 * i < number.length; i++) { map.put(number[i], value++); } HashSet<String> set
	 * = new HashSet<String>(); int n = 0; for (int i = 0; i < list.size(); i++) {
	 * for (int j = i + 1; j < list.size(); j++) { if
	 * (list.get(i).getNumber().equals(list.get(j).getNumber())) { n =
	 * map.get(list.get(i).getNumber()); set.add(list.get(i).getNumber()); } } }
	 * return set.size() > 1; }
	 */
}
