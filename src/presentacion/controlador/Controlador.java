package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersonas;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	
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

		
		//Eventos menu del Frame principal llamado Ventana
	this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		
	//Eventos PanelAgregarPersonas
	 this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
	// this.pnlIngresoPersonas.getBtnBorrar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelAgregarPersonas(s));	
		
	
		}
	
	//EventoClickMenu abrir PanelAgregarPersonas
			public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
			{		
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
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
	
	