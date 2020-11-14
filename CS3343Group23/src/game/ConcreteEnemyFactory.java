package game;

import java.util.Random;

public class ConcreteEnemyFactory extends EnemyFactory {

	private GameStart gs;
	private Random ran = new Random();
	
	public ConcreteEnemyFactory(GameStart gs){
		this.gs=gs;
	}
	
	@Override
	public Enemy factoryEnemy() {
		Enemy newEn;
		newEn = (new Enemy(ran.nextInt(500) + 10, 0, true, gs));
		return newEn;
	}
	
}