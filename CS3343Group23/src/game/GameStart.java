package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import game.BulletEm;
import game.Enemy;
import game.Explode;
import game.Food;
import game.GameStart;
import game.GameStart.MyThread;



public class GameStart extends Frame {

	private Background gs;
	private int height = 700;
	private int width = 600;
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
	private ArrayList<BulletPlayer> bulletPl = new ArrayList<BulletPlayer>();
	private ArrayList<BulletEm> bulletEms = new ArrayList<BulletEm>();
	private ArrayList<BulletBoss> bulletBs = new ArrayList<BulletBoss>();
	private ArrayList<Explode> explodes = new ArrayList<Explode>();
	private ArrayList<Food> foods = new ArrayList<Food>();
	private Background bg ;
	private Image img;
	private GUISetUp ui;
	public GameStart() 
	{
		this.setTitle("Plane War");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		
		this.ui=GUISetUp.Instance;
		this.bg=new Background(getUi());
		
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
		
				plane.keyPressed(e);
				if (!plane.isAlive()&& e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					plane.setAlive(true);
					plane.setFirst(false);
					plane.setCount(5);
					plane.setX(250);
					plane.setY(500);
				}
				if (!plane.isAlive() &&e.getKeyCode()==KeyEvent.VK_ESCAPE) 
				{
					int n = JOptionPane.showConfirmDialog(null, "Exit Game?", "Plane War",JOptionPane.YES_NO_OPTION);
					System.out.println("n:"+n);
					if (n==0) {
						System.exit(0);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				plane.keyReleased(e);

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
		return this.bulletBs;
	}
	
	public ArrayList<BulletPlayer> getBulletPl() {
		return this.bulletPl;
	}

	

	/**
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		
		if (!plane.isFirst()) {
			bg.drawMe(g);
			System.out.println(count);
			if (ran.nextInt(100) > 97) {
				enemies.add(new Enemy(ran.nextInt(500) + 10, 0, true,
						GameStart.this));
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
			System.out.println("explode.size:" + explodes.size());
			System.out.println("boostime:"+bossTime+"count:"+count);
			if (count >= bossTime) {
				boss.setAlive(true);
				boss.drawMe(g);
			}else if (bossTime-count<=3) {
				g.setColor(Color.RED);
				g.drawString("WARNNING", 250, 100);
			}
			g.drawString("Level："+level, 500, 50);
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