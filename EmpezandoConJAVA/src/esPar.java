import java.util.Scanner;

/*1.- Crear un método 'esPar' al que le pasemos un número y nos diga si es par o impar.
¿Qué tipo tendrá de entrada? ¿Qué tipo tendrá de salida?*/

public class esPar {
	public static void main(String[] args) {

		int numero;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduzca un número: ");
		numero = teclado.nextInt();

		if (numero % 2 == 0) {
			System.out.println("El número es par.");
		} else {
			System.out.println("El número es impar.");
		}
	}
}
