package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import game.Food;
import game.Plane;
import game.GameStart;

public class FoodTest {
 @Test
 // get L attack Block
 public void test_getL_Block() {
	 GameStart gs=new GameStart();
	 Plane plane=gs.getPlane();
	 plane.setCanL(false);
	 Food food= new Food(0,0,gs,true);
	 food.setIndex(0);
	 food.isEaten(true);
	 assertEquals(false,food.isAlive());
	 assertEquals(true,plane.isCanL());
 }
 
 @Test
 //get K attack Block
 public void test_getK_Block() {
	 GameStart gs=new GameStart();
	 Plane plane=gs.getPlane();
	 plane.setCanK(false);
	 Food food= new Food(0,0,gs,true);
	 food.setIndex(1);
	 food.isEaten(true);
	 assertEquals(false,food.isAlive());
	 assertEquals(true,plane.isCanK());
 }
}
