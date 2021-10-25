package com.sist.exam04;

public class SearchArray {

	public static int search(int[] arr, int value) throws NotFoundException {
		int index = -1;
		// �� �ʱⰪ�� -1�� �ֳ���?
		// �迭�� �ε����� 0���� �����ϴ� �ε����� �ƴ� ���� �����ϱ� ���� -1�� �־���

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				index = i;
			}
		}
		if (index == -1) {
			throw new NotFoundException("�迭�� ã�� �� " + value + "��(��) �����ϴ�!");
		}

		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] data = { 2, 4, 10, 9, 6 };
			int n = search(data, 100);
			System.out.println(n);
		} catch (NotFoundException e) {
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}

}
