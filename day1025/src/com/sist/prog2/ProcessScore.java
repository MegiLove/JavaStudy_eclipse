package com.sist.prog2;

public class ProcessScore {
	static int sum =0, avg = 0;

	public static int ProcessScore(int score[]) throws IllegalScore {
		for (int i = 0; i < score.length; i++) {
			sum+= score[i];
		}
		for (int i = 0; i < score.length; i++) {
			if (score[i] < 0) {
				throw new IllegalScore("성적은 0보다 커야 합니다");
			}
		}
		int avg = sum / score.length;
		return avg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int score[] = { 80, 90, -20, 70 };
			int n = ProcessScore(score);
			System.out.println("평균: " + n);
		} catch (IllegalScore e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}

}
