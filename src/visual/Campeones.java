package visual;

/** Jframe con infromación sobre los campeones de cada liga
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectCampeones;
import db.SelectEstadisticas;
import db.SelectJugador;
import db.SelectLiga;
import db.SelectTemporada;
import objetos.Equipo;
import objetos.Estadisticas;
import objetos.Jugador;
import objetos.Liga;
import objetos.Temporada;
import objetos.Usuario;

import javax.swing.JToolBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Campeones extends JFrame {

	private JPanel contentPane;
	private JTextField tf0;
	private JTextField tf1;
	private JTextField tf2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnVolver;
	private JLabel lblCampeones;

	
	public Campeones(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblCampon = new JLabel("Camp\u00E9on");
		lblCampon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCampon.setBounds(37, 206, 156, 23);
		contentPane.add(lblCampon);
		
		JLabel lblMximoGoleador = new JLabel("M\u00E1ximo goleador");
		lblMximoGoleador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMximoGoleador.setBounds(37, 263, 175, 26);
		contentPane.add(lblMximoGoleador);
		
		JLabel lblMximoAsistente = new JLabel("M\u00E1ximo asistente");
		lblMximoAsistente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMximoAsistente.setBounds(37, 311, 175, 23);
		contentPane.add(lblMximoAsistente);
		
		tf0 = new JTextField();
		tf0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf0.setBounds(227, 203, 254, 31);
		contentPane.add(tf0);
		tf0.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf1.setBounds(227, 258, 254, 31);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		tf2.setBounds(229, 308, 252, 31);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf0.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		comboBox.setBounds(499, 135, 136, 26);
		DefaultComboBoxModel<Temporada> modelTemporada = new DefaultComboBoxModel<Temporada>();
		ArrayList<Temporada> ediciones = SelectTemporada.getTemporada("SELECT EDICION FROM temporada ORDER BY EDICION DESC;");
		for (Temporada t: ediciones){
			modelTemporada.addElement(t);
		}
		comboBox.setModel(modelTemporada);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		comboBox_1.setBounds(37, 135, 233, 26);
		DefaultComboBoxModel<Liga> modelLiga = new DefaultComboBoxModel<Liga>();
		String consulta= "SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga";
		ArrayList <Liga> listaLigas = SelectLiga.getLiga(consulta);
		for (Liga l: listaLigas){
			modelLiga.addElement(l);
		}
		comboBox_1.setModel(modelLiga);
		contentPane.add(comboBox_1);

		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		lblTemporada.setBounds(377, 137, 107, 20);
		contentPane.add(lblTemporada);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu (user);
				m.setVisible(true);
				Campeones.this.setVisible(false);
			}
		});
		btnVolver.setBounds(61, 391, 652, 29);
		contentPane.add(btnVolver);
		
		lblCampeones = new JLabel("Datos");
		lblCampeones.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 51));
		lblCampeones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeones.setBounds(240, 36, 321, 57);
		contentPane.add(lblCampeones);
		
		
		Temporada t = (Temporada) comboBox.getSelectedItem();
		String edicion = t.getEdicion();
		Liga l = (Liga) comboBox_1.getSelectedItem();
		int Idliga = l.getIdLiga();
		
		String sql2= "SELECT E.IDESTADISTICAS, E.GOLES, E.ASISTENCIAS, E.TARJETASROJAS, E.TAREJETASAMARILLAS, E.IDJUGADOR, E.EDICION, E.NOMBREJUGADOR, " 
				+"E.EDADJUGADOR, E.IDJUGADOR, E.IDEQUIPO, E.PRECIOENM, E.NOMBREEQUIPO, E.IDEQUIPO, E.IDLIGA, E.ESTADIO, F.NOMBRELIGA, F.PAIS FROM LIGA F "
				+"JOIN("
				+"SELECT C.IDESTADISTICAS, C.GOLES, C.ASISTENCIAS, C.TARJETASROJAS, C.TAREJETASAMARILLAS, C.IDJUGADOR, C.EDICION, C.NOMBREJUGADOR, "
				+"C.EDADJUGADOR, C.IDJUGADOR, C.IDEQUIPO, C.PRECIOENM, D.NOMBREEQUIPO, D.IDEQUIPO, D.IDLIGA, D.ESTADIO FROM EQUIPO D "
				+"JOIN("
				+"SELECT A.IDESTADISTICAS, A.GOLES, A.ASISTENCIAS, A.TARJETASROJAS, A.TAREJETASAMARILLAS, A.IDJUGADOR, A.EDICION, B.NOMBREJUGADOR, "
				+"B.EDADJUGADOR, B.IDJUGADOR, B.IDEQUIPO, B.PRECIOENM FROM estadisticas A "
				+"JOIN jugador B "
				+"ON B.IDJUGADOR=A.IDJUGADOR "
				+"WHERE A.EDICION='"+edicion+"')C "
				+"ON C.IDEQUIPO=D.IDEQUIPO "
				+"WHERE D.IDLIGA="+Idliga+") E "
				+"ON F.IDLIGA=E.IDLIGA;";
		ArrayList<Estadisticas> estadisticasLigaTemporada = SelectEstadisticas.getEstadisticasJugador(sql2);
		int IdJugadorMaximoGoleador = Estadisticas.getMaximoGoleador(estadisticasLigaTemporada);
		Jugador maximoGoleador = SelectJugador.getJugador(IdJugadorMaximoGoleador);
		int IdJugadorMaximoAsistente = Estadisticas.getMaximoAsistente(estadisticasLigaTemporada);
		Jugador maximoAsistente = SelectJugador.getJugador(IdJugadorMaximoAsistente);
		if (t.getEdicion().equals("2021/2022")){
			tf0.setText("Temporada no finalizada");
			tf1.setText(maximoGoleador.getNombre());
			tf2.setText(maximoAsistente.getNombre());
			
		}
		else{
		if (comboBox.getSelectedItem()!= null && comboBox_1.getSelectedItem()!=null && (!comboBox.getSelectedItem().equals("2021/2022"))){
			String sql = "SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO FROM LIGA C"
					+" JOIN (SELECT B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA FROM EQUIPO B "
					+"JOIN (SELECT EDICION, IDLIGA, CAMPEON FROM temporadadeliga "
					+"WHERE IDLIGA ="+Idliga+" AND EDICION ='"+edicion+"')A "
					+"ON B.IDEQUIPO=A.CAMPEON) D "
					+"ON C.IDLIGA=D.IDLIGA;";
			Equipo equipo =SelectCampeones.getCampeon(sql);
			tf0.setText(equipo.getNombreEquipo());
			tf1.setText(maximoGoleador.getNombre());
			tf2.setText(maximoAsistente.getNombre());
	}
	}
		
		
		comboBox_1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) 
                {
                	Temporada t = (Temporada) comboBox.getSelectedItem();
                	String edicion = t.getEdicion();
                	Liga l = (Liga) comboBox_1.getSelectedItem();
        			int Idliga = l.getIdLiga();
        			String sql2= "SELECT E.IDESTADISTICAS, E.GOLES, E.ASISTENCIAS, E.TARJETASROJAS, E.TAREJETASAMARILLAS, E.IDJUGADOR, E.EDICION, E.NOMBREJUGADOR, " 
        					+"E.EDADJUGADOR, E.IDJUGADOR, E.IDEQUIPO, E.PRECIOENM, E.NOMBREEQUIPO, E.IDEQUIPO, E.IDLIGA, E.ESTADIO, F.NOMBRELIGA, F.PAIS FROM LIGA F "
        					+"JOIN("
        					+"SELECT C.IDESTADISTICAS, C.GOLES, C.ASISTENCIAS, C.TARJETASROJAS, C.TAREJETASAMARILLAS, C.IDJUGADOR, C.EDICION, C.NOMBREJUGADOR, "
        					+"C.EDADJUGADOR, C.IDJUGADOR, C.IDEQUIPO, C.PRECIOENM, D.NOMBREEQUIPO, D.IDEQUIPO, D.IDLIGA, D.ESTADIO FROM EQUIPO D "
        					+"JOIN("
        					+"SELECT A.IDESTADISTICAS, A.GOLES, A.ASISTENCIAS, A.TARJETASROJAS, A.TAREJETASAMARILLAS, A.IDJUGADOR, A.EDICION, B.NOMBREJUGADOR, "
        					+"B.EDADJUGADOR, B.IDJUGADOR, B.IDEQUIPO, B.PRECIOENM FROM estadisticas A "
        					+"JOIN jugador B "
        					+"ON B.IDJUGADOR=A.IDJUGADOR "
        					+"WHERE A.EDICION='"+edicion+"')C "
        					+"ON C.IDEQUIPO=D.IDEQUIPO "
        					+"WHERE D.IDLIGA="+Idliga+") E "
        					+"ON F.IDLIGA=E.IDLIGA;";
        			ArrayList<Estadisticas> estadisticasLigaTemporada = SelectEstadisticas.getEstadisticasJugador(sql2);
        			int IdJugadorMaximoGoleador = Estadisticas.getMaximoGoleador(estadisticasLigaTemporada);
        			Jugador maximoGoleador = SelectJugador.getJugador(IdJugadorMaximoGoleador);
        			int IdJugadorMaximoAsistente = Estadisticas.getMaximoAsistente(estadisticasLigaTemporada);
        			Jugador maximoAsistente = SelectJugador.getJugador(IdJugadorMaximoAsistente);
        			
                	if(t.getEdicion().equals("2021/2022")){
            			tf0.setText("Temporada no finalizada");
            			tf1.setText(maximoGoleador.getNombre());
            			tf2.setText(maximoAsistente.getNombre());
                	}
            		else{
                	if (comboBox.getSelectedItem()!= null && comboBox_1.getSelectedItem()!=null && (!comboBox.getSelectedItem().equals("2021/2022"))){
            			String sql = "SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO FROM LIGA C"
            					+" JOIN (SELECT B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA FROM EQUIPO B "
            					+"JOIN (SELECT EDICION, IDLIGA, CAMPEON FROM temporadadeliga "
            					+"WHERE IDLIGA ="+Idliga+" AND EDICION ='"+edicion+"')A "
            					+"ON B.IDEQUIPO=A.CAMPEON) D "
            					+"ON C.IDLIGA=D.IDLIGA;";
            			Equipo equipo =SelectCampeones.getCampeon(sql);
            			tf0.setText(equipo.getNombreEquipo());
            			tf1.setText(maximoGoleador.getNombre());
            			tf2.setText(maximoAsistente.getNombre());
            		}
                    
                }
                }
            }

         });
		comboBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) 
                {
                	Temporada t = (Temporada) comboBox.getSelectedItem();
                	String edicion = t.getEdicion();
                	Liga l = (Liga) comboBox_1.getSelectedItem();
        			int Idliga = l.getIdLiga();
        			String sql2= "SELECT E.IDESTADISTICAS, E.GOLES, E.ASISTENCIAS, E.TARJETASROJAS, E.TAREJETASAMARILLAS, E.IDJUGADOR, E.EDICION, E.NOMBREJUGADOR, " 
        					+"E.EDADJUGADOR, E.IDJUGADOR, E.IDEQUIPO, E.PRECIOENM, E.NOMBREEQUIPO, E.IDEQUIPO, E.IDLIGA, E.ESTADIO, F.NOMBRELIGA, F.PAIS FROM LIGA F "
        					+"JOIN("
        					+"SELECT C.IDESTADISTICAS, C.GOLES, C.ASISTENCIAS, C.TARJETASROJAS, C.TAREJETASAMARILLAS, C.IDJUGADOR, C.EDICION, C.NOMBREJUGADOR, "
        					+"C.EDADJUGADOR, C.IDJUGADOR, C.IDEQUIPO, C.PRECIOENM, D.NOMBREEQUIPO, D.IDEQUIPO, D.IDLIGA, D.ESTADIO FROM EQUIPO D "
        					+"JOIN("
        					+"SELECT A.IDESTADISTICAS, A.GOLES, A.ASISTENCIAS, A.TARJETASROJAS, A.TAREJETASAMARILLAS, A.IDJUGADOR, A.EDICION, B.NOMBREJUGADOR, "
        					+"B.EDADJUGADOR, B.IDJUGADOR, B.IDEQUIPO, B.PRECIOENM FROM estadisticas A "
        					+"JOIN jugador B "
        					+"ON B.IDJUGADOR=A.IDJUGADOR "
        					+"WHERE A.EDICION='"+edicion+"')C "
        					+"ON C.IDEQUIPO=D.IDEQUIPO "
        					+"WHERE D.IDLIGA="+Idliga+") E "
        					+"ON F.IDLIGA=E.IDLIGA;";
        			ArrayList<Estadisticas> estadisticasLigaTemporada = SelectEstadisticas.getEstadisticasJugador(sql2);
        			int IdJugadorMaximoGoleador = Estadisticas.getMaximoGoleador(estadisticasLigaTemporada);
        			Jugador maximoGoleador = SelectJugador.getJugador(IdJugadorMaximoGoleador);
        			int IdJugadorMaximoAsistente = Estadisticas.getMaximoAsistente(estadisticasLigaTemporada);
        			Jugador maximoAsistente = SelectJugador.getJugador(IdJugadorMaximoAsistente);
        			
        			if (t.getEdicion().equals("2021/2022")){
            			tf0.setText("Temporada no finalizada");
            			tf1.setText(maximoGoleador.getNombre());
            			tf2.setText(maximoAsistente.getNombre());
            		}
            		else{
            			if (comboBox.getSelectedItem()!= null && comboBox_1.getSelectedItem()!=null && (!comboBox.getSelectedItem().equals("2021/2022"))){
            			String sql = "SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO FROM LIGA C"
            					+" JOIN (SELECT B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA FROM EQUIPO B "
            					+"JOIN (SELECT EDICION, IDLIGA, CAMPEON FROM temporadadeliga "
            					+"WHERE IDLIGA ="+Idliga+" AND EDICION ='"+edicion+"')A "
            					+"ON B.IDEQUIPO=A.CAMPEON) D "
            					+"ON C.IDLIGA=D.IDLIGA;";
            			Equipo equipo =SelectCampeones.getCampeon(sql);
            			tf0.setText(equipo.getNombreEquipo());
            			tf1.setText(maximoGoleador.getNombre());
            			tf2.setText(maximoAsistente.getNombre());
            		}
            	}
                    
              }
           }

         });
		
	
		
	}
}
