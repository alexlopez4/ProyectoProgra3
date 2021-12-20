package visual;

/** Jframe donde el usuario visualiza los diferentes temas sobre los que debatir
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectTemas;
import objetos.Estadisticas;
import objetos.Liga;
import objetos.SalaDebate;
import objetos.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TemasForo extends JFrame {

	private JPanel contentPane;
	

	public TemasForo(Liga liga, Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		int idLigaABuscar = liga.getIdLiga();
		String sql = "SELECT A.IDLIGA, B.NOMBRELIGA, B.PAIS, A.IDSALADEBATE,A.TEMADEBATE FROM liga B"
				+" JOIN (SELECT IDLIGA, IDSALADEBATE,TEMADEBATE FROM saladebate) A "
				+"ON A.IDLIGA=B.IDLIGA"
				+" WHERE B.IDLIGA="+idLigaABuscar+";";
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setBounds(33, 122, 437, 334);
		DefaultListModel<SalaDebate> model = new DefaultListModel<SalaDebate>();
		ArrayList<SalaDebate> listaDebates = SelectTemas.getTemas(sql, user);
		listaDebates.sort(Comparator.comparing(e -> ((SalaDebate) e).getTemaDebate()));
		for (SalaDebate s: listaDebates){
			model.addElement(s);
		}
		list.setModel(model);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Ver Tema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue()==null){
					JOptionPane.showMessageDialog(TemasForo.this, "Selecciona un tema");
				}else{
				SalaDebate s = (SalaDebate) list.getSelectedValue();
				Foro f = new Foro (user,s);
				f.setVisible(true);
				TemasForo.this.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(521, 263, 228, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TemaNuevo tm = new TemaNuevo(user, liga);
				tm.setVisible(true);
				TemasForo.this.setVisible(false);
			}
		});
		btnAadir.setBounds(521, 320, 228, 29);
		contentPane.add(btnAadir);
		
		JButton btnVolverAln = new JButton("Volver");
		btnVolverAln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuForos m = new MenuForos (user);
				m.setVisible(true);
				TemasForo.this.setVisible(false);
			}
		});
		btnVolverAln.setBounds(521, 375, 228, 29);
		contentPane.add(btnVolverAln);
		
		JLabel lblTemasForo = new JLabel("TEMAS FORO");
		lblTemasForo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblTemasForo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemasForo.setBounds(33, 34, 716, 60);
		contentPane.add(lblTemasForo);
		
	}
}
