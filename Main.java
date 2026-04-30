
import java.util.Map;
//prueba de cambios
public class Main {

    public static void main(String[] args) {

        Controladora sistema = new Controladora();

        try {

            // Crea bl
            sistema.crearBlog("Mi Blog", "Blog de prueba");

            // Muestra bl
            Map<Integer, String> blogs = sistema.obtenerBlogs();

            int codigoBlog = 0;

            for (Integer cod : blogs.keySet()) {
                System.out.println("Blog: " + cod + " - " + blogs.get(cod));
                codigoBlog = cod;
            }

            // Crear pbl
            sistema.crearPublicacion(codigoBlog, "Primer Post", "Hola mundo", "Juan");

            // Agregar cm
            sistema.agregarComentario(codigoBlog, 1, "correo@test.com", "127.0.0.1", "Buen post");

            // Mostrar pbl
            String texto = sistema.obtenerPublicacion(codigoBlog, 1);
            System.out.println("\nPUBLICACION:");
            System.out.println(texto);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}