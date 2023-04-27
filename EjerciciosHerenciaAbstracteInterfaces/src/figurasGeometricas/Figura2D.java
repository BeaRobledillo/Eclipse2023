package figurasGeometricas;

/*De ahí derivaremos una clase 'Figura2D' para figuras de 2 dimensiones también abstracta 
 * que incorpora el método abstracto area que nos devuelve un double.*/
public abstract class Figura2D extends Figura { // Clase hija de Figura

	

	public Figura2D() {
		super();
	
	}
	

	public Figura2D(String nombre) {
		super(nombre);
	
	}
	
	
	@Override
	public String getNombre() {
		
		return super.getNombre();
	}


	@Override
	public void setNombre(String nombre) {
		
		super.setNombre(nombre);
	}


	@Override
	public String toString() {
		
		return super.toString();
	}


	@Override
	public void dibujar() {
		
		
	}


	public abstract double area();
}
