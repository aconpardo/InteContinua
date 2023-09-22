package models;

import java.util.Date;

public class Agenda {
private Long id;
	
	private Long idMascota; 
	
	private Long rutDueño;
	
	private String hora;
	
	private Date fecha;
	
	
	
	public Agenda() {
		super();
	}
	public Agenda(Long id, Long idMascota, Long rutDueño, String hora, Date fecha) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.rutDueño = rutDueño;
		this.hora = hora;
		this.fecha = fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", idMascota=" + idMascota + ", rutDueño=" + rutDueño + ", hora=" + hora
				+ ", fecha=" + fecha + "]";
	}
}
