package com.sist.Prog7;

class TwoDimShape extends Shape
{
 double x=0, y=0, area=0;
 String name = "";
 
 public void Shape()
 {
  System.out.println("test");
 }
 
 public TwoDimShape(double input_x)
 {
  name = "Circle";
  x = input_x;
  area = x*x*3.14;
 }
 
 public TwoDimShape(double input_x, double input_y)
 {
  name = "Rectangle";
  x = input_x;
  y = input_y;
  area = x*y;
 }
 
 public TwoDimShape(double input_x, double input_y, int a)
 {
  name = "Triangle";
  x = input_x;
  y = input_y;
  area = (x*y)/2;
 }
 
 public double getArea()
 {
  return area;
 }
 
 public String getInfo()
 {
  return "�� ������ " + name + "�̰�, ���δ� " + x + ", ���δ� " + y +  "�̸�, ���̴� " + area + "�̴�.";
 }
}


