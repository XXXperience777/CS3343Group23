package game;

import java.awt.Graphics;

public class LifePlane {

	private int x;
	private int y;
	private int width = 25;
	private int height = 21;
	private boolean alive;
	public GUISetUp ui;

	/**
	 *
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public LifePlane(int x, int y, GUISetUp ui, boolean alive) {
		super();
		this.x = x;
		this.y = y;
		this.ui = ui;
		this.alive = alive;
	}

	/**
	 *
	 * @param g
	 */
	public void drawMe(Graphics g) {
		g.drawImage(ui.getLifePlaneImg(), x, y, width, height, null);
	}

}