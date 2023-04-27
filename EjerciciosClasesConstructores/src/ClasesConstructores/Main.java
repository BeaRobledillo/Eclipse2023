package ClasesConstructores;

public class Main {

	public static void main(String[] args) {

		Empleado Laura = new Empleado("Laura", "contabilidad", 1300, 150);
		Empleado Juan = new Empleado("Juan", "administracion", 1100, 50);
		Empleado Maria = new Empleado("Maria", "direccion", 1600, 325);
		System.out.println(Laura.sueldoNeto());
		System.out.println(Laura.getBonificacion());
		Maria.getSueldoTotal();
		Juan.setBonificacion(300);
		System.out.println(Juan.getSueldo());
	}
}
