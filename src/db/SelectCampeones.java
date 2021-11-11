package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Equipo;
import objetos.Liga;

public class SelectCampeones {

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
	
	/** Este método permite obtener mediante una consulta indicada por parametro al equipo que se desee,
	 * nosotros lo hemos empleado para obtener a los campeones de cada una de las ligas
	 * @param sql la sentencia sql
	 * @return el equipo que se quiere obtener
	 */
	public static Equipo getCampeon(String sql){
		Equipo campeon = null;
		try (Connection conn=connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)
					)
		{
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Liga l = new Liga (rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
				campeon = new Equipo (l, rs.getInt("IDEQUIPO"),rs.getString("NOMBREEQUIPO"),rs.getString("ESTADIO"));
			}
			
		}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return campeon;
		}
	}

