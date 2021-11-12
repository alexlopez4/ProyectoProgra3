package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objetos.Usuario;

public class TestAdmin {

	private Usuario user;
	private Usuario user2;
	
	@Before
	public void setUp(){
		user = new Usuario ("Alex", 20, "Admin", "Admin"); 
		// Este usuario debería devolver true porque es el Admin de la App
		
		user2 = new Usuario ("Giovanni", 22, "GioL", "Italia");
		// Este usuario debería devolver un false porque no es el Admin de la App
		
	}
	
	@After
	public void tearDown(){
		user = null;
	}
	@Test
	public void test() {
		assertTrue(user.esAdmin());
		assertFalse(user2.esAdmin());
	}

}
