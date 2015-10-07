package pe.egcc.ejm05;

public class Ejm05Service {

	private String nombre;
	private String apellido;
	private String telefono;

	public Ejm05Service(String nombre, String telefono, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public void mostarDatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Telefono: " + telefono);
	}

}
