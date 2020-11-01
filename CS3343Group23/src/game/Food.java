package game;

import java.util.Random;

public class Food {

	int x;
	int y;
	int width = 34;
	int height = 36;
	boolean alive;
	int index;
	int k = 1;
	int fx1;
	int fx2;
	java.util.Random random = new Random();
	GameStart gs;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Food(int x, int y, GameStart gs, boolean alive) {
		// TODO - implement Food.Food
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(java.awt.Graphics g) {
		// TODO - implement Food.drawMe
		throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement Food.move
		throw new UnsupportedOperationException();
	}

	public void isEaten() {
		// TODO - implement Food.isEaten
		throw new UnsupportedOperationException();
	}

	public java.awt.Rectangle getRectangle() {
		// TODO - implement Food.getRectangle
		throw new UnsupportedOperationException();
	}

}