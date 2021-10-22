package com.sist.exam02;

import java.util.ArrayList;

class Animal {
	public void move() {

	}
}

class Lion extends Animal {
	public void move() {
		System.out.println("사자가 움직입니다");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 움직입니다");
	}
}

public class Cage {
	ArrayList<Animal> list = new ArrayList<Animal>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
		for(Animal animal:cage.list) {
			animal.move();
		}
		
	}

}
