package practicas.uno;

public class TestEstudiante {
	public static void main(String[] args) {
		Estudiante[] estudiantes = {new Estudiante(), new Estudiante(), new Estudiante(), new Estudiante() , new Estudiante()};
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
	}
}
