package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertNewForo {

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
	 public static int countSalaDebate(){
		 int numeroSala=0;
		 String sql = "SELECT count(*) AS NUMEROSALAS FROM SALADEBATE;";
		 try (
			 Connection conn= connect();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
		 ){
			 ResultSet rs  = pstmt.executeQuery();
				numeroSala =rs.getInt("NUMEROSALAS"); 
			 
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return numeroSala;
		 
	 }

	    public static void insertTema(String tema, int idLiga)
	    {
	        String sql = "INSERT INTO salaDebate(IDSALADEBATE,TEMADEBATE,IDLIGA) VALUES(?,?,?)";
	        try
         (
         		Connection conn = connect();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)
         )
 {
	           int numeroSalasDebate = countSalaDebate();
	           int idNuevaSalaDebate = numeroSalasDebate+1;
	           pstmt.setInt(1, idNuevaSalaDebate);
	           pstmt.setString(2, tema);
	           pstmt.setInt(3, idLiga);
	           pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }

}
