package Ejercicio1Clases;

/*Vamos a crear una clase Aula. Propiedades:
Nombre de tipo String, capacidad de tipo int
En el constructor ponemos el nombre y la capacidad
Hacemos
un método 'caben(cantidad)' que nos devuelve un boolean con true si la
cantidad es menos que la capacidad y false en caso contrario.*/
public class Aula {

	public String nombre;
	public int capacidad;

	public Aula(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public String mostrarAula() {
		return this.nombre + capacidad;
	}

	public boolean caben(int cantidad) {
		if (cantidad <= capacidad) {
			capacidad = cantidad;
			return true;
		} else {
			return false;
		}
	}

}