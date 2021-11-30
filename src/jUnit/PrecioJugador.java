package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objetos.Equipo;
import objetos.Jugador;
import objetos.Liga;

public class PrecioJugador {
	
	private Jugador u;

	@Before
	public void setUp() throws Exception {
		
		Liga a =new Liga(0, "a", "a");
		Equipo e = new Equipo(a, 0, "a", "a");
		Jugador u = new Jugador ("Giovanni", 20, e , 24, -1);		
	}
	
	@After
	public void tearDown() throws Exception {
		u=null;
		
	}

	@Test
	public void test() {

		int z= u.getPrecioEnMillones();
		int a=Jugador.Millones(z);
		
		if (a==0){
			u.setPrecioEnMillones(0);
		}
		else{
			fail();
		}
	}
	
}
