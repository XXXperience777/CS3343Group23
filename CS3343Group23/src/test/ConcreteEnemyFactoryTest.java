package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import game.ConcreteEnemyFactory;
import game.Enemy;
import game.GameStart;

public class ConcreteEnemyFactoryTest {
	@Test
	//factory one Enemy
	public void test_factory()throws Exception{
		GameStart gs=new GameStart();
		ConcreteEnemyFactory fa=new ConcreteEnemyFactory(gs);
		Enemy enemy=fa.factoryEnemy();
		assertEquals(true, enemy.isAlive());
		assertNotNull(enemy);
	}
}
