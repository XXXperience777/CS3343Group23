package game;

import java.util.*;

public class Boss {

	private int x;
	private int y;
	private int fx;
	private int width = 424;
	private int height = 128;
	private boolean alive;
	private int k = 1;
	private int count = 0;
	private int blood = 200;
	private java.util.Random random = new Random();
	private Collection<BulletBoss> bullets = new ArrayList<BulletBoss>();
	private fireAbstract fireMode;
	GameStart gs;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Boss(int x, int y, GameStart gs, boolean alive) {
		// TODO - implement Boss.Boss
		throw new UnsupportedOperationException();
	}

	public void isHitted() {
		// TODO - implement Boss.isHitted
		throw new UnsupportedOperationException();
	}

	public void expolde() {
		// TODO - implement Boss.expolde
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Boss.drawMe
		throw new UnsupportedOperationException();
	}

	private void move() {
		// TODO - implement Boss.move
		throw new UnsupportedOperationException();
	}

	public java.awt.Rectangle getRectangle() {
		// TODO - implement Boss.getRectangle
		throw new UnsupportedOperationException();
	}

}