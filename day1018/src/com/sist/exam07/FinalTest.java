package com.sist.exam07;

class Person{
	public String name="ȫ�浿";
	public final String addr="����� ������ ������";
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Person hong= new Person();
       System.out.println(hong.name);  
       hong.name="ȫ�ν�";
       System.out.println(hong.name);     
	}

}
