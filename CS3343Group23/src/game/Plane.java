package game;

import java.util.*;

public class Plane {

	int x;
	int y;
	int width = 88;
	int height = 102;
	boolean alive;
	boolean isUp;
	boolean isDown;
	boolean isLeft;
	boolean isRight;
	int blood = 100;
	int count = 5;
	boolean isFirst = true;
	boolean canL;
	boolean canK;
	GameStart gs;
	LifePlane[] lives = new LifePlane[10];
	public Collection<Bullet> bullets = new ArrayList<Bullet>();
	public Collection<Ult> ults = new ArrayList<Ult>();

	private Plane() {
		// TODO - implement Plane.Plane
		throw new UnsupportedOperationException();
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

	public java.awt.Rectangle getRectangle() {
		// TODO - implement Plane.getRectangle
		throw new UnsupportedOperationException();
	}

	public Plane getInstatnce() {
		// TODO - implement Plane.getInstatnce
		throw new UnsupportedOperationException();
	}

}