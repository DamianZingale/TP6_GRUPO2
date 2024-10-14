package viewController;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Service.UserService;
import views.PanelAgregarPersona;
import views.VentanaPrincipal;
import modelImplements.Persona;

public class UserController {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona panelAgregarPersona;
	private UserService Pneg;
	
	public UserController(VentanaPrincipal ventanaPrincipal, UserService pneg) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		Pneg = pneg;
		
		this.panelAgregarPersona = new PanelAgregarPersona();
		
		this.ventanaPrincipal.getMntmAgregar().addActionListener(e->EventoClickMenu_AbrirPanel_AgregarPersona(e));
		
		this.panelAgregarPersona.getBtnAceptar().addActionListener(e->EventoClickBoton_Aceptar_PanelAgregarPersona(e));
	}
	
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent e)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(panelAgregarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickBoton_Aceptar_PanelAgregarPersona(ActionEvent e)
	{
		String Mensaje;
		String Nombre = this.panelAgregarPersona.getTxtNombre().getText();
		String Apellido = this.panelAgregarPersona.getTxtApellido().getText();
		String Dni = this.panelAgregarPersona.getTxtDni().getText();
		Persona usuario = new Persona(Dni,Nombre,Apellido);
		if(!this.panelAgregarPersona.getTxtNombre().getText().isEmpty() && 
		!this.panelAgregarPersona.getTxtApellido().getText().isEmpty() && !this.panelAgregarPersona.getTxtDni().getText().isEmpty())
		{
			if(Pneg.existe(usuario.getDNI()) == 0)
			{
				if(Pneg.daoInsert(usuario) > 0)
				{
					Mensaje = "Usuario agregado con exito";
					this.panelAgregarPersona.getTxtNombre().setText(null);
					this.panelAgregarPersona.getTxtApellido().setText(null);
					this.panelAgregarPersona.getTxtDni().setText(null);
				}
				else
				{
					Mensaje = "El usuario no pudo ser agregado";
				}
			}
			else
			{
				Mensaje = "Dni ya existente";
			}
		}
		else
		{
			Mensaje = "Complete los 3 campos";
		}
		this.panelAgregarPersona.mostrarMensaje(Mensaje);
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
}
