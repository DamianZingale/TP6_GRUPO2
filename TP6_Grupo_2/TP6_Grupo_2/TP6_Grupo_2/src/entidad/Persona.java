package entidad;

public class Persona {
	
	private String DNI;
	private String nombre;
	private String apellido;
	
	public Persona(String dNI, String nombre, String apellido) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
