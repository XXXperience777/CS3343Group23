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

		isHitted();
		if(isAlive()){
			g.drawImage(enemyImg, getX(), getY(), width, height, null);
		}else {
			gs.getExplodes().add(new Explode(getX(), getY(), gs,true));
			gs.addCount();
			gs.addScore(100);
			gs.getEnemies().remove(this);
		}

		move();
		if(checkShoot())
			fire();

	}

	public void fire() {

		gs.addBulletEm(this.alive, this);

	}

	public void isHitted() {


		for (int j = 0; j < gs.getBulletPl().size(); j++) {
			BulletPlayer pBullet=gs.getBulletPl().get(j);

			if (pBullet.getRectangle().intersects(this.getRectangle())) {
				setAlive(false);
				pBullet.setAlive(false);
			}
		}
		for (int j = 0; j < gs.getPlaneults().size(); j++) {
			Ult ult=gs.getPlaneults().get(j);
			if (ult.getRectangle().intersects(getRectangle())) {
				setAlive(false);

			}
		}
		Plane plane=gs.getPlane();
		if(plane.isAlive() && plane.getRectangle().intersects(getRectangle())){
			setAlive(false);
			plane.setLife(plane.getLife()-1);
			if (plane.getLife()==0) {
				plane.setAlive(false);
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