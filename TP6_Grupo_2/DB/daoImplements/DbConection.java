package daoImplements;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;



import javax.swing.JOptionPane;



public class DbConection {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String password= "root";
	private String db_name = "bdPersonas";
	private Connection cn;
	
	
	public Connection conexion ()  {
		
		try {
		cn = DriverManager.getConnection(host+db_name, user, password);
		
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

}