package test;

import static org.junit.Assert.*;
import java.awt.event.KeyEvent;
import org.junit.Test;
import game.Plane;

public class PlaneTest {
	
	@Test
    //Test Press K after eaten K
    public void test_EatenK_PressK()throws Exception 
	{
		
		
		class StubPlane extends Plane
		{
           private String key="Null";
			public StubPlane(boolean alive) 
			{
				super(alive);
				
			}
			@Override
			public void keyPressed(int event) {
				
				key="Null";
				switch (event) 
				{
				case KeyEvent.VK_W:
					key="W";
					break;
				case KeyEvent.VK_S:
					key="S";
					break;
				case KeyEvent.VK_A:
					key="A";
					break;
				case KeyEvent.VK_D:
					key="D";
					break;
				case KeyEvent.VK_J:
					if (this.isAlive())
						key="J";
					break;
				case KeyEvent.VK_U:
					if(this.isAlive()&&this.isCanK()&&this.isCanL())
					{

						key="U";
						this.setCanK(false);
						this.setCanL(false);
					}
					break;
				case KeyEvent.VK_L:
					if (this.isAlive()&&this.isCanL()) 
					{
						key="L";
						this.setCanL(false);
					}
					break;
				case KeyEvent.VK_K:
					if (this.isAlive()&&this.isCanK()) 
					{
						key="K";
						this.setCanK(false);
					}
					break;
				}
			}
		  public String getKey() {return key;}
		}
		StubPlane plane=new StubPlane(true);
	    plane.setCanK(true);
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("K", plane.getKey());
    }
	
	@Test
	//Test Press K when have not eaten K
    public void test_Not_EatenK_PressK()throws Exception 
	{
		
		
		class StubPlane extends Plane
		{
	           private String key="Null";
				public StubPlane(boolean alive) 
				{
					super(alive);
					
				}
				@Override
				public void keyPressed(int event) 
				{
					key="Null";
					switch (event) {
					case KeyEvent.VK_W:
						key="W";
						break;
					case KeyEvent.VK_S:
						key="S";
						break;
					case KeyEvent.VK_A:
						key="A";
						break;
					case KeyEvent.VK_D:
						key="D";
						break;
					case KeyEvent.VK_J:
						if (this.isAlive())
							key="J";
						break;
					case KeyEvent.VK_U:
						if(this.isAlive()&&this.isCanK()&&this.isCanL())
						{

							key="U";
							this.setCanK(false);
							this.setCanL(false);
						}
						break;
					case KeyEvent.VK_L:
						if (this.isAlive()&&this.isCanL()) 
						{
							key="L";
							this.setCanL(false);
						}
						break;
					case KeyEvent.VK_K:
						if (this.isAlive()&&this.isCanK()) 
						{
							key="K";
							this.setCanK(false);
						}
						break;
					}
				}
			  public String getKey() {return key;}
			}
		StubPlane plane=new StubPlane(true);
	    plane.setCanK(false);
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("Null", plane.getKey());
    }
	
	@Test
	//Test Press M when have eaten K
    public void test_EatenK_PressM()throws Exception 
	{
		
		
		class StubPlane extends Plane{
	           private String key="Null";
				public StubPlane(boolean alive) 
				{
					super(alive);
					
				}
				@Override
				public void keyPressed(int event) 
				{
					key="Null";
					switch (event) {
					case KeyEvent.VK_W:
						key="W";
						break;
					case KeyEvent.VK_S:
						key="S";
						break;
					case KeyEvent.VK_A:
						key="A";
						break;
					case KeyEvent.VK_D:
						key="D";
						break;
					case KeyEvent.VK_J:
						if (this.isAlive())
							key="J";
						break;
					case KeyEvent.VK_U:
						if(this.isAlive()&&this.isCanK()&&this.isCanL())
						{

							key="U";
							this.setCanK(false);
							this.setCanL(false);
						}
						break;
					case KeyEvent.VK_L:
						if (this.isAlive()&&this.isCanL()) 
						{
							key="L";
							this.setCanL(false);
						}
						break;
					case KeyEvent.VK_K:
						if (this.isAlive()&&this.isCanK()) 
						{
							key="K";
							this.setCanK(false);
						}
						break;
					}
				}
			  public String getKey() {return key;}
			}
		StubPlane plane=new StubPlane(true);
	    plane.setCanK(false);
		plane.keyPressed(KeyEvent.VK_M);
		assertEquals("Null", plane.getKey());
    }
	
	@Test
	//Test Press K continuously while eaten one K
    public void test_EatenK_PressK_Continuously()throws Exception 
	{
		
		
	class StubPlane extends Plane
	{
        private String key="Null";
			public StubPlane(boolean alive) 
			{
				super(alive);
				
			}
			@Override
			public void keyPressed(int event) 
			{
				key="Null";
				switch (event) {
				case KeyEvent.VK_W:
					key="W";
					break;
				case KeyEvent.VK_S:
					key="S";
					break;
				case KeyEvent.VK_A:
					key="A";
					break;
				case KeyEvent.VK_D:
					key="D";
					break;
				case KeyEvent.VK_J:
					if (this.isAlive())
						key="J";
					break;
				case KeyEvent.VK_U:
					if(this.isAlive()&&this.isCanK()&&this.isCanL())
					{

						key="U";
						this.setCanK(false);
						this.setCanL(false);
					}
					break;
				case KeyEvent.VK_L:
					if (this.isAlive()&&this.isCanL()) 
					{
						key="L";
						this.setCanL(false);
					}
					break;
				case KeyEvent.VK_K:
					if (this.isAlive()&&this.isCanK()) 
					{
						key="K";
						this.setCanK(false);
					}
					break;
				}
			}
		  public String getKey() {return key;}
		}
		StubPlane plane=new StubPlane(true);
	    plane.setCanK(true);
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("K", plane.getKey());
		assertEquals(false, plane.isCanK());
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("Null", plane.getKey());
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("Null", plane.getKey());
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("Null", plane.getKey());
		plane.keyPressed(KeyEvent.VK_K);
		assertEquals("Null", plane.getKey());
    }
}
