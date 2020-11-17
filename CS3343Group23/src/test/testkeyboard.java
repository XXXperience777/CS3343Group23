package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;

import game.GameStart;
import game.Plane;
import game.Command;
import game.W;
import game.A;
import game.D;
import game.S;
import game.J;
import game.K;

public class testkeyboard {
        private	GameStart gs;

	@BeforeEach
	public void setup() throws Exception{
        gs=new GameStart();
	}
	
	public void pressKey() {
		
		
	}
	@Test
	//test if press the enter button will start the game
	public void test1()throws Exception{
		
		
	}
	
	@Test 
	//test if press the A button will make the plane go left
	public void test21() throws Exception{
		int newx,newy;
		Plane plane=gs.getPlane();
		Command a=new A();
		a.pressKey(plane);
		plane.move();
		newx=plane.getX();
		newy=plane.getY();
		a.releaseKey(plane);
		boolean result=(newy==500)&&(newx<250);
		assertEquals(result,true);
	}
	
	@Test 
	//test if press the A button continuously will make the plane go border and stop
	public void test22() throws Exception{
		Plane plane=gs.getPlane();
		Command a=new A();
		int x=plane.getX(),newx = 0;
		while(x>0) {
			x=plane.getX();
			a.pressKey(plane);
			plane.move();
			newx=plane.getX();
			a.releaseKey(plane);
		}
		boolean result= (x==newx);
		assertEquals(result,true);
	}

	@Test 
	//test if press the Q button will have no response
	public void test23() throws Exception{
		Plane plane=gs.getPlane();
		int x=plane.getX();
		int y=plane.getY();
		
				
	}
	
	@Test
	//test if press the D button will make the plane go right
	public void test31() throws Exception{
		int newx,newy;
		Plane plane=gs.getPlane();
		Command d=new D();
		d.pressKey(plane);
		plane.move();
		newx=plane.getX();
		newy=plane.getY();
		d.releaseKey(plane);
		boolean result=(newy==500)&&(newx>250);
		assertEquals(result,true);
	}

	@Test 
	//test if press the D button continuously will make the plane go border and stop
	public void test32() throws Exception{
		Plane plane=gs.getPlane();
		Command d=new D();
		int x=plane.getX(),newx = 0;
		while(x<512) {
			x=plane.getX();
			d.pressKey(plane);
			plane.move();
			newx=plane.getX();
			d.releaseKey(plane);
		}
		boolean result= (x==newx);
		assertEquals(result,true);
	}
	
	@Test
	//test if press the W button will make the plane go up
	public void test41() throws Exception{
		int newx,newy;
		Plane plane=gs.getPlane();
		Command w=new W();
	    w.pressKey(plane);	
	    plane.move();
		newx=plane.getX();
		newy=plane.getY();
		w.releaseKey(plane);
		boolean result=(newy<500)&&(newx==250);
		assertEquals(result,true);
	}
	
	@Test 
	//test if press the W button continuously will make the plane go border and stop
	public void test42() throws Exception{
		Plane plane=gs.getPlane();
		Command w=new W();
		int y=plane.getY(),newy = 0;
		while(y>25) {
			y=plane.getY();
			w.pressKey(plane);
			plane.move();
			newy=plane.getY();
			w.releaseKey(plane);
		}
		boolean result= (y==newy);
		assertEquals(result,true);
	}
	
	@Test 
	//test if press the S button will not make the plane go down
	public void test51() throws Exception{
		int newx,newy;
		Plane plane=gs.getPlane();
	    Command s=new S();
	    s.pressKey(plane);
	    plane.move();
		newx=plane.getX();
		newy=plane.getY();
		s.releaseKey(plane);
		boolean result=(newy>500)&&(newx==250);
		assertEquals(result,true);
	}
	
	@Test 
	//test if press the S button continuously will make the plane go border and stop
	public void test52() throws Exception{
		Plane plane=gs.getPlane();
		Command s=new S();
		int y=plane.getY(),newy = 0;
		while(y<600) {
			y=plane.getY();
			s.pressKey(plane);
			plane.move();
			newy=plane.getY();
			s.releaseKey(plane);
		}
		boolean result= (y==newy);
		assertEquals(result,true);
	}
	
	@Test
	//
	public void test61() throws Exception{
		Plane plane=gs.getPlane();
		Command j=new J();
		j.pressKey(plane);
		j.releaseKey(plane);
		int size=gs.getBulletPl().size();
		assertEquals(size,1);
	}
	
	@Test
	//
	public void test62() throws Exception{
		Plane plane=gs.getPlane();
		int num = (int)(Math.random()*101+100);
		Command j=new J();
		for(int i=0;i<num;i++) {
			j.pressKey(plane);
			j.releaseKey(plane);
		}
		int size=gs.getBulletPl().size();
		assertEquals(size,num);
	} 
	
	@Test 
	//
	public void test63() throws Exception{
		Plane plane=gs.getPlane();
		int num = (int)(Math.random()*101+100);
		Command j=new J();
		for(int i=0;i<num;i++)
			j.pressKey(plane);
		j.releaseKey(plane);
		
	}
	
	@Test
	//
	public void test641() throws Exception{
		Plane plane=gs.getPlane();
		
	}
	
	@Test 
	//
	public void test71() throws Exception{
		Plane plane=gs.getPlane();
		plane.setCanK(true);
		Command k=new K();
		k.pressKey(plane);
	}
}
