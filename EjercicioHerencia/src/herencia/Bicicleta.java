package herencia;

/*Bicicleta

Acelerar y frenar incrementan la velocidad en 3 en vez de 10*/
public class Bicicleta extends Vehiculo {

	public Bicicleta(int velocidad, int direccion) {
		super(velocidad, direccion);

	}

	public void acelerar() {
		setVelocidad(velocidad += 3);
	}

	public void frenar() {
		setVelocidad(velocidad -= 3);
	}
}
