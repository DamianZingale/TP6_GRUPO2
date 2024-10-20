package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.util.List;

public class PanelModificarPersona extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JList<String> listPersonas;
	private JButton btnModificar;

	public PanelModificarPersona() {
		listPersonas = new JList<>(); // Puedes pasar un modelo si es necesario

	    GridBagLayout gridBagLayout = new GridBagLayout();
	    gridBagLayout.columnWidths = new int[] { 25, 105, 105, 105, 77, 0 };
	    gridBagLayout.rowHeights = new int[] { 50, 144, 39, 30, 0 };
	    gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	    setLayout(gridBagLayout);

	    JLabel lblSelectPerson = new JLabel("Seleccione la persona que desea modificar");
	    GridBagConstraints gbc_lblSelectPerson = new GridBagConstraints();
	    gbc_lblSelectPerson.anchor = GridBagConstraints.SOUTH;
	    gbc_lblSelectPerson.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblSelectPerson.insets = new Insets(0, 0, 5, 5);
	    gbc_lblSelectPerson.gridwidth = 3;
	    gbc_lblSelectPerson.gridx = 1;
	    gbc_lblSelectPerson.gridy = 0;
	    add(lblSelectPerson, gbc_lblSelectPerson);

	    GridBagConstraints gbc_listPersonas = new GridBagConstraints();
	    gbc_listPersonas.fill = GridBagConstraints.BOTH;
	    gbc_listPersonas.insets = new Insets(0, 0, 5, 0);
	    gbc_listPersonas.gridwidth = 4;
	    gbc_listPersonas.gridx = 1;
	    gbc_listPersonas.gridy = 1;
	    add(listPersonas, gbc_listPersonas);  // Ahora no debería haber NullPointerException

	    txtNombre = new JTextField();
	    GridBagConstraints gbc_txtNombre = new GridBagConstraints();
	    gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
	    gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_txtNombre.gridx = 1;
	    gbc_txtNombre.gridy = 2;
	    add(txtNombre, gbc_txtNombre);

	    txtApellido = new JTextField();
	    GridBagConstraints gbc_txtApellido = new GridBagConstraints();
	    gbc_txtApellido.anchor = GridBagConstraints.SOUTH;
	    gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
	    gbc_txtApellido.gridx = 2;
	    gbc_txtApellido.gridy = 2;
	    add(txtApellido, gbc_txtApellido);

	    txtDNI = new JTextField();
	    txtDNI.setBackground(SystemColor.text);
	    txtDNI.setEditable(false);
	    GridBagConstraints gbc_txtDNI = new GridBagConstraints();
	    gbc_txtDNI.anchor = GridBagConstraints.SOUTH;
	    gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
	    gbc_txtDNI.gridx = 3;
	    gbc_txtDNI.gridy = 2;
	    add(txtDNI, gbc_txtDNI);

	    btnModificar = new JButton("Modificar");
	    GridBagConstraints gbc_btnModificar = new GridBagConstraints();
	    gbc_btnModificar.anchor = GridBagConstraints.SOUTH;
	    gbc_btnModificar.insets = new Insets(0, 0, 5, 0);
	    gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnModificar.gridx = 4;
	    gbc_btnModificar.gridy = 2;
	    add(btnModificar, gbc_btnModificar);
	}

	public JTextField gettxtNombre() {
		return txtNombre;
	}

	public void settxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField gettxtApellido() {
		return txtApellido;
	}

	public void settxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField gettxtDni() {
		return txtDNI;
	}

	public void settxtDni(JTextField txtDni) {
		this.txtDNI = txtDni;
	}

	public JButton getbtnModificar() {
		return btnModificar;
	}

	public void setBtnAceptar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	
	public JList<String> getListPersonas() {
	    return listPersonas;
	}

	public void setListPersonas(JList<String> listPersonas) {
	    this.listPersonas = listPersonas;
	}
	
	public void llenarJList(List<Persona> personasEnTabla) {
		
		DefaultListModel<String> modelo = new DefaultListModel<>();

	    for (Persona p : personasEnTabla) {
	        String persona = p.getNombre() + " " + p.getApellido() + " " + p.getDNI();
	        modelo.addElement(persona);
	    }
	    listPersonas.setModel(modelo);
	}
		
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
