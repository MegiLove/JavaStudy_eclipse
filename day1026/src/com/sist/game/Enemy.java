package com.sist.game;

public class Enemy extends GraphicObject {
	//적이 x축으로 움직이는 간격을 위한 변수
	//맨처음에는 오른쪽 끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정한다
	int dx=-10;
	
	public Enemy(String name) {
		super(name);
		x=500;
		y=0;
	}
	
	public void update() {
		x+=dx;
		
		//만약 왼쪽끝에 도달하면 오른쪽으로 이동시키기 위해 dx를 양수로 만든다
		if(x<0) {
			dx=10;
		}
		
		if(x>500) {
			dx=-10;
		}
	}

}
