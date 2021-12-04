package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.SelectEstadisticas;
import db.SelectJugador;
import objetos.Estadisticas;
import objetos.Jugador;
import objetos.Usuario;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaJugador extends JFrame {

	private JPanel contentPane;

	public PantallaJugador(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JList list = new JList();
		
		DefaultListModel  lista = new DefaultListModel();
		
		String sql = "SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ "ON B.IDEQUIPO= jugador.IDEQUIPO";
	
		
		ArrayList<Jugador> listaJugadores= SelectJugador.getJugadores(sql);
		
		String texto="";
		for (Jugador a: listaJugadores){
			texto="";
			texto=a.getNombre()+" , "+a.getEdad()+" años ";
			lista.addElement(texto);
		}
		list.setModel(lista);
		list.setBounds(15, 89, 377, 302);
		JScrollPane js = new JScrollPane(list);
		js.getViewport().setViewPosition(new Point(0,0));
		js.setBounds(15, 89, 377, 302);
		contentPane.add(js);
		
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setFont(new Font("Stencil", Font.PLAIN, 55));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(109, 16, 527, 57);
		contentPane.add(lblJugadores);
		
		JButton btnNewButton = new JButton("Mas informacion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				if (list.getSelectedValue()== null){
					JOptionPane.showMessageDialog(null,"No ha seleccionado ningun jugador");
				}else{
					String[]split = selected.split(" , ");
					JugadorInfo ji= new JugadorInfo(split[0], user);
					ji.setVisible(true);
					PantallaJugador.this.setVisible(false);
				}
			
			}
		});
		btnNewButton.setBounds(15, 407, 377, 29);
		contentPane.add(btnNewButton);
		
		JList list_1 = new JList();
		
		DefaultListModel  lista2 = new DefaultListModel();
		
		String sql2 = "SELECT * FROM (SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS ,TARJETASROJAS FROM estadisticas "
				+ "JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
				+ "JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ "JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ "JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ "ON A.IDLIGA = equipo.IDLIGA ) B "
				+ "ON B.IDEQUIPO= jugador.IDEQUIPO )C "
				+ "WHERE EDICION LIKE '%2021/2022%')D "
				+ "ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION) "
				+ "ORDER BY GOLES DESC );";
	
		
		ArrayList<Estadisticas> listaJugadores2= SelectEstadisticas.getEstadisticasJugador(sql2);
		
		String texto2="";
		for (Estadisticas Z: listaJugadores2){
			texto2="";
			texto2=Z.getNombre()+" , "+Z.getEdad()+" años "+" , "+Z.getGoles()+" goles.";
			lista2.addElement(texto2);
		}
		list_1.setModel(lista2);
		
		
		list_1.setBounds(485, 126, 256, 110);
		contentPane.add(list_1);
		
		JLabel lblMaximosGoleadores = new JLabel("Maximos goleadores 2020/2021");
		lblMaximosGoleadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximosGoleadores.setBounds(485, 91, 256, 20);
		contentPane.add(lblMaximosGoleadores);
		
		JLabel lblMaximosAsistentes = new JLabel("Maximos asistentes 2021");
		lblMaximosAsistentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximosAsistentes.setBounds(485, 254, 256, 20);
		contentPane.add(lblMaximosAsistentes);
		
		JList list_2 = new JList();
		DefaultListModel  lista3 = new DefaultListModel();
		
		String sql3 = "SELECT * FROM (SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS, TARJETASROJAS FROM estadisticas "
				+ " JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
				+ " JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ " ON B.IDEQUIPO= jugador.IDEQUIPO )C"
				+ " WHERE EDICION LIKE '%2021/2022%')D"
				+ " ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION)"
				+ " ORDER BY ASISTENCIAS DESC ) ";
	
		
		ArrayList<Estadisticas> listaJugadores3= SelectEstadisticas.getEstadisticasJugador(sql3);
		
		String texto3="";
		for (Estadisticas g: listaJugadores3){
			texto3="";
			texto3=g.getNombre()+" , "+g.getEdad()+" años "+" , "+g.getAsistencias()+" asistencias.";
			lista3.addElement(texto3);
		}
		list_2.setModel(lista3);
		
		
		list_2.setBounds(485, 290, 256, 110);
		contentPane.add(list_2);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(user);
				m.setVisible(true);
				PantallaJugador.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(485, 407, 256, 29);
		contentPane.add(btnNewButton_1);
	
	
	
	
	}
}
