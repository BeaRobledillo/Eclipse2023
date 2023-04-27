package archivoUtil;

import java.io.File;
import java.io.IOException;

public class ArchivoUtil {

    public static boolean crearArchivo(String carpeta, String nombre) {
        File archivo = new File(carpeta + File.separator + nombre);
        int contador = 1;
        while (archivo.exists()) {
            int punto = nombre.lastIndexOf(".");
            String nombreSinExtension = (punto >= 0) ? nombre.substring(0, punto) : nombre;
            String extension = (punto >= 0) ? nombre.substring(punto) : "";
            archivo = new File(carpeta + File.separator + nombreSinExtension + contador + extension);
            contador++;
        }
        try {
            return archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
