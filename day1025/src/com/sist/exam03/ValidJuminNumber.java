package com.sist.exam03;

import java.util.Scanner;

public class ValidJuminNumber {
	public static void main(String[] args) {
		String jumin;
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��Ͻÿ�(�������� �Է��ϼ���)==>");
		jumin = sc.next();
		
		int []n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		//800101-1234567
		//�ε����� 6��°�� ��꿡 �������� �ʾƿ�!
		//���ڿ��� ���̴� 14��
		//�ݺ������ؾ��� �ε����� 12		==> i < jumin.length() - 1
		
		int sum = 0;
		for(int i=0; i<jumin.length()-1; i++) {
			if(i != 6) {
				sum = sum + Integer.parseInt(jumin.charAt(i)+"") * n[i];
			}
		}
		
		sum = sum % 11;
		sum = 11 - sum;
		if(sum == 10) {
			sum = 0;
		}
		if( sum == 11) {
			sum = 1;
		}
		
		int check =  Integer.parseInt(jumin.charAt(13)+"");
		//charAt()�� ����� char�Դϴ�.
		//char�� ���ڿ�(String)���� ����� ���Ͽ� 
		//���� ""���� ���ϱ� �� �ݴϴ�.
		//�׷��� ������� ���ڿ��� Integer.parseInt�� �̿��Ͽ� ������ ����� �־��!
		
		if(sum == check) {
			System.out.println("�ùٸ� �ֹε�Ϲ�ȣ�Դϴ�.");
		}else {
			try {
				throw new InValidJuminNumberException("�ùٸ� �ֹι�ȣ ������ �ƴմϴ�.");
				// ���⿡ �� ������ �������?
				// �츮�� ���� InValidJuminNumberException�� RuntimeException�� �ļ��� �ƴմϴ�.
				// �׷��� ����ó���� �ؾ��մϴ�!
			}catch(InValidJuminNumberException e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}
		}
	}
}

	

