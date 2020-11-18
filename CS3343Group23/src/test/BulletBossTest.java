package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.BulletBoss;
import game.Boss;
import game.Explode;
import game.GameStart;
import game.Plane;

import org.junit.Test;

public class BulletBossTest {

	@Test
	//hitted by the normal mode boss when life=4
	public void test_Hit_By_Normal_Boss1() throws Exception{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(4);
		Boss boss=new Boss(0,0,gs,true);
		BulletBoss bullet=new BulletBoss(true,gs,boss);
		
		bullet.isHitted();
		assertEquals(3, plane.getLife());
		assertEquals(true, plane.isAlive());
	}
	
	@Test 
	//hitted by the normal boss when life=1
	public void test_Hit_By_Normal_Boss2() throws Exception{
		GameStart gs =new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(1);
		Boss boss=new Boss(0,0,gs,true);
		BulletBoss bullet=new BulletBoss(true,gs,boss);
		
		bullet.isHitted();
		assertEquals(0, plane.getLife());
		assertEquals(false, plane.isAlive());
	}
}
