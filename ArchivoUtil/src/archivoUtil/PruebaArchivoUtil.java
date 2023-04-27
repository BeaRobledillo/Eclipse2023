package archivoUtil;

public class PruebaArchivoUtil {

    public static void main(String[] args) {
        String carpeta = ".";
        String nombre = "archivo.txt";
        boolean creado = ArchivoUtil.crearArchivo(carpeta, nombre);
        if (creado) {
            System.out.println("Se ha creado el archivo");
        } else {
            System.out.println("No se ha podido crear el archivo");
        }
    }
}
