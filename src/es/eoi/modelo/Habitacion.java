package es.eoi.modelo;

public class Habitacion {

	private int n_habitacion;  //nuestra clase primaria
	private String tipo;
	private String disponibilidad;
	
	public Habitacion() {
		
	}
	
	public Habitacion(int n_habitacion, String tipo, String disponibilidad) {
		super();
		this.n_habitacion = n_habitacion;
		this.tipo = tipo;
		this.disponibilidad = disponibilidad;
	}
	
	public int getN_habitacion() {
		return n_habitacion;
	}
	
	public void setN_habitacion(int n_habitacion) {
		this.n_habitacion = n_habitacion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
