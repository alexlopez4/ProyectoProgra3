package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateContrasenya {

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


    public static void update(String nombreUsuario, String pssw)
    {
        String sql = "UPDATE usuario SET  PSSW = ? WHERE NOMBREUSUARIO = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, pssw);
            pstmt.setString(2, nombreUsuario);
            pstmt.executeUpdate();
            }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
