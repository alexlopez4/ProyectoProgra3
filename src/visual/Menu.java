package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalasDeDebate = new JButton("Salas de Debate");
		btnSalasDeDebate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForos salas = new MenuForos(user);
				salas.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		
		JButton btnNoticias = new JButton("Noticias");
		btnNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaNoticia pantalla = new PantallaNoticia(user);
				pantalla.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		
		btnSalasDeDebate.setBounds(38, 72, 145, 29);
		contentPane.add(btnSalasDeDebate);
		
		btnNoticias.setBounds(226, 72, 145, 29);
		contentPane.add(btnNoticias);	
		
		JButton btnDatosHistricos = new JButton("Datos hist\u00F3ricos");
		btnDatosHistricos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Campeones c = new Campeones (user);
					c.setVisible(true);
					Menu.this.setVisible(false);
				
			}
		});
		btnDatosHistricos.setBounds(38, 136, 145, 29);
		contentPane.add(btnDatosHistricos);
		
		JButton btnJugadores = new JButton("Jugadores");
		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PantallaJugador pj= new PantallaJugador(user);
				pj.setVisible(true);
				Menu.this.setVisible(false);
			
			}
		});
		btnJugadores.setBounds(226, 136, 145, 29);
		contentPane.add(btnJugadores);
		
		
	}
}
