package Service;

import modelImplements.Persona;

public interface UserService {

	public int daoInsert(Persona usuario);
	public int existe(String Dni);
}
