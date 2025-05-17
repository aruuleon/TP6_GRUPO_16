package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;
import negocioImpl.PersonaNegocioImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PanelEliminarPersonas extends JPanel {

	private JList listUsuarios;
	private DefaultListModel<Persona> listModel;
	private JButton btnEliminarUsuario;
	
	public JButton getBtnEliminarUsuario() {
		return btnEliminarUsuario;
	}

	public PanelEliminarPersonas() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEliminarUsuarios.setBounds(191, 11, 135, 14);
		add(lblEliminarUsuarios);
		
		listUsuarios = new JList();
		listModel = new DefaultListModel<Persona>();
		
		PersonaNegocioImpl pI = new PersonaNegocioImpl();	
		
		for (Persona p : pI.listar()) {	
			Persona aux = new Persona();
			
			aux.setDni(p.getDni()); 
			aux.setNombre(p.getNombre());;
			aux.setApellido(p.getApellido());
			
			listModel.addElement(aux);
		}
		

		listUsuarios.setModel(listModel);
		add(listUsuarios);
		listUsuarios.setBounds(107, 36, 311, 291);
		
		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEliminarUsuario.setBounds(170, 339, 179, 55); 
		add(btnEliminarUsuario);
		
	}

	public JList getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(JList listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
}
