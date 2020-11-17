package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.BulletEm;
import game.Enemy;
import game.Explode;
import game.GameStart;
import game.Plane;

import org.junit.Test;

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
}
