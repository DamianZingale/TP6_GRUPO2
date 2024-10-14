package dao;

import java.util.ArrayList;

import modelImplements.Persona;

public interface Idao {
	
	public int insertPerson(Persona usuario);
	public int searchPerson(String Dni);
	public int modifyPerson();
	public int deletePerson();
	public ArrayList<Persona> PeopleList(); 

}
