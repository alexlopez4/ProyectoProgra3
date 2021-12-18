package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.SelectCampeones;
import objetos.Equipo;
import objetos.Liga;

public class dbTest2 {
	private Equipo campeon1;
	private Equipo campeon2;
	private Liga liga1;
	private Liga liga2;
	private boolean prueba;
	@Before
	public void setUp() throws Exception {
		liga1 = new Liga (1,"Liga Santander", "Spain");
		campeon1 = new Equipo (liga1, 2,"Real Sociedad de Fútbol S.A.D.", "Reale Arena");
		liga2 = new Liga (4, "Ligue One", "France");
		campeon2= new Equipo (liga2, 9, "Paris Saint-Germain Football Club", "Parc des Princes");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		String sql = "SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO FROM LIGA C"
				+" JOIN (SELECT B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA FROM EQUIPO B "
				+"JOIN (SELECT EDICION, IDLIGA, CAMPEON FROM temporadadeliga "
				+"WHERE IDLIGA =1 AND EDICION ='2020/2021')A "
				+"ON B.IDEQUIPO=A.CAMPEON) D "
				+"ON C.IDLIGA=D.IDLIGA;";
		Equipo campeonAComprobar1 = SelectCampeones.getCampeon(sql);
		if (campeonAComprobar1.getIdEquipo()==campeon1.getIdEquipo() && campeonAComprobar1.getNombreEquipo().equals(campeon1.getNombreEquipo())
				&& campeonAComprobar1.getEstadio().equals(campeon1.getEstadio())){
			prueba = true;
		}else{
			prueba = false;
		}
			assertTrue(prueba);	
	}
	
	@Test
	public void test2() {
		String sql = "SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO FROM LIGA C"
				+" JOIN (SELECT B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA FROM EQUIPO B "
				+"JOIN (SELECT EDICION, IDLIGA, CAMPEON FROM temporadadeliga "
				+"WHERE IDLIGA =4 AND EDICION ='2020/2021')A "
				+"ON B.IDEQUIPO=A.CAMPEON) D "
				+"ON C.IDLIGA=D.IDLIGA;";
		Equipo campeonAComprobar2 = SelectCampeones.getCampeon(sql);
		assertEquals(campeonAComprobar2.getIdEquipo(),campeon2.getIdEquipo());
		assertEquals(campeonAComprobar2.getNombreEquipo(),campeon2.getNombreEquipo());
		assertEquals(campeonAComprobar2.getEstadio(),campeon2.getEstadio());
	}
}
