package game;

import java.util.*;

import game.Bullet;
import game.GameStart;
import game.LifePlane;
import game.Ult;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane {

	private int x;
	private int y;
	private int width = 88;
	private int height = 102;
	private boolean alive;
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	private int blood = 100;
	private int count = 5;
	private boolean isFirst = true;
	private boolean canL;
	private boolean canK;
	private GameStart gs;
	private LifePlane[] lives = new LifePlane[10];
	private ArrayList<Ult> ults = new ArrayList<Ult>();
	//private List<BulletPlayer> bullets = new ArrayList<BulletPlayer>();
	private Command a=new A();
	private Command w=new W();
	private Command s=new S();
	private Command d=new D();
	private Command j=new J();
	private Command k=new K();
	private Command l=new L();
	private Command u=new U();
	
	public Plane(int x, int y, boolean alive, GameStart gs) {
		super();
		this.setX(x);
		this.setY(y);
		this.setAlive(alive);
		this.gs = gs;
		
	}
	public Plane(boolean alive) {
		super();
		this.setAlive(alive);
	}

	public void drawMe(Graphics g) {
		GUISetUp ui=this.gs.getUi();
		if (isAlive()) {
			int index=0;
			System.out.println("count:"+getCount());
			for (int i = 0; i < getCount(); i++) {
				lives[i]=new LifePlane(index, 40, ui, true);
				index+=30;
			}
			if(isCanK()){
				g.drawImage(ui.getFoodImgs()[1], 20, 620, 29, 26, null);
			}
			if (isCanL()) {
				g.drawImage(ui.getFoodImgs()[0], 60, 620, 29, 26, null);
			}
			if (isCanK()&&isCanL()) {
				g.drawString("U", 20, 600);
			}
			Image planeImg;
			if (isLeft) {
				planeImg = ui.getPlaneImg_1();
			} else if (isRight) {
				planeImg = ui.getPlaneImg_2();
			} else {
				planeImg = ui.getPlaneImg_3();
			}
			g.drawImage(planeImg, getX(), getY(), width, height, null);
			
			
		}else {
			if(isFirst()){
				g.drawImage(ui.getStartImg(), 0, 0, 600, 700, null);
				return;
			}
			g.drawImage(ui.getContinueImg(), 150,250, 300, 200, null);
		}
		
		//System.out.println("size:" + bullets.size());
		for (int i = 0; i < gs.getBulletPl().size(); i++) {
			BulletPlayer bullet = gs.getBulletPl().get(i);
			if (bullet.isAlive()&&isAlive()) {
				bullet.drawMe(g);
			} else {
				gs.getBulletPl().remove(i);
			}
		}
		for (int i = 0; i < ults.size(); i++) {
			Ult ult=ults.get(i);

			if (ult.isAlive()) {
				ult.drawMe(g);
			} else {
				ults.remove(i);
			}
		}
		for (int i = 0; i < getCount(); i++) {
			LifePlane life=lives[i];
			if (isAlive()) {
				life.drawMe(g);
			}
		}
		move();
	}

	public void keyPressed(KeyEvent e) {
	
		if (isAlive()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				this.w.pressKey(this);
				break;
			case KeyEvent.VK_S:
				this.s.pressKey(this);
				break;
			case KeyEvent.VK_A:
				this.a.pressKey(this);
				break;
			case KeyEvent.VK_D:
				this.d.pressKey(this);
				break;
			case KeyEvent.VK_J:
				if (isAlive())
					this.j.pressKey(this);
				break;
			case KeyEvent.VK_U:
				if(isAlive()&&isCanK()&&isCanL()){
					
					this.u.pressKey(this);
				}
				break;
			case KeyEvent.VK_L:
				if (isAlive()&&isCanL()) {
					this.l.pressKey(this);
				}
				break;
			case KeyEvent.VK_K:
				if (isAlive()&&isCanK()) {
					this.k.pressKey(this);
					
				}
				break;
			}
		}



	}
	
	public void addBullet(BulletPlayer bullet)
	{
		gs.addBulletPl(this.alive);
	}
	
	public  void ult() {
		
		ults.add(new Ult(getGs(), true));
		setCanL(setCanK(false));
	}
	
	public ArrayList<Ult> getults() {
		return this.ults;
	}
	
	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {

		case KeyEvent.VK_W:
			this.w.releaseKey(this);
			break;
		case KeyEvent.VK_S:
			this.s.releaseKey(this);

			break;
		case KeyEvent.VK_A:
			this.a.releaseKey(this);
			break;
		case KeyEvent.VK_D:
			this.d.releaseKey(this);
			break;
		case KeyEvent.VK_J:
			if (isAlive())
				this.j.releaseKey(this);
			break;
		case KeyEvent.VK_U:
			if(isAlive()&&isCanK()&&isCanL()){
				
				this.u.releaseKey(this);
			}
			break;
		case KeyEvent.VK_L:
			if (isAlive()&&isCanL()) {
				this.l.releaseKey(this);
			}
			break;
		case KeyEvent.VK_K:
			if (isAlive()&&isCanK()) {
				this.k.releaseKey(this);
				
			}
			break;
		}
	}

	public void move() {
		if (isUp && !isDown && !isLeft() && !isRight()) {
			setY(getY() - 8);
			if (getY() < 25) {
				setY(25);
			}
		} else if (!isUp && isDown && !isLeft() && !isRight()) {
			setY(getY() + 8);
			if (getY() > 600) {
				setY(600);
			}
		} else if (!isUp && !isDown && isLeft() && !isRight()) {
			setX(getX() - 5);
			if (getX() < 0) {
				setX(0);
			}
		} else if (!isUp && !isDown && !isLeft() && isRight()) {
			setX(getX() + 8);
			if (getX() > 512) {
				setX(512);
			}
		} else if (isUp && !isDown && isLeft() && !isRight()) {
			setX(getX() - 5);
			setY(getY() - 8);
			if (getX() < 0) {
				setX(0);
			}
			if (getY() < 25) {
				setY(25);
			}
		} else if (isUp && !isDown && !isLeft() && isRight()) {
			setX(getX() + 5);
			setY(getY() - 5);
			if (getX() > 512) {
				setX(512);
			}
			if (getY() < 25) {
				setY(25);
			}
		} else if (!isUp && isDown && isLeft() && !isRight()) {
			setX(getX() - 5);
			setY(getY() + 8);
			if (getX() < 0) {
				setX(0);
			}
			if (getY() > 600) {
				setY(600);
			}
		} else if (!isUp && isDown && !isLeft() && isRight()) {
			setX(getX() + 5);
			setY(getY() + 8);
			if (getX() > 512) {
				setX(512);
			}
			if (getY() > 600) {
				setY(600);
			}
		}
	}

	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), width, height);
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	public boolean isRight() {
		return isRight;
	}
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}
	public GameStart getGs() {
		return gs;
	}
	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}
	public boolean isCanL() {
		return canL;
	}
	public boolean isCanK() {
		return canK;
	}
	public void setCanL(boolean canL) {
		this.canL = canL;
	}
	public boolean setCanK(boolean canK) {
		this.canK = canK;
		return canK;
	}

}