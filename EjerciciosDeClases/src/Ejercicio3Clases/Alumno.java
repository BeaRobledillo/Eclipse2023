package Ejercicio3Clases;

/*Vamos a crear la clase Alumno. Tiene de propiedades:
Nombre, nota, curso y actitud

nota es de tipo double, curso y nombre de tipo String, actitud de tipo int.

En el constructor pedimos el nombre

Creamos una función puntuar a la que le pasamos un valor y nos lo guarda en nota.

Tenemos una función castigo que resta 1 a la actitud

Tenemos una función recompensa que suma 1 a la actitud


Tenemos una función aprobado que nos devuelve un booleano que es true si la nota y la actitud son mayores o iguales a 5.*/

public class Alumno {
	public String nombre;
	public double nota;
	public String curso;
	public double actitud;

	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	public double puntuar(double cantidad) {
		nota += cantidad;
		return nota;
	}

	public double castigo() {
		return actitud - 1;
	}

	public double recompensa() {
		return actitud + 1;
	}

	public boolean aprobado() {
		if (nota >= 5 && actitud >= 5) {
			return true;
		} else {
			return false;
		}
	}
}
