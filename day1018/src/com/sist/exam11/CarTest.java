package com.sist.exam11;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Car c1= new Car();
        c1.speedUp(100);
        System.out.println(c1.TurnLeft());
        c1.speedDown(50);
        c1.printSpeed();
        
        Movable m= new Car();
        Car c= (Car)m;
	}

}
