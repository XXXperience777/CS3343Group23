package test;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

import game.LifePlane;
import game.GUISetUp;
import game.GameStart;
import game.GUISetUp;

public class LifePlaneTest {
@Test
//test lifePlane
public void test_LifePlane() throws Exception{
	GameStart gs=new GameStart();
	GUISetUp ui=gs.getUi();
	LifePlane life=new LifePlane(0,40,ui,true);
	assertEquals(life.isAlive(),true);
}
}
