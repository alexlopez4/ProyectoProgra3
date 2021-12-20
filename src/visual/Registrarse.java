package visual;

/** Jframe donde el usuario pude registrarse
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

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
import java.awt.Font;
import javax.swing.SwingConstants;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnAceptar;
	private JPasswordField passwordField;
	private JLabel lblRegistrase;

	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(130, 143, 107, 20);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(130, 197, 69, 20);
		contentPane.add(lblEdad);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(130, 253, 79, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(130, 302, 131, 20);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(389, 140, 249, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(389, 194, 249, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(389, 250, 249, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(390, 299, 248, 26);
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
		btnAceptar.setBounds(41, 403, 695, 29);
		contentPane.add(btnAceptar);
		
		lblRegistrase = new JLabel("Registrase");
		lblRegistrase.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblRegistrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrase.setBounds(123, 45, 515, 52);
		contentPane.add(lblRegistrase);
		
	}

}
