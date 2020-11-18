package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.Boss;
import game.Enemy;
import game.GameStart;
import game.Plane;
import game.Explode;

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
	    boss.isHitted(false,true);
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
	    boss.isHitted(false,true);
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
	    boss.isHitted(true,false);
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
	    boss.isHitted(true,false);
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
		plane.setFirst(true);
		Boss boss=new Boss(0,0,gs,true);
	    boss.isHitted(false, false);
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
		plane.setFirst(true);
		plane.setLife(3);
		Boss boss=new Boss(0,0,gs,true);
		boss.setBlood(-2);
		boss.checkDead();
		assertEquals(bosstime+10,gs.getBossTime());
		assertEquals(score+1000,gs.getScore());
		assertEquals(level+1,gs.getLevel());
		assertEquals(plane.getLife(),5);
	}
}
