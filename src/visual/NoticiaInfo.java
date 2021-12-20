package visual;

/** Jframe donde el usuario visualiza la informacion de la notica selecionada.
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectNoticia;
import objetos.Noticia;
import objetos.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class NoticiaInfo extends JFrame {

	private JPanel contentPane;


	public NoticiaInfo(String w, Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);

		String sql = "SELECT A.IDNOTICIA , A.TITULO , A.TEXTO , A.IDIOMA , A.FECHA , A.IDPERIODICO , NOMBREPERIODICO , PAIS FROM periodico D "
				+"JOIN ( SELECT IDNOTICIA , TITULO , TEXTO , IDIOMA , FECHA , IDPERIODICO FROM noticia) A "
				+"ON A.IDPERIODICO= D.IDPERIODICO"
				+ " WHERE A.TITULO Like '%"+ w+"%'";
	
		
		ArrayList <Noticia> listaNoticias = SelectNoticia.getNoticias(sql);
		
		JLabel TITULO = new JLabel();
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		TITULO.setBounds(15, 16, 651, 58);
		contentPane.add(TITULO);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Tahoma", Font.ITALIC, 18));
		textArea.setBounds(15, 90, 621, 274);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord (true);
		textArea.enable(false);
		contentPane.add(textArea);
		
		JLabel PERIODICO = new JLabel();
		PERIODICO.setHorizontalAlignment(SwingConstants.CENTER);
		PERIODICO.setBounds(15, 384, 163, 26);
		contentPane.add(PERIODICO);
		
		JLabel FECHA = new JLabel();
		FECHA.setHorizontalAlignment(SwingConstants.CENTER);
		FECHA.setFont(new Font("Tahoma", Font.ITALIC, 20));
		FECHA.setBounds(193, 384, 177, 26);
		contentPane.add(FECHA);
		
		for (Noticia a: listaNoticias){
		
		TITULO.setText(a.getTitulo());
		
		textArea.setText(a.getTexto());
		
		PERIODICO.setText(a.getNombrePeriodico());
		
		FECHA.setText(a.getFecha());
		}
		
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticiaInfo.this.setVisible(false);
				PantallaNoticia pant= new PantallaNoticia(usuario);
				pant.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(508, 383, 158, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.getViewport().setViewPosition(new Point(0,0));
		scrollPane.setBounds(15, 90, 651, 274);
		contentPane.add(scrollPane);
		
		
		
	}
}

