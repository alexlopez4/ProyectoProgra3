package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewMessage {

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

	    public static void insertMensaje(String nombreUsuario, int SalaDebate, String mensaje,String fecha)
	    {
	        String sql = "INSERT INTO registroMensajes(NOMBREUSUARIO,IDSALADEBATE,MENSAJE,FECHA) VALUES(?,?,?,?)";
	        try
            (
            		Connection conn = connect();
                    PreparedStatement pstmt  = conn.prepareStatement(sql)
            )
    {
	            pstmt.setString(1, nombreUsuario);
	            pstmt.setInt(2, SalaDebate);
	            pstmt.setString(3, mensaje);
	            pstmt.setString(4, fecha);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }

}
