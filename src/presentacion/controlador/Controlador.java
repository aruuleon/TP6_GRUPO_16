package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	
	private PersonaNegocioImpl pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	//Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocioImpl pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersonas();
		
		this.pnlEliminarPersonas = new PanelEliminarPersonas();

		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		
		//Eventos PanelAgregarPersonas
		this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		// this.pnlIngresoPersonas.getBtnBorrar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelAgregarPersonas(s));	
		
		//Evento del menu del frame principal llama a ventana eliminar
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		
		this.pnlEliminarPersonas.getBtnEliminarUsuario().addActionListener(a->EventoClickEliminar_EliminarPesona_PanelEliminarPersonas(a));
		}
	
	//EventoClickMenu abrir PanelAgregarPersonas
			public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
			{		
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
			
			public void  EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
			{				
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
				
			
			private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
			    String dni = this.pnlIngresoPersonas.getTxtDni().getText();
			    String nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
			    String apellido = this.pnlIngresoPersonas.getTxtApellido().getText();

			  
			    Persona nuevaPersona = new Persona(dni, nombre, apellido);

			    boolean estado = pNeg.insert(nuevaPersona);
			    String mensaje;
			    if (estado) {
			        mensaje = "Persona agregada con éxito";
			        this.pnlIngresoPersonas.getTxtDni().setText("");
			        this.pnlIngresoPersonas.getTxtNombre().setText("");
			        this.pnlIngresoPersonas.getTxtApellido().setText("");
			    } else {
			        mensaje = "Persona no agregada, complete todos los campos";
			    }

			    this.pnlIngresoPersonas.mostrarMensaje(mensaje);
			    this.refrescarTabla();
			}		
			
			private void EventoClickEliminar_EliminarPesona_PanelEliminarPersonas(ActionEvent a) {
	
				int aux = this.pnlEliminarPersonas.getListUsuarios().getSelectedIndex();
				PersonaNegocioImpl pI = new PersonaNegocioImpl();	
				ArrayList<Persona> listAux = pI.listar();
				String dni;
				
				dni = listAux.get(aux).getDni();
				
				if (pI.eliminar(dni)) {
					refrescarTabla();
		
					this.pnlEliminarPersonas.mostrarMensaje("Usuario eliminado con exito");
				}
				else {
					refrescarTabla();
					this.pnlEliminarPersonas.mostrarMensaje("No se puede eliminar el usuario");
				}
			}		
			
			/*
			private void actualizarJlist() {  
				DefaultListModel<Persona> listModel = new DefaultListModel<Persona>();
				PersonaNegocioImpl pI = new PersonaNegocioImpl();
				
				for (Persona p : pI.listar()) {
					Persona aux = new Persona();
					
					aux.setDni(p.getDni()); 
					aux.setNombre(p.getNombre());;
					aux.setApellido(p.getApellido());  
					
					listModel.addElement(aux);
				}
				this.pnlEliminarPersonas.setListModel(listModel);
			}
			*/
			
			private void refrescarTabla()
			{
				this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
				//this.pnlIngresoPersonas.llenarTabla(this.personasEnTabla);
			}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	