/*4.- Crear un método al que le pasemos tres números enteros y nos devuelva true 
si se los hemos pasado en orden de menor a mayor (ej: 4,9,20) y false si no es así

5.- Crear una sobrecarga del anterior para números double*/
public class Orden {

	public static void main(String[] args) {
		System.out.println(isInOrder(4, 9, 20));
		System.out.println(isInOrder(4.0, 9.0, 20.0));
	}

	public static boolean isInOrder(int a, int b, int c) {
		return (a < b) && (b < c);
	}

	public static boolean isInOrder(double a, double b, double c) {
		return (a < b) && (b < c);
	}
}
