package main;

import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		VentanaPrincipal ventanaP =  new VentanaPrincipal();
		PersonaNegocioImpl negocio = new PersonaNegocioImpl(); 
		Controlador controlador = new Controlador(ventanaP, negocio);
		ventanaP.setVisible(true);
	}
	
}
			