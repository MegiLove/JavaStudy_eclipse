package com.sist.Prog10;
import java.util.Scanner;
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		  Book[] book = new Book[5];

		  while (true) {
		   System.out.println("1. ���\n2. ��ȸ");
		   switch (scan.nextInt()) {
		   case 1: {

		    for (int i = 0; i < 5; i++) {
		     System.out.println("����Ͻ� �Ҽ��� ������.");
		     System.out.println("1. �Ҽ�\n2. ����\n3. SF");
		     switch (scan.nextInt()) {
		     case 1: {
		      Novel novel = new Novel();

		      System.out.println("������ �Է��ϼ��� : ");
		      novel.title = scan.next();

		      System.out.println("���ڸ� �Է��ϼ��� : ");
		      novel.name = scan.next();

		      System.out.println("å��ȣ�� �Է��ϼ��� : ");
		      novel.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == novel.number) {
		        System.out.println("�ߺ��� å�� �ֽ��ϴ�.");
		        break;
		       }
		     }
		      break;
		     case 2: {
		      Poet poet = new Poet();

		      System.out.println("������ �Է��ϼ��� : ");
		      poet.title = scan.next();

		      System.out.println("���ڸ� �Է��ϼ��� : ");
		      poet.name = scan.next();

		      System.out.println("å��ȣ�� �Է��ϼ��� : ");
		      poet.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == poet.number) {
		        System.out.println("�ߺ��� å�� �ֽ��ϴ�.");
		        break;
		       }
		     }
		      break;
		     case 3: {
		      ScienceFiction sf = new ScienceFiction();

		      System.out.println("������ �Է��ϼ��� : ");
		      sf.title = scan.next();

		      System.out.println("���ڸ� �Է��ϼ��� : ");
		      sf.name = scan.next();

		      System.out.println("å��ȣ�� �Է��ϼ��� : ");
		      sf.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == sf.number) {
		        System.out.println("�ߺ��� å�� �ֽ��ϴ�.");
		        break;
		       }
		     }
		      break;

		     }
		    }
		   }
		   case 2: {
		    for (int i = 0; i < 5; i++) {
		     System.out.println(book[i].title);
		     System.out.println(book[i].name);
		     System.out.println(book[i].number);
		    }
		   }
		    break;
		   }
		  }
		 }

}
