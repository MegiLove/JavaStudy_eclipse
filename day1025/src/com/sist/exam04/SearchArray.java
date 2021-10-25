package com.sist.exam04;

public class SearchArray {

	public static int search(int[] arr, int value) throws NotFoundException {
		int index = -1;
		// 왜 초기값을 -1을 주나요?
		// 배열의 인덱스는 0부터 시작하니 인덱스가 아닌 값을 설정하기 위해 -1로 주었다

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				index = i;
			}
		}
		if (index == -1) {
			throw new NotFoundException("배열에 찾는 값 " + value + "가(이) 없습니다!");
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
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
