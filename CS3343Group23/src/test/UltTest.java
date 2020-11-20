package test;
import static org.junit.Assert.*;
import org.junit.Test;

import game.GameStart;
import game.Ult;

public class UltTest {
@Test
//test ult disappear
public void test_Ult_Disappear() throws Exception{
	GameStart gs=new GameStart();
	Ult ult=new Ult(gs,true);
	ult.setY(5);
	ult.move();
	assertEquals(false,ult.isAlive());
}
}
