package com.sist.exam08;

class Person{
	public String name="ȫ�浿";
	public static final String addr="����� ������ ������";
	
}
public class FinalTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Person father= new Person(); 
      Person son= new Person();
      
      father.name="ȫ�浿";
      son.name="ȫ�ν�";
      
      System.out.println(father.name+","+father.addr);
      System.out.println(son.name+","+son.addr);
	}

}
