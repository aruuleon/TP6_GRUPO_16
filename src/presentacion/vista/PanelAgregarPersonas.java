package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;


	
	
public class PanelAgregarPersonas extends JPanel {

    private JTextField txtDni;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;

    public PanelAgregarPersonas() {
        setLayout(new BorderLayout());

        // Panel superior para formularios
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelForm.add(new JLabel("Dni:"));
        txtDni = new JTextField();
        panelForm.add(txtDni);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelForm.add(txtApellido);

        btnAgregar = new JButton("Agregar");
        btnBorrar = new JButton("Borrar");
        panelForm.add(btnAgregar);
        panelForm.add(btnBorrar);

    /*    // Tabla para mostrar personas
        modeloTabla = new DefaultTableModel(new Object[]{"Dni", "Nombre", "Apellido"}, 0);
        tablaPersonas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPersonas);
        */
        add(panelForm, BorderLayout.NORTH);
       // add(scrollPane, BorderLayout.CENTER);
    }

    // Getters
    public JTextField getTxtDni() {
        return txtDni;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

   /* public void llenarTabla(ArrayList<Persona> personas) {
        modeloTabla.setRowCount(0); // Limpiar tabla
        for (Persona p : personas) {
            modeloTabla.addRow(new Object[]{p.getDni(), p.getNombre(), p.getApellido()});
        }
    }*/
}
