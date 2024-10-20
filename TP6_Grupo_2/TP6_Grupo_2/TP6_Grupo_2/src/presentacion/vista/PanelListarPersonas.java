package presentacion.vista;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelListarPersonas extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"nombre y apellido", "DNI"};

	
	public PanelListarPersonas() {
		this.setBounds(100, 100, 514, 455);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 1, 138, 0};
		gridBagLayout.rowHeights = new int[]{17, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 171, 444, 227);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		this.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{383, 0};
		gbl_panel.rowHeights = new int[]{30, 126, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblListadoDePersonas = new JLabel("Listado de personas");
		GridBagConstraints gbc_lblListadoDePersonas = new GridBagConstraints();
		gbc_lblListadoDePersonas.insets = new Insets(0, 0, 5, 0);
		gbc_lblListadoDePersonas.gridx = 0;
		gbc_lblListadoDePersonas.gridy = 0;
		panel.add(lblListadoDePersonas, gbc_lblListadoDePersonas);
		lblListadoDePersonas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListadoDePersonas.setBounds(150, 151, 184, 14);
		
		JScrollPane spPersonas = new JScrollPane();
		GridBagConstraints gbc_spPersonas = new GridBagConstraints();
		gbc_spPersonas.fill = GridBagConstraints.BOTH;
		gbc_spPersonas.gridx = 0;
		gbc_spPersonas.gridy = 1;
		panel.add(spPersonas, gbc_spPersonas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		}
	
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}

	
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0);
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombreApellido = p.getNombre()+ " " + p.getApellido();
			String DNI = p.getDNI();
			Object[] fila = {nombreApellido, DNI};
			this.getModelPersonas().addRow(fila);
		}
		
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
