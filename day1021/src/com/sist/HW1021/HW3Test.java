package com.sist.HW1021;

import java.util.ArrayList;
import java.util.Scanner;

public class HW3Test {

	public static Scanner sc = new Scanner(System.in);

	public static void printMenu() {
		System.out.println("1.추가 2.검색 3.삭제 4.모두출력 5.모두삭제 0.종료");
		System.out.print("메뉴를 선택하세요=> ");
	}

	public static void insertWord(ArrayList<HW3> list) {
		String word,explain;
		System.out.println("저장할 단어를 입력하시오==>");
		word= sc.next();
		System.out.println("단어의 설명을 입력하시오==>");
		explain = sc.next();
		
		list.add(new HW3(word,explain));
	}

	public static void searchWord(ArrayList<HW3> list) {
		String word;
		System.out.println("검색할 단어의 이름을 입력하시오");
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
			System.out.println("찾고자 하는 단어 " + word + "은 없습니다");
		}
	}

	public static void removeWord(ArrayList<HW3> list) {
		System.out.println("삭제할 단어의 이름을 입력하시오");
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
			System.out.println("단어를 삭제하였습니다");
		} else {
			System.out.println("삭제하려는 단어의 데이터가 없습니다");
		}
	}

	private static void printAll(ArrayList<HW3> list) {
		// TODO Auto-generated method stub
		if (list.isEmpty()) {
			System.out.println("데이터가 없습니다");
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
				System.out.println("데이터를 모두 삭제하였습니다");
				break;
			}
		}
	}

}
