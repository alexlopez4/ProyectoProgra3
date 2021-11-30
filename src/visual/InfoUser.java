package visual;


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
	public InfoUser( objetos.Usuario user) {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD | Font.ITALIC, 83));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(258, 16, 475, 155);
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
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_3.setBounds(397, 237, 298, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		lblNewLabel_4.setBounds(397, 277, 310, 37);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Cambiar Contrase\u00F1a");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}
	
	public void setContrasena(String c)
	{
		lblNewLabel_4.setText(c);
	}

}
