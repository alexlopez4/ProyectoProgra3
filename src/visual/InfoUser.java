package visual;

/** Jframe donde aparece informacion sobre el usuario
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class InfoUser extends JFrame {

	private JPanel contentPane;
	private String Usuario;
	private String Contraseña;
	private JLabel lblNewLabel_4;



	/**
	 * Create the frame.
	 * @param login 
	 */
	public InfoUser(objetos.Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD | Font.ITALIC, 83));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 16, 475, 155);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Usuario :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 32));
		lblNewLabel_1.setBounds(115, 233, 239, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 32));
		lblNewLabel_2.setBounds(125, 277, 229, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(user.getNombreDeUsuario());
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_3.setBounds(397, 237, 298, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(user.getContraseña());
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_4.setBounds(397, 277, 310, 37);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Cambiar Contrase\u00F1a");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarContrasenya nuevaContrasenya = new CambiarContrasenya(user);
				nuevaContrasenya.setVisible(true);
				InfoUser.this.setVisible(false);
		}
		});
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 20));
		btnNewButton.setBounds(115, 397, 562, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setForeground(SystemColor.desktop);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu a= new Menu (user);
				a.setVisible(true);
				InfoUser.this.setVisible(false);
		}
		});
		btnNewButton_1.setFont(new Font("Bernard MT Condensed", Font.ITALIC, 21));
		btnNewButton_1.setBounds(115, 434, 562, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.ITALIC, 32));
		lblNewLabel_2_1.setBounds(125, 175, 229, 42);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel(user.getNombre());
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_3_1.setBounds(397, 187, 348, 28);
		contentPane.add(lblNewLabel_3_1);
	}
	
	public void setContrasena(String c)
	{
		lblNewLabel_4.setText(c);
	}
}
