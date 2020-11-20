package test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import game.BulletEm;
import game.Enemy;
import game.GameStart;
import game.Plane;


public class BulletEmTest {
	@Test
	//hitted by enemy when life =4 
	 public void test_Hit_By_Enemy_1()throws Exception
	{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(4);
		Enemy enemy=new Enemy(0, 0, true, gs);
		BulletEm bullet=new BulletEm (true,gs,enemy);
		bullet.hit(true);
		assertEquals(3, plane.getLife());
		assertEquals(false, plane.isCanK());
		assertEquals(false, plane.isCanL());
		assertEquals(true, plane.isAlive());
	}
	
	@Test
	//hitted by enemy when life =1
		 public void test_Hit_By_Enemy_2()throws Exception
		{
			GameStart gs =new GameStart();
			Plane plane=gs.getPlane();
			plane.setAlive(true);
			plane.setFirst(false);
			plane.setLife(1);
			Enemy enemy=new Enemy(0, 0, true, gs);
			BulletEm bullet=new BulletEm (true,gs,enemy);
			bullet.hit(true);
			assertEquals(0, plane.getLife());
			assertEquals(false, plane.isCanK());
			assertEquals(false, plane.isCanL());
			assertEquals(false, plane.isAlive());
		}
		 
     @Test 
     //bullet hit plane
     public void test_Hit_Plane() throws Exception{
    	 GameStart gs =new GameStart();
			Plane plane=gs.getPlane();
			plane.setAlive(true);
			plane.setFirst(true);
			plane.setX(250);
			plane.setY(126);
			Enemy enemy=new Enemy(216,46, true, gs);
			int bulletem=gs.getBulletEm().size();
			enemy.fire();
			int be=gs.getBulletEm().size();
		    boolean result1=gs.getBulletEm().get(be-1).checkisHitted();
		    gs.getBulletEm().get(be-1).hit(result1);
		    boolean result2=gs.getBulletEm().get(be-1).isAlive();
			assertEquals(bulletem,0);
			assertEquals(be,1);
		    assertEquals(result1,true);
		    assertEquals(result2,false);
     }
}
