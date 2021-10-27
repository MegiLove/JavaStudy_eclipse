package com.sist.score;

import java.io.FileReader;
import java.util.StringTokenizer;

public class ScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("c:/myData/student.txt");
			int ch;
			String str = "";
			while ((ch = fr.read()) != -1) {
				str += (char) ch;
			}
			System.out.println(str);
			StringTokenizer st = new StringTokenizer(str, ",");
			String name = st.nextToken();
			double kor = Double.parseDouble(st.nextToken());
			double eng = Double.parseDouble(st.nextToken());
			double math = Double.parseDouble(st.nextToken());

			double tot = kor + eng + math;
			double avg = tot / 3;
			System.out.println("총점: "+tot);
			System.out.println("평균: "+avg);
			
		} catch (Exception e) {
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
