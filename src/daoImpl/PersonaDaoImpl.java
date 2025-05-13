package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import dao.IPersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IPersonaDao {

	private Connection conexion;
	private static final String agregar = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
    private static final String modificar = "UPDATE personas SET nombre = ?, apellido = ? WHERE dni = ?";
    private static final String eliminar = "DELETE FROM personas WHERE dni = ?";
    private static final String listar = "SELECT * FROM personas";
    
    public PersonaDaoImpl() {
        this.conexion = Conexion.getConexion().getSQLConexion();
    }

    @Override
    public boolean agregar(Persona persona) {
        PreparedStatement statement;
        boolean insertado = false;
        try {
            statement = conexion.prepareStatement(agregar);
            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            if (statement.executeUpdate() > 0) {
                conexion.commit();
                insertado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return insertado;
    }
    
    @Override
    public boolean modificar(Persona persona) {
        PreparedStatement statement;
        boolean actualizado = false;
        try {
            statement = conexion.prepareStatement(modificar);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getDni());
            if (statement.executeUpdate() > 0) {
                conexion.commit();
                actualizado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return actualizado;
    }

    @Override
    public boolean eliminar(String dni) {
        PreparedStatement statement;
        boolean eliminado = false;
        try {
            statement = conexion.prepareStatement(eliminar);
            statement.setString(1, dni);
            if (statement.executeUpdate() > 0) {
                conexion.commit();
                eliminado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return eliminado;
    }

    @Override
    public ArrayList<Persona> listar() {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            statement = conexion.prepareStatement(listar);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personas.add(getPersona(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }
    
    private Persona getPersona(ResultSet resultSet) throws SQLException {
		String dni = resultSet.getString("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		return new Persona(dni, nombre, apellido);
	}
  
}
