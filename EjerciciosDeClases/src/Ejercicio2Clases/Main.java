package Ejercicio2Clases;

public class Main {
	public static void main(String[] args) {

		CuentaBancaria cuenta1 = new CuentaBancaria("Francisco Marín", 0);

		System.out.println(cuenta1.depositar(500));
		cuenta1.retirar(200);
		System.out.println(cuenta1.saldo);
		cuenta1.retirar(301);
		System.out.println(cuenta1.saldo);

	}
}
