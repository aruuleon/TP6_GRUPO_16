package dao;

import java.util.ArrayList;

import entidad.Persona;

public interface IPersonaDao {

	boolean agregar(Persona persona);
	boolean modificar(Persona persona);
    boolean eliminar(String dni);
    ArrayList<Persona> listar();
    
}
