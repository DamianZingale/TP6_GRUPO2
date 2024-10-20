package daoImpl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class Conexion 
{
	private String host = "jdbc:mysql://localhost:3306/bdPersonas?useSSL=false";
	private String user = "root";
	private String password= "root";
	//private String db_name = "bdPersonas";
	private Connection cn;
	
	
	public Connection conexion ()  {
		
		try {
		cn = (Connection) DriverManager.getConnection(host, user, password);
		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "NO se pudo establecer conexion con la base de datos");
	
		}
		return cn;
	}
	public Statement statement () {
		
		if(cn !=null) {
		try {
			Statement statement = cn.createStatement();
			return statement;
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		}
		return null;
	}
	public void closeConnection() {
	    try {
	        if (cn != null && !cn.isClosed()) {
	            cn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

