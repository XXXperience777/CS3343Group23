package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Enemy;
import game.Explode;
import game.GameStart;
import game.Plane;


public class BulletEm extends Bullet {

	private int x;
	private int y;
	private int width=18;
	private int height=24;
	private boolean alive;
	private GameStart gs;


	public BulletEm(boolean alive,GameStart gs,Enemy enemy) {
		super();
		
		this.y = enemy.getY()+80;
		this.x=enemy.getX()+34;
		this.setAlive(alive);
		this.gs = gs;

	}

	/**
	 *
	 * @param g
	 */
	public boolean checkisHitted() {
		boolean isHitted=false;
		Plane plane=gs.getPlane();
		if(plane.getRectangle().intersects(getRectangle())) {
			isHitted=true;
		}
		return isHitted;
	}
	
	public void drawMe(Graphics g) {
		hit(checkisHitted());
		if (isAlive()) {
			g.drawImage(gs.getUi().getBulletEm1Img(), x,y, width, height, null);		}
		move();
	}

	public void hit(boolean isHitted){
		Plane plane=gs.getPlane();
		if (plane.isAlive()&&isHitted) 
		{
			setAlive(false);
			plane.setLife(plane.getLife() - 1);
			plane.setCanK(false);
			plane.setCanL(false);
			if (plane.getLife()==0) {
				gs.addExplode(new Explode(plane.getX(), plane.getY(), gs,true));
				plane.setAlive(false);
			}

		}
	}

	public void move(){
		y+=10;
		if(y>700){
			setAlive(false);
		}
	}

	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}



}
