package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Equipo;

public class DeleteUsuario {

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
     * Borrar un jugador especificado mediante su nombre , nombreUsuario , edad , pasw
     *
     * @param 
     */
	public static void delete(String nombre,String nom, int edad, String pasw){
        String sql = "DELETE FROM usuario "
        		+ "WHERE NOMBREUSUARIO=? "
        		+ "AND NOMBRE =? "
        		+ "AND EDAD=?"        		
        		+ "AND PSSW=?;";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
        	pstmt.setString(1, nombre);
            pstmt.setString(2, nom);
            pstmt.setInt(3,edad);
            pstmt.setString(4,pasw);


        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}