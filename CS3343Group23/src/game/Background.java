package game;

import java.awt.Graphics;

import game.GameStart;

public class Background {

	private GameStart bg;
	private int x = 0;
	private int y = 0;
	private int y1 = 700;
	private GameStart gs;

	/**
	 * 
	 * @param gs
	 */
	public Background(GameStart gs) {
		super();
		this.gs = gs;
	}
	public void drawMe(Graphics g){
		g.drawImage(gs.bgImg,x, y, gs.width, gs.height,  null);
		g.drawImage(gs.bgImg, x, y1, gs.width, gs.height, null);
		move();
	}
	public void move(){
		y+=3;
		y1+=3;
		if(y>700){
			y=y1-700;
		}else if(y1>700){
			y1=y-700;
		}
	}

}