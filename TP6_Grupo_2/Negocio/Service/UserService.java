package Service;

import java.util.List;

import modelImplements.Persona;

public interface UserService {

	public int daoInsert(Persona usuario);
	public int existe(String Dni);
	public List<Persona>listPerson(); 
}
