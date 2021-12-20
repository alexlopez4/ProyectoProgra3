package visual;

/** Jframe para insertar ligas
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectLiga;
import objetos.Liga;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdminInsertLiga extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public AdminInsertLiga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreLiga = new JLabel("Nombre Liga:");
		lblNombreLiga.setBounds(15, 199, 113, 20);
		contentPane.add(lblNombreLiga);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(15, 248, 113, 20);
		contentPane.add(lblPais);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(15, 300, 69, 20);
		contentPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(199, 196, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 245, 146, 26);
		contentPane.add(textField_1);
		
		JLabel lblNuevaLiga = new JLabel("Nueva Liga");
		lblNuevaLiga.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNuevaLiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaLiga.setBounds(32, 66, 366, 47);
		contentPane.add(lblNuevaLiga);
		
		DefaultListModel  lista = new DefaultListModel();
		
		String consulta= "SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga";
		ArrayList <Liga> listaLigas = SelectLiga.getLiga(consulta);
		for (Liga a: listaLigas){
			String b = a.getNombreLiga() +", "+ a.getPais();
			lista.addElement(b);}
		
		int z= lista.getSize()+1;
		
		JLabel Codigo = new JLabel(z+"");
		Codigo.setBounds(209, 300, 69, 20);
		contentPane.add(Codigo);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(e-> {
			String a =textField.getText();
			String b =textField_1.getText();
			db.InsertLiga.insertLiga(z,a,b);
			LigasAdmin la= new LigasAdmin();
			la.setVisible(true);
			AdminInsertLiga.this.setVisible(false);	
		});
		btnCrear.setBounds(163, 354, 115, 29);
		contentPane.add(btnCrear);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LigasAdmin la= new LigasAdmin();
				la.setVisible(true);
				AdminInsertLiga.this.setVisible(false);
			}
		});
		btnVolver.setBounds(163, 399, 115, 29);
		contentPane.add(btnVolver);
	}
}
