package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	public int daoInsert(Persona usuario);
	public int existe(String Dni);
	public List<Persona>listPerson();
	int modifyPerson(Persona usuario);
}
