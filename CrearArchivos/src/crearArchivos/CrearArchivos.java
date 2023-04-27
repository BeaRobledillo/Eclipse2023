package crearArchivos;

import java.io.File;
import java.io.IOException;

public class CrearArchivos {

    public static boolean crearArchivo(String carpeta, String nombre) {
        File archivo = new File(carpeta, nombre);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] nombreSplit = nombre.split("\\.");
            String extension = nombreSplit[nombreSplit.length-1];
            String nombreSinExtension = nombre.replace("." + extension, "");
            int num = 1;
            while (archivo.exists()) {
                nombre = nombreSinExtension + num + "." + extension;
                archivo = new File(carpeta, nombre);
                num++;
            }
            try {
                archivo.createNewFile();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String carpeta = ".";
        String nombre = "miArchivo.txt";
        boolean creado = crearArchivo(carpeta, nombre);
        System.out.println("¿Se ha creado el archivo? " + creado);
    }
}
