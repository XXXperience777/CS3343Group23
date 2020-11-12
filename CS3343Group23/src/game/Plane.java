package game;

import java.util.*;

import game.Bullet;
import game.GameStart;
import game.LifePlane;
import game.Ult;

import java.awt.Graphics;
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
	private List<Bullet> bullets = new ArrayList<Bullet>();
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
		if (isAlive()) {
			int index=0;
			System.out.println("count:"+getCount());
			for (int i = 0; i < getCount(); i++) {
				lives[i]=new LifePlane(index, 40, getGs(), true);
				index+=30;
			}
			if(canK){
				g.drawImage(getGs().foodImgs[1], 20, 620, 29, 26, null);
			}
			if (canL) {
				g.drawImage(getGs().foodImgs[0], 60, 620, 29, 26, null);
			}
			if (canK&&canL) {
				g.drawString("U", 20, 600);
			}
			g.drawImage(getGs().planeImg, getX(), getY(), width, height, null);
		}else {
			if(isFirst()){
				g.drawImage(getGs().startImg, 0, 0, 600, 700, null);
				return;
			}
			g.drawImage(getGs().continueImg, 150,250, 300, 200, null);
		}
		
		//System.out.println("size:" + bullets.size());
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (bullet.alive&&isAlive()) {
				bullet.drawMe(g);
			} else {
				bullets.remove(i);
			}
		}
		for (int i = 0; i < ults.size(); i++) {
			Ult ult=ults.get(i);

			if (ult.alive) {
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
				isUp = true;
				break;
			case KeyEvent.VK_S:
				isDown = true;
				break;
			case KeyEvent.VK_A:
				setLeft(true);
				break;
			case KeyEvent.VK_D:
				setRight(true);
				break;
			case KeyEvent.VK_J:
				if (isAlive())
					this.j.pressKey(this);
				break;
			case KeyEvent.VK_U:
				if(isAlive()&&canK&&canL){
					
					this.u.pressKey(this);
				}
				break;
			case KeyEvent.VK_L:
				if (isAlive()&&canL) {
					this.l.pressKey(this);
				}
				break;
			case KeyEvent.VK_K:
				if (isAlive()&&canK) {
					this.k.pressKey(this);
					
				}
				break;
			}
		}



	}
	
	public void addBullet(BulletPlayer bullet)
	{
		this.bullets.add(bullet);
	}
	
	public  void ult() {
		
		ults.add(new Ult(getGs(), true));
		canL=canK=false;
	}
	
	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {

		case KeyEvent.VK_W:
			isUp = false;
			break;
		case KeyEvent.VK_S:
			isDown = false;

			break;
		case KeyEvent.VK_A:
			setLeft(false);
			break;
		case KeyEvent.VK_D:
			setRight(false);
			break;
		case KeyEvent.VK_J:
			if (isAlive())
				this.j.releaseKey(this);
			break;
		case KeyEvent.VK_U:
			if(isAlive()&&canK&&canL){
				
				this.u.releaseKey(this);
			}
			break;
		case KeyEvent.VK_L:
			if (isAlive()&&canL) {
				this.l.releaseKey(this);
			}
			break;
		case KeyEvent.VK_K:
			if (isAlive()&&canK) {
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

}