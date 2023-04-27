package figurasGeometricas;

/*Y de ahí una clase para figuras de 3 dimensiones 'Figuras3D¡ también abstracta 
 * que incorpore el método volumen.*/
public abstract class Figuras3D extends Figura { // Clase hija de Figura

	public abstract double volumen();

	public Figuras3D() {
		super();
		
	}

	public Figuras3D(String nombre) {
		super(nombre);
		
	}
	
	
}
