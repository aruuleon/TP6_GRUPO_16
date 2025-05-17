package presentacion.vista;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entidad.Persona;
import java.awt.BorderLayout;

public class PanelListadoPersonas extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tablaPersonas;
    private DefaultTableModel modelPersonas;
    private String[] nombreColumnas = {"DNI", "Nombre", "Apellido"};

    public PanelListadoPersonas() {
        setLayout(new BorderLayout());

        modelPersonas = new DefaultTableModel(null, nombreColumnas);
        tablaPersonas = new JTable(modelPersonas);
        JScrollPane scrollPane = new JScrollPane(tablaPersonas);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void llenarTabla(ArrayList<Persona> personas) {
        modelPersonas.setRowCount(0); 
        for (Persona persona : personas) {
            Object[] fila = {persona.getDni(), persona.getNombre(), persona.getApellido()};
            modelPersonas.addRow(fila);
        }
    }
}