package colores;

import java.util.Arrays;

public class JuegoColores implements ILogica {
	public JuegoColores(String[] jugadas) {
		super();
		this.jugadas = jugadas;
	}

	public JuegoColores() {
		
	}

	private String[] jugadas = { "rojo", "verde", "azul", "amarillo" };

	@Override
	public int comprobar(String jugada1, String jugada2) {
		int pos1 = Arrays.asList(jugadas).indexOf(jugada1.toLowerCase());
		int pos2 = Arrays.asList(jugadas).indexOf(jugada2.toLowerCase());
		
		if (pos1<2 && pos2<2) {
			return 1;
		}
		if (pos1>=2 && pos2>=2) {
			return 2;
		}
		return 0;
	}

	@Override
	public String[] validas() {
		
		return this.jugadas;
	}

}