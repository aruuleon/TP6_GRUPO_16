package presentacion.vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import entidad.Persona;

public class PanelModificarPersonas extends JPanel {
  
	private static final long serialVersionUID = 1L;
	private JList<Persona> listaPersonas;
    private DefaultListModel<Persona> modeloLista;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnModificar;

    public PanelModificarPersonas() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
     
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitulo = new JLabel("Seleccione la persona que desea modificar");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaPersonas = new JList<>(modeloLista);
        listaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPersonas.setVisibleRowCount(8);
        
        JScrollPane scrollPane = new JScrollPane(listaPersonas);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); 
        
        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.add(scrollPane);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelEdicion = new JPanel(new GridLayout(2, 4, 10, 10));
        panelEdicion.setBorder(BorderFactory.createEmptyBorder(20, 50, 10, 50)); 
        
        panelEdicion.add(new JLabel("DNI:"));
        panelEdicion.add(new JLabel("Nombre:"));
        panelEdicion.add(new JLabel("Apellido:"));
        panelEdicion.add(new JLabel(""));
        
        txtDni = new JTextField();
        txtDni.setEditable(false);
        panelEdicion.add(txtDni);
        
        txtNombre = new JTextField();
        panelEdicion.add(txtNombre);
        
        txtApellido = new JTextField();
        panelEdicion.add(txtApellido);
        
        btnModificar = new JButton("Modificar");
        panelEdicion.add(btnModificar);
        
        add(panelEdicion, BorderLayout.SOUTH);
        
        listaPersonas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Persona seleccionada = listaPersonas.getSelectedValue();
                if (seleccionada != null) {
                    cargarDatosPersona(seleccionada);
                }
            }
        });
    }
    
    public void cargarDatosPersona(Persona persona) {
        txtDni.setText(persona.getDni());
        txtNombre.setText(persona.getNombre());
        txtApellido.setText(persona.getApellido());
    }
    
    public void setListaPersonas(List<Persona> personas) {
        modeloLista.clear();
        if (personas != null) {
            for (Persona p : personas) {
                modeloLista.addElement(p);
            }
        }
    }

    public JList<Persona> getListaPersonas() { return listaPersonas; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtDni() { return txtDni; }
    public JButton getBtnModificar() { return btnModificar; }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}