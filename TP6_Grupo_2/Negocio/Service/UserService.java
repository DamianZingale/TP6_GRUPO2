package Service;

import daoImplements.UserRepository;
import modelImplements.Persona;

public class UserService {

	UserRepository dao =new UserRepository() ;
	Persona usuario;
	
	public int daoInsert(Persona usuario){
		
		int filaAfectada = dao.insertPerson(usuario);
		return filaAfectada;
		
	}
	
}
