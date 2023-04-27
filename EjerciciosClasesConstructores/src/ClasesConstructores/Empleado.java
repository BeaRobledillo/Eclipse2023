package ClasesConstructores;
/*Crear una clase 'Empleado' con las siguientes propiedades (elegid el tipo más adecuado):
Nombre, departamento, sueldo, bonificacion
Todas privadas y con getters y setters
Tendremos tres constructores:

1.- Nombre y sueldo (Departamento vacío y bonificación 0)
2.- Nombre, departamento y sueldo (bonificación 0)
3.- Nombre, departamento, sueldo y bonificación


En el setter del sueldo vamos a limitar que esté entre el mínimo interprofesional y 5 veces el mínimo interprofesional
En el setter de la bonificación debe estar entre 0 y 500

*/

public class Empleado {
	private String nombre;
	private String departamento;
	private double sueldo;
	private double bonificacion;

	public Empleado(String nombre, double sueldo) {
		super();
		this.nombre = nombre;
		this.departamento = "";
		this.sueldo = sueldo;
		this.bonificacion = 0;
	}

	public Empleado(String nombre, String departamento, double sueldo) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.bonificacion = 0;
	}

	public Empleado(String nombre, String departamento, double sueldo, double bonificacion) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
		this.bonificacion = bonificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	/*
	 * Vamos a crear un getSueldoTotal que nos devuelva el sueldo mas la
	 * bonificacion
	 */

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		double salarioMinimo = 1080;
		if (sueldo >= (salarioMinimo) && (sueldo <= 5 * salarioMinimo)) {
			this.sueldo = sueldo;
		}

	}

	public double getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(double bonificacion) {
		if ((bonificacion >= 0) && (bonificacion <= 500)) {
			this.bonificacion = bonificacion;
		}
	}

	public double getSueldoTotal() {
		return this.sueldo + this.bonificacion;

	}

	/*
	 * Vamos a crear un método bonus(String) al que le pasamos el nombre de un
	 * departamento. Si es igual al departamento del empleado subimos la
	 * bonificación en 50
	 */

	public void bonus(String departamento) {
		if (departamento == "contabilidad") {
			if (bonificacion <= 500)
				bonificacion += 50;
		}
	}

	/*
	 * Vamos a crear un método sueldoNeto() que nos devuelve el sueldo después de
	 * aplicar el IRPF
	 * 
	 * Tenemos los siguientes tramos: hasta 1500->9% de IRPF 1500-3000: 12% de IRPF
	 * más de 3000: 15% de IRPF
	 * 
	 * El IRPF se aplica al sueldo SIN la bonificación
	 */
	public double sueldoNeto() {
		int IRPF;
		if (sueldo <= 1500) {
			IRPF = 9;
		}
		if (sueldo <= 3000) {
			IRPF = 12;
		} else {
			IRPF = 15;
		}
		return sueldo - sueldo * IRPF / 100;
	}
}
