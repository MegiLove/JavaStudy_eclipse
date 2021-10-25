package com.sist.exam01;
import java.util.Scanner;
/*interface SistAction
{
	public void pro();
}

public InsertBoard implements SistAction
{
	public void pro()
		{
			System.out.println("게시물을 등록하였습니다");
		}
}
*/
class CmdTest 
{	
	public static void insertBoard(){
		System.out.println("게시물을 등록하였습니다");
	}

	public static void listBoard(){
		System.out.println("게시물 목록입니다");
	}

	public static void updateBoard(){
		System.out.println("게시물을 수정하였습니다");
	}
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String url= args[0];
		String cmd= url.substring(url.lastIndexOf("/")+1);
		

	}
}
