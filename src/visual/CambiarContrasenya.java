package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.UpdateContrasenya;
import objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContrasenya extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public CambiarContrasenya(Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setBounds(122, 151, 174, 20);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblNuevaContrasea_1 = new JLabel("Repetir nueva contraseña");
		lblNuevaContrasea_1.setBounds(122, 211, 211, 20);
		contentPane.add(lblNuevaContrasea_1);
		
		textField = new JTextField();
		textField.setBounds(442, 148, 197, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(442, 208, 197, 26);
		contentPane.add(textField_1);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios");
		btnConfirmarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String contrasenyaNueva = textField.getText();
				String contrasenyaNuevaConfirmada = textField_1.getText();
				if (contrasenyaNueva.equals(contrasenyaNuevaConfirmada)){
					if (contrasenyaNueva.equals(user.getContraseña())){
					JOptionPane.showMessageDialog(CambiarContrasenya.this, "La contraseña es la misma que la actual");
					}else{
				UpdateContrasenya.update(user.getNombreDeUsuario(),contrasenyaNueva);
				user.setContraseña(contrasenyaNueva);
				JOptionPane.showMessageDialog(CambiarContrasenya.this, "La contraseña ha sido cambiada con éxito");
				InfoUser infoUsuario = new InfoUser(user);
				infoUsuario.setVisible(true);
				CambiarContrasenya.this.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(CambiarContrasenya.this, "Error de confirmación, las contraseñas no coinciden");
				}
			}
		});
		btnConfirmarCambios.setBounds(263, 359, 252, 29);
		contentPane.add(btnConfirmarCambios);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(263, 404, 252, 29);
		contentPane.add(btnVolver);
	}
}
