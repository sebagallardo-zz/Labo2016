package practicas.uno;

import java.util.Date;

public class EstudianteUniversitario extends Estudiante{
	private Date ingreso;
	
	public EstudianteUniversitario(){
		this.ingreso = new Date();
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}
}
