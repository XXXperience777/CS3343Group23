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

import com.game.BulletEm;
import com.game.Enemy;
import com.game.Explode;
import com.game.Food;
import com.game.GameStart;
import com.game.GameStart.MyThread;



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
	private ArrayList<BulletEm> be = new ArrayList<BulletEm>();
	private ArrayList<Explode> explodes = new ArrayList<Explode>();
	private ArrayList<Food> foods = new ArrayList<Food>();
	private Background bg = newBackground(this);
	private ArrayList<BulletEm> bulletEms = new ArrayList<BulletEm>();
	private Image img, bulletImg,bgImg, planeImg, bulletEmImg, bulletEm1Img, boosImg,
	ult, continueImg, lifePlane, startImg;
    private Image[]  bulletImgs,enemyImgs, boomImgs, bulletBossImgs, foodImgs;
	public GameStart() 
	{
		this.setTitle("Plane War");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
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
				if (!plane.alive && e.getKeyCode() == KeyEvent.VK_ENTER) 
				{
					plane.alive = true;
					plane.isFirst = false;
					plane.count = 5;
					plane.x = 250;
					plane.y = 500;
				}
				if (!plane.alive &&e.getKeyCode()==KeyEvent.VK_ESCAPE) 
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
	public void update(java.awt.Graphics g) {
		if (img == null) {
			img = this.createImage(width, height);
		}
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		print(graphics);
		g.drawImage(img, 0, 0, null);
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

	public void initView() {
		bgImg = toolkit.getImage(GameStart.class.getResource("/imgs/bg01.jpg"));
		if (plane.isLeft) {
			planeImg = toolkit.getImage(GameStart.class
					.getResource("/imgs/51.png"));
		} else if (plane.isRight) {
			planeImg = toolkit.getImage(GameStart.class
					.getResource("/imgs/61.png"));
		} else {
			planeImg = toolkit.getImage(GameStart.class
					.getResource("/imgs/7.png"));
		}
		boomImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/b1.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b2.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b3.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b4.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b5.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b6.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b7.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b8.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b9.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b10.gif")),
				toolkit.getImage(GameStart.class.getResource("/imgs/b11.gif")) };
		enemyImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/5.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/21.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/15.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/敌机2.png")) };
		bulletImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/子弹1.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/坦克.png"))
				};
		bulletEmImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/敌军子弹.png"));
		bulletEm1Img = toolkit.getImage(GameStart.class
				.getResource("/imgs/敌军子弹1.png"));
		boosImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/BossA.png"));
		bulletBossImgs = new Image[] {
				toolkit.getImage(GameStart.class
						.getResource("/imgs/BOSS子弹.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/子弹2.png")) };
		ult = toolkit.getImage(GameStart.class.getResource("/imgs/BKILL.png"));
		continueImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/continue.png"));
		foodImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/食物1.jpg")),
				toolkit.getImage(GameStart.class.getResource("/imgs/22.png")) };
		lifePlane = toolkit.getImage(GameStart.class
				.getResource("/imgs/飞猪boss子弹.png"));
		startImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/gamebegin1.gif"));
	}

	/**
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		// TODO - implement GameStart.paint
		throw new UnsupportedOperationException();if (!plane.isFirst) {
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
				if (enemy.alive) {
					enemy.drawMe(g);
				} else {
					enemies.remove(i);
				}
			}
			for (int i = 0; i < bulletEms.size(); i++) {
				BulletEm bullet = bulletEms.get(i);
				if (bullet.alive) {
					bullet.drawMe(g);
				} else {
					bulletEms.remove(i);
				}
			}

			for (int i = 0; i < explodes.size(); i++) {
				Explode explode = explodes.get(i);
				if (explode.alive) {
					explode.drawMe(g);
				} else {
					explodes.remove(explode);
				}
			}
			if (foods.size()>0) {
				Food food=foods.get(0);
				if (food.alive) {
					food.drawMe(g);
				}else {
					foods.remove(food);
				}
			}
			System.out.println("explode.size:" + explodes.size());
			System.out.println("boostime:"+bossTime+"count:"+count);
			if (count >= bossTime) {
				boss.alive=true;
				boss.drawMe(g);
			}else if (bossTime-count<=3) {
				g.setColor(Color.RED);
				g.drawString("WARNNING", 250, 100);
			}
			g.drawString("第"+level+"关", 500, 50);
			g.drawString("得分：" + score, 500, 80);
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


	class MyThread extends Thread {
		@Override
		public void run() {
		
			while (true) {
				try {
					sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				initView();
				repaint();
			}
		}
	}

}