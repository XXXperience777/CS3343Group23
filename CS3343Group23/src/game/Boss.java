package game;

import java.util.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class Boss {

	private int x;
	private int y;
	
	private int width = 424;
	private int height = 128;
	private boolean alive;
	private int k = 1; //move unit
	
	private int blood = 200;
	private Random random = new Random();
	private fireAbstract fireMode;
	private GameStart gs;
	private GUISetUp ui;

	/**
	 *
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Boss(int x, int y, GameStart gs, boolean alive) {
		this.x = x;
		
		this.y = y;
		this.gs = gs;
		this.ui=gs.getUi();
		this.setAlive(alive);
		this.fireMode=new Normal();

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
			if (isAlive() && pBullet.getRectangle().intersects(getRectangle())) {

				blood-=5;

				checkDead();
				pBullet.setAlive(false);
			}
		}
		//get hit by player plane
		for (int j = 0; j < gs.getPlaneults().size(); j++) {
			Ult ult = gs.getPlaneults().get(j);
			if (isAlive() && ult.getRectangle().intersects(getRectangle())) {
				blood -= 10;
				checkDead();
			}
		}

	}

	public void checkDead() {

		if (blood <= 0 && isAlive()) {
			setAlive(false);
			gs.addScore(1000);
			gs.getExplodes().add(new Explode(x+212, y+64,gs,true,true));
			gs.clearCount();
			gs.levelUp();
			gs.addBossTime();


//			gs.getPlane().setLife(gs.getPlane().getLife() + 1);
//			if (gs.getPlane().getLife()>5) {
//				gs.getPlane().setLife(5);
//			}
		}

	}

	/**
	 *
	 * @param g
	 */
	public void drawMe(Graphics g) {

		isHitted();
		if (isAlive()) {
			g.setColor(Color.WHITE);
			g.drawRect(x + 117, y - 17, 200, 11);
			g.setColor(Color.RED);
			g.fillRect(x + 118, y - 16, blood - 1, 10);
			g.drawImage(ui.getbossImg(), x, y, width, height, null);
			move();

			switch (fireMode.getFireMode())
			{
				case "Normal":
					if (random.nextInt(100) > 92) {
						fire();
					}
				case "Angry":
					if (random.nextInt(100) > 88) {
						fire();
					}
				case "Crazy":
					if (random.nextInt(100) > 75) {
						fire();
					}
				default:
					if (random.nextInt(100) > 90) {
						fire();
					}
			}
		}else {
			blood=200;
		}

		for (int i = 0; i < gs.getBulletBoss().size(); i++) {
			BulletBoss bulletBoss = gs.getBulletBoss().get(i);
			if (bulletBoss.getAlive()) {
				bulletBoss.drawMe(g);
			} else {
				gs.getBulletBoss().remove(i);
			}
		}

	}

	private void fire() {


		gs.addBulletBoss(alive);
	}

	private void move() {

		if (x > 400 || x < -200)
			k = -k;
		x += 5 * k;

	}

	public Rectangle getRectangle() {

		return new Rectangle(x, y, width, height);

	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}