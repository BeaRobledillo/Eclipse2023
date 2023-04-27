/*2.- Crear un método al que le pasemos un número entero y nos imprima el numero tantas veces como el mismo. 
Si le paso 3 nos imprime '3' tres veces, si le paso 10 nos imprime '10' diez veces. */
import java.util.Scanner;

public class numeroVeces {
	public static void main(String[] args) {
		
		int numero;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduzca un número: ");
		numero = teclado.nextInt();
		for(int i=0; i<numero; i++) {
			System.out.println(numero);
		}
		
	}
}
