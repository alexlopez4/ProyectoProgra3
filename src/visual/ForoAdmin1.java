package visual;

/** Jframe del adminstrador donde modifica el contenido del foro
 * @author Alex Lopez de Lacalle and Giovanni Locatelli 
 * @version 1.0
 */

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import db.DeleteSalaDebate;
import db.SelectTemas;
import objetos.SalaDebate;
import objetos.Usuario;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class ForoAdmin1 extends JFrame {

	private JPanel contentPane;

	public ForoAdmin1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuario u = new Usuario ("Admin", 20,"Admin", "Admin");
		String sql= "SELECT A.IDLIGA, B.NOMBRELIGA, B.PAIS, A.IDSALADEBATE,A.TEMADEBATE FROM liga B"
				+" JOIN (SELECT IDLIGA, IDSALADEBATE,TEMADEBATE FROM saladebate) A "
				+"ON A.IDLIGA=B.IDLIGA";
		ArrayList<SalaDebate> listaForos = SelectTemas.getTemas(sql, u);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 21));
		DefaultListModel<SalaDebate> modelForos= new DefaultListModel<SalaDebate>();
		
		for (SalaDebate s: listaForos){
			modelForos.addElement(s);
		}
		list.setModel(modelForos);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(55, 84, 511, 347);
		contentPane.add(scrollPane);
		
		JLabel lblGestinSalasDe = new JLabel("Gesti\u00F3n salas de debate");
		lblGestinSalasDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinSalasDe.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblGestinSalasDe.setBounds(54, 16, 642, 44);
		contentPane.add(lblGestinSalasDe);
		
		JButton btnEliminarTema = new JButton("Eliminar tema");
		btnEliminarTema.addActionListener(e->{
				if (list.getSelectedValue()==null){
					JOptionPane.showMessageDialog(ForoAdmin1.this, "Selecciona la sala de debate que desees eliminar");
				}else{
				int idSalaDebate = ((SalaDebate) list.getSelectedValue()).getIdSalaDebate();
				DeleteSalaDebate.delete(idSalaDebate);
				JOptionPane.showMessageDialog(ForoAdmin1.this, "Sala de debate eliminada");
				modelForos.clear();
				ArrayList<SalaDebate> listaForos2 = SelectTemas.getTemas(sql, u);
				for (SalaDebate s: listaForos2){
						modelForos.addElement(s);
				}
			list.setModel(modelForos);
				}
			});
		btnEliminarTema.setBounds(581, 346, 182, 34);
		contentPane.add(btnEliminarTema);
		
		JButton btnGestionarMensajes = new JButton("Gestionar mensajes");
		btnGestionarMensajes.addActionListener(e-> {
				if (list.getSelectedValue()==null){
					JOptionPane.showMessageDialog(ForoAdmin1.this, "Selecciona un foro al que acceder");
				}else{
				SalaDebate s = ((SalaDebate)list.getSelectedValue());
				ForoAdmin2 foroMensajes = new ForoAdmin2(s);
				foroMensajes.setVisible(true);
				ForoAdmin1.this.setVisible(false);
				}
			
		});
		btnGestionarMensajes.setBounds(581, 296, 182, 34);
		contentPane.add(btnGestionarMensajes);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(e-> {
				AdminVentana menuAdmin= new AdminVentana();
				menuAdmin.setVisible(true);
				ForoAdmin1.this.setVisible(false);
		});
		btnVolver.setBounds(581, 396, 182, 34);
		contentPane.add(btnVolver);
		
		
		
	}
}
