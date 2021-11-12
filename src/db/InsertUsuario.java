package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsuario {

	/** Establece la conexión con la base de datos
	 * 
	 * @return conn, la conexion que se establece con el DriverManager
	 */
	 private static Connection connect()
	    {
	        String url = "jdbc:sqlite:Proyect.db";
	        Connection conn = null;
	        try
	        {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 
	 public static void insertUsuario(String nombre, int edad, String nombreUsuario, String contrasenya){
		 String sql = "INSERT INTO usuario(NOMBREUSUARIO,NOMBRE,EDAD,PSSW) VALUES(?,?,?,?)";
	        try
         (
         		Connection conn = connect();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)
         )
 {
	            pstmt.setString(1, nombreUsuario);
	            pstmt.setString(2, nombre);
	            pstmt.setInt(3, edad);
	            pstmt.setString(4, contrasenya);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 }

