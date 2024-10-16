package daoImplements;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		query= "INSERT INTO Personas (Dni, Nombre, Apellido) VALUES ('"+User.getDNI()+"', '"+User.getNombre()+"', '"+User.getApellido()+"')";
		db.conexion();
		Statement st = db.statement();
		fila = st.executeUpdate(query);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return fila;
	}
		
	public int searchPerson(String Dni)
	{
		ResultSet fila = null;
		int filasAfectadas = 0;
		try {
			query= "SELECT * FROM Personas WHERE Dni = " + Dni;
			db.conexion();
			Statement st = db.statement();
			fila = st.executeQuery(query);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		try {
			while(fila.next())
			{
				filasAfectadas += 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filasAfectadas;
	}
	
	public int modifyPerson() {//logica modificacion persona
		int fila= 0;
		
		
		return fila;
	}
	public int deletePerson() {//logica eliminar persona
		int fila= 0;
		
		
		return fila;
	}
	
	public List<Persona> listPerson(){
		ResultSet resultado;
		ArrayList<Persona> personas = new ArrayList <Persona>();
	
		try {
			query = "SELECT * FROM Personas";
			db.conexion();
			Statement st = db.statement();
			resultado = st.executeQuery(query);
			
			while(resultado.next()) {
				personas.add(getPersona(resultado));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return personas;
	}
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String DNI = resultSet.getString("DNI");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(DNI, nombre, apellido);
	}

	
}
