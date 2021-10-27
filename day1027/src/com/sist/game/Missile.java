package com.sist.game;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {

	boolean launched = false;

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

		if (event.getKeyCode() == KeyEvent.VK_SPACE) {

			launched = true; // �̻����� �߻��Ű�� ���Ͽ� launched�� true�� �����Ѵ�
			this.x = x;
			this.y = y;

		}
		File file = new File("LASER.WAV");
		try {
			// ����� ������ �о���� ���� �غ� �Ѵ�
			Clip clip = AudioSystem.getClip();
			// ����� ������ �о�´�
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
		} catch (Exception e) {

		}
	}
}
