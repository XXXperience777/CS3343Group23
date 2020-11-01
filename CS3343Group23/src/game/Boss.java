package game;

import java.util.*;
import java.awt.Rectangle;

public class Boss {

	private int x;
	private int y;
	private int fx;
	private int width = 424;
	private int height = 128;
	private boolean alive;
	private int k = 1;
	private int count = 0;
	private int blood = 200;
	private java.util.Random random = new Random();
	private Collection<BulletBoss> bullets = new ArrayList<BulletBoss>();
	private fireAbstract fireMode;
	GameStart gs;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Boss(int x, int y, GameStart gs, boolean alive) {
		// TODO - implement Boss.Boss
		this.x = x;
		this.fx = x;
		this.y = y;
		this.gs = gs;
		this.alive = alive;
		
		//throw new UnsupportedOperationException();
	}

	public void isHitted() {
		// TODO - implement Boss.isHitted
		//get hit by bullet
				for (int j = 0; j < gs.plane.bullets.size(); j++) {
					Bullet pBullet = gs.plane.bullets.get(j);
					if (alive && pBullet.getRectangle().intersects(getRectangle())) {
						blood -= 10;
						checkDead();
						pBullet.alive = false;
					}
				}
				//get hit by player plane
				for (int j = 0; j < gs.plane.ults.size(); j++) {
					Ult ult = gs.plane.ults.get(j);
					if (alive && ult.getRectangle().intersects(getRectangle())) {
						blood -= 20;
						checkDead();
					}
				}
		//throw new UnsupportedOperationException();
	}

	public void checkDead() {
		// TODO - implement Boss.expolde
		if (blood <= 0 && alive) {
			alive = false;
			gs.score += 1000;
			gs.explodes.add(new Explode(x + 212, y + 64, gs, true,true));
			gs.count = 0;
			gs.level++;
			gs.bossTime+=10; //?
			gs.plane.count++;
			if (gs.plane.count>5) {
				gs.plane.count=5;
			}
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Boss.drawMe
		isHitted();
		if (alive) {
			g.setColor(Color.WHITE);
			g.drawRect(x + 117, y - 17, 200, 11);
			g.setColor(Color.RED);
			g.fillRect(x + 118, y - 16, blood - 1, 10);
			g.drawImage(gs.boosImg, x, y, width, height, null);
			move();
			if (random.nextInt(100) > 80) {
				fire();
			}
		}else {
			blood=200;
		}
		System.out.println("boss bullets:" + bullets.size());
		for (int i = 0; i < bullets.size(); i++) {
			BulletBoss bulletBoss = bullets.get(i);
			if (bulletBoss.alive) {
				bulletBoss.drawMe(g);
			} else {
				bullets.remove(i);
			}
		}
		//throw new UnsupportedOperationException();
	}
	
	private void fire() {
		// TODO Auto-generated method stub
		bullets.add(new BulletBoss(true, gs, this));
	}

	private void move() {
		// TODO - implement Boss.move
		if (x > 400 || x < -200)
			k = -k;
		x += 5 * k;
		//throw new UnsupportedOperationException();
	}

	public Rectangle getRectangle() {
		// TODO - implement Boss.getRectangle
		return new Rectangle(x, y, width, height);
		//throw new UnsupportedOperationException();
	}

}