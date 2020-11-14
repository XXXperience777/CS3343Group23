package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;




public class BulletBoss extends Bullet {

	private int x;
	private int y;
	private int width;
	private int height;
	private int fx;
	private boolean alive;
	private GameStart gs;
	
	private Plane plane;
	private Random random = new Random();
	private int index = random.nextInt(10);
    private int[] a=new int[4];
	
	public BulletBoss(boolean alive, GameStart gs, Boss boss) {
		super();
		
		this.y = boss.getY()+50;
		this.x = boss.getX();
		this.alive = alive;
		this.gs = gs;
		this.plane = gs.getPlane();
	}

	public void drawMe(Graphics g) {

		if (alive) {
			if(index >= 9){
				fx=x+20;
				height=width=25;
				g.drawImage(gs.getUi().getBulletBossImgs()[1], fx, y, width, height, null);
				y += 8;
				a[0]=fx;
				a[1]=y;
				a[2]=height;
				a[3]=width;
				if (plane.isAlive()&&plane.getRectangle().intersects(getRectangle())) {
					alive = false;
					plane.setLife(plane.getLife() - 1);

					plane.setCanK(false);
					if (plane.getLife()==0) {
						gs.addExplode(new Explode(plane.getX(), plane.getY(), gs, true));
						plane.setAlive(false);
					}
				}
			}else if(index<=3){
				height=10;
				width=15;
				fx=x+400;
				a[0]=fx;
				a[1]=y+100;
				a[2]=height;
				a[3]=width;
				g.drawImage(gs.getUi().getBulletBossImgs()[0], x+400, y+100, height, width, null);
				move();
				if (plane.isAlive()&&plane.getRectangle().intersects(getRectangle())) {
					alive = false;
					plane.setLife(plane.getLife() - 1);

					plane.setCanL(false);
					if (plane.getLife()==0) {
						gs.addExplode(new Explode(plane.getX(), plane.getY(), gs, true));
						plane.setAlive(false);
					}
				}
			}
		}
		move();
	}

	public void isHitted() {


	}

	public void move() {
		y += 6;
		if (y > 700) {
			alive = false;
		}
	}

	public boolean getAlive() {
		return alive;
	}

	public Rectangle getRectangle() {
		return new Rectangle(a[0],a[1],a[2],a[3]);
	}

}