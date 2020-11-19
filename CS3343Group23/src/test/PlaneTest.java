package test;

import static org.junit.Assert.*;
import java.awt.event.KeyEvent;
import org.junit.Test;

import game.GameStart;
import game.Plane;

public class PlaneTest {
	
	@Test
	//Test press A
	public void test_PressA() throws Exception {
	GameStart gs = new GameStart();
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
	plane.keyPressed(KeyEvent.VK_A);
	plane.move();
	boolean result = plane.isLeft();
	plane.keyReleased(KeyEvent.VK_A);
	assertEquals(result, true);
}
	
	@Test
	//Test press A continuously 
	public void test_PressA_Continuously() throws Exception {
	GameStart gs = new GameStart();
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
	int x = plane.getX(), newx = 0;
	while (x > 0) {
		x = plane.getX();
		plane.keyPressed(KeyEvent.VK_A);
		plane.move();
		newx = plane.getX();
	}
	plane.keyReleased(KeyEvent.VK_A);
	boolean result = (x == newx);
	assertEquals(result, true);
}
	
	@Test
	//Test Press Q
	public void test_PressQ() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_Q);
	    plane.keyReleased(KeyEvent.VK_Q);
		assertEquals("Unknown", plane.getLastCommand());
	}
	
	@Test 
	//Test Press D
	public void test_PressD() throws Exception{
		GameStart gs = new GameStart();
		Plane plane = gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
		plane.keyPressed(KeyEvent.VK_D);
		plane.move();
		boolean result = plane.isRight();
		plane.keyReleased(KeyEvent.VK_D);
		assertEquals(result, true);
	}
	
	@Test
	//Test press D continuously 
		public void test_PressD_Continuously() throws Exception {
		GameStart gs = new GameStart();
		Plane plane = gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
		int x = plane.getX(), newx = 0;
		while (x < 512) {
			x = plane.getX();
			plane.keyPressed(KeyEvent.VK_D);
			plane.move();
			newx = plane.getX();
		}
		plane.keyReleased(KeyEvent.VK_D);
		boolean result = (x == newx);
		assertEquals(result, true);
	}
	
	@Test
	//Test Press F
	public void test_PressF() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_F);
	    plane.keyReleased(KeyEvent.VK_F);
		assertEquals("Unknown", plane.getLastCommand());
	}
	
	@Test
	//Test press W 
	public void test_PressW() throws Exception {
	GameStart gs = new GameStart();
	int newx, newy;
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
	plane.keyPressed(KeyEvent.VK_W);
	plane.move();
	newx = plane.getX();
	newy = plane.getY();
	plane.keyReleased(KeyEvent.VK_W);
	boolean result = (newy < 500) && (newx == 250);
	assertEquals(result, true);
}
	
	@Test
	//Test press W continuously
	public void test_PressW_Continuously() throws Exception {
	GameStart gs = new GameStart();
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
	int y = plane.getY(), newy = 0;
	while (y > 25) {
		y = plane.getY();
		plane.keyPressed(KeyEvent.VK_W);
		plane.move();
		newy = plane.getY();
	}
	plane.keyReleased(KeyEvent.VK_W);
	boolean result = (y == newy);
	assertEquals(result, true);
}

	@Test
	//Test Press E
	public void test_PressE() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_E);
	    plane.keyReleased(KeyEvent.VK_E);
		assertEquals("Unknown", plane.getLastCommand());
	}
	
	@Test
	//Test press S
	public void test_PressS() throws Exception {
	GameStart gs = new GameStart();
	int newx, newy;
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
    plane.keyPressed(KeyEvent.VK_S);
	plane.move();
	newx = plane.getX();
	newy = plane.getY();
	plane.keyReleased(KeyEvent.VK_S);
	boolean result = (newy > 500) && (newx == 250);
	assertEquals(result, true);
}
	
	@Test
	//Test press S continuously
	public void test_PressS_Continuously() throws Exception {
	GameStart gs = new GameStart();
	Plane plane = gs.getPlane();
	plane.setAlive(true);
	plane.setFirst(false);
	plane.setLife(5);
	int y = plane.getY(), newy = 0;
	while (y < 600) {
		y = plane.getY();
		plane.keyPressed(KeyEvent.VK_S);
		plane.move();
		newy = plane.getY();
	}
	plane.keyReleased(KeyEvent.VK_S);
	boolean result = (y == newy);
	assertEquals(result, true);
}
	
	@Test
	//Test Press X
	public void test_PressX() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_X);
	    plane.keyReleased(KeyEvent.VK_X);
		assertEquals("Unknown", plane.getLastCommand());
	}
	
	@Test
	//Test Press J
	public void test_PressJ() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_J);
	    plane.keyReleased(KeyEvent.VK_J);
		assertEquals(1,gs.getBulletPl().size());
	}
	
	@Test
	//Test Press J Rapidly
	public void test_PressJ_Rapidly() throws Exception{
		GameStart gs = new GameStart();
		Plane plane = gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
		int num = 20;
		for (int i = 0; i < num; i++) {
			plane.keyPressed(KeyEvent.VK_J);
			plane.keyReleased(KeyEvent.VK_J);
		}
		int size = gs.getBulletPl().size();
		assertEquals(size, num);
	}
	
	@Test
	//Test Press J Continuously
	public void test_PressJ_Continuously() throws Exception{
		GameStart gs = new GameStart();
		Plane plane = gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
		int num = 20;
		for (int i = 0; i < num; i++) {
			plane.keyPressed(KeyEvent.VK_J);
		}
		plane.keyReleased(KeyEvent.VK_J);
		int size = gs.getBulletPl().size();
		assertEquals(size, num);
	}
	
	@Test
	//Test Press H
	public void test_PressH() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.keyPressed(KeyEvent.VK_H);
	    plane.keyReleased(KeyEvent.VK_H);
		assertEquals("Unknown", plane.getLastCommand());
	}
	
	@Test
	//Test Press H Rapidly
	public void test_PressH_Rapidly() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    for(int i=0;i<20;i++) {
	    plane.keyPressed(KeyEvent.VK_H);
	    plane.keyReleased(KeyEvent.VK_H);
		assertEquals("Unknown", plane.getLastCommand());
	    }
	 }
	
	@Test
    //Test Press K after eaten K
    public void test_EatenK_PressK()throws Exception 
	{

		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanK(true);
		plane.keyPressed(KeyEvent.VK_K);
		plane.keyReleased(KeyEvent.VK_K);
		assertEquals("GrapeShot", plane.getLastCommand());
    }
	
	@Test
	//Test Press K when have not eaten K
    public void test_Not_EatenK_PressK()throws Exception 
	{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanK(false);
		plane.keyPressed(KeyEvent.VK_K);
		plane.keyReleased(KeyEvent.VK_K);
		assertEquals("PressK", plane.getLastCommand());
    }
	
	@Test
	//Test Press M when have eaten K
    public void test_EatenK_PressM()throws Exception 
	{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanK(false);
	    plane.keyPressed(KeyEvent.VK_M);
	    plane.keyReleased(KeyEvent.VK_M);
		assertEquals("Unknown", plane.getLastCommand());
		
    }
	
	@Test
	//Test Press K continuously while eaten one K
    public void test_EatenK_PressK_Continuously()throws Exception 
	{
		
		GameStart gs=new GameStart();
		  Plane plane=gs.getPlane();
		  plane.setAlive(true);
		  plane.setFirst(false);
		  plane.setLife(5);
		     plane.setCanK(true);
		     plane.keyPressed(KeyEvent.VK_K);
		  assertEquals("GrapeShot", plane.getLastCommand());
		  assertEquals(false, plane.isCanK());
		  plane.keyPressed(KeyEvent.VK_K);
		  assertEquals("PressK", plane.getLastCommand());
		  plane.keyPressed(KeyEvent.VK_K);
		  assertEquals("PressK", plane.getLastCommand());
		  plane.keyPressed(KeyEvent.VK_K);
		  assertEquals("PressK", plane.getLastCommand());
		  plane.keyPressed(KeyEvent.VK_K);
		  assertEquals("PressK", plane.getLastCommand());
		  plane.keyPressed(KeyEvent.VK_K);
		  plane.keyReleased(KeyEvent.VK_K);
		  assertEquals("PressK", plane.getLastCommand());
	  
    }
	
	@Test
	//Test Press L after eaten L
	 public void test_EatenL_PressL()throws Exception 
		{

			GameStart gs=new GameStart();
			Plane plane=gs.getPlane();
			plane.setAlive(true);
			plane.setFirst(false);
			plane.setLife(5);
		    plane.setCanL(true);
			plane.keyPressed(KeyEvent.VK_L);
			plane.keyReleased(KeyEvent.VK_L);
			assertEquals("Triple Shot", plane.getLastCommand());
	    }
	
	@Test
	//Test Press L Continuously
	 public void test_EatenL_PressL_Continuously()throws Exception 
		{
			
			GameStart gs=new GameStart();
			  Plane plane=gs.getPlane();
			  plane.setAlive(true);
			  plane.setFirst(false);
			  plane.setLife(5);
			     plane.setCanL(true);
			     plane.keyPressed(KeyEvent.VK_L);
			  assertEquals("Triple Shot", plane.getLastCommand());
			  assertEquals(false, plane.isCanL());
			  plane.keyPressed(KeyEvent.VK_L);
			  assertEquals("PressL", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_L);
			  assertEquals("PressL", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_L);
			  assertEquals("PressL", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_L);
			  assertEquals("PressL", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_L);
			  plane.keyReleased(KeyEvent.VK_L);
			  assertEquals("PressL", plane.getLastCommand());
	    }
	
	@Test
	//Test Press O when have eaten L
    public void test_EatenL_PressO()throws Exception 
	{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanL(true);
	    plane.keyPressed(KeyEvent.VK_O);
	    plane.keyReleased(KeyEvent.VK_O);
		assertEquals("Unknown", plane.getLastCommand());
    }
	
	@Test
	//Test Press U when have eaten K and L
	public void test_EatenKL_PressU() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanL(true);
	    plane.setCanK(true);
		plane.keyPressed(KeyEvent.VK_U);
		plane.keyReleased(KeyEvent.VK_U);
		assertEquals("Ultra Kill", plane.getLastCommand());
	}
	
	@Test
	//Test Press U continuously when have eaten K and L
	 public void test_EatenKL_PressU_Continuously()throws Exception 
		{
			GameStart gs=new GameStart();
			  Plane plane=gs.getPlane();
			  plane.setAlive(true);
			  plane.setFirst(false);
			  plane.setLife(5);
			     plane.setCanL(true);
			     plane.setCanK(true);
			     plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("Ultra Kill", plane.getLastCommand());
			  assertEquals(false, plane.isCanL()||plane.isCanK());
			  plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("PressU", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("PressU", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("PressU", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("PressU", plane.getLastCommand());
			  plane.keyPressed(KeyEvent.VK_U);
			  assertEquals("PressU", plane.getLastCommand());
			  plane.keyReleased(KeyEvent.VK_U);
			  }
	
	@Test
	//Test Press M when have eaten K and L
    public void test_EatenKL_PressM()throws Exception 
	{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanL(true);
	    plane.setCanK(true);
	    plane.keyPressed(KeyEvent.VK_M);
	    plane.keyReleased(KeyEvent.VK_M);
		assertEquals("Unknown", plane.getLastCommand());
    }
	
	@Test
	//test ult
	public void test_ult() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		int ultnum=plane.getults().size();
		plane.ult();
		assertEquals(ultnum+1, plane.getults().size());
		
	}
	
	@Test
	//Test Press U when have eaten L
	public void test_EatenL_PressU() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanL(true);
	    plane.keyPressed(KeyEvent.VK_U);
	    plane.keyReleased(KeyEvent.VK_U);
		assertEquals("PressU", plane.getLastCommand());
	}
	
	@Test
	//Test Press U when have eaten K
	public void test_EatenK_PressU() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
	    plane.setCanK(true);
	    plane.keyPressed(KeyEvent.VK_U);
	    plane.keyReleased(KeyEvent.VK_U);
		assertEquals("PressU", plane.getLastCommand());
	}
	
	@Test
	//test if plane is not hitted
	public void test_Not_Hitted() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(5);
		plane.setCanK(false);
		plane.setCanL(true);
		assertEquals(plane.isAlive(),true);
		assertEquals(plane.getLife(),5);
		assertEquals(plane.isFirst(),false);
	    assertEquals(plane.isCanK(),false);
	    assertEquals(plane.isCanL(),true);
	}
	
	
}

