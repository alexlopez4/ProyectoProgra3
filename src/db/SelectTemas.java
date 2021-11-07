package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Liga;
import objetos.SalaDebate;
import objetos.Usuario;

public class SelectTemas {

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

	public static ArrayList<SalaDebate> getTemas(String sql, Usuario u)
    {
    	ArrayList<SalaDebate> listaTemas = new ArrayList<SalaDebate>();
        try
                (
                		Connection conn = connect();
                        PreparedStatement pstmt  = conn.prepareStatement(sql)
                )
        {


            ResultSet rs  = pstmt.executeQuery();
            
            while (rs.next())
            {
            Liga ligaTema = new Liga(rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
            SalaDebate sala= new SalaDebate (u, ligaTema, rs.getInt("IDSALADEBATE"),rs.getString("TEMADEBATE"));
            listaTemas.add(sala);
            }
            
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return listaTemas;
        
    }
	
}
