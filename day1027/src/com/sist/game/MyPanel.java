package com.sist.game;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;

//적,미사일, 우주선을 동시에 담을 수 있는 패널 클래스를 만든다
//또, 패널에 키보드가 눌러지는 이벤트를 처리하기 위하여 keyListener도 구현한다
public class MyPanel extends JPanel implements KeyListener{
	
	//적,미사일,우주선을 패널의 맴버변수로 선언합니다
	
	//여러개의 적을 만들기 위해 ArrayList를 만든다
	
	ArrayList<Enemy> enemyList;
	SpaceShip spaceship;
	Missile missile;
	
	//생성자에 즉, 패널이 생성되고 동시에 동작하여
	public MyPanel() {
		super();
		this.addKeyListener(this); //패널의 키보드 이벤트를 등록한다
		this.requestFocus(); //패널의 키보드 요청을 설정한다	A
		setFocusable(true); //패널의 포커스를 설정한다		B
		//화면구성요소중에 원래 키보드로부터 입력을 받아들이는 용도가 아니기 때문에
		//키보드로부터 입력을 받아들이게 하려면 "패널"에 일단은 "포커스"를 설정해야 한다
		
		//여러개의 적을 담기 위한 ArrayList객체를 생성한다
		
		enemyList= new ArrayList<Enemy>();
		
		//적을 5개 만들어 리스트에 담는다
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		enemyList.add(new Enemy("enemy.png"));
		//enemy= new Enemy("enemy.png"); //이미지파일명을 갖고 객체를 생성한다
		spaceship= new SpaceShip("spaceship.png");
		missile= new Missile("missile.png");
		
		//패널의 구성요소인 적,미사일, 우주선이 서로 독립적으로(동시에,공평하게)움직이도록 하기 위해
		//멀티쓰레드를 만든다
		//적,미사일,우주선을 독립적으로 움직이게 하는 기능은 여기 패널에서만 필요하다
		//이럴 때에 클래스를 클래스 안에 만든다
		//이것을 inner class라고 한다
		
		class MyThread extends Thread{	//Thread클래스를 상속받아 멀티쓰레드를 구현한다
			public void run() {			//run을 오버라이딩하여 동시에 실행시킬 명령어를 쓴다
				while(true) {		//계속 3객체가 움직이게 하기 위해 while(true)를 사용한다
					
					missile.update();
					
					//리스트에 담긴 적의 수만큼 반복하여 위치를 변경한다
					for(Enemy enemy:enemyList) {
						enemy.update();
						enemy.crush(missile);
					}
					
					//enemy.update(); //적을 움직이게 하기 위해 적의 위치를 변경하는 메소드를 호출한다
					//spaceship.update(); //우주선은 키보드가 움직이는 방향으로 한 번 움직여서 호출 할 필요없다
					
					//missile.update();
					
					//적이 미사일에 맞았는지 판별하여 없애는 메소드를 호출한다
					//enemy.crush(missile);
					
					repaint(); //적,미사일, 우주선의 변경된 위치에 다시 그리기 위한 요청을 한다
								//화면에 그래픽을 그려주는 메소드는 paintComponent메소드이다
								//사용자가 직접 paintComponent를 호출할 수는 없고
								//repaint를 호출하여 paintComponent를 동작시킬 수 있다
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}// 3개를 서로 독립적으로 움직이게 만든 멀티쓰레드 객체 MyThread를 생성한다
		Thread t= new MyThread();
		//쓰레드를 가동한다
		t.start();
	}
	//3개를 변경된 위치에 그래픽을 다시 그려준다
	//패널에 그래픽을 표현하기 위해 paintComponent를 오버라이딩한다
	//이를 매개변수로 전달받은 Graphics에 그래픽을 표현하기 위한 다양한 메소드들이 있다
	public void paint(Graphics g) {
		super.paint(g);
		//여러개의 적이 담겨있는 리스트의 수만큼 반복하여 적을 다시 그려준다
		for(Enemy enemy:enemyList) {
			enemy.draw(g);
		}
		//enemy.draw(g);
		spaceship.draw(g);
		missile.draw(g);		
	}
	//패널에서 키보드가 눌러지면
	public void keyPressed(KeyEvent event) {
		spaceship.keyPressed(event); //눌러진 키보드이벤트의 정보를 우주선에 전달한다
		missile.keyPressed(event, spaceship.x, spaceship.y);
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
