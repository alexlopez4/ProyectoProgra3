package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Noticia;
import objetos.Periodico;

public class SelectNoticia{

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
	
	public static ArrayList<Noticia> getNoticias (String sql ){
		
		ArrayList<Noticia> listaNoticias= new ArrayList<Noticia>();
		
        try (
			Connection conn = connect();
        	PreparedStatement pstmt  = conn.prepareStatement(sql);
		)
        	 {
                 ResultSet rs  = pstmt.executeQuery();
                 
                 while (rs.next())
                 {
                Periodico periodico= new Periodico (rs.getInt("IDPERIODICO"),rs.getString("NOMBREPERIODICO"),rs.getString("PAIS"));
                Noticia noticia= new Noticia(periodico.getIdPeriodico(),periodico.getNombrePeriodico(),periodico.getPais(),rs.getInt("IDNOTICIA"),rs.getString("TITULO"),
                		 rs.getString("TEXTO"),rs.getString("IDIOMA"),rs.getString("FECHA"));
                
                listaNoticias.add(noticia);
                 }
             }
        catch (SQLException e) {
        	 System.out.println(e.getMessage());
		}
        
		return listaNoticias;
		
	}
}

