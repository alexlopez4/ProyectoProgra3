package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.SelectLiga;
import objetos.Liga;

public class dbTest {

	private Liga liga1;
	private Liga liga2;
	private Liga liga3;
	private Liga liga4;
	private Liga liga5; 
	private ArrayList <Liga> listaLigas = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		this.liga1 = new Liga(1,"Liga Santander","Spain");
		this.liga2 = new Liga(2, "Bundesliga", "Germany");
		this.liga3 = new Liga(3, "Premier League", "England");
		this.liga4 = new Liga(4, "Ligue One", "France");
		this.liga5 = new Liga(5, "Seria A", "Italy");
		this.listaLigas.add(this.liga1);
		this.listaLigas.add(this.liga2);
		this.listaLigas.add(this.liga3);
		this.listaLigas.add(this.liga4);
		this.listaLigas.add(this.liga5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<Liga> arrayAComprobar = SelectLiga.getLiga("SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga");
		for (int i=0; i<listaLigas.size();i++){
			assertEquals(listaLigas.get(i).getIdLiga(), arrayAComprobar.get(i).getIdLiga());
			assertEquals(listaLigas.get(i).getNombreLiga(), arrayAComprobar.get(i).getNombreLiga());
			assertEquals(listaLigas.get(i).getPais(), arrayAComprobar.get(i).getPais());
		}
	}

}
