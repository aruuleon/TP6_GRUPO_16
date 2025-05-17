package presentacion.vista;

import javax.swing.*;

import presentacion.controlador.ListarPersonaControlador;

public class VentanaPrincipal extends JFrame {

private static final long serialVersionUID = 1L;

private JMenuBar menuBar;

private JMenu mnPersonas;

private JMenuItem menuAgregar;

private JMenuItem menuModificar;

private JMenuItem menuEliminar;

private JMenuItem menuListar;

public VentanaPrincipal() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setBounds(100, 100, 650, 500);

	setLocationRelativeTo(null);
	

	menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		mnPersonas = new JMenu("Personas");

		menuBar.add(mnPersonas);

		menuAgregar = new JMenuItem("Agregar");

		mnPersonas.add(menuAgregar);

		menuModificar = new JMenuItem("Modificar");

		mnPersonas.add(menuModificar);

		menuEliminar = new JMenuItem("Eliminar");

		mnPersonas.add(menuEliminar);

		menuListar = new JMenuItem("Listar");

		mnPersonas.add(menuListar);
		
		
		 new ListarPersonaControlador(this);  // aca

		
		

}

	public JMenuItem getMenuAgregar() {

		return menuAgregar;

	}

	public void setMenuAgregar(JMenuItem menuAgregar) {

		this.menuAgregar = menuAgregar;
	}

	public JMenuItem getMenuModificar() {

return menuModificar;

}

	public void setMenuModificar(JMenuItem menuModificar) {

this.menuModificar = menuModificar;

}

	public JMenuItem getMenuEliminar() {

return menuEliminar;

}

	public void setMenuEliminar(JMenuItem menuEliminar) {

this.menuEliminar = menuEliminar;

}

	public JMenuItem getMenuListar() {

return menuListar;

}

	public void setMenuListar(JMenuItem menuListar) {

this.menuListar = menuListar;

}

	public JMenu getMnPersonas() {

return mnPersonas;

}

	public void setMnPersonas(JMenu mnPersonas) {

this.mnPersonas = mnPersonas;

}
	

}