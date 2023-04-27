package herencia;
/*Tanque

Al girar a la izquierda o a la derecha se giran 90 en vez de 10.*/
public class Tanque extends Vehiculo {

	public Tanque(int velocidad, int direccion) {
		super(velocidad, direccion);
		
	}
	public void izquierda() {
		setDireccion(direccion += 90);
	}

	public void derecha() {
		setDireccion(direccion -= 90);
	}


}
