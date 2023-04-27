package Ejercicio2Clases;

/*Vamos a crear una clase 'CuentaBancaria' con las propiedades Titular (String) y saldo (double) 
 * En el constructor pedimos el nombre del titular, el saldo por defecto es 0. 
 * Vamos a crear los métodos 'depositar(cantidad)' que nos añade una cantidad al saldo y 
 * 'retirar(cantidad)' que nos retira esa cantidad del saldo si hay suficiente, 
 * en caso contrario no hace nada (ni avisa).*/
public class CuentaBancaria {
	public String titular;
	public double saldo;

	public CuentaBancaria(String titular, int saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public double depositar(double cantidad) {
		saldo += cantidad;
		return saldo;
	}

	public void retirar(double cantidad) {
		if (cantidad <= saldo) {
			saldo -= cantidad;
		} else {
		}

	}
}
