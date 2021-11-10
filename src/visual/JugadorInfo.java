package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectEstadisticas;
import db.SelectTemporada;
import objetos.Estadisticas;
import objetos.Temporada;
import objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JugadorInfo extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param split 
	 * @param sql 
	 */
	public JugadorInfo(String split, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(42, 114, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(42, 155, 69, 20);
		contentPane.add(lblEdad);
		
		JLabel lblGoles = new JLabel("Goles :");
		lblGoles.setBounds(42, 203, 69, 20);
		contentPane.add(lblGoles);
		
		JLabel lblNombre_2_1 = new JLabel("Asistencias :");
		lblNombre_2_1.setBounds(42, 250, 96, 20);
		contentPane.add(lblNombre_2_1);
		
		JLabel lblNombre_2_2 = new JLabel("Tarjetas Amarillas :");
		lblNombre_2_2.setBounds(42, 297, 147, 20);
		contentPane.add(lblNombre_2_2);
		
		JLabel lblNombre_2 = new JLabel("Tarjetas Rojas:");
		lblNombre_2.setBounds(42, 344, 147, 20);
		contentPane.add(lblNombre_2);
		
		JLabel lblNewLabel = new JLabel("FICHA JUGADOR");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 16, 457, 61);
		contentPane.add(lblNewLabel);
		
		JLabel NOM = new JLabel("New label");
		NOM.setBounds(207, 114, 399, 20);
		contentPane.add(NOM);
		
		JLabel ED = new JLabel("New label");
		ED.setBounds(207, 155, 399, 20);
		contentPane.add(ED);
		
		JLabel GOL = new JLabel("New label");
		GOL.setBounds(207, 203, 399, 20);
		contentPane.add(GOL);
		
		JLabel ASIS = new JLabel("New label");
		ASIS.setBounds(207, 250, 399, 20);
		contentPane.add(ASIS);
		
		JLabel TA = new JLabel("New label");
		TA.setBounds(207, 297, 399, 20);
		contentPane.add(TA);
		
		JLabel TR = new JLabel("New label");
		TR.setBounds(207, 344, 399, 20);
		contentPane.add(TR);
		
		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel<Temporada> modelTemporada = new DefaultComboBoxModel<Temporada> ();
		ArrayList<Temporada> ediciones = SelectTemporada.getTemporada("SELECT EDICION FROM temporada ORDER BY EDICION DESC;");
		for (Temporada t: ediciones){
			modelTemporada.addElement(t);
		}
		comboBox.setModel(modelTemporada);
		comboBox.setBounds(404, 152, 274, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaJugador pj = new PantallaJugador(user);
				pj.setVisible(true);
				JugadorInfo.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(404, 199, 274, 29);
		contentPane.add(btnNewButton_1);
		
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
            			}
            		}
                }
	}
});
}
}

