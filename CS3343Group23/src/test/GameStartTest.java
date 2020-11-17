package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import game.GameStart;

public class GameStartTest {
	@Test
	//test if kill 10 enemy will birth the boss
	public void test_kill_10_enemy()throws Exception{
		GameStart gs=new GameStart();
		gs.getPlane().setFirst(false);
		for(int i=0;i<10;i++)
			gs.addCount();
		assertEquals(true,gs.getBoss().isAlive());
		
	}
}
