package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateJugador {

	private static Connection connect()
    {
		String url = "jdbc:sqlite:Proyect.db";
	      Connection conn=null;
	        try
	        {
	          conn = DriverManager.getConnection(url);
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }


    public static void updateJugador(String nombreJugador , int precio )
    {
        String sql = "UPDATE  jugador  SET PRECIOENM = ? WHERE NOMBREJUGADOR = ? ";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, precio);
            pstmt.setString(2, nombreJugador);
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateJugadorEstadisticas( int goles , int ta , int tr , int asist , int idjug )
    {
        String sql = "UPDATE estadisticas SET  GOLES = ? , ASISTENCIAS = ? , TAREJETASAMARILLAS = ? , TARJETASROJAS = ?  WHERE IDJUGADOR = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, goles);
            pstmt.setInt(2, asist);
            pstmt.setInt(3, ta);
            pstmt.setInt(4, tr);
            pstmt.setInt(5, idjug);
            
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}