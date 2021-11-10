package visual;

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

public class Campeones extends JFrame {

	private JPanel contentPane;
	private JTextField tf0;
	private JTextField tf1;
	private JTextField tf2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnVolver;

	
	public Campeones(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCampon = new JLabel("Camp\u00E9on");
		lblCampon.setBounds(39, 80, 69, 20);
		contentPane.add(lblCampon);
		
		JLabel lblMximoGoleador = new JLabel("M\u00E1ximo goleador");
		lblMximoGoleador.setBounds(39, 125, 139, 20);
		contentPane.add(lblMximoGoleador);
		
		JLabel lblMximoAsistente = new JLabel("M\u00E1ximo asistente");
		lblMximoAsistente.setBounds(39, 168, 126, 20);
		contentPane.add(lblMximoAsistente);
		
		tf0 = new JTextField();
		tf0.setBounds(123, 77, 254, 26);
		contentPane.add(tf0);
		tf0.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setBounds(193, 122, 184, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		
		tf2.setBounds(193, 165, 184, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf0.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		comboBox.setBounds(312, 16, 101, 26);
		DefaultComboBoxModel<Temporada> modelTemporada = new DefaultComboBoxModel<Temporada>();
		ArrayList<Temporada> ediciones = SelectTemporada.getTemporada("SELECT EDICION FROM temporada ORDER BY EDICION DESC;");
		for (Temporada t: ediciones){
			modelTemporada.addElement(t);
		}
		comboBox.setModel(modelTemporada);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		comboBox_1.setBounds(25, 16, 151, 26);
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
		lblTemporada.setBounds(204, 18, 107, 20);
		contentPane.add(lblTemporada);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu (user);
				m.setVisible(true);
				Campeones.this.setVisible(false);
			}
		});
		btnVolver.setBounds(325, 207, 88, 29);
		contentPane.add(btnVolver);
		
		
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
