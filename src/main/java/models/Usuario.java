package models;

public class Usuario {
	
private Long id;
	
	private String nombreUsuario;
	
	private String password;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombreUsuario, String password) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
	}

}
