package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.InsertUsuario;
import db.SelectUser;
import objetos.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAceptar;
	private JPasswordField passwordField;

	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Registrarse.this.setVisible(true);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 39, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(41, 75, 69, 20);
		contentPane.add(lblEdad);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(41, 117, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(41, 153, 96, 20);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(211, 36, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 75, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(211, 114, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 150, 146, 26);
		contentPane.add(passwordField);
		passwordField.setVisible(true);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				String edad =(textField_1.getText());
				String nombreUsuario = textField_2.getText();
				String contraseña = passwordField.getText();
				String SQL = "SELECT NOMBREUSUARIO, NOMBRE, EDAD, PSSW FROM usuario;";
				if (nombre.equals("")|| edad.equals("")|| nombreUsuario.equals("")||contraseña.equals("")){
					JOptionPane.showMessageDialog(Registrarse.this,"No dejes ningun campo vacio");
				}
				else{
					ArrayList<Usuario> users = SelectUser.getUser(SQL);
					boolean UsuarioRepetido=false;
					for (Usuario u: users){
						if (u.getNombreDeUsuario().equals(nombreUsuario)){
							UsuarioRepetido=true;
						}
					}
						if (UsuarioRepetido==false){
							int edadNumero = Integer.parseInt(edad);
						InsertUsuario.insertUsuario(nombre, edadNumero, nombreUsuario, contraseña);
						Login ventanaLogin = new Login();
						ventanaLogin.setVisible(true);
						Registrarse.this.setVisible(false);
			}
				
				else{
					JOptionPane.showMessageDialog(Registrarse.this, "El nombre de usuario ya existe, prueba con otro");
					
				}
				}
			}
		});
		btnAceptar.setBounds(36, 202, 115, 29);
		contentPane.add(btnAceptar);
		
	}

}
