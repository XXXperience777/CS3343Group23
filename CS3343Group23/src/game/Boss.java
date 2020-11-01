package game;

import java.util.*;
import java.awt.Color;
import java.awt.Rectangle;

public class Boss {

	private int x;
	private int y;
	private int fx;
	private int width = 424;
	private int height = 128;
	private boolean alive;
	private int k = 1; //move unit
	private int count = 0;
	private int blood = 200;
	private Random random = new Random();
	private Collection<BulletBoss> bullets = new ArrayList<BulletBoss>();
	private fireAbstract fireMode;
	GameStart gs;
	GUISetUp ui;

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
		for (int j = 0; j < gs.getPlane().bullets.size(); j++) {
			Bullet pBullet = gs.getPlane().bullets.get(j);
			if (alive && pBullet.getRectangle().intersects(getRectangle())) {
				switch (fireMode.getMode())
				{
					case 1: 
						blood -= 10;
					case 2: 
						blood -= 20;
					default:
						blood -= 10;
				}
				
				checkDead();
				pBullet.alive = false;
			}
		}
		//get hit by player plane
		for (int j = 0; j < gs.getPlane().ults.size(); j++) {
			Ult ult = gs.getPlane().ults.get(j);
			if (alive && ult.getRectangle().intersects(getRectangle())) {
				blood -= 50;
				checkDead();
			}
		}
		//throw new UnsupportedOperationException();
	}

	public void checkDead() {
		// TODO - implement Boss.expolde
		if (blood <= 0 && alive) {
			alive = false;
			gs.addScore(1000);
			gs.getExplodes().add(new Explode(x+212, y+64,gs,true,true));
			gs.clearCount();
			gs.levelUp();
			gs.bossTime+=10; //?
			//need to modify in class plane
			gs.getPlane().count++;
			if (gs.getPlane().count>5) {
				gs.getPlane().count=5;
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
			g.drawImage(ui.getbossImg(), x, y, width, height, null);
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