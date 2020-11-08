package game;

import java.awt.Rectangle;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BulletBoss extends Bullet {

	private Boss boss;
	private boolean alive; //?
	private int x;
	private int y;
	private int width;
	private int height;
	private int fx;
	private GameStart gs;
	private Plane plane;
	private Random random = new Random();
	private int index = random.nextInt(10);
	private GUISetUp ui;
	
	public BulletBoss(boolean alive, GameStart gs, Boss boos) {
		super();
		this.y = boss.getY()+50;
		this.x = boss.getX();
		this.alive = alive;
		this.gs = gs;
		this.boss = boss;
		this.plane = gs.getPlane();
	}

	/**
	 * 
	 * @param g
	 */
	public void drawMe(Graphics g) {
		// TODO - implement BulletBoss.drawMe
		if(index >= 9){
			fx=x+20;
			height=width=34;
			g.drawImage(ui.getbulletBossImgs()[1], fx, y, width, height, null);
			y += 8;
			if (plane.alive&&plane.getRectangle().intersects(getRectangle(fx,y,34,34))) {
				alive = false;
				plane.count--;
				System.out.println("plane count:"+plane.count);
				plane.canK=false;
				if (plane.count==0) {
					gs.getExplodes().add(new Explode(plane.x, plane.y, gs, true));
					plane.alive = false;
				}
			}
		}else if(index<=3){
			height=11;
			width=13;
			fx=x+400;
			g.drawImage(ui.getbulletBossImgs()[0], x+400, y+100, height, width, null);
			move();
			if (plane.alive&&plane.getRectangle().intersects(getRectangle(fx,y+100,15,13))) {
				alive = false;
				plane.count--;
				System.out.println("plane count:"+plane.count);
				plane.canL=false;
				if (plane.count==0) {
					gs.getExplodes().add(new Explode(plane.x, plane.y, gs, true));
					plane.alive = false;
				}
			}
		}
		move();
		
		//throw new UnsupportedOperationException();
	}

	//maybe...can be removed?
	public void isHitted() {
		// TODO - implement BulletBoss.isHitted
		//throw new UnsupportedOperationException();
	}

	public void move() {
		// TODO - implement BulletBoss.move
		y += 6;
		//why dead if the bullet position is larger than 700?
		if (y > 700) {
			alive = false;
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	//dont know the meaning
	public Rectangle getRectangle(int... a) {
		// TODO - implement BulletBoss.getRectangle
		return new Rectangle(a[0],a[1],a[2],a[3]);
		//throw new UnsupportedOperationException();
	}

	//not appear in the origin version
	public void traceMove() {
		// TODO Auto-generated method stub
		
	}


}