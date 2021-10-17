package com.sist.Lab11;

abstract class Vehicle
{
 int speed=0;
 
 int printSpeed()
 {
  return speed;
 }
 
 public abstract double getKilosPerLiter();
}

class Car extends Vehicle
{
 public double getKilosPerLiter()
 {
  return 0;
 }
}



