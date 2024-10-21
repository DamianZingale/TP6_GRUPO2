package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	
	public int insertPerson(Persona usuario);
	public int searchPerson(String Dni);
	public int modifyPerson();
	public int deletePerson(String dni);
	public List<Persona> listPerson();
}
