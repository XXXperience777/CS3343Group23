package game;

import java.awt.Graphics;

import com.game.GameStart;

public class Explode {

	private int x;
	private int y;
	private int width = 96;
	private int height = 96;
	private int index = 0;
	private boolean alive;
	private boolean isBoss;
	private GameStart gs;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Explode(int x, int y, GameStart gs,boolean alive) {
		super();
		this.x = x;
		this.y = y;
		this.gs = gs;
		this.alive=alive;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 * @param isBoss
	 */
	public Explode(int x, int y, GameStart gs, boolean alive, boolean isBoss) {
		super();
		this.x = x;
		this.y = y;
		this.gs = gs;
		this.alive = alive;
		this.isBoss = isBoss;
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		if (index>=10)
			alive = false;
		if (isBoss) {
			g.drawImage(gs.boomImgs[index], x-96, y-96, width*2, height*2, null);
		}else {
			g.drawImage(gs.boomImgs[index], x, y, width, height, null);
		}
		
		index++;
		
		
	}

}