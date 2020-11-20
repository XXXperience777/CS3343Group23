package game;

import java.util.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class Boss {

	private int x;
	private int y;
	
	private int width = 424;
	private int height = 128;
	private boolean alive;
	private int k = 1; //move unit
	
	private int blood = 200;
	private Random random = new Random();
	private fireAbstract fireMode;
	private GameStart gs;
	private GUISetUp ui;

	/**
	 *
	 * @param x
	 * @param y
	 * @param gs
	 * @param alive
	 */
	public Boss(int x, int y, GameStart gs, boolean alive) {
		this.x = x;
		
		this.y = y;
		this.gs = gs;
		this.ui=gs.getUi();
		this.setAlive(alive);
		this.fireMode=new Normal();

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void isHitted(boolean isHittedByPlane,boolean isHittedByUlt,boolean isCrashed) {

		//get hit by player bullets
		if(isHittedByPlane) {
			blood-=5;
			checkDead();
			checkMode();
		}
		//get hit by player bonus bullets
		if(isHittedByUlt) {
			blood -= 10;
			checkDead();
			checkMode();
		}
		//get hit by player plane
		if(isCrashed){
			blood -= 50;
			gs.getPlane().setAlive(false);
			gs.getPlane().setLife(0);
			checkDead();
			checkMode();
		}
		}
		
		
		public boolean checkisHitted() {
			boolean isHittedByPlane=false;
			for (int j = 0; j < gs.getBulletPl().size(); j++) {
				BulletPlayer pBullet = gs.getBulletPl().get(j);
				if (isAlive() && pBullet.getRectangle().intersects(getRectangle())) {
	             isHittedByPlane=true;
	             pBullet.setAlive(false);
				}
			}
			return isHittedByPlane;
		}

	public void checkDead() {
		if (blood <= 0 && isAlive()) {
			setAlive(false);
			gs.addScore(1000);
			gs.getExplodes().add(new Explode(x+212, y+64,gs,true,true));
			gs.clearCount();
			gs.levelUp();
			gs.addBossTime();
			
			//test 
			System.out.println("bossTime: "+gs.getBossTime());

		}

	}

	public void checkMode() {
		if (blood >= 60 && isAlive()) {
			fireMode=new Normal();
		}
		else if (blood >= 20) {
			fireMode=new Angry();
		}
		else if (blood >0 && isAlive()) {
			fireMode=new Crazy();
		}
	}

	private boolean checkNormal() {
		   return random.nextInt(100) > 95;
	}
	private boolean checkAngry() {
		   return random.nextInt(100) > 92;
	}
	private boolean checkCrazy() {
		   return random.nextInt(100) > 88;
	}
	
	public void drawMe(Graphics g) {
		Plane plane=gs.getPlane();
		boolean isCrashed=plane.isAlive() && plane.getRectangle().intersects(getRectangle());
		boolean isHittedByUlt=false;
		for (int j = 0; j < gs.getPlaneults().size(); j++) {
			Ult ult = gs.getPlaneults().get(j);
			if (isAlive() && ult.getRectangle().intersects(getRectangle())) {
				isHittedByUlt=true;
			}
		}
		isHitted(checkisHitted(),isHittedByUlt,isCrashed);
		if (isAlive()) {
			g.setColor(Color.WHITE);
			g.drawRect(x + 117, y - 17, 200, 11);
			g.setColor(Color.RED);
			g.fillRect(x + 118, y - 16, blood - 1, 10);
			g.drawImage(ui.getbossImg(), x, y, width, height, null);
			move();

			switch (fireMode.getFireMode())
			{
				case "Normal":
					if (checkNormal()) {
						fire();
					}
				case "Angry":
					if (checkAngry()) {
						fire();
					}
				case "Crazy":
					if (checkCrazy()) {
						fire();
					}
				default:
					if (checkNormal()) {
						fire();
					}
			}
		}else {
			blood=200;
		}

		for (int i = 0; i < gs.getBulletBoss().size(); i++) {
			BulletBoss bulletBoss = gs.getBulletBoss().get(i);
			if (bulletBoss.getAlive()) {
				bulletBoss.drawMe(g);
			} else {
				gs.getBulletBoss().remove(i);
			}
		}

	}

	public void fire() {


		gs.addBulletBoss(alive);
	}

	private void move() {

		if (x > 400 || x < -200)
			k = -k;
		x += 5 * k;

	}
    
	public fireAbstract getFireMode() {
		return fireMode;
	}
	
	public Rectangle getRectangle() {

		return new Rectangle(x, y, width, height);

	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setBlood(int blood) {
		this.blood=blood;
	}

	public int getBlood() {
		return blood;
	}
	
}

