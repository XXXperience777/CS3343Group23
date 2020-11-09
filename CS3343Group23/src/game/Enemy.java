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
	private int k = 1;
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
		// TODO - implement Enemy.Enemy
		this.x = x;
		this.y = y;
		this.fx=x;
		this.alive = alive;
		this.gs = gs;
		this.enemyImg=ui.getenemyImg()[random.nextInt(4)];
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Enemy.drawMe
		isHitted();
		if(alive){
			g.drawImage(enemyImg, x, y, width, height, null);
		}else {
			gs.getExplodes().add(new Explode(x, y, gs,true));
			gs.addCount();
			gs.addScore(100);
			gs.getEnemies().remove(this);
		}
	
		move();
		if(random.nextInt(100)>97)
			fire();
		
		//throw new UnsupportedOperationException();
	}

	public void fire() {
		// TODO - implement Enemy.fire
		BulletEm bulletEm=new BulletEm(true, gs, this);
		gs.getBulletEm().add(bulletEm);
		//throw new UnsupportedOperationException();
	}

	public void isHitted() {
		// TODO - implement Enemy.isHitted
		for (int j = 0; j < gs.getBulletPl().size(); j++) {
			BulletPlayer pBullet=gs.getBulletPl().get(j);
			if (pBullet.getRectangle().intersects(getRectangle())) {
				alive=false;
				pBullet.alive=false;
			}
		}
		for (int j = 0; j < gs.getPlane().ults.size(); j++) {
			Ult ult=gs.getPlane().ults.get(j);
			if (ult.getRectangle().intersects(getRectangle())) {
				alive=false;
			}
		}
		Plane plane=gs.getPlane();
		if(plane.getAlive() && plane.getRectangle().intersects(getRectangle())){
			alive=false;
			plane.minusCount();
			if (plane.getCount()==0) {
				plane.setDead();
			}
			
		}
		//throw new UnsupportedOperationException();
	}

	public Rectangle getRectangle() {
		// TODO - implement Enemy.getRectangle
		return new Rectangle(x, y, width, height);
		
		//throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement Enemy.move
		if(fx>=500){
			x-=3;
		}else if (fx<=100){
			x+=3;
		}
		y+=5;
		if(y>700)alive=false;
		//throw new UnsupportedOperationException();
	}

}