package com.sist.game;

public class Enemy extends GraphicObject {
	//���� x������ �����̴� ������ ���� ����
	//��ó������ ������ ������ �������� �����̵��� �ϱ� ���Ͽ� ������ �����Ѵ�
	int dx=-10;
	
	public Enemy(String name) {
		super(name);
		x=500;
		y=0;
	}
	
	public void update() {
		x+=dx;
		
		//���� ���ʳ��� �����ϸ� ���������� �̵���Ű�� ���� dx�� ����� �����
		if(x<0) {
			dx=10;
		}
		
		if(x>500) {
			dx=-10;
		}
	}

}
