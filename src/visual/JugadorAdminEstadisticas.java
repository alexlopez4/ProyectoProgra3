package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectEstadisticas;
import db.SelectTemporada;
import objetos.Estadisticas;
import objetos.Temporada;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JugadorAdminEstadisticas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public JugadorAdminEstadisticas(String split) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel<Temporada> modelTemporada = new DefaultComboBoxModel<Temporada> ();
		ArrayList<Temporada> ediciones = SelectTemporada.getTemporada("SELECT EDICION FROM temporada ORDER BY EDICION DESC;");
		for (Temporada t: ediciones){
			modelTemporada.addElement(t);
		}
		comboBox.setModel(modelTemporada);
		comboBox.setBounds(55, 126, 255, 26);
		contentPane.add(comboBox);
		
		Temporada t = (Temporada) comboBox.getSelectedItem();
		String edicion = t.getEdicion();
		String sql="SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS, TARJETASROJAS FROM estadisticas "
				+ " JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
				+ " JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ " ON B.IDEQUIPO= jugador.IDEQUIPO )C"
				+ " WHERE EDICION='"+edicion+"')D"
				+ " ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION) ";
	
		

		
		JLabel NOM = new JLabel("New label");
		NOM.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 63));
		NOM.setHorizontalAlignment(SwingConstants.CENTER);
		NOM.setBounds(55, 36, 687, 49);
		contentPane.add(NOM);
		
		JLabel lblPrecioEnMillones = new JLabel("Precio en millones");
		lblPrecioEnMillones.setBounds(55, 174, 167, 20);
		contentPane.add(lblPrecioEnMillones);
		
		JLabel lblGoles = new JLabel("Goles:");
		lblGoles.setBounds(55, 223, 136, 20);
		contentPane.add(lblGoles);
		
		JLabel lblAmarillas = new JLabel("Amarillas:");
		lblAmarillas.setBounds(55, 273, 136, 20);
		contentPane.add(lblAmarillas);
		
		JLabel lblRoja = new JLabel("Rojas:");
		lblRoja.setBounds(55, 323, 136, 20);
		contentPane.add(lblRoja);
		
		JLabel ED = new JLabel("New label");
		ED.setBounds(237, 174, 69, 20);
		contentPane.add(ED);
		
		JLabel GOL = new JLabel("New label");
		GOL.setBounds(237, 223, 69, 20);
		contentPane.add(GOL);
		
		JLabel TA = new JLabel("New label");
		TA.setBounds(237, 273, 69, 20);
		contentPane.add(TA);
		
		JLabel TR = new JLabel("New label");
		TR.setBounds(237, 323, 69, 20);
		contentPane.add(TR);
		
		JLabel lblAsistencias = new JLabel("Asistencias:");
		lblAsistencias.setBounds(55, 376, 136, 20);
		contentPane.add(lblAsistencias);
		
		JLabel ASIS = new JLabel("New label");
		ASIS.setBounds(237, 376, 69, 20);
		contentPane.add(ASIS);
		
		textField = new JTextField();
		textField.setBounds(377, 171, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 220, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(377, 270, 146, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(377, 320, 146, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(377, 373, 146, 26);
		contentPane.add(textField_4);
		
		JLabel lblDatosAModificar = new JLabel("Datos a modificar");
		lblDatosAModificar.setBounds(377, 129, 146, 20);
		contentPane.add(lblDatosAModificar);
		
		JButton btnNewButton = new JButton("Modificar Estadisticas ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temporada t = (Temporada) comboBox.getSelectedItem();
        		String edicion = t.getEdicion();
        		String sql="SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS, TARJETASROJAS FROM estadisticas "
        				+ " JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
        				+ " JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
        				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
        				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
        				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
        				+ " ON B.IDEQUIPO= jugador.IDEQUIPO )C"
        				+ " WHERE EDICION='"+edicion+"')D"
        				+ " ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION) ";
        		ArrayList<Estadisticas> listaJugadores= SelectEstadisticas.getEstadisticasJugador(sql);
        		for (Estadisticas a: listaJugadores){
        			if (a.getNombre().equals(split)){
        				NOM.setText(a.getNombre());
        				ED.setText(String.valueOf(a.getEdad()));
        				GOL.setText(String.valueOf(a.getGoles()));
        				ASIS.setText(String.valueOf(a.getAsistencias()));
        				TA.setText(String.valueOf(a.getTarjetasAmarillas()));
        				TR.setText(String.valueOf(a.getTarjetasRojas()));
        				
        				String nom = a.getNombre();
        				int valor =a.getPrecioEnMillones();
        				int gol= a.getGoles();
        				int asist= a.getAsistencias();
        				int Ta=a.getTarjetasAmarillas();
        				int Tr= a.getTarjetasRojas();
        			
        			}
        		}
			}
			
		});
		btnNewButton.setBounds(565, 249, 198, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminVentana a= new AdminVentana();
				a.setVisible(true);
				JugadorAdminEstadisticas.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(565, 294, 198, 29);
		contentPane.add(btnNewButton_1);
		
		ArrayList<Estadisticas> listaJugadores= SelectEstadisticas.getEstadisticasJugador(sql);
		for (Estadisticas a: listaJugadores){
			if (a.getNombre().equals(split)){
				NOM.setText(a.getNombre());
				ED.setText(String.valueOf(a.getPrecioEnMillones()));
				GOL.setText(String.valueOf(a.getGoles()));
				ASIS.setText(String.valueOf(a.getAsistencias()));
				TA.setText(String.valueOf(a.getTarjetasAmarillas()));
				TR.setText(String.valueOf(a.getTarjetasRojas()));
				String nom = a.getNombre();
				int valor =a.getPrecioEnMillones();
				int gol= a.getGoles();
				int asist= a.getAsistencias();
				int Ta=a.getTarjetasAmarillas();
				int Tr= a.getTarjetasRojas();
				int id = a.getIdJugador();
			}
		}
		comboBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) 
                {
                	Temporada t = (Temporada) comboBox.getSelectedItem();
            		String edicion = t.getEdicion();
            		String sql="SELECT * FROM (SELECT D.IDJUGADOR, D.NOMBREJUGADOR, D.EDADJUGADOR ,D.PRECIOENM, D.IDEQUIPO, D.NOMBREEQUIPO, D.ESTADIO, D.IDLIGA , D.NOMBRELIGA , D.PAIS , D.EDICION ,IDESTADISTICAS, GOLES , ASISTENCIAS, TAREJETASAMARILLAS, TARJETASROJAS FROM estadisticas "
            				+ " JOIN (SELECT C.IDJUGADOR, C.NOMBREJUGADOR, C.EDADJUGADOR ,C.PRECIOENM, C.IDEQUIPO, C.NOMBREEQUIPO, C.ESTADIO, C.IDLIGA , C.NOMBRELIGA , C.PAIS , EDICION FROM temporada "
            				+ " JOIN(SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
            				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
            				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
            				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
            				+ " ON B.IDEQUIPO= jugador.IDEQUIPO )C"
            				+ " WHERE EDICION='"+edicion+"')D"
            				+ " ON estadisticas.IDJUGADOR= D.IDJUGADOR and D.EDICION = estadisticas.EDICION) ";
            		ArrayList<Estadisticas> listaJugadores= SelectEstadisticas.getEstadisticasJugador(sql);
            		for (Estadisticas a: listaJugadores){
            			if (a.getNombre().equals(split)){
            				NOM.setText(a.getNombre());
            				ED.setText(String.valueOf(a.getEdad()));
            				GOL.setText(String.valueOf(a.getGoles()));
            				ASIS.setText(String.valueOf(a.getAsistencias()));
            				TA.setText(String.valueOf(a.getTarjetasAmarillas()));
            				TR.setText(String.valueOf(a.getTarjetasRojas()));
            				
            				String nom = a.getNombre();
            				int valor =a.getPrecioEnMillones();
            				int gol= a.getGoles();
            				int asist= a.getAsistencias();
            				int Ta=a.getTarjetasAmarillas();
            				int Tr= a.getTarjetasRojas();
            			}
            		}
                }
	}
});	}

}
