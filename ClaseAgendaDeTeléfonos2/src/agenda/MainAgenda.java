package agenda;

import java.util.ArrayList;

public class MainAgenda {

	public static void main(String[] args) {

		AgendaTelefonica myAgenda = new AgendaTelefonica();

		// Añadir teléfonos válidos
		addValidPhone(myAgenda, "123456789", "Pedro");
		addValidPhone(myAgenda, "987654321", "Juan");
		addValidPhone(myAgenda, "012345678", "María");
		addValidPhone(myAgenda, "111111111", "Eva");
		addValidPhone(myAgenda, "888888888", "Sergio");

		// Añadir teléfonos inválidos
		addInvalidPhone(myAgenda, "12345", "Fallo1");
		addInvalidPhone(myAgenda, "abcdefghi", "Fallo2");
		addInvalidPhone(myAgenda, "123abc456", "Fallo3");
		addInvalidPhone(myAgenda, "", "Fallo4");

		// Borrar un teléfono
		myAgenda.removeTelefono("012345678");

		// Obtener el nombre de un teléfono
		String nombre = myAgenda.getNombre("987654321");
		System.out.println("El teléfono 987654321 es de: " + nombre);

		// Obtener el teléfono de un nombre
		String telefono = myAgenda.getTelefono("Juan");
		System.out.println("El teléfono de Juan es: " + telefono);

		// Buscar teléfonos por cadena de nombre
		ArrayList<String> telefonos = myAgenda.buscarNombre("e");
		System.out.println("Los teléfonos que contienen la letra 'e' en su nombre son: " + telefonos);

		// Obtener todos los contactos ordenados alfabéticamente
		ArrayList<String> contactos = myAgenda.getAll();
		System.out.println("Todos los contactos en la agenda:");
		for (String contacto : contactos) {
			System.out.println(contacto);
		}

		// Comprobar si hay algún teléfono capicúa
		boolean hayCapicuas = myAgenda.hayCapicuas();
		System.out.println("¿Hay algún teléfono capicúa en la agenda? " + hayCapicuas);

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

	// Comprueba si un teléfono es válido
	private static boolean isValidPhone(String telefono) {
		return telefono.matches("\\d{9}");
	}

}
