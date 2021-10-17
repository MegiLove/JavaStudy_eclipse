package com.sist.Prog10;
import java.util.Scanner;
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		  Book[] book = new Book[5];

		  while (true) {
		   System.out.println("1. 등록\n2. 조회");
		   switch (scan.nextInt()) {
		   case 1: {

		    for (int i = 0; i < 5; i++) {
		     System.out.println("등록하실 소설을 고르세요.");
		     System.out.println("1. 소설\n2. 우편\n3. SF");
		     switch (scan.nextInt()) {
		     case 1: {
		      Novel novel = new Novel();

		      System.out.println("제목을 입력하세요 : ");
		      novel.title = scan.next();

		      System.out.println("저자를 입력하세요 : ");
		      novel.name = scan.next();

		      System.out.println("책번호를 입력하세요 : ");
		      novel.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == novel.number) {
		        System.out.println("중복된 책이 있습니다.");
		        break;
		       }
		     }
		      break;
		     case 2: {
		      Poet poet = new Poet();

		      System.out.println("제목을 입력하세요 : ");
		      poet.title = scan.next();

		      System.out.println("저자를 입력하세요 : ");
		      poet.name = scan.next();

		      System.out.println("책번호를 입력하세요 : ");
		      poet.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == poet.number) {
		        System.out.println("중복된 책이 있습니다.");
		        break;
		       }
		     }
		      break;
		     case 3: {
		      ScienceFiction sf = new ScienceFiction();

		      System.out.println("제목을 입력하세요 : ");
		      sf.title = scan.next();

		      System.out.println("저자를 입력하세요 : ");
		      sf.name = scan.next();

		      System.out.println("책번호를 입력하세요 : ");
		      sf.number = scan.nextInt();
		      for (int j = 0; j < 5; j++)
		       if (book[j].number == sf.number) {
		        System.out.println("중복된 책이 있습니다.");
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
