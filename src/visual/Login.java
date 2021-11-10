package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.SelectUser;
import objetos.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JButton registrarse;
	private JButton iniciarSesion;
	private JPasswordField passwordField;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(190, 110, 329, 26);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 194, 329, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoUsuario = txtusuario.getText();
				String passwordTexto= passwordField.getText();
				String sentencia = "SELECT NOMBREUSUARIO, NOMBRE, EDAD, PSSW FROM usuario";
				ArrayList<Usuario> listaUsuarios = SelectUser.getUser(sentencia);
				
				if (passwordTexto.equals("") ||textoUsuario.equals("")){
					JOptionPane.showMessageDialog(Login.this, "No dejes ning�n campo vacio");
				}
				else{
					Usuario u = null;
					boolean UsuarioCorrecto=false;
					for (Usuario a: listaUsuarios){
					if (a.getNombreDeUsuario().equals(passwordTexto) || a.getContrase�a().equals(passwordTexto)){
						UsuarioCorrecto=true;
						u = a;
					}
}
					if (UsuarioCorrecto){
						boolean esAdmin=u.esAdmin();
						if (esAdmin){
							AdminVentana admin= new AdminVentana();
							admin.setVisible(true);
							Login.this.setVisible(false);
						}
						else{
							Menu entradaMenu = new Menu(u);
							entradaMenu.setVisible(true);
							Login.this.setVisible(false);
						}
					} else{
						JOptionPane.showMessageDialog(Login.this, "Usuario o contrase�a Incorrectas");
					}
				}
			}
		});
		btnNewButton.setBounds(33, 255, 501, 29);
		contentPane.add(btnNewButton);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(33, 300, 501, 29);
		contentPane.add(btnRegistrarse);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblUsuario.setBounds(15, 112, 123, 23);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblContrasea.setBounds(15, 196, 170, 23);
		contentPane.add(lblContrasea);
		
		JLabel lblInico = new JLabel("Inicio");
		lblInico.setFont(new Font("Stencil", Font.PLAIN, 73));
		lblInico.setHorizontalAlignment(SwingConstants.CENTER);
		lblInico.setBounds(171, 16, 231, 67);
		contentPane.add(lblInico);
		
	}
}
