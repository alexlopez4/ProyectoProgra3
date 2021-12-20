package visual;

/** Jframe del menu del administrador
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;


public class AdminVentana extends JFrame {

	private JPanel contentPane;

	public AdminVentana() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 64));
		lblAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrador.setBounds(15, 37, 308, 50);
		contentPane.add(lblAdministrador);
		
		
		JSeparator separator = new JSeparator();
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(344, 37, 400, 51);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu1 = new JMenu("Ligas");
		mnNewMenu1.setBackground(new Color(240, 240, 240));
		mnNewMenu1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu1.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu1);
		
		JMenuItem ligas = new JMenuItem("Lista de ligas");
		ligas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		ligas.addActionListener(e ->{
		      LigasAdmin la= new LigasAdmin();
		      la.setVisible(true);
		      AdminVentana.this.setVisible(false);
        });
		mnNewMenu1.add(ligas);
		
		mnNewMenu1.add(separator);
		
		JMenuItem salaDebate = new JMenuItem("Salas de Debate");
		salaDebate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		salaDebate.addActionListener( e ->{
		    	  ForoAdmin1 foros= new ForoAdmin1();
		    	  foros.setVisible(true);
		    	  AdminVentana.this.setVisible(false);
		      
        });
		mnNewMenu1.add(salaDebate);
		
		JMenu mnNewMenu2 = new JMenu("Jugadores");
		mnNewMenu2.setBackground(new Color(240, 240, 240));
		mnNewMenu2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu2.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu2);
		
		JMenuItem jugadores = new JMenuItem("Lista de jugadores");
		jugadores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		jugadores.addActionListener(e->{
		    	  JugadorAdmin a= new JugadorAdmin ();
		    	  a.setVisible(true);
		    	  AdminVentana.this.setVisible(false);
		      
        });
		mnNewMenu2.add(jugadores);
		
		JMenu mnNewMenu3 = new JMenu("Usuarios");
		mnNewMenu3.setBackground(new Color(240, 240, 240));
		mnNewMenu3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu3.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu3);
		
		
		
		JMenuItem usuarios = new JMenuItem("Lista de usuarios");
		usuarios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		usuarios.addActionListener(e->{
		    	  UsuariosAdmin pant= new UsuariosAdmin();
		    	  pant.setVisible(true);
		    	  AdminVentana.this.setVisible(false);
        });
		mnNewMenu3.add(usuarios);
		
		JMenu mnNewMenu4= new JMenu("Opciones");
		mnNewMenu4.setBackground(new Color(240, 240, 240));
		mnNewMenu4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 26));
		mnNewMenu4.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu4);
		
		JMenuItem cerrar = new JMenuItem("Cerrar programa");
		cerrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		cerrar.addActionListener(e ->{
		      AdminVentana.this.setVisible(false);
		      
        });
		mnNewMenu4.add(cerrar);
	}
}
