package visual;

/** Jframe donde el usuario visualiza las diferentes noticias sobre fútbol.
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.SelectLiga;
import db.SelectNoticia;
import objetos.Estadisticas;
import objetos.Liga;
import objetos.Noticia;
import objetos.Usuario;

public class PantallaNoticia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNoticias;
	
	public PantallaNoticia(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
	
		JList <String> list = new JList <String>();
		list.setBounds(15, 75, 751, 322);
		getContentPane().add(list);
		
		DefaultListModel  lista = new DefaultListModel();
		
		String sql = "SELECT A.IDNOTICIA , A.TITULO , A.TEXTO , A.IDIOMA , A.FECHA , A.IDPERIODICO , NOMBREPERIODICO , PAIS FROM periodico D "
				+"JOIN ( SELECT IDNOTICIA , TITULO , TEXTO , IDIOMA , FECHA , IDPERIODICO FROM noticia) A "
				+"ON A.IDPERIODICO= D.IDPERIODICO";
	
		
		ArrayList <Noticia> listaNoticias = SelectNoticia.getNoticias(sql);
		listaNoticias.sort(Comparator.comparing(e -> ((Noticia) e).getFecha()));
		ArrayList<String> info= new ArrayList<String> ();
		String texto="";
		for (Noticia a: listaNoticias){
			texto="";
			texto=a.getTitulo()+"---"+a.getNombrePeriodico()+"---"+a.getFecha();
			lista.addElement(texto);
		}
		list.setModel(lista);
		
		JButton btnSaberMas = new JButton("Saber mas");
		btnSaberMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String selected = list.getSelectedValue();
			if (selected== null){
				JOptionPane.showMessageDialog(null,"No ha seleccionado ninguna noticia");
			}else{
				String[]split = selected.split("---");
				NoticiaInfo notifo= new NoticiaInfo(split[0], usuario);
				notifo.setVisible(true);
				PantallaNoticia.this.setVisible(false);
			}
			}
		});
		btnSaberMas.setBounds(88, 413, 236, 29);
		contentPane.add(btnSaberMas);
		
		txtNoticias = new JTextField();
		txtNoticias.setFont(new Font("Tahoma", Font.PLAIN, 54));
		txtNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoticias.setText("Noticias");
		txtNoticias.setBounds(88, 7, 609, 52);
		txtNoticias.setEditable(false);
		contentPane.add(txtNoticias);
		txtNoticias.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu(usuario);
				m.setVisible(true);
				PantallaNoticia.this.setVisible(false);
			}
		});
		btnVolver.setBounds(426, 413, 236, 29);
		contentPane.add(btnVolver);
	
	
	}
}
