package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import entidad.Persona;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class PanelEliminarPersona extends JPanel {

    private JTextField txtDni;
    private JButton btnEliminar;
    private JList<String> listPersonas;
    private DefaultListModel<String> listModel;

    public PanelEliminarPersona() {
        setLayout(null);
        

        // Inicializa el modelo de la lista y el JList
        listModel = new DefaultListModel<>();

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(182, 221, 100, 25);
        add(btnEliminar);
        listPersonas = new JList<>(listModel);
        listPersonas.setBounds(106, 51, 248, 148);
        add(listPersonas);
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JList<String> getListPersonas() {
        return listPersonas;
    }

    public void llenarJList(ArrayList<Persona> personas) {
        listModel.clear(); // Limpiar campos al cambiar de "pantalla"
        for (Persona persona : personas) {
            String displayText = persona.getNombre() + " " + persona.getApellido() + " - " + persona.getDNI();
            listModel.addElement(displayText); 
        }
    }


}