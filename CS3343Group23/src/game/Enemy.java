package game;

import java.util.Random;

public class Enemy {

	private int x;
	private int y;
	private int fx;
	private int width = 68;
	private int height = 68;
	private boolean alive;
	private java.awt.Image enemyImg;
	private int k = 1;
	private java.util.Random random = new Random();
	GameStart gs;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param alive
	 * @param gs
	 */
	public Enemy(int x, int y, boolean alive, GameStart gs) {
		// TODO - implement Enemy.Enemy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Enemy.drawMe
		throw new UnsupportedOperationException();
	}

	public void fire() {
		// TODO - implement Enemy.fire
		throw new UnsupportedOperationException();
	}

	public void isHitted() {
		// TODO - implement Enemy.isHitted
		throw new UnsupportedOperationException();
	}

	public java.awt.Rectangle getRectangle() {
		// TODO - implement Enemy.getRectangle
		throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement Enemy.move
		throw new UnsupportedOperationException();
	}

}