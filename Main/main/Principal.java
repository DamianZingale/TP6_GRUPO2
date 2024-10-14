package main;

import Service.UserService;
import ServiceImplements.UserServiceImp;
import viewController.UserController;
import views.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VentanaPrincipal vista = new VentanaPrincipal();
		UserService negocio = new UserServiceImp();
		UserController controlador = new UserController(vista, negocio);
		controlador.inicializar();

	}

}
