package viewController;


import javax.swing.JOptionPane;

import Service.UserService;
import modelImplements.Persona;

public class UserController {

	static UserService Uservice = new UserService();
	
	public static void main(String[] args) {
		
		
		
		Persona usuario = new Persona("42351913", "Natalia", "Vasquez");
		int fila = Uservice.daoInsert(usuario);
		if(fila == 1) {
			JOptionPane.showMessageDialog(null, "Usuario agregado!");
		}else {
			JOptionPane.showMessageDialog(null, "ERROR!  no se pudo cargar el usuario");
		}
	}

}
