package negocioImpl;

import java.util.List;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl  implements PersonaNegocio{
	
	PersonaDaoImpl dao =new PersonaDaoImpl() ;
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

	@Override
	public List<Persona> listPerson() {
		return dao.listPerson();
	}
	
	@Override
    public int modifyPerson(Persona usuario) {
        return dao.modifyPerson(usuario);
    }
}
