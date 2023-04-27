package figurasGeometricas;

/*Por último crearemos las clases cuadrado, circulo, cubo y esfera derivándolas de sus clases más adecuadas 
 * e implementando los métodos requeridos. 
 * No hace falta que pongamos lógica, es decir, que no calculemos las areas y volúmenes correspondientes.*/
public abstract class Cubo extends Figuras3D { // Clase hija de Figura3D
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public void dibujar() {
		System.out.println("Dibujando un cubo");
	}

	@Override
	public double volumen() {
		return 0; // Sin implementar la lógica
	}
}
