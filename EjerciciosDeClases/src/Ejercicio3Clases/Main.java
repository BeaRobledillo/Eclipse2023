package Ejercicio3Clases;

public class Main {
	public static void main(String[] args) {
		
		Alumno alumno1 = new Alumno("Jaime López");
		alumno1.nota = 0;
		alumno1.curso = "3º ESO B";
		alumno1.actitud = 6;
		System.out.println(alumno1.puntuar(5.5));
		System.out.println(alumno1.nota);
		System.out.println(alumno1.castigo());

		System.out.println(alumno1.recompensa());
		System.out.println(alumno1.nota);
		System.out.println(alumno1.actitud);

		System.out.println(alumno1.aprobado());
	}
}
