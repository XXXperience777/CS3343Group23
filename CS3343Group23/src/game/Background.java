package game;

import java.awt.Graphics;

import game.GameStart;

public class Background {


	private int x = 0;
	private int y = 0;
	private int y1 = 700;
	private GUISetUp gs;

	/**
	 *
	 * @param gs
	 */
	public Background(GUISetUp gs) {
		super();
		this.gs = gs;
	}
	public void drawMe(Graphics g){
		g.drawImage(gs.getBgImg(),x, y, gs.getWidth(), gs.getHeight(),  null);
		g.drawImage(gs.getBgImg(), x, y1, gs.getWidth(), gs.getHeight(), null);
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