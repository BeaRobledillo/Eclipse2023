package Ejercicio1Clases;

public class Main {

	public static void main(String[] args) {
		Aula aula1 = new Aula("Música", 20);
		Aula aula2 = new Aula("Matemáticas", 30);
		System.out.println(aula1.nombre);

		System.out.println(aula1.caben(27));
		System.out.println(aula2.caben(15));

	}

}
