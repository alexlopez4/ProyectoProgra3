package visual;

/** Jframe foro donde los usuarios pueden interactuar
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.InsertNewMessage;
import db.SelectForo;
import objetos.RegistroMensajes;
import objetos.SalaDebate;
import objetos.Usuario;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Foro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public Foro(Usuario u, SalaDebate s) {
		JFrame frame = new JFrame( );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
	    
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPane.setEditable(false);
	
		
		String temaDebate = s.getTemaDebate();
		int idLiga = s.getLiga().getIdLiga();
		String sql = "SELECT E.NOMBREUSUARIO, E.EDAD, E.NOMBRE, E.PSSW, F.IDLIGA, F.NOMBRELIGA, F.PAIS, F.IDSALADEBATE, F.TEMADEBATE, F.NOMBREUSUARIO, F.MENSAJE, F.FECHA FROM usuario E "
					+"JOIN ("
						+"SELECT C.IDLIGA, C.NOMBRELIGA, C.PAIS, C.IDSALADEBATE, C.TEMADEBATE, D.NOMBREUSUARIO, D.MENSAJE, D.FECHA FROM registroMensajes D "
						+"JOIN ("
						+"SELECT A.IDLIGA, B.NOMBRELIGA, B.PAIS, A.IDSALADEBATE,A.TEMADEBATE FROM liga B JOIN (SELECT IDLIGA, IDSALADEBATE,TEMADEBATE FROM saladebate) A "
						+"ON A.IDLIGA=B.IDLIGA)C "
						+"ON D.IDSALADEBATE=C.IDSALADEBATE)F "
						+"ON F.NOMBREUSUARIO=E.NOMBREUSUARIO "
						+"WHERE IDLIGA="+idLiga+" AND TEMADEBATE='"+temaDebate+"'"
						+"ORDER BY F.FECHA ASC;";
		ArrayList<RegistroMensajes> rm = SelectForo.getForo(sql);
		String texto ="";
		for (RegistroMensajes mensaje: rm){
			texto = texto +mensaje.getFecha()+" - " +mensaje.getUser().getNombreDeUsuario()+": " +mensaje.getMensaje()+"\n";
		}
		textPane.setText(texto);
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(15, 111, 531, 280);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(15, 407, 531, 42);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnEnviar = new JButton("Send");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = u.getNombreDeUsuario();
				int idSalaDebate = s.getIdSalaDebate();
				String mensaje = textField.getText();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String fecha = dtf.format(LocalDateTime.now());
				InsertNewMessage.insertMensaje(nombreUsuario,idSalaDebate,mensaje,fecha);
				ArrayList<RegistroMensajes> rm = SelectForo.getForo(sql);
				String texto="";
				for (RegistroMensajes message: rm){
					texto = texto +message.getFecha()+" - " +message.getUser().getNombreDeUsuario()+": " +message.getMensaje()+"\n";
				}
				textPane.setText(texto);
				scrollPane.add(textPane);
				textField.setText("");
			}
		});
		btnEnviar.setBounds(561, 410, 202, 36);
		contentPane.add(btnEnviar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemasForo tf = new TemasForo (s.getLiga(), u);
				tf.setVisible(true);
				Foro.this.setVisible(false);
			}
		});
		btnVolver.setBounds(561, 365, 202, 29);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("SALA DEBATE");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(15, 33, 748, 55);
		contentPane.add(lblNewLabel);
		
	}
}
