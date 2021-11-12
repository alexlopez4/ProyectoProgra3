package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objetos.Equipo;
import objetos.Jugador;
import objetos.Liga;

public class TestMediaPrecioEquipo {

	private Jugador u;
	private Jugador x;
	private ArrayList <Jugador> players;
	
	@Before
	public void setUp() throws Exception {
		Liga a =new Liga(0, "a", "a");
		Equipo e = new Equipo(a, 0, "a", "a");
		this.u = new Jugador ("Giovanni", 20, e , 24, 30);
		
		Liga b =new Liga(1, "b", "b");
		Equipo e2 = new Equipo(b, 1, "b", "b");
		this.x = new Jugador ("Alex", 20, e2 , 24, 10);
		
		this.players.add(u);
		this.players.add(x);
	}

	@After
	public void tearDown() throws Exception {
		this.u = null;
		this.x = null;
	}

	@Test
	public void test() {
		int jugadoresEnEquipo = 0;
		try{
			double media = Equipo.mediaPrecioEquipo(players, jugadoresEnEquipo);
			fail();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
