package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectEquipo;
import db.SelectJugador;
import db.SelectLiga;
import objetos.Equipo;
import objetos.Liga;
import objetos.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipoAnalisis extends JFrame {

	private JPanel contentPane;

	public EquipoAnalisis(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(533, 116, 177, 36);
		DefaultComboBoxModel<Liga> modelLiga = new DefaultComboBoxModel<Liga>();
		String consulta= "SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga";
		ArrayList <Liga> listaLigas = SelectLiga.getLiga(consulta);
		for (Liga l: listaLigas){
			modelLiga.addElement(l);
		}
		comboBox.setModel(modelLiga);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setBounds(704, 231, 59, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(704, 267, 59, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(699, 303, 64, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(704, 339, 64, 20);
		contentPane.add(label_3);
		
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue()!=null){
					String sql2 = "SELECT * FROM (SELECT COUNT(IDJUGADOR) AS NUMEROJUGADORES, "
							+ "NOMBREEQUIPO FROM (SELECT jugador.IDJUGADOR, equipo.NOMBREEQUIPO from jugador"
							+" join equipo"
							+" on equipo.IDEQUIPO=jugador.IDEQUIPO)"
							+" GROUP BY NOMBREEQUIPO)"
							+" WHERE NOMBREEQUIPO='"+((Equipo) list.getSelectedValue()).getNombreEquipo()+"';";
					int numeroJugadores = SelectJugador.getNumeroJugadores(sql2);
					label_1.setText(""+numeroJugadores);
					
					String sql3 = "SELECT VALOR, NOMBREEQUIPO FROM("
							+ "SELECT SUM(PRECIOENM) AS VALOR, NOMBREEQUIPO FROM(SELECT jugador.PRECIOENM, jugador.IDEQUIPO, equipo.IDEQUIPO, equipo.NOMBREEQUIPO from jugador"
							+ " join equipo on equipo.IDEQUIPO=jugador.IDEQUIPO) "
							+ "GROUP BY NOMBREEQUIPO) "
							+ "WHERE NOMBREEQUIPO='"+((Equipo) list.getSelectedValue()).getNombreEquipo()+"';";
					int valor = SelectEquipo.getValor(sql3);
					label_2.setText(valor+" M");
					double valorMedioJugador = valor/numeroJugadores;
					label_3.setText(valorMedioJugador+" M");
					
					String sql4 = "SELECT * FROM(SELECT COUNT(*) AS VECESCAMPEON, NOMBREEQUIPO FROM("
							+" SELECT CAMPEON, NOMBREEQUIPO FROM equipo"
							+" join temporadadeliga"
							+" on equipo.IDEQUIPO=temporadadeliga.CAMPEON)"
							+" GROUP BY NOMBREEQUIPO)"
							+" where NOMBREEQUIPO='"+((Equipo) list.getSelectedValue()).getNombreEquipo()+"';";
					
					int titulos = SelectEquipo.vecesCampeon(sql4);
					label.setText(""+titulos);
					}
			}
		});
		list.setFont(new Font("Verdana", Font.PLAIN, 22));
		list.setBounds(39, 112, 441, 326);
		String sql = "Select equipo.NOMBREEQUIPO, equipo.IDEQUIPO, equipo.ESTADIO, liga.IDLIGA, "
				+ "liga.NOMBRELIGA, liga.PAIS FROM equipo "
				+"JOIN liga "
				+"ON equipo.IDLIGA=liga.IDLIGA " 
				+ "WHERE NOMBRELIGA = '"+((Liga) comboBox.getSelectedItem()).getNombreLiga()+"';";
		ArrayList<Equipo> equipos = SelectEquipo.getEquipo(sql);
		DefaultListModel<Equipo> modeloLista = new DefaultListModel<Equipo>();
		for (Equipo e: equipos){
			modeloLista.addElement(e);
		}
		list.setModel(modeloLista);
		contentPane.add(list);
		
		JLabel lblNJugadores = new JLabel("N\u00BA jugadores:");
		lblNJugadores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNJugadores.setBounds(516, 266, 144, 20);
		contentPane.add(lblNJugadores);
		
		JLabel lblPrecioTotalEquipo = new JLabel("Precio total equipo:");
		lblPrecioTotalEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecioTotalEquipo.setBounds(516, 302, 168, 20);
		contentPane.add(lblPrecioTotalEquipo);
		
		JLabel lblNewLabel = new JLabel("Precio medio jugador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(516, 338, 194, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitulosObtenidos = new JLabel("Titulos obtenidos: ");
		lblTitulosObtenidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulosObtenidos.setBounds(516, 230, 168, 20);
		contentPane.add(lblTitulosObtenidos);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(user);
				m.setVisible(true);
				EquipoAnalisis.this.setVisible(false);
			}
		});
		btnVolver.setBounds(533, 439, 184, 29);
		contentPane.add(btnVolver);
		
		JButton btnNewButton = new JButton("Ver plantilla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue()==null){
					JOptionPane.showMessageDialog(EquipoAnalisis.this,"No hay ningún equipo seleccionado");
				}else{
				TeamPlayers tp = new TeamPlayers((Equipo) list.getSelectedValue(), user);
				tp.setVisible(true);
				EquipoAnalisis.this.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(533, 394, 184, 29);
		contentPane.add(btnNewButton);
		
		
		
		comboBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if ( e.getStateChange() == ItemEvent.SELECTED ) 
                {
                	String sql = "Select equipo.NOMBREEQUIPO, equipo.IDEQUIPO, equipo.ESTADIO, liga.IDLIGA, "
            				+ "liga.NOMBRELIGA, liga.PAIS FROM equipo "
            				+"JOIN liga "
            				+"ON equipo.IDLIGA=liga.IDLIGA " 
            				+ "WHERE NOMBRELIGA = '"+((Liga) comboBox.getSelectedItem()).getNombreLiga()+"';";
            		ArrayList<Equipo> equipos = SelectEquipo.getEquipo(sql);
            		DefaultListModel<Equipo> modeloLista = new DefaultListModel<Equipo>();
            		for (Equipo team: equipos){
            			modeloLista.addElement(team);
            		}
            		list.setModel(modeloLista);
            		label_1.setText("");
            		label_2.setText("");
            		label_3.setText("");
            		label.setText("");
                }
            }
		});
		
		
		
		
	}
}
