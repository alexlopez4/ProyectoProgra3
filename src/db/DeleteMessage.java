package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import objetos.Usuario;

public class DeleteMessage {

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

    /**
     * Borrar un mensaje especificado mediante su texto, hora, fecha y autor
     *
     * @param 
     */
    public static void delete(String nombreUsuario,int idSalaDebate, String fecha, String texto)
    {
        String sql = "DELETE FROM registroMensajes "
        		+ "WHERE NOMBREUSUARIO=? "
        		+ "AND IDSALADEBATE=? "
        		+ "AND MENSAJE =? "
        		+ "AND FECHA=?;";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            pstmt.setObject(1, nombreUsuario);
            pstmt.setInt(2, idSalaDebate);
            pstmt.setString(3,texto);
            pstmt.setString(4,fecha);
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
