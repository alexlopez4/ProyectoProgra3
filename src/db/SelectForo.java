package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Liga;
import objetos.RegistroMensajes;
import objetos.SalaDebate;
import objetos.Usuario;

public class SelectForo {
	
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
	
	public static ArrayList<RegistroMensajes> getForo(String sql)
    {
    	ArrayList<RegistroMensajes> listaMensajes = new ArrayList<RegistroMensajes>();
        try
                (
                		Connection conn = connect();
                        PreparedStatement pstmt  = conn.prepareStatement(sql)
                )
        {


            ResultSet rs  = pstmt.executeQuery();
            
            while (rs.next())
            {
            Usuario user = new Usuario (rs.getString("NOMBRE"),rs.getInt("EDAD"),rs.getString("NOMBREUSUARIO"), rs.getString("PSSW"));
            Liga ligaTema = new Liga(rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
            SalaDebate sala= new SalaDebate (user, ligaTema, rs.getInt("IDSALADEBATE"),rs.getString("TEMADEBATE"));
            RegistroMensajes rm = new RegistroMensajes (user,sala,rs.getString("MENSAJE"),rs.getString("FECHA"));
            listaMensajes.add(rm);
            }
            
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return listaMensajes;
        
    }
	

}
