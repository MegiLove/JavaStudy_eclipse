package com.sist.exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestUSingMethod {

	public static Scanner sc = new Scanner(System.in);

	public static void printMenu() {
		System.out.print("1.�߰� 2.�˻� 3.���� 4.������ 5.��λ��� 0.����");
		System.out.print("�޴��� �����ϼ���=> ");
	}

	public static void insertStudent(ArrayList<Student> list) {
		String name, addr, phone;
		System.out.println("�л��� �̸��� �Է��Ͻÿ�==>");
		name = sc.next();
		System.out.println("�л��� �ּ��� �Է��Ͻÿ�==>");
		addr = sc.next();
		System.out.println("�л��� ��ȭ��ȣ�� �Է��Ͻÿ�==>");
		phone = sc.next();
		list.add(new Student(name, addr, phone));
	}

	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("�˻��� �л��� �̸��� �Է��Ͻÿ�");
		name = sc.next();
		Student searchStudent = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				searchStudent = list.get(i);
				break;
			}
		}
		if (searchStudent != null) {
			System.out.println(searchStudent);
		} else {
			System.out.println("ã���� �ϴ� �л� " + name + "�� �����ϴ�");
		}
	}

	public static void removeStudent(ArrayList<Student> list) {
		System.out.println("������ �л��� �̸��� �Է��Ͻÿ�");
		String name = sc.next();
		int i;
		int cnt = list.size();
		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(list.get(i));
				break;
			}
		}
		if (i < cnt) {
			System.out.println("�л��� �����͸� �����Ͽ����ϴ�");
		} else {
			System.out.println("�����Ϸ��� �л��� �����Ͱ� �����ϴ�");
		}
	}

	private static void printAll(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		if (list.isEmpty()) {
			System.out.println("�����Ͱ� �����ϴ�");
		} else {
			for (Student student : list) {
				System.out.println(student);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		String name, addr, phone;
		while (true) {
			printMenu();
			int menu = sc.nextInt();
			if (menu == 0) {
				break;
			}

			switch (menu) {
			case 1:
				insertStudent(list);
				break;
			case 2:
				searchStudent(list);
				break;
			case 3:
				removeStudent(list);
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
