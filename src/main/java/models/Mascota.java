package models;

public class Mascota {
	
private Long idMascota;
	
	private Long rutDueño;
	
	private String tipoMascota;
	
	private Long edad;
	
	private String nombreMascota;

	
	
	public Mascota() {
		super();
	}

	public Mascota(Long idMascota, Long rutDueño, String tipoMascota, Long edad, String nombreMascota) {
		super();
		this.idMascota = idMascota;
		this.rutDueño = rutDueño;
		this.tipoMascota = tipoMascota;
		this.edad = edad;
		this.nombreMascota = nombreMascota;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public Long getRutDueño() {
		return rutDueño;
	}

	public void setRutDueño(Long rutDueño) {
		this.rutDueño = rutDueño;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", rutDueño=" + rutDueño + ", tipoMascota=" + tipoMascota + ", edad="
				+ edad + ", nombreMascota=" + nombreMascota + "]";
	}

}
