package herencia;
/*De aquí vamos a derivar las siguientes clases:
Coche
La velocidad máxima es de 150. ¿QUé tendríamos que hacer para conseguirlo?*/

public class Coche extends Vehiculo {

	public Coche(int velocidad, int direccion) {
		super(velocidad, direccion);
		
	}
	public void setVelocidad(int velocidad) {
		if (velocidad > 0 && velocidad < 150) {
			this.velocidad = velocidad;
		}
	}
}
