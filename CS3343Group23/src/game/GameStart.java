package game;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.Toolkit;
import java.util.Random;
import java.awt.Graphics;


public class GameStart extends Frame {

	Background gs;
	private int count = 0;
	private int num = 0;
	private int score = 0;
	private int bossTime = 5; //?
	private int level = 1;
	private boolean isOver = false;
	private Random ran = new Random();
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Plane plane = new Plane(250, 500, false, this);
	private Boss boss = new Boss(30, 50, this, true);
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<BulletEm> be = new ArrayList<BulletEm>();
	private ArrayList<Explode> explodes = new ArrayList<Explode>();
	private ArrayList<Food> foods = new ArrayList<Food>();
	private Background bg = newBackground(this);
	private ArrayList<BulletEm> bulletEms = new ArrayList<BulletEm>();
	private ArrayList<BulletBoss> bulletBoss = new ArrayList<BulletBoss>();
	private ArrayList<BulletPlayer> bulletPl = new ArrayList<BulletPlayer>();

	public GameStart() {
		// TODO - implement GameStart.GameStart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	@Override
	public void update(Graphics g) {
		// TODO - implement GameStart.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ui
	 */
	public void SetUp(GUISetUp ui) {
		// TODO - implement GameStart.SetUp
		throw new UnsupportedOperationException();
	}
	
	public Plane getPlane() {
		return this.plane;
	}

	public int getScore() {
		return this.score;
	}
	
	public void addScore(int points) {
		this.score += points;
	}
	
	public void levelUp() {
		this.level ++;
	}
	
	public void addCount() {
		this.count ++;
	}
	
	public void clearCount() {
		this.count=0;
	}
	
	public ArrayList<Explode> getExplodes() {
		return this.explodes;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return this.enemies;
	}
	
	public ArrayList<BulletEm> getBulletEm() {
		return this.bulletEms;
	}
	
	public ArrayList<BulletBoss> getBulletBoss() {
		return this.bulletBoss;
	}
	
	public ArrayList<BulletPlayer> getBulletPl() {
		return this.bulletPl;
	}

	public void initView() {
		// TODO - implement GameStart.initView
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	@Override
	public void paint(java.awt.Graphics g) {
		// TODO - implement GameStart.paint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement GameStart.main
		throw new UnsupportedOperationException();
	}


	class MyThread extends Thread {

		@Override
		public void run() {
			// TODO - implement MyThread.run
			throw new UnsupportedOperationException();
		}

	}

}