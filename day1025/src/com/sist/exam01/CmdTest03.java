package com.sist.exam01;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
class CmdTest03
{	
	public static void main(String[] args) throws Exception
	{	//����ڰ� ��û�ϴ� ���񽺸� key�� ��ó����� ��ü value�� ��� ���� map�� ���� 
		HashMap<String,SistAction>map= new HashMap<String,SistAction>();
		//���񽺸�� ��ó�����Ŭ�������� �ִ� ���ϰ�ü�� ������
		FileReader fr= new FileReader("sist.properties");
		//������ ������ key�� value�� �����ϱ� ���� ��ü�� ������
		Properties prop= new Properties();
		//������ ������ �о����
		prop.load(fr);
		//������Ƽ ���Ϸκ��� key���(���񽺸�)�� �ݺ��� ��ü�� ������
		Iterator iter= prop.keySet().iterator();
		//key�� �ִ� ��ŭ �ݺ� ������
		while(iter.hasNext())
			{	//key�� �ϳ��� ������ �����(���񽺸�)
				String cmd= (String)iter.next();
				//key�� �ش��ϴ� value�� ������ �����(��ó�� ��� Ŭ�����̸�)
				String clsName= (String)prop.get(cmd);
				//���ڿ��� �Ǿ��ִ� Ŭ�����̸��� �ش��ϴ� ��ü�� ������
				SistAction obj= (SistAction)Class.forName(clsName).newInstance();
				//����ڰ� ��û�� ���񽺸�� ��ó�� ����� �ϴ� ��ü�� key�� value�� �Ͽ� map�� �����
				map.put(cmd,obj);
				//System.out.println(cmd+","+clsName);
			}
		
		/*map.put("insert.do",new InsertBoard());
		map.put("list.do",new ListBoard());
		map.put("update.do",new UpdateBoard());*/

		//���α׷� ���� �ÿ� ���޵Ǵ� �Ű������� url������ ������
		String url= args[0];
		//url�κ��� ���񽺸��� �߶� ������ ������
		String cmd= url.substring(url.lastIndexOf("/")+1);
		//map���κ��� ���񽺸� �ش��ϴ� ��ó�� ��簴ü�� �̾ƿ�
		SistAction action= map.get(cmd);
		//��ó���� ���� �޼ҵ带 ȣ����
		action.pro();

	}
}
