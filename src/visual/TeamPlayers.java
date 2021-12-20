package visual;

/** Jframe donde el usuario visualiza tras seleccionar un equipo , sus jugadores.
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.SelectJugador;
import objetos.Equipo;
import objetos.Jugador;
import objetos.Usuario;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class TeamPlayers extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	

	
	public TeamPlayers(Equipo equipo, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		DefaultTableModel players = new DefaultTableModel();
		
		players.addColumn("NOMBRE");
		players.addColumn("EDAD");
		players.addColumn("PRECIO (M€)");
		
		String sql = "SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ "ON B.IDEQUIPO= jugador.IDEQUIPO"
				+ " WHERE B.NOMBREEQUIPO ='"+equipo.getNombreEquipo()+"';";
		
		ArrayList<Jugador> playersList = SelectJugador.getJugadores(sql);
		Object[] filaTabla = new Object[3];
		for (Jugador j: playersList){
			filaTabla[0] = j.getNombre();
			filaTabla[1] = j.getEdad();
			filaTabla[2] = j.getPrecioEnMillones();
			players.addRow(filaTabla);
		}
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sitka Small", Font.BOLD, 26));
		label.setBounds(125, 27, 508, 84);
		label.setText(equipo.getNombreEquipo());
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoAnalisis ea=new EquipoAnalisis(user);
				ea.setVisible(true);
				TeamPlayers.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(66, 414, 271, 29);
		contentPane.add(btnNewButton);
		JButton btnEstadsticas = new JButton("Estad\u00EDsticas");
		btnEstadsticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = (String)table_1.getValueAt(table_1.getSelectedRow(), 0);
				Jugador j = null;
				for (Jugador jug: playersList){
					if (nombre.equals(jug.getNombre())){
						j=jug;
					}
				}
				JugadorInfo2 estadisticas = new JugadorInfo2(user,j, equipo);
				estadisticas.setVisible(true);
				TeamPlayers.this.setVisible(false);
				}
			
		});
		btnEstadsticas.setBounds(417, 414, 274, 29);
		contentPane.add(btnEstadsticas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 132, 625, 262);
		contentPane.add(scrollPane);
		table_1 = new JTable(players);
		scrollPane.setViewportView(table_1);
		
	}
}
