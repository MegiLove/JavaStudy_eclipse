package com.sist.game;

import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {

	boolean launched;

	public Missile(String name) {
		super(name);
	}

	public void update() {
		if (launched) {
			y -= 20;
		}
		if (y < -100) {
			launched = false;
		}

	}

	public void keyPressed(KeyEvent event, int x, int y) {
		
		if(event.getKeyCode()== KeyEvent.VK_SPACE) {
			
			launched= true; //�̻����� �߻��Ű�� ���Ͽ� launched�� true�� �����Ѵ�
			this.x=x;
			this.y=y;
		}
	}
}
