package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Liga;
import objetos.Usuario;

public class SelectLiga {

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

	public static ArrayList<Liga> getLiga(String sql)
    {
    	ArrayList<Liga> listaLigas = new ArrayList<Liga>();
        try
                (
                		Connection conn = connect();
                        PreparedStatement pstmt  = conn.prepareStatement(sql)
                )
        {


            ResultSet rs  = pstmt.executeQuery();
            
            while (rs.next())
            {
             Liga l = new Liga (rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
             listaLigas.add(l);
            }
            
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return listaLigas;
        
    }
}
