package test;

import static org.junit.Assert.*;
import java.awt.event.KeyEvent;
import org.junit.Test;

import game.GameStart;
import game.Plane;

public class PlaneTest {
	
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
		assertEquals("PressK", plane.getLastCommand());
		
	
	  
    }
}
