package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.InsertNewForo;

public class TestNumeroSalasDebate {

	private int a;
	
	@Before
	public void setUp(){
		int a=0;
	}
	
	@After
	public void tearDown(){
		
	}
	@Test
	public void test() {
		a = InsertNewForo.countSalaDebate();
		assertEquals(13,a,0.0);
	}

	
}
