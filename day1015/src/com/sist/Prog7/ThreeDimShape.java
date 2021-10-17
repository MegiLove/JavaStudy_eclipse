package com.sist.Prog7;

class ThreeDimShap extends Shape
{
 double x=0, y=0, z=0, Volum=0;
 String name="";
 
 public void Shape()
 {
  System.out.println("test");
 }
 
 public ThreeDimShap(double input_x)
 {
  name = "Sphere";
  x = input_x;
  Volum = (4*3.14*x*x*x)/3;
 }
 
 public ThreeDimShap(double input_x, double input_y, double input_z)
 {
  name = "Cube";
  x = input_x;
  y = input_y;
  z = input_z;
  Volum = x*y*z;
 }
 
 public ThreeDimShap(double input_x, double input_z)
 {
  name = "Cylinder";
  x = input_x;
  z = input_z;
  Volum = (3.14*x*x*z)/3;
 }
 
 public double getVolum()
 {
  return Volum;
 }
 
 public String getInfo()
 {
  return "이 도형은 " + name + "이고, 가로는 " + x + ", 세로는 " + y + "높이는  " + z + "이며, 부피는 " + Volum + "이다.";
 }
}


