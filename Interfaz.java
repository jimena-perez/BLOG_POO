import java.util.Scanner;

public class Interfaz {

    private Scanner entrada;
    private Controladora sistema;

    public Interfaz() {
        entrada = new Scanner(System.in);
        sistema = new Controladora();
    }

    public void iniciar() {
        int opcion = 0;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(entrada.nextLine());

                if (opcion == 8) {
                    System.out.println("Saliendo del sistema...");
                } else {
                    System.out.println("Opcion seleccionada: " + opcion);
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar solo numeros.");
            }

        } while (opcion != 8);
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE BLOG =====");
        System.out.println("1. Crear blog");
        System.out.println("2. Mostrar blogs");
        System.out.println("3. Crear publicacion");
        System.out.println("4. Mostrar publicaciones de un blog");
        System.out.println("5. Ver publicacion completa");
        System.out.println("6. Agregar comentario");
        System.out.println("7. Borrar comentario");
        System.out.println("8. Salir");
        System.out.print("Digite una opcion: ");
    }
}