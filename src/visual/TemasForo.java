package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectTemas;
import objetos.Liga;
import objetos.SalaDebate;
import objetos.Usuario;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TemasForo extends JFrame {

	private JPanel contentPane;
	

	public TemasForo(Liga liga, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int idLigaABuscar = liga.getIdLiga();
		String sql = "SELECT A.IDLIGA, B.NOMBRELIGA, B.PAIS, A.IDSALADEBATE,A.TEMADEBATE FROM liga B"
				+" JOIN (SELECT IDLIGA, IDSALADEBATE,TEMADEBATE FROM saladebate) A "
				+"ON A.IDLIGA=B.IDLIGA"
				+" WHERE B.IDLIGA="+idLigaABuscar+";";
		JList list = new JList();
		list.setBounds(15, 32, 287, 196);
		DefaultListModel<SalaDebate> model = new DefaultListModel<SalaDebate>();
		ArrayList<SalaDebate> listaDebates = SelectTemas.getTemas(sql, user);
		for (SalaDebate s: listaDebates){
			model.addElement(s);
		}
		list.setModel(model);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Ver Tema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaDebate s = (SalaDebate) list.getSelectedValue();
				Foro f = new Foro (user,s);
				f.setVisible(true);
				TemasForo.this.setVisible(false);
					
				
			}
		});
		btnNewButton.setBounds(317, 86, 100, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemaNuevo tm = new TemaNuevo(user, liga);
				tm.setVisible(true);
				TemasForo.this.setVisible(false);
			}
		});
		btnAadir.setBounds(317, 131, 100, 29);
		contentPane.add(btnAadir);
		
		JButton btnVolverAln = new JButton("Volver");
		btnVolverAln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForos m = new MenuForos (user);
				m.setVisible(true);
				TemasForo.this.setVisible(false);
			}
		});
		btnVolverAln.setBounds(317, 176, 100, 29);
		contentPane.add(btnVolverAln);
		
	}
}
