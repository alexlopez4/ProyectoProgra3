package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Usuario;

public class SelectUser {

	
	/** Establece la conexión con la base de datos
	 * 
	 * @return conn, la conexion que se establece con el DriverManager
	 */
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

    public static ArrayList<Usuario> getUser(String sql)
    {
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try
                (
                		Connection conn = connect();
                        PreparedStatement pstmt  = conn.prepareStatement(sql)
                )
        {


            ResultSet rs  = pstmt.executeQuery();
            
            while (rs.next())
            {
             Usuario u = new Usuario (rs.getString("NOMBRE"),rs.getInt("EDAD"),rs.getString("NOMBREUSUARIO"),rs.getString("PSSW"));
             usuarios.add(u);
            }
            
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return usuarios;
        
    }
    
}
