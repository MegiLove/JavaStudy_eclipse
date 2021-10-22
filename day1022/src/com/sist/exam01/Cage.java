package com.sist.exam01;
class Animal{}
class Lion extends Animal{}
class Tiger extends Animal{}

public class Cage {
	private Object animal;
	
	public Object getAnimal() {
		return animal;
	}

	public void setAnimal(Object animal) {
		this.animal = animal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cage cage= new Cage();
		cage.setAnimal(new Lion());
		Lion lion=(Lion)cage.getAnimal();
		
		
		
	}

}
