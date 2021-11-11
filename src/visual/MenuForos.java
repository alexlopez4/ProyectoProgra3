package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.SelectLiga;
import objetos.Liga;
import objetos.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuForos extends JFrame {

	private JPanel contentPane;
	private JComboBox combobox;

	
	public MenuForos(Usuario u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		DefaultComboBoxModel<Liga> model = new DefaultComboBoxModel<Liga>();
		
		
		String consulta= "SELECT IDLIGA, NOMBRELIGA, PAIS FROM liga";
		ArrayList <Liga> listaLigas = SelectLiga.getLiga(consulta);
		for (Liga l: listaLigas){
			model.addElement(l);
		}
		comboBox.setModel(model);
		comboBox.setBounds(55, 66, 137, 26);
		contentPane.add(comboBox);
		
		JButton btnVerTemas = new JButton("Ver temas");
		btnVerTemas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liga ligaSeleccionada = (Liga) comboBox.getSelectedItem();
				TemasForo verTemas= new TemasForo(ligaSeleccionada,u);
				verTemas.setVisible(true);
				MenuForos.this.setVisible(false);
			}
		});
		btnVerTemas.setBounds(298, 65, 115, 29);
		contentPane.add(btnVerTemas);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu (u);
				m.setVisible(true);
				MenuForos.this.setVisible(false);
				
			}
		});
		btnVolver.setBounds(298, 126, 115, 29);
		contentPane.add(btnVolver);
		
		
	}
	
}
