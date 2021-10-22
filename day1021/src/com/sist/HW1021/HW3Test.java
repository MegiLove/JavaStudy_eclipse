package com.sist.HW1021;

import java.util.ArrayList;
import java.util.Scanner;

public class HW3Test {

	public static Scanner sc = new Scanner(System.in);

	public static void printMenu() {
		System.out.println("1.�߰� 2.�˻� 3.���� 4.������ 5.��λ��� 0.����");
		System.out.print("�޴��� �����ϼ���=> ");
	}

	public static void insertWord(ArrayList<HW3> list) {
		String word,explain;
		System.out.println("������ �ܾ �Է��Ͻÿ�==>");
		word= sc.next();
		System.out.println("�ܾ��� ������ �Է��Ͻÿ�==>");
		explain = sc.next();
		
		list.add(new HW3(word,explain));
	}

	public static void searchWord(ArrayList<HW3> list) {
		String word;
		System.out.println("�˻��� �ܾ��� �̸��� �Է��Ͻÿ�");
		word = sc.next();
		HW3 searchWord = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getWord().equals(word)) {
				searchWord = list.get(i);
				break;
			}
		}
		if (searchWord != null) {
			System.out.println(searchWord);
		} else {
			System.out.println("ã���� �ϴ� �ܾ� " + word + "�� �����ϴ�");
		}
	}

	public static void removeWord(ArrayList<HW3> list) {
		System.out.println("������ �ܾ��� �̸��� �Է��Ͻÿ�");
		String word = sc.next();
		int i;
		int cnt = list.size();
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getWord().equals(word)) {
				list.remove(list.get(i));
				break;
			}
		}
		if (i < cnt) {
			System.out.println("�ܾ �����Ͽ����ϴ�");
		} else {
			System.out.println("�����Ϸ��� �ܾ��� �����Ͱ� �����ϴ�");
		}
	}

	private static void printAll(ArrayList<HW3> list) {
		// TODO Auto-generated method stub
		if (list.isEmpty()) {
			System.out.println("�����Ͱ� �����ϴ�");
		} else {
			for (HW3 word : list) {
				System.out.println(word);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<HW3> list = new ArrayList<HW3>();
		String word,explain;
		while (true) {
			printMenu();
			int menu = sc.nextInt();
			if (menu == 0) {
				break;
			}

			switch (menu) {
			case 1:
				insertWord(list);
				break;
			case 2:
				searchWord(list);
				break;
			case 3:
				removeWord(list);
				break;
			case 4:
				printAll(list);
				break;
			case 5:
				list.clear();
				System.out.println("�����͸� ��� �����Ͽ����ϴ�");
				break;
			}
		}
	}

}
