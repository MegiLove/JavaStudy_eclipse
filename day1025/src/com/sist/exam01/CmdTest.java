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
			System.out.println("�Խù��� ����Ͽ����ϴ�");
		}
}
*/
class CmdTest 
{	
	public static void insertBoard(){
		System.out.println("�Խù��� ����Ͽ����ϴ�");
	}

	public static void listBoard(){
		System.out.println("�Խù� ����Դϴ�");
	}

	public static void updateBoard(){
		System.out.println("�Խù��� �����Ͽ����ϴ�");
	}
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String url= args[0];
		String cmd= url.substring(url.lastIndexOf("/")+1);
		

	}
}
