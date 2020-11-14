package game;

import java.awt.Image;
import java.awt.Toolkit;

public class GUISetUp {

	private int height = 700;
	private int width = 600;
	private Image bgImg;
	private Image planeImg_1;
	private Image planeImg_2;
	private Image planeImg_3;
	private Image bulletEmImg;
	//private Image bulletEm1Img;
	private Image bossImg;
	private Image ult;
	private Image continueImg;
	private Image lifePlaneImg;
	private Image startImg;
	private Image[] bulletImgs;
	private Image[] bulletBossImgs;
	private Image[] enemyImgs;
	private Image[] boomImgs;
	private Image[] foodImgs;
	
	private Toolkit toolkit = Toolkit.getDefaultToolkit();


	private static GUISetUp Instance=new GUISetUp();
	public static GUISetUp getInstance() {return Instance;}
    private GUISetUp() {

		bgImg = toolkit.getImage(GameStart.class.getResource("/imgs/bg1.jpg"));

	    planeImg_1 = toolkit.getImage(GameStart.class
				.getResource("/imgs/7.png"));

	    planeImg_2 = toolkit.getImage(GameStart.class
				.getResource("/imgs/7.png"));

		planeImg_3 = toolkit.getImage(GameStart.class
				.getResource("/imgs/7.png"));

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
				toolkit.getImage(GameStart.class.getResource("/imgs/enemy1.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/enemy2.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/enemy3.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/enemy4.png")) };
		bulletImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/bullet_p.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/bullet_p.png"))
				};
		bulletEmImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/bullet_e0.png"));
		//bulletEm1Img = toolkit.getImage(GameStart.class
		//		.getResource("/imgs/bullet_e1.png"));
		bossImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/Boss.png"));
		bulletBossImgs = new Image[] {
				toolkit.getImage(GameStart.class
						.getResource("/imgs/bullet_b.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/bullet_b1.png")) };
		ult = toolkit.getImage(GameStart.class.getResource("/imgs/BKILL.png"));
		continueImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/continue.png"));
		foodImgs = new Image[] {
				toolkit.getImage(GameStart.class.getResource("/imgs/buff0.png")),
				toolkit.getImage(GameStart.class.getResource("/imgs/buff1.png")) };
		lifePlaneImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/life.png"));
		startImg = toolkit.getImage(GameStart.class
				.getResource("/imgs/GameStart.png"));
	}


	public Image getbossImg() {
		return this.bossImg;
	}

	public Image[] getenemyImg() {
		return this.enemyImgs;
	}

	public Image[] getbulletImgs() {
		return this.getBulletImgs();
	}

	public Image[] getbulletBossImgs() {
		return this.getBulletBossImgs();
	}



	public Image getBgImg() {
		return bgImg;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


	public Image[] getBoomImgs() {
		return boomImgs;
	}


	public Image getUlt() {
		return ult;
	}


	public Image[] getFoodImgs() {
		return foodImgs;
	}


	public Image getStartImg() {
		return startImg;
	}


	public Image getContinueImg() {
		return continueImg;
	}


	public Image getPlaneImg_1() {
		return planeImg_1;
	}


	public Image getPlaneImg_2() {
		return planeImg_2;
	}


	public Image getPlaneImg_3() {
		return planeImg_3;
	}


	public Image[] getBulletBossImgs() {
		return bulletBossImgs;
	}


	public Image getBulletEm1Img() {
		return bulletEmImg;
	}


	public Image[] getBulletImgs() {
		return bulletImgs;
	}


	public Image getLifePlaneImg() {
		return lifePlaneImg;
	}

}