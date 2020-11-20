package game;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Enemy {

	private int x;
	private int y;
	private int fx;
	private int width = 68;
	private int height = 68;
	private boolean alive;
	private Image enemyImg;
	private Random random = new Random();
	private GameStart gs;
	private GUISetUp ui;

	/**
	 *
	 * @param x
	 * @param y
	 * @param alive
	 * @param gs
	 */
	public Enemy(int x, int y, boolean alive, GameStart gs) {

		this.setX(x);
		this.setY(y);
		this.fx=x;
		this.setAlive(alive);
		this.gs = gs;
		this.ui = gs.getUi();
		this.enemyImg=ui.getenemyImg()[random.nextInt(4)];

	}

	/**
	 *
	 * @param g
	 */
	private boolean checkShoot() {
		   return random.nextInt(100) > 97;
	}
	
	public void drawMe(Graphics g) {
		Plane plane=gs.getPlane();
		boolean isHittedByUlt=false;
		for (int j = 0; j < gs.getPlaneults().size(); j++) {
			Ult ult=gs.getPlaneults().get(j);
			if (ult.getRectangle().intersects(getRectangle())) {
				isHittedByUlt=true;
			}
		}
		boolean isCrashed=plane.isAlive() && plane.getRectangle().intersects(getRectangle());
		isHitted(checkisHitted(),isHittedByUlt,isCrashed);
		if(isAlive()){
			g.drawImage(enemyImg, getX(), getY(), width, height, null);
		}
//		else {
//			isDead();
//		}

		move();
		if(checkShoot())
			fire();
		}
	
	public void isDead() {
			gs.getExplodes().add(new Explode(getX(), getY(), gs,true));
			gs.addCount();
			gs.addScore(100);
			gs.getEnemies().remove(this);
	}

	public void fire() {

		gs.addBulletEm(this.alive, this);

	}

	public boolean checkisHitted() {
		boolean isHittedByPlane=false;
		for (int j = 0; j < gs.getBulletPl().size(); j++) {
			BulletPlayer pBullet=gs.getBulletPl().get(j);

			if (pBullet.getRectangle().intersects(this.getRectangle())) {
			    pBullet.setAlive(false);
				isHittedByPlane=true;
			}
		}
		return isHittedByPlane;
	}
	
	public void isHitted(boolean isHittedByPlane,boolean isHittedByUlt,boolean isCrashed) {
      if(isHittedByPlane) {
	   setAlive(false);
	   isDead();
}
		if(isHittedByUlt) {
			setAlive(false);
            isDead();
		}
		
		if(isCrashed){
			setAlive(false);
			isDead();
			gs.getPlane().setLife(gs.getPlane().getLife()-1);
			gs.getPlane().setCanK(false);
			gs.getPlane().setCanL(false);
			if (gs.getPlane().getLife()==0) {
				gs.getPlane().setAlive(false);
			}
		}

	}

	public Rectangle getRectangle() {

		return new Rectangle(x, y, width, height);


	}

	public void move() {

		if(fx>=500){
			setX(getX() - 3);
		}else if (fx<=100){
			setX(getX() + 3);
		}
		setY(getY() + 5);
		if(getY()>700)setAlive(false);

	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
