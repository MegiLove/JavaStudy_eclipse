package com.sist.exam01;
import java.util.HashMap;
/*interface SistAction
{
	public void pro();
}

class InsertBoard implements SistAction
{
	public void pro()
		{
			System.out.println("게시물을 등록하였습니다");
		}
}

class ListBoard implements SistAction
{
	public void pro()
		{
			System.out.println("게시물 목록입니다");
		}
}

class UpdateBoard implements SistAction
{
	public void pro()
	{
		System.out.println("게시물을 수정하였습니다");
	}
}
*/
class CmdTest02
{	
	public static void main(String[] args) 
	{	
		HashMap<String,SistAction>map= new HashMap<String,SistAction>();
		
		map.put("insert.do",new InsertBoard());
		map.put("list.do",new ListBoard());
		map.put("update.do",new UpdateBoard());
		String url= args[0];
		String cmd= url.substring(url.lastIndexOf("/")+1);
		
		SistAction action= map.get(cmd);
		action.pro();

	}
}
