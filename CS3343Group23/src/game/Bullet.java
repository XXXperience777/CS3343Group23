package game;

import java.util.Random;

public class Bullet {

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
	private BulletState bulletState;
	GameStart gs;

	/**
	 * 
	 * @param alive
	 * @param gs
	 */
	public void BulletPlayer(boolean alive, GameStart gs) {
		// TODO - implement Bullet.BulletPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param alive
	 * @param gs
	 * @param isGrape
	 */
	public void BulletPlayer(int x, int y, boolean alive, GameStart gs, int isGrape) {
		// TODO - implement Bullet.BulletPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Bullet.drawMe
		throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement Bullet.move
		throw new UnsupportedOperationException();
	}

	private void traceMove() {
		// TODO - implement Bullet.traceMove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param d
	 */
	private double fabs(double d) {
		// TODO - implement Bullet.fabs
		throw new UnsupportedOperationException();
	}

	public java.awt.Rectangle getRectangle() {
		// TODO - implement Bullet.getRectangle
		throw new UnsupportedOperationException();
	}

}