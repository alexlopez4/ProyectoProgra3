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


    public static void updateJugador(String nombreJugador , int precio , int goles , int ta , int tr , int asist , int idjug )
    {
        String sql = "UPDATE  SET jugador PRECIOENM = ? WHERE NOMBREJUGADOR = ? AND UPDATE SET estadisticas GOLES = ? ,"
        		+" ASISTENCIAS = ? , TAREJETASAMARILLAS = ? , TARJETASROJAS = ?  WHERE IDJUGADOR = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, precio);
            pstmt.setString(2, nombreJugador);
            pstmt.setInt(3, goles);
            pstmt.setInt(4, asist);
            pstmt.setInt(5, ta);
            pstmt.setInt(6, tr);
            pstmt.setInt(7, idjug);
            
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}