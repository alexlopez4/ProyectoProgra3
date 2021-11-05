package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void createNewTable(String sql){
		String name="Proyect.db";
		String url="jdbc:sqlite:"+name;
		
		try
		(Connection conn=DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();	
				)
		{
			stmt.execute(sql);
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args){
		createNewTable("CREATE TABLE IF NOT EXISTS usuario(\n"
				+"NOMBREUSUARIO VARCHAR(40) NOT NULL PRIMARY KEY,\n"
				+"NOMBRE VARCHAR2 NOT NULL,\n"
				+"EDAD NUMBER NOT NULL,\n"
				+"PSSW VARCHAR(25) NOT NULL\n"
				+ ");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS periodico(\n"
				+"IDPERIODICO NUMBER NOT NULL PRIMARY KEY,\n"
				+"NOMBREPERIODICO VARCHAR(50) NOT NULL,\n"
				+"PAIS VARCHAR(25) NOT NULL\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS liga(\n"
				+"IDLIGA NUMBER NOT NULL PRIMARY KEY,\n"
				+"NOMBRELIGA VARCHAR(30) NOT NULL,\n"
				+"PAIS VARCHAR(25) NOT NULL\n"
				+ ");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS noticia(\n"
				+"IDNOTICIA NUMBER NOT NULL PRIMARY KEY,\n"
				+"TITULO VARCHAR2 NOT NULL,\n"
				+"TEXTO VARCHAR2 NOT NULL,\n"
				+"IDIOMA VARCHAR(25) NOT NULL,\n"
				+"FECHA DATE NOT NULL,\n"
				+"IDPERIODICO NUMBER REFERENCES PERIODICO(IDPERIODICO) ON DELETE CASCADE,\n"
				+"IDLIGA NUMBER REFERENCES LIGA(IDLIGA) ON DELETE CASCADE\n"
				+");");
				
		createNewTable("CREATE TABLE IF NOT EXISTS equipo(\n"
				+"IDEQUIPO NUMBER NOT NULL PRIMARY KEY,\n"
				+"NOMBREEQUIPO VARCHAR(40) NOT NULL,\n"
				+"ESTADIO VARCHAR(25) NOT NULL,\n"
				+"IDLIGA NUMBER REFERENCES LIGA(IDLIGA) ON DELETE CASCADE\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS jugador(\n"
				+"IDJUGADOR NUMBER NOT NULL PRIMARY KEY,\n"
				+"NOMBREJUGADOR VARCHAR2 NOT NULL,\n"
				+"EDADJUGADOR NUMBER NOT NULL,\n"
				+"PRECIOENM NUMBER NOT NULL,\n"
				+"IDEQUIPO NUMBER REFERENCES EQUIPO(IDEQUIPO) ON DELETE CASCADE\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS temporada(\n"
				+"EDICION VARCHAR(10) NOT NULL PRIMARY KEY\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS estadisticas(\n"
				+"IDESTADISTICAS NUMBER NOT NULL PRIMARY KEY,\n"
				+"GOLES NUMBER NOT NULL,\n"
				+"ASISTENCIAS NUMBER NOT NULL, \n"
				+"TAREJETASAMARILLAS NUMBER NOT NULL,\n"
				+"TARJETASROJAS NUMBER NOT NULL,\n"
				+"IDJUGADOR NUMBER REFERENCES JUGADOR(IDJUGADOR) ON DELETE CASCADE,\n"
				+"EDICION VARCHAR(10) REFERENCES TEMPORADA(EDICION) ON DELETE CASCADE\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS saladebate(\n"
				+"IDSALADEBATE NUMBER NOT NULL PRIMARY KEY,\n"
				+"TEMADEBATE VARCHAR2 NOT NULL,\n"
				+"TEXTO VARCHAR2 NOT NULL,\n"
				+"IDLIGA NUMBER REFERENCES LIGA(IDLIGA) ON DELETE CASCADE\n"
				+");");
		
		createNewTable("CREATE TABLE IF NOT EXISTS usuarioensaladebate(\n"
				+"NOMBREUSUARIO VARCHAR(40) REFERENCES USUARIO(NOMBREUSUARIO) ON DELETE CASCADE,\n"
				+"IDSALADEBATE NUMBER REFERENCES SALADEBATE(IDSALADEBATE) ON DELETE CASCADE,\n"
				+"PRIMARY KEY(NOMBREUSUARIO,IDSALADEBATE)\n"
				+ ");");
		
		createNewTable("CREATE TABLE temporadadeliga(\n"
				+"EDICION VARCHAR(10) REFERENCES TEMPORADA(EDICION) ON DELETE CASCADE,\n"
				+"IDLIGA NUMBER REFERENCES LIGA(IDLIGA) ON DELETE CASCADE,\n"
				+"PRIMARY KEY(EDICION,IDLIGA)\n"
				+");");
	}
}
