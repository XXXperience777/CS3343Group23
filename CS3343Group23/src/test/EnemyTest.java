package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.Enemy;
import game.GameStart;
import game.Plane;
import game.Explode;

public class EnemyTest {

	@Test
	//crash with enemy when life=4
	public void test_Crash_With_Enemy1() throws Exception{
     GameStart gs=new GameStart();
     int score=gs.getScore();
     Plane plane=gs.getPlane();
     plane.setAlive(true);
     plane.setFirst(false);
     plane.setCanK(true);
     plane.setCanL(true);
     plane.setLife(4);
     Enemy enemy=new Enemy(0, 0, true, gs);
     enemy.isHitted(false,false,true);
     assertEquals(3,plane.getLife());
     assertEquals(true, plane.isAlive());
     assertEquals(false,enemy.isAlive());
     assertEquals(score+100,gs.getScore());
     assertEquals(false, plane.isCanK());
     assertEquals(false, plane.isCanL());
	}
	
	@Test 
	//crash with enemy when life=1
	public void test_Crash_With_Enemy2() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		plane.setLife(1);
		plane.setCanK(true);
	     plane.setCanL(true);
		Enemy enemy=new Enemy(0,0,true,gs);
		enemy.isHitted(false,false,true);
		assertEquals(0,plane.getLife());
	    assertEquals(false, plane.isAlive());
	    assertEquals(false,enemy.isAlive());
	    assertEquals(false, plane.isCanK());
	    assertEquals(false, plane.isCanL());
	}
	
	@Test
	//hit by plane 
	public void test_Hitted_By_Plane() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		Enemy enemy=new Enemy(0,0,true,gs);
	    enemy.isHitted(true,false, false);
	    assertEquals(enemy.isAlive(),false);
	    assertEquals(score+100,gs.getScore());
	}
	
	@Test 
	//hit by plane ult
	public void test_Hitted_By_PlaneUlt() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		Enemy enemy=new Enemy(0,0,true,gs);
	    enemy.isHitted(false,true, false);
	    assertEquals(enemy.isAlive(),false);
	    assertEquals(score+100,gs.getScore());
	}
	
	@Test
	//not hitted
	public void test_NotHitted() throws Exception{
		GameStart gs=new GameStart();
		int score=gs.getScore();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		Enemy enemy=new Enemy(0,0,true,gs);
	    enemy.isHitted(false,false, false);
		assertEquals(enemy.isAlive(),true);
		assertEquals(score,gs.getScore());
	}
	
	@Test
	//enemy go out of game board
	public void test_Go_Out_Board() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		Enemy enemy=new Enemy(0,0,true,gs);
		enemy.setY(800);
		enemy.move();
		assertEquals(enemy.isAlive(),false);
	}
	
	@Test 
	//test enemy fire
	public void test_Fire() throws Exception{
		GameStart gs=new GameStart();
		Plane plane=gs.getPlane();
		plane.setAlive(true);
		plane.setFirst(true);
		int bulletEmnum=gs.getBulletEm().size();
		Enemy enemy=new Enemy(0,0,true,gs);
		enemy.fire();
		assertEquals(bulletEmnum+1,gs.getBulletEm().size());
	}
}
