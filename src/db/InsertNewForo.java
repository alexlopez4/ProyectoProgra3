package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertNewForo {

	/** Establece la conexión con la base de datos
	 * 
	 * @return conn, la conexion que se establece con el DriverManager
	 */
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
	 
	 /** Permite realizar un recuento del número de salas de debate que hay creadas
	  * 
	  * @return numeroSala, es el número de salas de debate que hay creadas hasta el momento de forma que
	  * permite añadir una identificador correcto a una nueva sala que se cree
	  */
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

	 /** Inserta un nuevo tema de debate 
	  * 
	  * @param tema, es el nombre del nuevo tema de debate
	  * @param idLiga, es el identificador de la liga con el que esta relacionado el nuevo tema de debate
	  */
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
