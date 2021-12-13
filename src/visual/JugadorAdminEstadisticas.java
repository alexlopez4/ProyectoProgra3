package visual;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import db.SelectEstadisticas;
import db.SelectTemporada;
import db.UpdateJugador;
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
	private JTextField PrecioMillones;
	private JTextField GolesText;
	private JTextField TaText;
	private JTextField TrText;
	private JTextField AsistText;

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
		
		PrecioMillones = new JTextField();
		PrecioMillones.setBounds(377, 171, 146, 26);
		contentPane.add(PrecioMillones);
		PrecioMillones.setColumns(10);
		
		GolesText = new JTextField();
		GolesText.setBounds(377, 220, 146, 26);
		contentPane.add(GolesText);
		GolesText.setColumns(10);
		
		TaText = new JTextField();
		TaText.setColumns(10);
		TaText.setBounds(377, 270, 146, 26);
		contentPane.add(TaText);
		
		TrText = new JTextField();
		TrText.setColumns(10);
		TrText.setBounds(377, 320, 146, 26);
		contentPane.add(TrText);
		
		AsistText = new JTextField();
		AsistText.setColumns(10);
		AsistText.setBounds(377, 373, 146, 26);
		contentPane.add(AsistText);
		
		JLabel lblDatosAModificar = new JLabel("Datos a modificar");
		lblDatosAModificar.setBounds(377, 129, 146, 20);
		contentPane.add(lblDatosAModificar);
		
		String nom = "";
		int valor =0;
		int gol= 0;
		int asist= 0;
		int Ta=0;
		int Tr= 0;
		int id =0;
	
		
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
				
				nom = a.getNombre();
				valor =a.getPrecioEnMillones();
				gol= a.getGoles();
				asist= a.getAsistencias();
				Ta=a.getTarjetasAmarillas();
				Tr= a.getTarjetasRojas();
				id = a.getIdJugador();
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
            				int id= a.getIdJugador();
            			}
            		}
                }
	}
});	
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
        		String nom = "";
        		int valor =0;
        		int gol= 0;
        		int asist= 0;
        		int Ta=0;
        		int Tr= 0;
        		int id =0;
        		for (Estadisticas a: listaJugadores){
        			if (a.getNombre().equals(split)){
        				nom = a.getNombre();
        				id= a.getIdJugador();
        				if(PrecioMillones.getText().equals("")){
        					valor =a.getPrecioEnMillones();
        				}else{
        					 valor = Integer.parseInt(PrecioMillones.getText());
        				}
        				if(GolesText.getText().equals("")){
        					gol= a.getGoles();
        				}else{
        					gol = Integer.parseInt(GolesText.getText());
        				}
        				if(AsistText.getText().equals("")){
        					asist= a.getAsistencias();
        				}else{
        					asist = Integer.parseInt(AsistText.getText());
        				}
        				if(TaText.getText().equals("")){
        					Ta=a.getTarjetasAmarillas();
        				}else{
        					Ta = Integer.parseInt(TaText.getText());
        				}
        				if(TrText.getText().equals("")){
        					Tr= a.getTarjetasRojas();
        				}else{
        					Tr = Integer.parseInt(TrText.getText());
        				}
        				
        			}
        		}
        		UpdateJugador.updateJugador(nom, valor);
        		UpdateJugador.updateJugadorEstadisticas(gol, Ta, Tr, asist, id);
				ED.setText(String.valueOf(valor));
				GOL.setText(String.valueOf(gol));
				ASIS.setText(String.valueOf(asist));
				TA.setText(String.valueOf(Ta));
				TR.setText(String.valueOf(Tr));
			}
		});
		

		btnNewButton.setBounds(565, 249, 198, 29);
		contentPane.add(btnNewButton);
			
		
}

}
