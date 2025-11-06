import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase proporciona un programa base para la gestión de ficheros y directorios
 * utilizando la clase java.io.File.
 *
 * @Autor: Javier Raposo Huelva
 * @Version: 2025:10
 */

public class Main {

    /**
     * Programa base para la gestión de ficheros y directorios con java.io.File.
     * <p>
     * TODO:
     * - Implementar menú principal en consola.
     * - Usar únicamente la clase File para las operaciones.
     * - Reutilizar la comprobación de existencia/tipo de la práctica anterior.
     * - Manejar errores y mensajes.
     */
    public static void main(String[] args) {
        // TODO: Inicializar lectura de entrada y, si procede, ruta base desde args.
        // TODO: Bucle del menú hasta seleccionar Salir.
        // TODO: Enrutar cada opción a su método correspondiente.
        // TODO: Mensaje final al salir.

        Scanner sc = new Scanner(System.in);
        System.out.print("Inserta ruta absoluta del directorio base: ");
        String rutaBase = sc.nextLine();
        File file = new File(rutaBase);


        int opc;

        do {
            System.out.println("Menú de gestión de ficheros y directorios:");
            System.out.println("1. Crear directorio");
            System.out.println("2. Eliminar directorio");
            System.out.println("3. Crear fichero");
            System.out.println("4. Eliminar fichero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");
            opc = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opc) {
                case 1:
                    crearDirectorio(file);
                    break;
                case 2:
                    eliminarDirectorio(file);
                    break;
                case 3:
                    crearFichero(file);
                    break;
                case 4:
                    eliminarFichero(file);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    System.out.println("Pulse \"ENTER\" para continuar...");
                    sc.nextLine();
            }
        } while (opc != 5);

    }

    /**
     * Crear directorio.
     * <p>
     * TODO:
     * - Pedir ruta del directorio.
     * - Validar entrada.
     * - Elegir mkdir o mkdirs.
     * - Mostrar éxito o motivo de fallo.
     */
    public static void crearDirectorio(File file) {
        // TODO: Implementar según los puntos anteriores usando únicamente File.

        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directorio creado con éxito.");
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe.");
        }


    }

    /**
     * Eliminar directorio.
     * <p>
     * TODO:
     * - Pedir ruta y verificar exists e isDirectory.
     * - Intentar delete (solo si está vacío).
     * - Informar si no se puede eliminar.
     */
    public static void eliminarDirectorio(File file) {
        if (file.exists() && file.isDirectory()) {
            if (file.delete()) {
                System.out.println("Directorio eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el directorio. Asegúrese de que está vacío.");
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio.");
        }
    }

    /**
     * Crear fichero.
     * <p>
     * TODO:
     * - Pedir ruta completa del fichero.
     * - Verificar si existe.
     * - Crear con createNewFile controlando posibles excepciones.
     * - Si el directorio padre no existe, decidir si crearlo. si o no.
     */
    public static void crearFichero(File file) {
        Scanner sc = new Scanner(System.in);
        String opc;

        try{
            if (!file.exists()) {
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    System.out.println("El directorio padre no existe. ¿Desea crearlo? (s/n): ");
                    opc = sc.nextLine();
                    if (!opc.equalsIgnoreCase("s")) {
                        System.out.println("No se creó el fichero.");
                        return;
                    } else {
                        System.out.println("Creando directorio padre...");
                        if (parentDir.mkdirs()) {
                            System.out.println("Directorio padre creado con éxito.");
                        } else {
                            System.out.println("No se pudo crear el directorio padre.");
                            return;
                        }
                    }
                }
                if (file.createNewFile()) {
                    System.out.println("Fichero creado con éxito.");
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } else {
                System.out.println("El fichero ya existe.");

            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }



    }

    /**
     * Eliminar fichero.
     * <p>
     * TODO:
     * - Pedir ruta y verificar exists() e isFile().
     * - Confirmar con el usuario antes de borrar.
     * - Eliminar con delete y mostrar resultado.
     */
    public static void eliminarFichero(File file) {
        // TODO: Implementar según los puntos anteriores usando únicamente File.

        if (!file.exists() ) {
            System.out.println("El fichero no existe.");

        } else {
            if (file.delete()) {
                System.out.println("El fichero " + file.getName() + " ha sido eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el fichero.");
            }
        }
    }
}
