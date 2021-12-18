package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.DeleteUsuario;
import db.SelectUser;
import objetos.Usuario;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;


public class UsuariosAdmin extends JFrame {

	private JPanel contentPane;
	
	public UsuariosAdmin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(59, 111, 343, 335);
		contentPane.add(list);
		
		DefaultListModel  lista = new DefaultListModel();
		
		String sql = "SELECT  NOMBRE,EDAD,NOMBREUSUARIO,PSSW FROM usuario";
	
		ArrayList<Usuario> listaUsuarios= SelectUser.getUser(sql);
		
		String texto="";
		for (Usuario a: listaUsuarios){
			if (a.getNombreDeUsuario().equals("Admin")){
				
			}else{
				texto="";
				texto=a.getNombre()+" , "+a.getEdad()+" años , nombreUsuario:" + a.getNombreDeUsuario();
				lista.addElement(texto);
			}
		}
		list.setModel(lista);
		list.setBounds(15, 89, 377, 302);
		JScrollPane js = new JScrollPane(list);
		js.getViewport().setViewPosition(new Point(0,0));
		js.setBounds(15, 125, 377, 302);
		contentPane.add(js);
		
		JButton btnNewButton = new JButton("Eliminar Usuario");
		btnNewButton.addActionListener( e->{
				String selected = (String) list.getSelectedValue();
				int indice =list.getSelectedIndex();
				String[]split = selected.split(":");
				for (Usuario a: listaUsuarios){
					if (a.getNombreDeUsuario().equals(split[1])){
						DeleteUsuario.delete(a.getNombreDeUsuario(),a.getNombre(),a.getEdad(), a.getContraseña());
						list.remove(indice);
					}
				}
			});
		btnNewButton.setBounds(457, 207, 279, 29);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e ->{
				AdminVentana a= new AdminVentana();
				a.setVisible(true);
				UsuariosAdmin.this.setVisible(false);
			
		});
		btnVolver.setBounds(457, 264, 279, 29);
		contentPane.add(btnVolver);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 70));
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(59, 16, 677, 68);
		contentPane.add(lblUsuarios);
		
	}
}
