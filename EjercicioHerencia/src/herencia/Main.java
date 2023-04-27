package herencia;

public class Main extends Vehiculo{

	public Main(int velocidad, int direccion) {
		super(velocidad, direccion);
	}

	public static void main(String[] args) {
		Coche coche1 = new Coche(140,50);
		Tanque tanque1 = new Tanque(50,70);
		Bicicleta bicicleta1 = new Bicicleta(10,15);
		System.out.println(bicicleta1);
		bicicleta1.acelerar();
		System.out.println(bicicleta1);
		System.out.println(tanque1);
		tanque1.izquierda();
		System.out.println(tanque1);
		System.out.println(coche1);
		coche1.frenar();
		System.out.println(coche1);
		System.out.println(coche1.getVelocidad());
	}

}
