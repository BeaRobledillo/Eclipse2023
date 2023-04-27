package figurasGeometricas;
/*Por último crearemos las clases cuadrado, circulo, cubo y esfera derivándolas de sus clases más adecuadas 
 * e implementando los métodos requeridos. 
 * No hace falta que pongamos lógica, es decir, que no calculemos las areas y volúmenes correspondientes.*/
public abstract class Cuadrado extends Figura2D { //Clase hija de Figura2D
	private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un cuadrado");
    }

    @Override
    public double area() {
		return 0; // Sin implementar la lógica
    }

}
