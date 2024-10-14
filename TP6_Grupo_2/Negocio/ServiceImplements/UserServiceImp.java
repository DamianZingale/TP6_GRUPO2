package ServiceImplements;

import Service.UserService;
import daoImplements.UserRepository;
import modelImplements.Persona;

public class UserServiceImp implements UserService {
	
	UserRepository dao =new UserRepository() ;
	Persona usuario;
	
	@Override
	public int daoInsert(Persona usuario){
		
		int filaAfectada = dao.insertPerson(usuario);
		return filaAfectada;
		
	}

	@Override
	public int existe(String Dni) {
		
		int filaAfectada = dao.searchPerson(Dni);
		return filaAfectada;
	}
}
