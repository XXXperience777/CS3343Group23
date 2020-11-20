package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.BulletBoss;
import game.Boss;
import game.GameStart;
import game.Plane;


public class BulletBossTest {

	@Test
	//hitted by the right normal mode boss when life=4
	public void test_Hit_By_Normal_Boss1() throws Exception{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(4);
		plane.setCanL(true);
		plane.setCanK(true);
		Boss boss=new Boss(0,0,gs,true);
		BulletBoss bullet=new BulletBoss(true,gs,boss);
		bullet.setIndex(9);
		bullet.isHitted(true);
		assertEquals(3, plane.getLife());
		assertEquals(true, plane.isAlive());
	    assertEquals(plane.isCanL(),false);
	    assertEquals(plane.isCanK(),true);
	}
	
	@Test
	//hitted by the left normal mode boss when life=4
	public void test_Hit_By_Normal_Boss2() throws Exception{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(4);
		plane.setCanL(true);
		plane.setCanK(true);
		Boss boss=new Boss(0,0,gs,true);
		BulletBoss bullet=new BulletBoss(true,gs,boss);
		bullet.setIndex(1);
		bullet.isHitted(true);
		assertEquals(3, plane.getLife());
		assertEquals(true, plane.isAlive());
	    assertEquals(plane.isCanL(),true);
	    assertEquals(plane.isCanK(),false);
	}
	
	@Test 
	//hitted by the normal boss when life=1
	public void test_Hit_By_Normal_Boss3() throws Exception{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(1);
		Boss boss=new Boss(0,0,gs,true);
		BulletBoss bullet=new BulletBoss(true,gs,boss);
		
		bullet.isHitted(true);
		assertEquals(0, plane.getLife());
		assertEquals(false, plane.isAlive());
	}
	
	@Test 
	//bullet1 hit plane
	public void test_Bullet1_Hit_Plane() {
		 GameStart gs =new GameStart();
			Plane plane=gs.getPlane();
			plane.setAlive(true);
			plane.setFirst(true);
			plane.setX(250);
			plane.setY(170);
			Boss boss=new Boss(230,120, gs,true);
			BulletBoss bboss=new BulletBoss(true,gs,boss);
		    bboss.setIndex(9);
			boolean result=bboss.checkisHitted();
			assertEquals(result,true);	
	}
	
	@Test 
	//bullet2 hit plane
	public void test_Bullet2_Hit_Plane() {
		 GameStart gs =new GameStart();
			Plane plane=gs.getPlane();
			plane.setAlive(true);
			plane.setFirst(true);
			plane.setX(450);
			plane.setY(170);
			Boss boss=new Boss(50,20, gs,true);
			BulletBoss bboss=new BulletBoss(true,gs,boss);
		    bboss.setIndex(1);
			boolean result=bboss.checkisHitted();
			assertEquals(result,true);	
	}
}
