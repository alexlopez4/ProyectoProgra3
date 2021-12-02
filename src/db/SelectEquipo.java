package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Equipo;
import objetos.Jugador;
import objetos.Liga;

public class SelectEquipo {

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
	
	public static ArrayList<Equipo> getEquipo(String sql)
    {
		ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
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
	Equipo e = new Equipo(l,rs.getInt("IDEQUIPO"),rs.getString("NOMBREEQUIPO"),rs.getString("ESTADIO"));
		
	listaEquipo.add(e);
    }
	
	} catch (SQLException e)
	{
	System.out.println(e.getMessage());
	}
	return listaEquipo;
    }
	
	
	public static int getValor(String sql)
    {
		int valor = 0;
    try
    (
    		Connection conn = connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)
    )
    {
    		ResultSet rs  = pstmt.executeQuery();
    while (rs.next())
    		{
    valor = rs.getInt("VALOR");
	
    }
	
	} catch (SQLException e)
	{
	System.out.println(e.getMessage());
	}
	return valor;
    }
	
	public static int vecesCampeon(String sql)
    {
		int titulos = 0;
    try
    (
    		Connection conn = connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)
    )
    {
    		ResultSet rs  = pstmt.executeQuery();
    while (rs.next())
    		{
    titulos = rs.getInt("VECESCAMPEON");
	
    }
	
	} catch (SQLException e)
	{
	System.out.println(e.getMessage());
	}
	return titulos;
    }
	
}
