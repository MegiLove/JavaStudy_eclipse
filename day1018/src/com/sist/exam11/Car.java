package com.sist.exam11;

interface Movable{
	public void speedUp(int amount);
	public void speedDown(int amount);
	int speed=100;
	
	public abstract void printSpeed();
	
}

class Car implements Movable {
	int amount=0;
	
	public void speedUp(int amount) {
		this.amount=amount+speed;
	}
	public void speedDown(int amount) {
		this.amount=this.amount-amount;
	}
	public void printSpeed() {
		System.out.println("���� ���ǵ��"+amount+"�Դϴ�");
	}
	
	public String TurnLeft(){
		return "Left";
	}
	public String TurnRight(){
		return "Right";
	}
}
