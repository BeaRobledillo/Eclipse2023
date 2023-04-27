package figurasGeometricas;

/*Por último crearemos las clases cuadrado, circulo, cubo y esfera derivándolas de sus clases más adecuadas 
 * e implementando los métodos requeridos. 
 * No hace falta que pongamos lógica, es decir, que no calculemos las areas y volúmenes correspondientes.*/
public abstract class Esfera extends Figuras3D { // Clase hija de Figura3D
	private double radio;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public void dibujar() {
		System.out.println("Dibujando una esfera");
	}

	@Override
	public double volumen() {
		return 0; // Sin implementar la lógica
	}
}
