package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectJugador;
import objetos.Equipo;
import objetos.Jugador;
import objetos.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;



public class Game extends JFrame {
	private JPanel contentPane;
	
	public static int num (int a){	
		int min_val = 0;
	    int max_val = a;
	    Random rand = new Random();
	    int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
		return randomNum;
	    }

	public Game(int puntuacion, Usuario user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		
		String sql = "SELECT IDJUGADOR, NOMBREJUGADOR, EDADJUGADOR ,PRECIOENM, B.IDEQUIPO, B.NOMBREEQUIPO, B.ESTADIO, B.IDLIGA , B.NOMBRELIGA , B.PAIS FROM jugador "
				+ " JOIN (SELECT IDEQUIPO, NOMBREEQUIPO, ESTADIO, A.IDLIGA , A.NOMBRELIGA , A.PAIS FROM equipo "
				+ " JOIN(SELECT IDLIGA , NOMBRELIGA , PAIS FROM liga) A "
				+ " ON A.IDLIGA = equipo.IDLIGA ) B "
				+ "ON B.IDEQUIPO= jugador.IDEQUIPO";
	
		
		ArrayList<Jugador> listaJugadores= SelectJugador.getJugadores(sql);
		
		int a= num(listaJugadores.size()-1);
		
		Jugador jug=listaJugadores.get(a);
		
		String nombre = jug.getNombre();
		Equipo equip = jug.getEquipo();
		String equipo = equip.getNombreEquipo();
		int edad=jug.getEdad();
		
		

		int b= num(listaJugadores.size()-1);
		
		Jugador jugador=listaJugadores.get(b);
		
		String name = jugador.getNombre();
		Equipo equi = jugador.getEquipo();
		String team = equi.getNombreEquipo();
		int años=jugador.getEdad();
		
		JLabel lblNewLabel = new JLabel("Football game");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 63));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(185, 16, 399, 84);
		getContentPane().add(lblNewLabel);
		
		Label player1 = new Label(nombre);
		player1.setFont(new Font("Calibri Light", Font.PLAIN, 28));
		player1.setAlignment(Label.CENTER);
		player1.setBounds(46, 124, 310, 36);
		getContentPane().add(player1);
		
		Label player2 = new Label(name);
		player2.setFont(new Font("Calibri Light", Font.PLAIN, 28));
		player2.setAlignment(Label.CENTER);
		player2.setBounds(403, 124, 310, 36);
		getContentPane().add(player2);
		
		Label label = new Label("Puntuaci\u00F3n:");
		label.setBounds(46, 447, 95, 27);
		getContentPane().add(label);
		
		Label label_1 = new Label(""+puntuacion);
		label_1.setBounds(147, 447, 82, 27);
		getContentPane().add(label_1);
		
		Button button = new Button("Su valor es mayor ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mill1= jug.getPrecioEnMillones();
				int mill2=jugador.getPrecioEnMillones();
				if ( mill1 > mill2){
					int  punt= puntuacion +1;
					Game gam= new Game (punt , user);
					gam.setVisible(true);
					Game.this.setVisible(false);	
				}else{
					int n = JOptionPane.showConfirmDialog(null,"Error el valor del segundo jugador es superior al primero, quiere seguir jugando?!","",JOptionPane.YES_NO_OPTION);
			      if(n == JOptionPane.YES_OPTION)
			      {
			          JOptionPane.showMessageDialog(null, "Reiniciando...");
			          Game gam= new Game (0, user);
			          gam.setVisible(true);
			          Game.this.setVisible(false);
			      }
			      else
			      {
			          JOptionPane.showMessageDialog(null, "Volviendo al menu...");
			          Menu men= new Menu(user);
			          men.setVisible(true);
			          Game.this.setVisible(false);
				}
			}}});
		int mill1= jug.getPrecioEnMillones();
		int mill2=jugador.getPrecioEnMillones();
		
		String valores= "El valor del jugador 1 : " + mill1;
		String valores1= "y del jugador2 :" +mill2;
		String valores2 = valores + valores1;
		
		Button button_2 = new Button("Su valor es mayor");
		button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if( mill1<mill2){
				int  punt= puntuacion +1;
				Game gam= new Game (punt, user);
				gam.setVisible(true);
				Game.this.setVisible(false);	
			}else {
				int n = JOptionPane.showConfirmDialog(null,"Error el valor del primer jugador es superior al segundo, quiere seguir jugando?!","",JOptionPane.YES_NO_OPTION);
			      if(n == JOptionPane.YES_OPTION)
			      {
			          JOptionPane.showMessageDialog(null, "Reiniciando...");
			          Game gam= new Game (0, user);
			          gam.setVisible(true);
			          Game.this.setVisible(false);
			      }
			      else
			      {
			          JOptionPane.showMessageDialog(null, "Volviendo al menu...");
			          Menu men= new Menu(user);
			          men.setVisible(true);
			          Game.this.setVisible(false);
				}
			}}});
		button_2.setBounds(465, 382, 219, 27);
		contentPane.add(button_2);
		
		button.setBounds(83, 382, 219, 27);
		getContentPane().add(button);
		
		Button button_1 = new Button("Volver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu= new Menu (user);
				menu.setVisible(true);
				Game.this.setVisible(false);
			}

		});
		button_1.setBounds(549, 447, 219, 27);
		getContentPane().add(button_1);
		
		JLabel equipo1 = new JLabel("Equipo: "+equipo);
		equipo1.setBounds(46, 189, 310, 36);
		contentPane.add(equipo1);
		
		JLabel edad1 = new JLabel("Edad: "+edad);
		edad1.setBounds(46, 241, 310, 34);
		contentPane.add(edad1);
		
		JLabel valor = new JLabel("Valor: --------€");
		valor.setBounds(46, 300, 310, 36);
		contentPane.add(valor);
		
		JLabel equipo1_1 = new JLabel("Equipo: "+team);
		equipo1_1.setBounds(430, 189, 310, 36);
		contentPane.add(equipo1_1);
		
		JLabel edad1_1 = new JLabel("Edad: "+años);
		edad1_1.setBounds(430, 248, 310, 34);
		contentPane.add(edad1_1);
		
		JLabel valor_1 = new JLabel("Valor: --------€");
		valor_1.setBounds(430, 300, 310, 36);
		contentPane.add(valor_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este es un juego que trata de adivinar cual de los dos jugadores tiene un valor de mercado superior");
			}
		});
		btnNewButton.setIcon(new ImageIcon(Game.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		btnNewButton.setBounds(517, 447, 26, 27);
		contentPane.add(btnNewButton);
		
		
	
	}}