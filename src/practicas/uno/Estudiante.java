package practicas.uno;

public class Estudiante {
	private String apellido;
	private String nombre;
	private String legajo;
	private StringBuffer buffer;
	
	public Estudiante(){
		this.apellido = "Pepo";
		this.nombre = "Pepito";
		this.legajo = "9999/9";
		this.buffer = new StringBuffer();
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	@Override
	public String toString() {
		String aux = buffer.append(getApellido()).append(getNombre()).append(getLegajo()).toString();
		buffer.delete(0, buffer.length());
		return aux;
	}	
}