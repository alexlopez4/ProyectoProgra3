package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.SelectJugador;
import objetos.Equipo;
import objetos.Jugador;

public class TestValorEquipo {
	private ArrayList<Jugador> jugadoresRealSociedad = null;

	@Before
	public void setUp() throws Exception {
		String sql ="SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ "ON B.IDEQUIPO= jugador.IDEQUIPO"
				+ " WHERE B.NOMBREEQUIPO ='Real Sociedad de Fútbol S.A.D.';";
		jugadoresRealSociedad = SelectJugador.getJugadores(sql);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		int valorEquipo = 150;
		int valorAComprobar = Jugador.valorEquipo(jugadoresRealSociedad);
		assertEquals(valorAComprobar, valorEquipo,0.0);
		}
	
	@Test (expected = ArithmeticException.class)
	public void test2ValorMedio(){
		int jugadoresEquipo =0;
		double media = Equipo.mediaPrecioEquipo(jugadoresRealSociedad, jugadoresEquipo);
	}
	
	@Test
	public void test() {
		int jugadoresEquipo = 0;
		try{
			double media = Equipo.mediaPrecioEquipo(jugadoresRealSociedad, jugadoresEquipo);
			fail();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
