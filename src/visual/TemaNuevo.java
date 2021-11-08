package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.NewForo;
import objetos.Liga;
import objetos.Usuario;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemaNuevo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public TemaNuevo(Usuario usuario,Liga liga) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(26, 78, 387, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textField.getText();
				int idLiga = liga.getIdLiga();
				NewForo.insertTema(tema, idLiga);
				TemasForo tm = new TemasForo(liga, usuario);
				tm.setVisible(true);
				TemaNuevo.this.setVisible(false);
			}
		});
		btnAadir.setBounds(77, 147, 115, 29);
		contentPane.add(btnAadir);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(234, 147, 115, 29);
		contentPane.add(btnNewButton);
		
		
	}
}
