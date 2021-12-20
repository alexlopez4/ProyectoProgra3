package visual;

/** Jframe donde el administrador visualiza y añade ligas
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectLiga;
import objetos.Jugador;
import objetos.Liga;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LigasAdmin extends JFrame {

	private JPanel contentPane;

	public LigasAdmin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 23));
		DefaultListModel  lista = new DefaultListModel();
		
		String consulta= "SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga";
		ArrayList <Liga> listaLigas = SelectLiga.getLiga(consulta);
		for (Liga a: listaLigas){
			String b = a.getNombreLiga() +", "+ a.getPais();
			lista.addElement(b);}
		
		list.setModel(lista);
		list.setBounds(41, 122, 315, 316);
		contentPane.add(list);
		
		
		JLabel lblLigas = new JLabel("Ligas");
		lblLigas.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 94));
		lblLigas.setHorizontalAlignment(SwingConstants.CENTER);
		lblLigas.setBounds(41, 16, 700, 90);
		contentPane.add(lblLigas);
		
		JButton btnNewButton = new JButton("Nueva Liga");
		btnNewButton.addActionListener(e-> {
			AdminInsertLiga a= new AdminInsertLiga();
			a.setVisible(true);
			LigasAdmin.this.setVisible(false);
		});
		btnNewButton.setBounds(397, 228, 344, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(e-> {
			AdminVentana a= new AdminVentana();
			a.setVisible(true);
			LigasAdmin.this.setVisible(false);
			
		});
		btnNewButton_1.setBounds(397, 273, 344, 29);
		contentPane.add(btnNewButton_1);
	}
}
