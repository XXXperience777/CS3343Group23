package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;


public class BulletPlayer extends Bullet {
	private int x;
	private int y;
	private double speed = 10;
	private int width = 6;
	private int height = 8;
	private boolean alive;
	private int bType;
	private double pi = Math.PI;
	private java.util.Random ran = new Random();
	private double delta;
	private GameStart gs;

	/**
	 * 
	 * @param alive
	 * @param gs
	 */
	public BulletPlayer(boolean alive, GameStart gs) {
		super();
		this.x = gs.getPlane().getX() + 44;
		this.y = gs.getPlane().getY() - 10;
		this.setAlive(alive);
		this.gs = gs;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param alive
	 * @param gs
	 * @param isGrape
	 */
	public BulletPlayer(int x, int y, boolean alive, GameStart gs, int isGrape) {
		super();
		this.x = x;
		this.y = y;
		this.setAlive(alive);
		this.gs = gs;
		this.bType = isGrape;
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		g.drawImage(gs.getUi().getBulletImgs()[0], x, y, width, height, null);
		move();
	}

	public void move() {
		switch (bType) {
		case 1:
			x -= 2;
			y -= 6;
			break;
		case 2:
			y -= 6;
			break;
		case 3:
			x += 2;
			y -= 6;
			break;
		case 4:
			traceMove();
			break;
		default:
			y -= 5;
			break;
		}
		if (y < 0||y>=700) {
			setAlive(false);
		}
	}

	private void traceMove() {
	
				int eSize = gs.getEnemies().size();
				if (eSize > 0) {
					Enemy enemy = gs.getEnemies().get(0);
					double deltax = enemy.getX() - x;
					double deltay = enemy.getY() - y;
					if (deltax == 0) {
						if (enemy.getY()>=y ) 
							deltax = 0.0000001;
						else
							deltax = -0.0000001;
					}
					if (deltay == 0) {
						if (enemy.getX()>=x) 
							deltay = 0.0000001;
						else
							deltay = -0.0000001;
					}
					if( deltax>0 && deltay>0 )
						delta = Math.atan(fabs(deltay / deltax)); 
					else if( deltax<0 && deltay>0 )
						delta = pi - Math.atan(fabs(deltay / deltax)); 
					else if( deltax<0 && deltay<0 )  
						delta = pi + Math.atan(fabs(deltay/deltax)); 
					else
						delta = 2*pi - Math.atan(fabs(deltay/deltax));
					System.out.println("delta:"+delta);
					x += speed * Math.cos(delta);
					y += speed * Math.sin(delta);
				}else {
					y-=5;
				}
	}

	/**
	 * 
	 * @param d
	 */
	private double fabs(double d) {
		if (d < 0) {
			d = -d;
		}
		return d;
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