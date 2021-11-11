package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Equipo;
import objetos.Estadisticas;
import objetos.Jugador;
import objetos.Liga;
import objetos.Temporada;

public class SelectEstadisticas {

	/** Establece la conexión con la base de datos
	 * 
	 * @return conn, la conexion que se establece con el DriverManager
	 */
	private static Connection connect(){
		String url = "jdbc:sqlite:Proyect.db";
		Connection conn=null;
		try{
			conn = DriverManager.getConnection(url);
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
		}
	
	/**Este método sirve para obtener todas las estadísticas que se indiquen mediante la consulta sql
	 * que se le pasa por parametro
	 * 
	 * @param sql, consulta a realizar
	 * @return arrayList con las estadisticas que responden a la consulta sql realizada
	 */
	public static ArrayList<Estadisticas> getEstadisticasJugador(String sql){
		ArrayList<Estadisticas> arrayEstadis= new ArrayList<Estadisticas>();
		try (Connection conn=connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)
					)
		{
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Temporada temp = new Temporada(rs.getString("EDICION"));
				Liga liga = new Liga (rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
				Equipo equipo= new Equipo (liga, rs.getInt("IDEQUIPO"),rs.getString("NOMBREEQUIPO"),rs.getString("ESTADIO"));
				Estadisticas estadistica = new Estadisticas( rs.getString("NOMBREJUGADOR"), rs.getInt("EDADJUGADOR"), equipo, rs.getInt("IDJUGADOR"),rs.getInt("PRECIOENM"),
						temp, rs.getInt("IDESTADISTICAS"),rs.getInt("GOLES"),rs.getInt("ASISTENCIAS"),rs.getInt("TAREJETASAMARILLAS"),rs.getInt("TARJETASROJAS"));
				arrayEstadis.add(estadistica);
			}
			
		}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return arrayEstadis;
		}

	}



