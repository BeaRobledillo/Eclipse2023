import java.util.Scanner;

/*3.- Crear un método que le vaya pidiendo números al usuario hasta que introduzca el 0 
y en ese momento salga y nos devuelva el mayor de los números que ha introducido.*/
public class NumeroMayor {

	public static void main(String[] args) {

		int numero;
		int max = Integer.MIN_VALUE;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("Introduzca un número (0 para salir): ");
			numero = teclado.nextInt();
			if (numero > max && numero != 0) {
				max = numero;
			}
		} while (numero != 0);
		System.out.println("El número mayor es: " + max);
	}

}
