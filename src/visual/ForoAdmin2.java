package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.DeleteMessage;
import db.DeleteSalaDebate;
import db.SelectForo;
import db.SelectTemas;
import objetos.Liga;
import objetos.RegistroMensajes;
import objetos.SalaDebate;
import objetos.Usuario;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForoAdmin2 extends JFrame {

	private JPanel contentPane;

	public ForoAdmin2(SalaDebate s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
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
		ArrayList<RegistroMensajes> listMensajes = SelectForo.getForo(sql);
		DefaultListModel <RegistroMensajes> modelMensajes = new DefaultListModel<RegistroMensajes>();
		for (RegistroMensajes rm: listMensajes){
			modelMensajes.addElement(rm);
		}
		list.setModel(modelMensajes);
		
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBounds(35, 83, 556, 367);
		contentPane.add(scroll);
		
		JLabel lblGestinMensajesSala = new JLabel("Gesti\u00F3n mensajes sala de debate "+s.getIdSalaDebate());
		lblGestinMensajesSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinMensajesSala.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGestinMensajesSala.setBounds(35, 16, 556, 51);
		contentPane.add(lblGestinMensajesSala);
		
		JButton btnNewButton = new JButton("Eliminar mensaje");
		btnNewButton.addActionListener(e -> {
				if (list.getSelectedValue()==null){
					JOptionPane.showMessageDialog(ForoAdmin2.this, "Selecciona el mensaje que desees eliminar");
				}else{
					Usuario u = ((RegistroMensajes)list.getSelectedValue()).getUser();
					DeleteMessage.delete(u.getNombreDeUsuario(), s.getIdSalaDebate(),((RegistroMensajes)list.getSelectedValue()).getFecha(), ((RegistroMensajes)list.getSelectedValue()).getMensaje());
					JOptionPane.showMessageDialog(ForoAdmin2.this, "Mensaje eliminado");
					modelMensajes.clear();
					ArrayList<RegistroMensajes> listMensajes2 = SelectForo.getForo(sql);
					for (RegistroMensajes rm: listMensajes2){
						modelMensajes.addElement(rm);
					}
					list.setModel(modelMensajes);
				}
		});
		btnNewButton.setBounds(606, 343, 157, 37);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e->{
				ForoAdmin1 temasForo = new ForoAdmin1();
				temasForo.setVisible(true);
				ForoAdmin2.this.setVisible(false);
			
		});
		btnVolver.setBounds(606, 396, 157, 37);
		contentPane.add(btnVolver);
		
		
		
	}
}
