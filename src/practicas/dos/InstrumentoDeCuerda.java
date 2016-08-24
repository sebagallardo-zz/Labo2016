package practicas.dos;

public class InstrumentoDeCuerda implements InstrumentoMusical{

	public void hacerSonar() {
		System.out.println("Sonar cuerdas");
	}

	public String queEs() {
		return "Instrumento de Cuerda";
	}
	
	public void afinar(){} //ERROR : implementar los métodos abstractos de la interface
}
