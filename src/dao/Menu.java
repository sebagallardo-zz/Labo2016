package dao;

public class Menu {
	
	private int 	id;
	private String 	nombre;
	private String 	descripcion;
	private float 	precio;
	
	public Menu(){}
	
	public Menu(String unNombre, String unaDescripcion, float unPrecio){
		this.nombre 		= unNombre;
		this.descripcion 	= unaDescripcion;
		this.precio 		= unPrecio;
	}
	
	public Menu(int unId, String unNombre, String unaDescripcion, float unPrecio){
		this.id 			= unId;
		this.nombre 		= unNombre;
		this.descripcion 	= unaDescripcion;
		this.precio 		= unPrecio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
