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

public class SelectJugador {
	
	
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

	/**Este método sirve para obtener un arrayList con los jugadores indicados mediante la consulta 
	 * sql que se le pasa por parametro
	 * 
	 * @param sql, consulta a realizar
	 * @return arrayList con los jugadores que responden a la consulta sql realizada
	 */
	public static ArrayList<Jugador> getJugadores(String sql)
    {
		ArrayList<Jugador> listaJugador = new ArrayList<Jugador>();
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
	Jugador j= new Jugador(rs.getString("NOMBREJUGADOR"),rs.getInt("EDADJUGADOR"),e,rs.getInt("IDJUGADOR"),rs.getInt("PRECIOENM"));
	
	listaJugador.add(j);
    }
	
	} catch (SQLException e)
	{
	System.out.println(e.getMessage());
	}
	return listaJugador;
    }
	
	/**Este método permite obtener los datos del jugador del que se indica su identificador
	 * 
	 * @param Id identificador del jugador
	 * @return j, jugador indicado mediante el identificador
	 */
	public static Jugador getJugador(int Id){
		Jugador j=null;
		try (Connection conn=connect();
				PreparedStatement pstmt = conn.prepareStatement("SELECT C.NOMBRELIGA, C.IDLIGA, C.PAIS, D.NOMBREJUGADOR, D.EDADJUGADOR, "
						+ "D.IDJUGADOR, D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDEQUIPO FROM LIGA C "
						+"JOIN(SELECT A.NOMBREJUGADOR, A.EDADJUGADOR, A.IDJUGADOR, A.PRECIOENM, A.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, "
						+ "B.IDEQUIPO, B.IDLIGA FROM jugador A JOIN EQUIPO B ON B.IDEQUIPO=A.IDEQUIPO "
						+"WHERE IDJUGADOR ="+Id+")D "
						+"ON C.IDLIGA=D.IDLIGA;);"))
			{ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Liga l = new Liga (rs.getInt("IDLIGA"),rs.getString("NOMBRELIGA"),rs.getString("PAIS"));
				Equipo e = new Equipo (l, rs.getInt("IDEQUIPO"),rs.getString("NOMBREEQUIPO"),rs.getString("ESTADIO"));
				j = new Jugador(rs.getString("NOMBREJUGADOR"), rs.getInt("EDADJUGADOR"), e, rs.getInt("IDJUGADOR"),rs.getInt("PRECIOENM"));
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return j;
		}
	
	public static int getNumeroJugadores(String sql)
    {
		int numeroJugadores = 0;
    try
    (
    		Connection conn = connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql)
    )
    {
    		ResultSet rs  = pstmt.executeQuery();
    while (rs.next())
    		{
    numeroJugadores = rs.getInt("NUMEROJUGADORES");
	
    }
	
	} catch (SQLException e)
	{
	System.out.println(e.getMessage());
	}
	return numeroJugadores;
    }
	
	

}
