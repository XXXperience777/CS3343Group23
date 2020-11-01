package game;

import java.awt.Image;

public class GUISetUp {

	private int height = 700;
	private int width = 600;
	private Image img;
	private Image bulletImg;
	private Image bgImg;
	private Image planeImg;
	private Image bulletEmImg;
	private Image bulletEm1Img;
	private Image bossImg;
	private Image ult;
	private Image continueImg;
	private Image lifePlaneImg;
	private Image startImg;
	private Image[] bulletImgs;
	private Image[] enemyImgs;
	private Image[] boomImgs;
	private Image[] foodImgs;
	private Background bg = new Background(this);

	public Image getbossImg() {
		return this.bossImg;
	}
	
	public GUISetUp() {
		// TODO - implement GUISetUp.GUISetUp
		throw new UnsupportedOperationException();
	}

}