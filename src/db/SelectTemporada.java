package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Liga;
import objetos.RegistroMensajes;
import objetos.SalaDebate;
import objetos.Temporada;
import objetos.Usuario;

public class SelectTemporada {

	
	/** Establece la conexión con la base de datos
	 * 
	 * @return conn, la conexion que se establece con el DriverManager
	 */
	private static Connection connect(){
		String url = "jdbc:sqlite:Proyect.db";
		Connection con = null;
		try{
			con = DriverManager.getConnection(url);
			}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static ArrayList <Temporada> getTemporada(String sql){
		ArrayList<Temporada> ediciones = new ArrayList<Temporada>();
		try
		(
        		Connection conn = connect();
                PreparedStatement pstmt  = conn.prepareStatement(sql)
        )
		{
	ResultSet rs  = pstmt.executeQuery();
	 
    while (rs.next())
    {
    Temporada t = new Temporada(rs.getString("EDICION"));
    ediciones.add(t); }
	}
		catch(SQLException e){
	System.out.println(e.getMessage());
	}
		return ediciones;
			
		}
}

