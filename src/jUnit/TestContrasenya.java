package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objetos.Usuario;

public class TestContrasenya {
	
	private Usuario u ;
	
	@Before
	public void setUp() throws Exception {
		
		Usuario u= new Usuario ("Giovanni",9,"hola"," ");
	}

	@After
	public void tearDown() throws Exception {

	u=null;	
	}

	@Test
	public void test() {
		
		try{
			Usuario.Contrasena(u);
			fail();
			
		}catch(Exception e){	
		}	
	}

}

