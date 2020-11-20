package test;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.Test;

import game.Boss;
import game.GameStart;
import game.Plane;

public class BossTest {

	@Test
	//Crash with boss when boss life >50
	public void test_Crash_With_Boss1() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(100);
	    boss.isHitted(false,false,true);
	    assertEquals(plane.getLife(),0);
	    assertEquals(boss.getBlood(),50);
	    assertEquals(plane.isAlive(),false);
	}
	
	@Test
	//Crash with boss when boss life < 50
	public void test_Crash_With_Boss2() throws Exception{
		GameStart gs=new GameStart();
		int originscore=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(40);
	    boss.isHitted(false,false,true);
	    assertEquals(plane.getLife(),0);
	    assertEquals(boss.isAlive(),false);
	    assertEquals(plane.isAlive(),false);
		assertEquals(gs.getScore(),originscore+1000);
	}
	
	@Test
	//hit by plane when boss life >5
	public void test_Hitted_By_Plane1() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(10);
	    boss.isHitted(true,false,false);
	    assertEquals(boss.getBlood(),5);
	}
	
	@Test 
	//hit by plane when boss life <5
	public void test_Hitted_By_Plane2() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(4);
	    boss.isHitted(true,false,false);
	    assertEquals(boss.isAlive(),false);
	    assertEquals(score+1000,gs.getScore());
	}
	
	@Test
	//hit by plane ult when boss life >10
	public void test_Hitted_By_PlaneUlt1() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(20);
	    boss.isHitted(false,true,false);
	    assertEquals(boss.getBlood(),10);
	}
	
	@Test 
	//hit by plane ult when boss life <10
	public void test_Hitted_By_PlaneUlt2() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
	    plane.setFirst(false);
	    Boss boss=new Boss(0,0,gs,true);
	    boss.setBlood(8);
	    boss.isHitted(false,true,false);
	    assertEquals(boss.isAlive(),false);
	    assertEquals(score+1000,gs.getScore());
	}
	
	@Test
	//not hitted
	public void test_NotHitted() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		Boss boss=new Boss(0,0,gs,true);
	    boss.isHitted(false, false,false);
		assertEquals(boss.isAlive(),true);
		assertEquals(score,gs.getScore());
	}
	
	@Test 
	// beat boss
	public void test_Beat_Boss() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		int bosstime=gs.getBossTime();
		int level=gs.getLevel();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setLife(3);
		Boss boss=new Boss(0,0,gs,true);
		boss.setBlood(-2);
		boss.checkDead();
		assertEquals(bosstime+10,gs.getBossTime());
		assertEquals(score+1000,gs.getScore());
		assertEquals(level+1,gs.getLevel());
		assertEquals(plane.getLife(),5);
	}
	
	@Test
	//Normal mode
	public void test_Normal_Mode() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		Boss boss=new Boss(0,0,gs,true);
		boss.setBlood(80);
		boss.checkMode();
		assertEquals("Normal", boss.getFireMode().getFireMode());
	}
	
	@Test
	//Angry mode
	public void test_Angry_Mode() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		Boss boss=new Boss(0,0,gs,true);
		boss.setBlood(40);
		boss.checkMode();
		assertEquals("Angry", boss.getFireMode().getFireMode());
	}
	
	@Test
	//Crazy mode
	public void test_Crazy_Mode() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		Boss boss=new Boss(0,0,gs,true);
		boss.setBlood(10);
		boss.checkMode();
		assertEquals("Crazy", boss.getFireMode().getFireMode());
	}
	
	@Test
	//test fire
	public void test_Fire() {
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		int bulletBossnum=gs.getBulletBoss().size();
		Boss boss=new Boss(0,0,gs,true);
		boss.fire();
		assertEquals(bulletBossnum+1,gs.getBulletBoss().size());
	}
	
	@Test
	//test bullet from player
	public void test_Bullet_From_Plane()throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(false);
		plane.setX(50);
		plane.setY(50);
		int origin=gs.getBulletPl().size();
		plane.keyPressed(KeyEvent.VK_J);
		int news=gs.getBulletPl().size();
		Boss boss=new Boss(94,40,gs,true);
		boolean result=boss.checkisHitted();
		assertEquals(origin,0);
		assertEquals(news,1);
		assertEquals(result,true);
	}
}
