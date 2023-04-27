package herencia;

/*Vamos a crear una clase ‘Vehiculo’ con las siguientes propiedades:

velocidad, direccion de tipo entero


Si la velocidad es 0 no podemos frenar más.

Si la velocidad es mayor de 200 no podemos acelerar más.

Si la dirección es mayor o igual de 360 le restamos 360.

Si la dirección es negativa le sumamos 360.

Ejemplos: direccion: 350 y ejecutamos izquierda. Debería valer 360, pero le restamos 360 y pasa a valer 0.

direccion vale 0 y ejecutamos derecha. Debería valer -10, pero le sumamos 360 y pasa a valer 350.*/
public class Vehiculo {
	protected int velocidad;
	protected int direccion;

	public Vehiculo(int velocidad, int direccion) {
		super();
		this.velocidad = velocidad;
		this.direccion = direccion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		if (velocidad > 0 && velocidad < 200) {
			this.velocidad = velocidad;
		}
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	/*
	 * Tendrá los siguientes métodos:
	 * 
	 * acelerar(): Incrementa 10 a la velocidad
	 * 
	 * frenar(): decrementa 10 a la velocidad
	 * 
	 * izquierda(): Suma 10 a la dirección
	 * 
	 * derecha(): Resta 10 a la dirección.
	 */

	public void acelerar() {
		setVelocidad(velocidad += 10);
	}

	public void frenar() {
		setVelocidad(velocidad -= 10);
	}

	public void izquierda() {
		setDireccion(direccion += 10);
	}

	public void derecha() {
		setDireccion(direccion -= 10);
	}

	@Override
	public String toString() {
		return "Vehiculo [velocidad=" + velocidad + ", direccion=" + direccion + "]";
	}

}
