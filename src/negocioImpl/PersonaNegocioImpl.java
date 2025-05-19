package negocioImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IPersonaDao;
import daoImpl.Conexion;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.IPersonaNegocio;

public class PersonaNegocioImpl implements IPersonaNegocio{

IPersonaDao iPersonaDao = new PersonaDaoImpl();

	public boolean agregar(Persona persona) {

	boolean estado = false;
	if(persona.getNombre().trim().length() > 0){
		estado = iPersonaDao.agregar(persona);
	}
	return estado;
}

/*	
	public boolean modificar(Persona dni) { 
    boolean estado = false;

	if (dni != null && !dni.getDni().isEmpty()) {
		estado = iPersonaDao.modificar(dni);
	    }
	return estado;
}
*/

	public boolean eliminar(String dni) {
	boolean estado = false;
	if (dni != null && !dni.isEmpty()) {
		estado = iPersonaDao.eliminar(dni);
	}
	return estado;
}

	public ArrayList<Persona> listar() {
    return iPersonaDao.listar();
	}

	public boolean insert(Persona nuevaPersona) {
		  return iPersonaDao.agregar(nuevaPersona);
	}

	public ArrayList<Persona> readAll() {
		return iPersonaDao.readAll();
	}

	public boolean modificar(Persona persona) {
	    if (persona == null || persona.getDni() == null || persona.getDni().isEmpty()) {
	        return false;
	    }

	    Conexion conexion = null;
	    PreparedStatement statement = null;
	    
	    try {
	        conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        if(conn == null || conn.isClosed()) {
	            throw new SQLException("La conexión no está disponible");
	        }
	        
	        String sql = "UPDATE personas SET nombre = ?, apellido = ? WHERE dni = ?";
	        statement = conn.prepareStatement(sql);
	        
	        statement.setString(1, persona.getNombre());
	        statement.setString(2, persona.getApellido());
	        statement.setString(3, persona.getDni());
	        
	        int filasAfectadas = statement.executeUpdate();
	        conn.commit();
	        
	        return filasAfectadas == 1;
	        
	    } catch (SQLException e) {
	        try {
	            if (conexion != null && conexion.getSQLConexion() != null) {
	                conexion.getSQLConexion().rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (statement != null) statement.close();
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}