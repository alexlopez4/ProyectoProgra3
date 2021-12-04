package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.InsertNewForo;
import objetos.Liga;
import objetos.Usuario;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class TemaNuevo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblTemaNuevo;


	public TemaNuevo(Usuario usuario,Liga liga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(44, 210, 685, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textField.getText();
				int idLiga = liga.getIdLiga();
				InsertNewForo.insertTema(tema, idLiga);
				TemasForo tm = new TemasForo(liga, usuario);
				tm.setVisible(true);
				TemaNuevo.this.setVisible(false);
			}
		});
		btnAadir.setBounds(44, 321, 685, 29);
		contentPane.add(btnAadir);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(44, 382, 685, 29);
		contentPane.add(btnNewButton);
		
		lblTemaNuevo = new JLabel("TEMA NUEVO");
		lblTemaNuevo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
		lblTemaNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemaNuevo.setBounds(44, 73, 685, 67);
		contentPane.add(lblTemaNuevo);
		
		
	}
}
