/*Vamos a crear una agenda de teléfonos.
La clase tendrá un HashMap<String,String> y guardaremos un número de teléfono como clave y un nombre como valor.
Tendremos un addTelefono(Telefono, nombre) que nos lo añade a la lista
Tendremos un removeTelefono(Telefono) que nos borra ese teléfono
Tendremos un getNombre(Telefono) que nos devuelve el nombre de ese teléfono
Un getTelefono(nombre) que nos devuelve el teléfono de ese nombre
Si no existe devuelve la cadena vacía en los dos casos.
Y crearemos también un buscarNombre(cadena) que nos devuelva una lista (ArrayList) de los teléfonos cuyo nombre contenga la cadena que nos pasan.

Cuando todo esto funcione añadiremos:

- Comprobar que cuando nos añaden un teléfono tenga una longitud de nueve caracteres y todo sea números
Si no es así, no añadir el teléfono. Y que el nombre no esté vacío
- Método getAll()->Devolver un arraylist de cadenas con el formato Nombre-Telefono ordenado alfabeticamente (es más fácil de lo que parece, no busquéis cosas raras)

- hayCapicuas()-> Nos devolverá true si hay algún teléfono que sea capicua*/

package agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AgendaTelefonica {

	private HashMap<String, String> agenda;

	public AgendaTelefonica() {

		agenda = new HashMap<>(); // HashMap para almacenar los números de teléfono y los nombres.
	}

	// método que añade un número de teléfono y un nombre
	public void addTelefono(String telefono, String nombre) {
		if (telefono.matches("[0-9]{9}") && !nombre.isEmpty()) {
			agenda.put(telefono, nombre); // Comprobar la longitud del teléfono y que el nombre no sea vacío
		}
	}

	// método que borra un número de teléfono
	public void removeTelefono(String telefono) {
		agenda.remove(telefono);
	}

	// método que devuelven el nombre
	public String getNombre(String telefono) {
		return agenda.getOrDefault(telefono, "");
	}

	// método que devuelven el teléfono
	public String getTelefono(String nombre) {
		for (String telefono : agenda.keySet()) {
			if (agenda.get(telefono).equals(nombre)) {
				return telefono;
			}
		}
		return ""; // Si el número de teléfono o el nombre no existen en la agenda, se devuelve una
					// cadena vacía.
	}

	// método que nos devuelva una lista (ArrayList)de los teléfonos cuyo nombre
	// contenga la cadena que nos pasan.
	public ArrayList<String> buscarNombre(String cadena) {
		ArrayList<String> telefonos = new ArrayList<>();
		for (String telefono : agenda.keySet()) {
			String nombre = agenda.get(telefono);
			if (nombre.contains(cadena)) {
				telefonos.add(telefono);
			}
		}
		return telefonos;
	}

	/*
	 * Cuando todo esto funcione añadiremos:
	 * 
	 * - Comprobar que cuando nos añaden un teléfono tenga una longitud de nueve
	 * caracteres y todo sea números Si no es así, no añadir el teléfono. Y que el
	 * nombre no esté vacío - Método getAll()->Devolver un arraylist de cadenas con
	 * el formato Nombre-Telefono ordenado alfabeticamente (es más fácil de lo que
	 * parece, no busquéis cosas raras)
	 * 
	 * - hayCapicuas()-> Nos devolverá true si hay algún teléfono que sea capicua
	 */

	// método que devuelve un ArrayList con el formato Nombre-Telefono ordenado
	// alfabeticamente

	public ArrayList<String> getAll() {
		ArrayList<String> lista = new ArrayList<>();
		for (String telefono : agenda.keySet()) {
			String nombre = agenda.get(telefono);
			lista.add(nombre + "-" + telefono);
		}
		Collections.sort(lista); // Ordenar alfabéticamente
		return lista;
	}

	// método que devuelve true si hay algún teléfono capicúa

	public boolean hayCapicuas() {
		for (String telefono : agenda.keySet()) {
			if (telefono.equals(new StringBuilder(telefono).reverse().toString())) {
				return true;
			}
		}
		return false;
	}

	// Comprueba si un teléfono es válido
	private static boolean isValidPhone(String telefono) {
		return telefono.matches("\\d{9}");
	}

	// Añade un teléfono a la agenda si es válido
	private static void addValidPhone(AgendaTelefonica agenda, String telefono, String nombre) {
		if (isValidPhone(telefono) && !nombre.isEmpty()) {
			agenda.addTelefono(telefono, nombre);
		}
	}

	// Añade un teléfono a la agenda si es inválido
	private static void addInvalidPhone(AgendaTelefonica agenda, String telefono, String nombre) {
		if (!isValidPhone(telefono) || nombre.isEmpty()) {
			agenda.addTelefono(telefono, nombre);
		}
	}

}
