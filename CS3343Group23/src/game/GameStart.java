package game;

import java.awt.*;
import java.util.*;

public class GameStart extends Frame {

	Background gs;
	private int count = 0;
	private int num = 0;
	private int score = 0;
	private int bossTime = 5; //?
	private int level = 1;
	private boolean isOver = false;
	private java.util.Random ran = new Random();
	private java.awt.Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Plane plane = new Plane(250, 500, false, this);
	private Boss boss = new Boss(30, 50, this, true);
	private Collection<Enemy> enemies = new ArrayList<Enemy>();
	private Collection<BulletEm> be = new ArrayList<BulletEm>();
	private Collection<Explode> explodes = new ArrayList<Explode>();
	private Collection<Food> foods = new ArrayList<Food>();
	private Background bg = newBackground(this);

	public GameStart() {
		// TODO - implement GameStart.GameStart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	@Override
	public void update(java.awt.Graphics g) {
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
	
	public int getPlane() {
		return this.plane;
	}

	public int getScore() {
		return this.score;
	}
	
	public void addScore() {
		this.score += 1000;
	}
	
	public void levelUp() {
		this.level ++;
	}
	
	public void clearCount() {
		this.count=0;
	}
	
	public void addExplodes(int x, int y) {
		this.explodes.add(new Explode(x + 212, y + 64, gs, true,true));
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