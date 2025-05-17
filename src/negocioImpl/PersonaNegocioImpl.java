package negocioImpl;

import java.util.ArrayList;

import dao.IPersonaDao;
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

	public boolean modificar(Persona dni) { 
    boolean estado = false;

	if (dni != null && !dni.getDni().isEmpty()) {
		estado = iPersonaDao.modificar(dni);
	    }
	return estado;
}

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

}