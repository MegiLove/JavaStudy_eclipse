package com.sist.Prog7;
import java.util.Scanner;
public class ShapeTest 
{
 public static void main(String[] args)
 {
  Scanner scan = new Scanner(System.in);
  Shape[] shape = new Shape[6];
  int num=0;
  
  for(int i=0; i<6; i++)
  {
   System.out.println("���ϴ� ������ ������.");
   System.out.println("1. ��\n2. �ﰢ��\n3. �簢��\n4. ��\n5. ������ü\n6. �����");
   num = scan.nextInt();
   
   switch(num)
   {
   case 1 :
   {
    double x=0;
    
    System.out.println("���� �������� �Է��ϼ���.");
    x = scan.nextInt();
    
    TwoDimShape circle = new TwoDimShape(x);
    shape[i] = circle;
   }break;
   case 2 :
   {
    double x=0, y=0;
    
    System.out.println("�ﰢ���� ���ο� ���θ� �Է��ϼ���.");
    x = scan.nextInt();
    y = scan.nextInt();
    
    TwoDimShape triangle = new TwoDimShape(x, y, 3);
    shape[i] = triangle;
   }break;
   case 3 :
   {
    double x=0, y=0;
    
    System.out.println("�簢���� ���ο� ���θ� �Է��ϼ���.");
    x = scan.nextInt();
    y = scan.nextInt();
    
    TwoDimShape rectangle = new TwoDimShape(x, y);
    shape[i] = rectangle;
   }break;
   case 4 :
   {
    double x=0, y=0;
    
    System.out.println("���� �������� �Է��ϼ���.");
    x = scan.nextInt();
    
    ThreeDimShap Sphere = new ThreeDimShap(x);
    shape[i] = Sphere;
   }break;
   case 5 :
   {
    double x=0, y=0, z=0;
    
    System.out.println("������ü�� ���ο� ����, ���̸� �Է��ϼ���.");
    x = scan.nextInt();
    y = scan.nextInt();
    z = scan.nextInt();
    
    ThreeDimShap parallelepiped = new ThreeDimShap(x, y, z);
    shape[i] = parallelepiped;
   }break;
   case 6 :
   {
    double x=0, z=0;
    
    System.out.println("������� ���ο� ���̸� �Է��ϼ���.");
    x = scan.nextInt();
    z = scan.nextInt();
    
    ThreeDimShap parallelepiped = new ThreeDimShap(x, z);
    shape[i] = parallelepiped;
   }break;
   }
  }
  
  for(int i=0; i<6; i++)
  {
   System.out.println(shape[i].getInfo());
  }

 }

}



