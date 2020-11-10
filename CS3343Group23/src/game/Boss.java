package game;

import java.util.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

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
	private fireAbstract fireMode;
	private GameStart gs;
	private GUISetUp ui;
	private ArrayList<BulletBoss> myBullets=gs.getBulletBoss();

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
		
	
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void isHitted() {
		
		for (int j = 0; j < gs.getBulletPl().size(); j++) {
			BulletPlayer pBullet = gs.getBulletPl().get(j);
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
				pBullet.getAlive() = false;
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
		
	}

	public void checkDead() {
	
		if (blood <= 0 && alive) {
			alive = false;
			gs.addScore(1000);
			gs.getExplodes().add(new Explode(x+212, y+64,gs,true,true));
			gs.clearCount();
			gs.levelUp();
			gs.bossTime+=10; 
			//need to modify in class plane
			gs.getPlane().setCount(gs.getPlane().getCount() + 1);
			if (gs.getPlane().getCount()>5) {
				gs.getPlane().setCount(5);
			}
		}
		
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
	
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
		System.out.println("boss bullets:" + myBullets.size());
		for (int i = 0; i < myBullets.size(); i++) {
			BulletBoss bulletBoss = myBullets.get(i);
			if (bulletBoss.alive) {
				bulletBoss.drawMe(g);
			} else {
				myBullets.remove(i);
			}
		}
		
	}
	
	private void fire() {
	
		//check alive or not?
		BulletBoss bulletBoss=new BulletBoss(true, gs, this);
		gs.getBulletBoss().add(bulletBoss);
	}

	private void move() {
	
		if (x > 400 || x < -200)
			k = -k;
		x += 5 * k;

	}

	public Rectangle getRectangle() {
	
		return new Rectangle(x, y, width, height);
	
	}

}