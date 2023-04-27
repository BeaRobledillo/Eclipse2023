package figurasGeometricas;

/*Vamos a crear una serie de clases para figuras geométricas.
La clase madre 'Figura' será abstracta y tendrá una propiedad Nombre (getters y setters) 
 y un método dibujar abstracto.*/
public abstract class Figura { // Clase Padre

	private String nombre;

	public Figura() {
		super();
	}

	public Figura(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + "]";
	}

	public abstract void dibujar();

}
