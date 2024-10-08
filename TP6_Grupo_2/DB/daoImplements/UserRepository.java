package daoImplements;

import java.util.ArrayList;
import java.sql.Statement;

import dao.Idao;
import modelImplements.Persona;

public class UserRepository implements Idao {
	
	private int fila = 0;
	private String query ="";
	DbConection db = new DbConection(); 
	
	public int insertPerson(Persona usuario) { //logica agregado personas
		Persona User = usuario;
		try {
		query= "INSERT INTO Personas (DNI, Nombre, Apellido) VALUES ('"+User.getDNI()+"', '"+User.getNombre()+"', '"+User.getApellido()+"')";
		db.conexion();
		Statement st = db.statement();
		fila = st.executeUpdate(query);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return fila;
	}
		
		
	public int modifyPerson() {//logica modificacion persona
		int fila= 0;
		
		
		return fila;
	}
	public int deletePerson() {//logica eliminar persona
		int fila= 0;
		
		
		return fila;
	}
	public ArrayList<Persona> PeopleList(){//logica listar personas
		ArrayList<Persona> lista = new ArrayList<Persona>();
		
		
		return lista;
	}


	
}
