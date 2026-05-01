import java.util.Scanner;
import java.util.Map;

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

                switch (opcion) {
                    case 1:
                        crearBlog();
                        break;

                    case 2:
                        mostrarBlogs();
                        break;

                    case 8:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        break;
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

    private void crearBlog() {
        System.out.println("\n--- CREAR BLOG ---");

        System.out.print("Digite el nombre del blog: ");
        String nombre = entrada.nextLine();

        System.out.print("Digite la descripcion del blog: ");
        String descripcion = entrada.nextLine();

        sistema.crearBlog(nombre, descripcion);

        System.out.println("Blog creado correctamente.");
    }

    private void mostrarBlogs() {
        System.out.println("\n--- LISTA DE BLOGS ---");

        Map<Integer, String> blogs = sistema.obtenerBlogs();

        if (blogs.size() == 0) {
            System.out.println("No hay blogs registrados.");
        } else {
            for (Integer codigo : blogs.keySet()) {
                System.out.println("Codigo: " + codigo + " | Nombre: " + blogs.get(codigo));
            }
        }
    }
}