/*Crear los siguientes métodos. Pensad primero parámetros de entrada y salida y después implementar la lógica de los mismos.

1.- Método masLarga Le pasamos dos cadenas y nos devuelve la de mayor longitud.
2.- Método repetirCadena: Le pasamos una cadena y un entero y nos devuelve la cadena repetida n veces
3.- Método vocales: Le pasamos una cadena y nos dice cuantas vocales tiene (podemos usar el contarChar)
4.- Método capitalizar: Nos pone en mayúsculas todas las letras de cada palabra(una palabra es lo que va después de un espacio).*/
public class Cadenas {

	public static void main(String[] args) {
		
	}
	/*Crear los siguientes métodos. Pensad primero parámetros de entrada y salida y después implementar la lógica de los mismos.

	1.- Método masLarga Le pasamos dos cadenas y nos devuelve la de mayor longitud.*/

	public static String masLarga(String cadena1, String cadena2) {
	    return cadena1.length() > cadena2.length() ? cadena1 : cadena2;
	}

	/*2.- Método repetirCadena: Le pasamos una cadena y un entero y nos devuelve la cadena repetida n veces*/

	public static String repetirCadena(String cadena, int veces) {
	    String resultado = "";
	    for (int i = 0; i < veces; i++) {
	        resultado += cadena;
	    }
	    return resultado;
	}

	/*3.- Método vocales: Le pasamos una cadena y nos dice cuantas vocales tiene (podemos usar el contarChar)*/

	public static int vocales(String cadena) {
	    int contador = 0;
	    for (int i = 0; i < cadena.length(); i++) {
	        char c = cadena.charAt(i);
	        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	            contador++;
	        }
	    }
	    return contador;
	}

	/*4.- Método capitalizar: Nos pone en mayúsculas todas las letras de cada palabra(una palabra es lo que va después de un espacio).*/

	public static String capitalizar(String cadena) {
	    String[] palabras = cadena.split(" ");
	    for (int i = 0; i < palabras.length; i++) {
	        palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1);
	    }
	    return String.join(" ", palabras);
	}


}
