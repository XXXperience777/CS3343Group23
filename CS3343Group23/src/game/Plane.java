package game;

import java.util.*;

import game.Bullet;
import game.GameStart;
import game.LifePlane;
import game.Ult;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane {

	private int x;
	private int y;
	private int width = 88;
	private int height = 102;
	private boolean alive;
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	private int blood = 100;
	private int count = 5;
	private boolean isFirst = true;
	private boolean canL;
	private boolean canK;
	private GameStart gs;
	private LifePlane[] lives = new LifePlane[10];
	private ArrayList<Ult> ults = new ArrayList<Ult>();
	private List<Bullet> bullets = new ArrayList<Bullet>();
	
	public Plane(int x, int y, boolean alive, GameStart gs) {
		super();
		this.x = x;
		this.y = y;
		this.alive = alive;
		this.gs = gs;
	}
	public Plane(boolean alive) {
		super();
		this.alive = alive;
	}

	public void drawMe(Graphics g) {
		if (alive) {
			int index=0;
			System.out.println("count:"+count);
			for (int i = 0; i < count; i++) {
				lives[i]=new LifePlane(index, 40, gs, true);
				index+=30;
			}
			if(canK){
				g.drawImage(gs.foodImgs[1], 20, 620, 29, 26, null);
			}
			if (canL) {
				g.drawImage(gs.foodImgs[0], 60, 620, 29, 26, null);
			}
			if (canK&&canL) {
				g.drawString("����׼������", 20, 600);
			}
			g.drawImage(gs.planeImg, x, y, width, height, null);
		}else {
			if(isFirst){
				g.drawImage(gs.startImg, 0, 0, 600, 700, null);
				return;
			}
			g.drawImage(gs.continueImg, 150,250, 300, 200, null);
		}
		
		System.out.println("ǰ��" + bullets.size());
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (bullet.alive&&alive) {
				bullet.drawMe(g);
			} else {
				bullets.remove(i);
			}
		}
		for (int i = 0; i < ults.size(); i++) {
			Ult ult=ults.get(i);

			if (ult.alive) {
				ult.drawMe(g);
			} else {
				ults.remove(i);
			}
		}
		for (int i = 0; i < count; i++) {
			LifePlane life=lives[i];
			if (alive) {
				life.drawMe(g);
			}
		}
		move();
	}

	public void keyPressed(KeyEvent e) {
	
		if (alive) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				isUp = true;
				break;
			case KeyEvent.VK_S:
				isDown = true;
				break;
			case KeyEvent.VK_A:
				isLeft = true;
				break;
			case KeyEvent.VK_D:
				isRight = true;
				break;
			case KeyEvent.VK_J:
				if (alive)
					fire();
				break;
			case KeyEvent.VK_U:
				if(alive&&canK&&canL){
					ult();
				}
				break;
			case KeyEvent.VK_L:
				if (alive&&canL) {
					grapeShot();
				}
				break;
			case KeyEvent.VK_K:
				if (alive&&canK) {
					traceShot();
				}
			}
		}



	}
	private void traceShot() {
		
		bullets.add(new BulletPlayer(x+44, y-20, true, gs,4) );
	}
	private void grapeShot() {
	
		bullets.add(new BulletPlayer(x+22, y-20, true, gs, 1) );
		bullets.add(new BulletPlayer(x+12, y-20, true, gs, 1) );
		bullets.add(new BulletPlayer(x+40, y-20, true, gs, 2));
		bullets.add(new BulletPlayer(x+50, y-20, true, gs, 2));
		bullets.add(new BulletPlayer(x+66, y-20, true, gs, 3));
		bullets.add(new BulletPlayer(x+76, y-20, true, gs, 3));
	}
	private void ult() {
		// TODO Auto-generated method stub
		ults.add(new Ult(gs, true));
		canL=canK=false;
	}
	private void fire() {
	
		bullets.add(new BulletPlayer(true, gs));
	}

	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {

		case KeyEvent.VK_W:
			isUp = false;
			break;
		case KeyEvent.VK_S:
			isDown = false;

			break;
		case KeyEvent.VK_A:
			isLeft = false;
			break;
		case KeyEvent.VK_D:
			isRight = false;
			break;
		}
	}

	public void move() {
		if (isUp && !isDown && !isLeft && !isRight) {
			y -= 8;
			if (y < 25) {
				y = 25;
			}
		} else if (!isUp && isDown && !isLeft && !isRight) {
			y += 8;
			if (y > 600) {
				y = 600;
			}
		} else if (!isUp && !isDown && isLeft && !isRight) {
			x -= 5;
			if (x < 0) {
				x = 0;
			}
		} else if (!isUp && !isDown && !isLeft && isRight) {
			x += 8;
			if (x > 512) {
				x = 512;
			}
		} else if (isUp && !isDown && isLeft && !isRight) {
			x -= 5;
			y -= 8;
			if (x < 0) {
				x = 0;
			}
			if (y < 25) {
				y = 25;
			}
		} else if (isUp && !isDown && !isLeft && isRight) {
			x += 5;
			y -= 5;
			if (x > 512) {
				x = 512;
			}
			if (y < 25) {
				y = 25;
			}
		} else if (!isUp && isDown && isLeft && !isRight) {
			x -= 5;
			y += 8;
			if (x < 0) {
				x = 0;
			}
			if (y > 600) {
				y = 600;
			}
		} else if (!isUp && isDown && !isLeft && isRight) {
			x += 5;
			y += 8;
			if (x > 512) {
				x = 512;
			}
			if (y > 600) {
				y = 600;
			}
		}
	}

	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

}