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
	private int width=3;
	private int height=4;
	private boolean alive;
	private GameStart gs;
	private Enemy enemy;
	private Graphics g;
	
	public BulletEm(boolean alive,GameStart gs,Enemy enemy) {
		super();
		this.y = enemy.y+80;
		this.x=enemy.x+34;
		this.alive = alive;
		this.gs = gs;
		this.enemy=enemy;
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		isHitted();
		if (alive) {
			g.drawImage(gs.bulletEm1Img, x,y, width, height, null);
		}
		move();
	}

	public void isHitted(){
		Plane plane=gs.plane;
		if (plane.isAlive()&&plane.getRectangle().intersects(getRectangle())) {
			alive=false;
			plane.setCount(plane.getCount() - 1);
			plane.canK=false;
			plane.canL=false;
			if (plane.getCount()==0) {
				gs.explodes.add(new Explode(plane.getX(), plane.getY(), gs,true));
				plane.setAlive(false);
			}
			
		}
	}

	public void move(){
		y+=8;
		if(y>700){
			alive=false;
		}
	}
	public void ult(){
		
	}
	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
	}

	

}