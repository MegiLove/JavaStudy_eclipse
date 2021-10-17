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
   System.out.println("원하는 도형을 고르세요.");
   System.out.println("1. 원\n2. 삼각형\n3. 사각형\n4. 구\n5. 직육면체\n6. 원기둥");
   num = scan.nextInt();
   
   switch(num)
   {
   case 1 :
   {
    double x=0;
    
    System.out.println("원의 반지름을 입력하세요.");
    x = scan.nextInt();
    
    TwoDimShape circle = new TwoDimShape(x);
    shape[i] = circle;
   }break;
   case 2 :
   {
    double x=0, y=0;
    
    System.out.println("삼각형의 가로와 세로를 입력하세요.");
    x = scan.nextInt();
    y = scan.nextInt();
    
    TwoDimShape triangle = new TwoDimShape(x, y, 3);
    shape[i] = triangle;
   }break;
   case 3 :
   {
    double x=0, y=0;
    
    System.out.println("사각형의 가로와 세로를 입력하세요.");
    x = scan.nextInt();
    y = scan.nextInt();
    
    TwoDimShape rectangle = new TwoDimShape(x, y);
    shape[i] = rectangle;
   }break;
   case 4 :
   {
    double x=0, y=0;
    
    System.out.println("구의 반지름을 입력하세요.");
    x = scan.nextInt();
    
    ThreeDimShap Sphere = new ThreeDimShap(x);
    shape[i] = Sphere;
   }break;
   case 5 :
   {
    double x=0, y=0, z=0;
    
    System.out.println("직육면체의 가로와 세로, 높이를 입력하세요.");
    x = scan.nextInt();
    y = scan.nextInt();
    z = scan.nextInt();
    
    ThreeDimShap parallelepiped = new ThreeDimShap(x, y, z);
    shape[i] = parallelepiped;
   }break;
   case 6 :
   {
    double x=0, z=0;
    
    System.out.println("원기둥의 가로와 높이를 입력하세요.");
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



