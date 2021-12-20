package visual;

/** Jframe donde el administrador visualiza los jugadores y puede eliminar uno
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.DeleteJugador;
import db.SelectJugador;
import objetos.Jugador;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JugadorAdmin extends JFrame {

	private JPanel contentPane;
	
	public JugadorAdmin() {
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
		js.setBounds(15, 125, 377, 302);
		contentPane.add(js);
		
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 63));
		lblJugadores.setBounds(39, 16, 689, 71);
		contentPane.add(lblJugadores);
		
		JButton btnEditarEstadisticas = new JButton("Editar estadisticas");
		btnEditarEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				if (list.getSelectedValue()== null){
					JOptionPane.showMessageDialog(null,"No ha seleccionado ningun jugador");
				}else{
					String[]split = selected.split(" , ");
					JugadorAdminEstadisticas a= new JugadorAdminEstadisticas(split[0]);
					a.setVisible(true);
					JugadorAdmin.this.setVisible(false);
			}}
		});
		btnEditarEstadisticas.setBounds(425, 159, 303, 29);
		contentPane.add(btnEditarEstadisticas);
		
		JButton btnNewButton = new JButton("Eliminar jugador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) list.getSelectedValue();
				String[]split = selected.split(" , ");
				int indice =list.getSelectedIndex();
				for (Jugador a: listaJugadores){
					if (a.getNombre().equals(split[0]));
						DeleteJugador.delete(a.getIdJugador(), a.getNombre(),a.getEdad(), a.getPrecioEnMillones(),a.getEquipo());
						list.remove(indice);
				}
			}
		});
		btnNewButton.setBounds(425, 227, 303, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminVentana a= new AdminVentana();
				a.setVisible(true);
				JugadorAdmin.this.setVisible(false);
				}
		});
		btnNewButton_1.setBounds(425, 294, 303, 29);
		contentPane.add(btnNewButton_1);
		
	}

}
