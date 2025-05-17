package presentacion.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.IPersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.PanelListadoPersonas;
import presentacion.vista.VentanaPrincipal;

public class ListarPersonaControlador implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelListadoPersonas panelListadoPersonas;
	private IPersonaNegocio personaNegocio;
	
	
    public ListarPersonaControlador(VentanaPrincipal ventanaPrincipal) {
    	this.ventanaPrincipal = ventanaPrincipal;
        this.personaNegocio = new PersonaNegocioImpl();
        this.panelListadoPersonas = new PanelListadoPersonas();
        this.ventanaPrincipal.getMenuListar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ventanaPrincipal.getMenuListar()) {
            mostrarListadoPersonas();
        }
    }
    
    private void mostrarListadoPersonas() {
    	ArrayList<Persona> listaPersonas = this.personaNegocio.listar();
        this.panelListadoPersonas.llenarTabla(listaPersonas);
        
        ventanaPrincipal.getContentPane().removeAll();
        ventanaPrincipal.getContentPane().add(panelListadoPersonas);
        ventanaPrincipal.getContentPane().repaint();
        ventanaPrincipal.getContentPane().revalidate();
    }
}
