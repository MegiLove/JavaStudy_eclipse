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

			launched = true; // 미사일을 발사시키기 위하여 launched에 true를 설정한다
			this.x = x;
			this.y = y;

		}
		File file = new File("LASER.WAV");
		try {
			// 오디오 파일을 읽어오기 위한 준비를 한다
			Clip clip = AudioSystem.getClip();
			// 오디오 파일을 읽어온다
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.start();
		} catch (Exception e) {

		}
	}
}
