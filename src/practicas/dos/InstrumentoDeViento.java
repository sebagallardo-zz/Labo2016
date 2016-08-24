package practicas.dos;

public abstract class InstrumentoDeViento implements InstrumentoMusical{
		
		public void hacerSonar(){ // ERROR : No se puede reducir la accesibilidad a package
			System.out.println("Sonar Vientos"); 
		}
		
		public String queEs() { 
			return "Instrumento de Viento"; 
		}
}
