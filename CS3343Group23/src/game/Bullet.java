package game;

import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class Bullet
{
public Bullet()
  {
	
  }

  public abstract void drawMe(Graphics g);
	

  public abstract void move();
  
  public abstract Rectangle getRectangle();
 



}