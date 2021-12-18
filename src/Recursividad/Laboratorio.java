package Recursividad;

import java.util.ArrayList;

import db.SelectEstadisticas;
import objetos.Estadisticas;
/**
 * 
 * @author Alex López de Lacalle
 * @author Giovanni Locatelli
 * Esta clase es un laboratorio para tratar de comprobar el funcionamiento del metodo mergeSortNum
 * No acabamos de darnos cuenta de donde está el error, puesto que es obvio que el método no funciona como lo esperado
 *
 */
public class Laboratorio {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS, TARJETASROJAS FROM estadisticas "
				+ " JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
				+ " JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ " ON B.IDEQUIPO= jugador.IDEQUIPO )C"
				+ " WHERE EDICION='2020/2021')D"
				+ " ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION) ";

		ArrayList <Estadisticas> e = SelectEstadisticas.getEstadisticasJugador(sql);
		System.out.println(e);
		Ordenacion.mergeSortNum(e);
		System.out.println(e);
	}

}
