package game;

import java.util.*;
import java.awt.Rectangle;

public class Plane {

	private int x;
	private int y;
	private int width = 88;
	private int height = 102;
	private boolean alive;
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	private int blood = 100;
	private int count = 5;
	private boolean isFirst = true;
	private boolean canL;
	private boolean canK;
	private GameStart gs;
	private LifePlane[] lives = new LifePlane[10];
	private ArrayList<Ult> ults = new ArrayList<Ult>();

	private Plane() {
		// TODO - implement Plane.Plane
		throw new UnsupportedOperationException();
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setDead() {
		alive=false;
	}
	
	public int getCount() {
		return count;
	}
	
	public void minusCount() {
		count--;
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Plane.drawMe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void keyPressed(java.awt.event.KeyEvent e) {
		// TODO - implement Plane.keyPressed
		throw new UnsupportedOperationException();
	}

	private void traceShot() {
		// TODO - implement Plane.traceShot
		throw new UnsupportedOperationException();
	}

	private void grapeShot() {
		// TODO - implement Plane.grapeShot
		throw new UnsupportedOperationException();
	}

	private void ult() {
		// TODO - implement Plane.ult
		throw new UnsupportedOperationException();
	}

	private void fire() {
		// TODO - implement Plane.fire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void keyReleased(java.awt.event.KeyEvent e) {
		// TODO - implement Plane.keyReleased
		throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement Plane.move
		throw new UnsupportedOperationException();
	}

	public Rectangle getRectangle() {
		// TODO - implement Plane.getRectangle
		throw new UnsupportedOperationException();
	}

	public Plane getInstatnce() {
		// TODO - implement Plane.getInstatnce
		throw new UnsupportedOperationException();
	}

}