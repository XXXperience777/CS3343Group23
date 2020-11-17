package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import java.util.Random;

import javax.swing.JOptionPane;


import game.GameStart;




public class GameStart extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int height = 700;
	private int width = 600;
	private int count = 0;

	private int score = 0;
	private int bossTime = 10; 
	private int level = 1;
	
	private boolean factoryEnemy=false;
	
	private Random ran = new Random();
	private GUISetUp ui=GUISetUp.getInstance();
	private Plane plane = new Plane(250, 500, false, this);
	private Boss boss;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<BulletPlayer> bulletPl = new ArrayList<BulletPlayer>();
	private ArrayList<BulletEm> bulletEms = new ArrayList<BulletEm>();
	private ArrayList<BulletBoss> bulletBs = new ArrayList<BulletBoss>();
	private ArrayList<Explode> explodes = new ArrayList<Explode>();
	private ArrayList<Food> foods = new ArrayList<Food>();
	private Background bg ;
	private Image img;

	public GameStart()
	{
		this.setTitle("Plane War");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setFont(new Font("Airial",Font.BOLD,15));

		//this.ui=GUISetUp.getInstance();
		this.bg=new Background(this.ui);
		this.boss = new Boss(30, 50, this, true);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{

				System.exit(0);
			}
		});
		this.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{

				plane.keyPressed(e.getKeyCode());
				if (!plane.isAlive()&& e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					plane.setAlive(true);
					plane.setFirst(false);
					plane.setLife(5);
					plane.setX(250);
					plane.setY(500);
				}
				if (!plane.isAlive() &&e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					int n = JOptionPane.showConfirmDialog(null, "Exit Game?", "Plane War",JOptionPane.YES_NO_OPTION);

					if (n==0) {
						System.exit(0);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				plane.keyReleased(e.getKeyCode());

			}
		});
		new MyThread().start();
	}

	/**
	 *
	 * @param g
	 */
	@Override
	public void update(Graphics g) {
		if (img == null) {
			img = this.createImage(width, height);
		}
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		print(graphics);
		g.drawImage(img, 0, 0, null);
	}

	public void addExplode(Explode explode)
	{
		explodes.add(explode);
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

	public int addBossTime() {
		return this.bossTime+=10;
	}

	public void levelUp() {
		this.level ++;
		this.plane.recover();
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

	public void addBulletEm(boolean alive, Enemy thisEm) {
		bulletEms.add(new BulletEm(alive, this, thisEm));
	}

	public ArrayList<BulletBoss> getBulletBoss() {
		return this.bulletBs;
	}

	public void addBulletBoss(boolean alive) {
		bulletBs.add(new BulletBoss(alive, this, this.getBoss()));
	}

	public ArrayList<BulletPlayer> getBulletPl() {
		return this.bulletPl;
	}

	public void addBulletPl(BulletPlayer bullet) {
		bulletPl.add(bullet);
	}

	public ArrayList<Ult> getPlaneults() {
		return plane.getults();
	}
   private void factoryEnemy()
   {
	   EnemyFactory EnFactory=new ConcreteEnemyFactory(this);
		enemies.add(EnFactory.factoryEnemy());
		this.setFactoryEnemy(false);
   }

   private boolean checkFactory()
   {
	   return ran.nextInt(100) > 97;
   }

	/**
	 *
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		
		
		if (!plane.isFirst()) {
			bg.drawMe(g);

			this.setFactoryEnemy(checkFactory());
			if (this.factoryEnemy) {
				 factoryEnemy();

			}
			if (foods.size() <3&&count==5) {
				foods.add(new Food(ran.nextInt(500) + 10, 0, GameStart.this,
						true));
			}
			for (int i = 0; i < enemies.size(); i++) {
				Enemy enemy = enemies.get(i);
				if (enemy.isAlive()) {
					enemy.drawMe(g);
				} else {
					enemies.remove(i);
				}
			}
			for (int i = 0; i < bulletEms.size(); i++) {
				BulletEm bullet = bulletEms.get(i);
				if (bullet.isAlive()) {
					bullet.drawMe(g);
				} else {
					bulletEms.remove(i);
				}
			}

			for (int i = 0; i < explodes.size(); i++) {
				Explode explode = explodes.get(i);
				if (explode.isAlive()) {
					explode.drawMe(g);
				} else {
					explodes.remove(explode);
				}
			}
			if (foods.size()>0) {
				Food food=foods.get(0);
				if (food.isAlive()) {
					food.drawMe(g);
				}else {
					foods.remove(food);
				}
			}

			if (count >= bossTime) {
				getBoss().setAlive(true);
				getBoss().drawMe(g);
			}else if (bossTime-count<=3) {
				g.setColor(Color.RED);
				g.drawString("WARNNING", 250, 100);
			}
			g.drawString("Level:"+level, 500, 50);
			g.drawString("Score:" + score, 500, 80);
		}
		plane.drawMe(g);
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		new GameStart();
	}




	public GUISetUp getUi() {
		return ui;
	}




	public void setFactoryEnemy(boolean factoryEnemy) {
		this.factoryEnemy = factoryEnemy;
	}




	public Boss getBoss() {
		return boss;
	}




	class MyThread extends Thread {
		@Override
		public void run() {

			while (true) {
				try {
					sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				repaint();
			}
		}
	}

}