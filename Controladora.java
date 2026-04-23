import java.util.Map;
import java.util.TreeMap;

public class Controladora {

    private Map<Integer, Blog> blogs;

    public Controladora() {
        blogs = new TreeMap<>();
    }

    public void crearBlog(String nombre, String descripcion) {
        Blog b = new Blog(nombre, descripcion);
        blogs.put(b.getCodigo(), b);
    }

    public Map<Integer, String> obtenerBlogs() {
        Map<Integer, String> resultado = new TreeMap<>();

        for (Blog b : blogs.values()) {
            resultado.put(b.getCodigo(), b.getNombre());
        }

        return resultado;
    }

    public void crearPublicacion(int codigoBlog, String titulo, String texto, String creador) throws Exception {
        if (!blogs.containsKey(codigoBlog)) {
            throw new Exception("Blog no existe");
        }

        Blog b = blogs.get(codigoBlog);
        b.crearPublicacion(titulo, texto, creador);
    }

    public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) throws Exception {
        if (!blogs.containsKey(codigoBlog)) {
            throw new Exception("Blog no existe");
        }

        Blog b = blogs.get(codigoBlog);
        return b.obtenerPublicacion(codigoPublicacion);
    }

    public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) throws Exception {
        if (!blogs.containsKey(codigoBlog)) {
            throw new Exception("Blog no existe");
        }

        Blog b = blogs.get(codigoBlog);
        b.agregarComentario(codigoPublicacion, email, ip, texto);
    }

    public void borrarComentario(int codigoBlog, int codigoPublicacion, int posicion) throws Exception {
        if (!blogs.containsKey(codigoBlog)) {
            throw new Exception("Blog no existe");
        }

        Blog b = blogs.get(codigoBlog);
        b.borrarComentario(codigoPublicacion, posicion);
    }
}