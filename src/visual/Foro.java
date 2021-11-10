package visual;

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

public class Foro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public Foro(Usuario u, SalaDebate s) {
		JFrame frame = new JFrame( );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(15, 16, 308, 160);
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
		
		contentPane.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(15, 192, 308, 42);
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
				String texto ="";
				for (RegistroMensajes message: rm){
					texto = texto +message.getFecha()+" - " +message.getUser().getNombreDeUsuario()+": " +message.getMensaje()+"\n";
				}
				textPane.setText(texto);
				
				contentPane.add(textPane);
			}
		});
		btnEnviar.setBounds(329, 199, 84, 29);
		contentPane.add(btnEnviar);
		
	}
}
