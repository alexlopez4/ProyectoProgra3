package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.SelectLiga;
import objetos.Liga;

public class TestLiga {

	private Liga u;
	
	@Before
	public void setUp() throws Exception {
		
		u= new Liga(1,"Serie A", "Spain" );
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}

	@Test
	public void test() {
		String sql = "SELECT IDLIGA,NOMBRELIGA ,PAIS from liga";
		ArrayList<Liga> a =SelectLiga.getLiga(sql);
		try{
			Liga.LigaDuplicada(u, a);
		}catch(Exception e){
			
		}
	}

}

