package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectForo;
import objetos.RegistroMensajes;
import objetos.SalaDebate;
import objetos.Usuario;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Foro extends JFrame {

	private JPanel contentPane;

	
	public Foro(Usuario u, SalaDebate s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(15, 35, 342, 193);
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
						+"ORDER BY F.FECHA DESC;";
		ArrayList<RegistroMensajes> rm = SelectForo.getForo(sql);
		String texto ="";
		for (RegistroMensajes mensaje: rm){
			texto = texto +mensaje.getFecha()+" - " +mensaje.getUser().getNombreDeUsuario()+": " +mensaje.getMensaje()+"\n";
		}
		textPane.setText(texto);
		
		contentPane.add(textPane);
		
	}
}
