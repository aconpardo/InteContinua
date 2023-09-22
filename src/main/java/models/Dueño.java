package models;

public class Dueño {
private Long rut;
	
	private String nombre;
	
	private String apellido;
	
	private String direccion;
	
	private String correo;
	
	private Long telefono;
	
	private String nombreMascota;
	
	

	public Dueño() {
		super();
	}

	public Dueño(Long rut, String nombre, String apellido, String direccion, String correo, Long telefono,
			String nombreMascota) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.nombreMascota = nombreMascota;
	}

	public Long getRut() {
		return rut;
	}

	public void setRut(Long rut) {
		this.rut = rut;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	@Override
	public String toString() {
		return "Dueño [rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", correo=" + correo + ", telefono=" + telefono + ", nombreMascota=" + nombreMascota + "]";
	}
}
