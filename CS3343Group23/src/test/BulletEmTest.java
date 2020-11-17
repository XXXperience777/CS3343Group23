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
	//hitted by enemy when life > 1 
	 public void test_Hit_By_Enemy_1()throws Exception
	{
		Plane plane= new Plane(true);
		plane.setLife(4);
		class StubBulletEm extends BulletEm{

			public StubBulletEm(boolean alive, GameStart gs, Enemy enemy) {
				super(alive, gs, enemy);
			
			}
			@Override
			public void isHitted() {
				
				if (plane.isAlive()) {
					setAlive(false);
					plane.setLife(plane.getLife() - 1);
					plane.setCanK(false);
					plane.setCanL(false);
					
				}
			}
		}

		GameStart gs =new GameStart();
		Enemy enemy=new Enemy(0, 0, true, gs);
		StubBulletEm bullet=new StubBulletEm (true,gs,enemy);
		bullet.isHitted();
		assertEquals(3, plane.getLife());
		assertEquals(false, plane.isCanK());
		assertEquals(false, plane.isCanL());
	}

}
