package game;

public interface BulletState {

	/**
	 * 
	 * @param g
	 */
	void drawMe(java.awt.Graphics g);

	void move();

	void traceMove();

	java.awt.Rectangle getRectangle();

}