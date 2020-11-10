package game;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameStart;

public class Ult {

	private int x;
	private int y;
	private int width = 600;
	private int height = 10;
	private boolean alive;
	GameStart gs;

	/**
	 * 
	 * @param gs
	 * @param alive
	 */
	public Ult(GameStart gs, boolean alive) {
		super();
		this.x=0;
		this.y=gs.height;
		this.gs = gs;
		this.alive = alive;
	}
	public void drawMe(Graphics g){
		if(alive){
			g.drawImage(gs.ult, x, y, width, height, null);
		}
		move();
	}
	public void move(){
		y-=10;
		if(y<0)alive=false;
	}
	public Rectangle getRectangle(){
		return new Rectangle(x, y, width, height);
	}

}