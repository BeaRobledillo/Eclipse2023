package ficheros;

import java.io.File;
import java.io.IOException;

public class TestFicheros {
	public static void main(String[] args) throws IOException {
		File archivo = new File("prueba.txt");
		File otro = new File("otro.txt");

		if (archivo.exists()) {
			archivo.renameTo(otro);
		} else {
			archivo.createNewFile();

		}

		File directory = new File(".");
		if (directory.isDirectory()) {
			String[] files = directory.list();
			for (String file : files) {
				System.out.println(file);
			}
		}
	}
}
