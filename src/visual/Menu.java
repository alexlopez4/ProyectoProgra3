package visual;

/** Jframe menu de el usuario 
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import objetos.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu(Usuario user) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(416, 16, 400, 51);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu1 = new JMenu("Ligas");
		mnNewMenu1.setBackground(new Color(240, 240, 240));
		mnNewMenu1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu1.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu1);
		
		JMenuItem equipos = new JMenuItem("Equipos");
		equipos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		equipos.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    	  EquipoAnalisis ventanaEquipos = new EquipoAnalisis(user);
					ventanaEquipos.setVisible(true);
					Menu.this.setVisible(false);
				}
        });
		mnNewMenu1.add(equipos);
		mnNewMenu1.add(separator4);
		
		JMenuItem deb = new JMenuItem("Sala Debates");
		deb.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		deb.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    		MenuForos salas = new MenuForos(user);
					salas.setVisible(true);
					Menu.this.setVisible(false);
				
		      }
        });
		mnNewMenu1.add(deb);
		
		mnNewMenu1.add(separator1);
		
		JMenuItem not = new JMenuItem("Noticias");
		not.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		not.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    		PantallaNoticia pantalla = new PantallaNoticia(user);
					pantalla.setVisible(true);
					Menu.this.setVisible(false);
		      }
        });
		
		mnNewMenu1.add(not);
		
		
		
		JMenu mnNewMenu2 = new JMenu("Jugadores");
		mnNewMenu2.setBackground(new Color(240, 240, 240));
		mnNewMenu2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu2.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu2);
		
		JMenuItem jugadores = new JMenuItem("Info Jugadores");
		jugadores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		jugadores.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		  		PantallaJugador pj= new PantallaJugador(user);
				pj.setVisible(true);
				Menu.this.setVisible(false);
		      }
        });
		mnNewMenu2.add(jugadores);
		
		mnNewMenu2.add(separator2);
		
		JMenuItem datos = new JMenuItem("Datos Historicos");
		datos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		datos.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    	  Campeones c = new Campeones (user);
					c.setVisible(true);
					Menu.this.setVisible(false);
				}
        });
		mnNewMenu2.add(datos);
		
		mnNewMenu2.add(separator3);
		
		JMenuItem juego= new JMenuItem("What's my value?");
		juego.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		juego.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    	  Game game = new Game( 0, user);
		    	  game.setVisible(true);
		    	  Menu.this.setVisible(false);
				}
        });
		mnNewMenu2.add(juego);
		
		
		JMenu mnNewMenu4= new JMenu("Usuario");
		mnNewMenu4.setBackground(new Color(240, 240, 240));
		mnNewMenu4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu4.setForeground(SystemColor.desktop);
		mnNewMenu4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		      
		      }
		});
		menuBar.add(mnNewMenu4);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		mnNewMenu.setBackground(new Color(240, 240, 240));
		mnNewMenu.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu.setForeground(SystemColor.desktop);
		mnNewMenu.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		      
		      }
      });
		menuBar.add(mnNewMenu);
		
		JMenuItem Cerrar = new JMenuItem("Cerrar Programa");
		Cerrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		Cerrar.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    	  Menu.this.setVisible(false);
	            }
	        });
		mnNewMenu.add(Cerrar);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Info Usuario");
		mntmNewMenuItem_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		      InfoUser b= new InfoUser(user);
		      b.setVisible(true);
		      Menu.this.setVisible(false);
		      }
        });
		mnNewMenu4.add(mntmNewMenuItem_2);

		mnNewMenu4.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesión");
		mntmNewMenuItem_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e){
		    Login a= new Login ();
		    a.setVisible(true);
		    Menu.this.setVisible(false);
		      }
        });
		
		mnNewMenu4.add(mntmNewMenuItem_1);
		
		JLabel lblFootballPage = new JLabel("Football Page");
		lblFootballPage.setForeground(SystemColor.desktop);
		lblFootballPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFootballPage.setLocation(15, 0);
		lblFootballPage.setSize(395, 72);
		lblFootballPage.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 48));
		contentPane.add(lblFootballPage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\Nueva carpeta (2)\\ProyectoProgra3\\Imagenes\\campo.jpg"));
		lblNewLabel.setBounds(87, 83, 600, 385);
		contentPane.add(lblNewLabel);
		
}
}

