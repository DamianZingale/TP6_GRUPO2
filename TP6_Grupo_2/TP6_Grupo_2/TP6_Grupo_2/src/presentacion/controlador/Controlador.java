package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

    private VentanaPrincipal ventanaPrincipal;
    private PanelAgregarPersona panelAgregarPersona;
    private PanelListarPersonas panelListarPersonas;
    private PanelModificarPersona panelModificarPersona;
    private PanelEliminarPersona panelEliminarPersona;
    private PersonaNegocio Pneg;
    private ArrayList<Persona> personasEnTabla;

    public Controlador(VentanaPrincipal ventanaPrincipal, PersonaNegocio pneg) {

        this.ventanaPrincipal = ventanaPrincipal;
        this.Pneg = pneg;

        // Instancia paneles
        this.panelAgregarPersona = new PanelAgregarPersona();
        this.panelListarPersonas = new PanelListarPersonas();
        this.panelModificarPersona = new PanelModificarPersona();
        this.panelEliminarPersona = new PanelEliminarPersona();

        // Eventos del menu principal
        this.ventanaPrincipal.getMntmAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
        this.ventanaPrincipal.getMntmListar().addActionListener(b -> EventoClickMenu_AbrirPanel_ListarPersonas(b));
        this.ventanaPrincipal.getMntmModificar().addActionListener(c -> EventoClickMenu_AbrirPanel_ModificarPersonas(c));
        this.ventanaPrincipal.getMntmEliminar().addActionListener(d -> EventoClickMenu_AbrirPanel_EliminarPersona(d));

        // Eventos PanelAgregarPersonas
        this.panelAgregarPersona.getBtnAceptar().addActionListener(e -> EventoClickBoton_Aceptar_PanelAgregarPersona(e));
        
        // Eventos PanelModificarrPersonas
        this.panelModificarPersona.getbtnModificar().addActionListener(e -> EventoClickBoton_Modificar_PanelModificarPersona(e));
        
     // Eventos PanelEliminarPersona
        this.panelEliminarPersona.getBtnEliminar().addActionListener(e -> EventoClickBoton_Eliminar_PanelEliminarPersona(e));
        
        // KeyListeners para validar entradas
        agregarKeyListeners();
        
        // Listener para el JList de modificar personas
        agregarListSelectionListener();
    }


	// M�todos de eventos
    public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
        cambiarPanel(panelAgregarPersona);
    }

    public void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent b) {
        cambiarPanel(panelListarPersonas);
        refrescarTabla();
    }

    public void EventoClickMenu_AbrirPanel_ModificarPersonas(ActionEvent c) {
        cambiarPanel(panelModificarPersona);
        refrescarTabla();
    }
    
    public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent d) {
        cambiarPanel(panelEliminarPersona);
        refrescarTabla();
    }

    public void EventoClickBoton_Aceptar_PanelAgregarPersona(ActionEvent e) {
        String mensaje;
        String nombre = this.panelAgregarPersona.getTxtNombre().getText();
        String apellido = this.panelAgregarPersona.getTxtApellido().getText();
        String dni = this.panelAgregarPersona.getTxtDni().getText();
        Persona usuario = new Persona(dni, nombre, apellido);

        if (!nombre.isEmpty() && !apellido.isEmpty() && !dni.isEmpty()) {
            if (Pneg.existe(usuario.getDNI()) == 0) {
                if (Pneg.daoInsert(usuario) > 0) {
                    mensaje = "Usuario agregado con �xito";
                    limpiarCampos();
                } else {
                    mensaje = "El usuario no pudo ser agregado";
                    limpiarCampos();
                }
            } else {
                mensaje = "DNI ya existente";
            }
        } else {
            mensaje = "Complete los 3 campos";
        }
        this.panelAgregarPersona.mostrarMensaje(mensaje);
    }

    public void EventoClickBoton_Modificar_PanelModificarPersona(ActionEvent e) {
        String mensaje;
        int selectedIndex = panelModificarPersona.getListPersonas().getSelectedIndex();
        if (selectedIndex != -1) {
            Persona personaSeleccionada = Pneg.listPerson().get(selectedIndex);
            String nombre = panelModificarPersona.gettxtNombre().getText();
            String apellido = panelModificarPersona.gettxtApellido().getText();
            String dni = personaSeleccionada.getDNI();

            Persona personaActualizada = new Persona(dni, nombre, apellido);
            int filasActualizadas = Pneg.modifyPerson(personaActualizada);
            if (filasActualizadas > 0) {
                mensaje = "Usuario modificado con �xito";
            } else {
                mensaje = "El usuario no pudo ser modificado";
            }
            JOptionPane.showMessageDialog(null, mensaje);
            refrescarTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una persona para modificar.");
        }
    }
    
    public void EventoClickBoton_Eliminar_PanelEliminarPersona(ActionEvent e) {
        int selectedIndex = panelEliminarPersona.getListPersonas().getSelectedIndex();
        if (selectedIndex != -1) {
            Persona personaSeleccionada = personasEnTabla.get(selectedIndex);
            int confirm = JOptionPane.showConfirmDialog(null, 
                    "¿Estás seguro que deseas eliminar a " + personaSeleccionada.getNombre() + "?");
            
            if (confirm == JOptionPane.YES_OPTION) {
                int filasEliminadas = Pneg.deletePerson(personaSeleccionada.getDNI());
                mostrarMensajeResultadoEliminacion(filasEliminadas);
                refrescarTabla(); // Refresca la tabla después de la eliminación
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una persona para eliminar.");
        }
    }

    private void mostrarMensajeResultadoEliminacion(int filasEliminadas) {
        if (filasEliminadas > 0) {
            JOptionPane.showMessageDialog(null, "Persona eliminada con éxito");
            refrescarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la persona");
        }
    }

    // Listener para el JList
    private void agregarListSelectionListener() {
        panelModificarPersona.getListPersonas().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = panelModificarPersona.getListPersonas().getSelectedIndex();
                    if (index != -1) {
                        // Obtener la persona seleccionada por el �ndice
                        Persona personaSeleccionada = personasEnTabla.get(index);

                        // Actualizar los campos de texto con los datos de la persona seleccionada
                        panelModificarPersona.gettxtNombre().setText(personaSeleccionada.getNombre());
                        panelModificarPersona.gettxtApellido().setText(personaSeleccionada.getApellido());
                        panelModificarPersona.gettxtDni().setText(personaSeleccionada.getDNI());
                    }
                }
            }
        });
    }
    

    

 // --------M�todos auxiliares--------------
    private void agregarKeyListeners() {
       
    	// Solo letras en campo Nombre
        panelAgregarPersona.getTxtNombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        // Solo letras en campo Apellido
        panelAgregarPersona.getTxtApellido().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });

        // Solo n�meros en campo DNI
        panelAgregarPersona.getTxtDni().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        });
    }

    private void cambiarPanel(Object panel) {
        ventanaPrincipal.getContentPane().removeAll();
        ventanaPrincipal.getContentPane().add((java.awt.Component) panel);
        ventanaPrincipal.getContentPane().repaint();
        ventanaPrincipal.getContentPane().revalidate();
    }

    private void refrescarTabla() {
        this.personasEnTabla = (ArrayList<Persona>) Pneg.listPerson();
        this.panelListarPersonas.llenarTabla(this.personasEnTabla);
        this.panelModificarPersona.llenarJList(this.personasEnTabla);
        this.panelEliminarPersona.llenarJList(this.personasEnTabla);
    }

    private void limpiarCampos() {
        panelAgregarPersona.getTxtNombre().setText("");
        panelAgregarPersona.getTxtApellido().setText("");
        panelAgregarPersona.getTxtDni().setText("");
        panelModificarPersona.gettxtNombre().setText("");
        panelModificarPersona.gettxtApellido().setText("");
        panelModificarPersona.gettxtDni().setText("");
    }

    // Inicializaci�n del controlador
    public void inicializar() {
        this.ventanaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

}

