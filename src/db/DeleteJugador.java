package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import objetos.Equipo;

public class DeleteJugador {

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
     * Borrar un jugador especificado mediante su id, nombre, edad ,precio y idequipo
     *
     * @param 
     */
	public static void delete(int id ,String nombreJugador,int edad, int precio, Equipo equipo){
        String sql = "DELETE FROM jugador "
        		+ "WHERE IDJUGADOR=? "
        		+ "AND NOMBREJUGADOR=? "
        		+ "AND EDADJUGADOR =? "
        		+ "AND PRECIOENM=?"        		
        		+ "AND IDEEQUIPO=?;";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            int a=equipo.getIdEquipo();
        	pstmt.setInt(1, id);
            pstmt.setString(2, nombreJugador);
            pstmt.setInt(3,edad);
            pstmt.setInt(4,precio);
            pstmt.setInt(5,a);
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
