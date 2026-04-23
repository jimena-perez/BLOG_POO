import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {

    private static int contador = 1;

    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    private Map<Integer, Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        this.codigo = contador++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
        this.publicaciones = new TreeMap<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void crearPublicacion(String titulo, String texto, String creador) {
        Publicacion p = new Publicacion(titulo, texto, creador);
        publicaciones.put(p.getCodigo(), p);
    }

    public String obtenerPublicacion(int codigo) throws Exception {
        if (!publicaciones.containsKey(codigo)) {
            throw new Exception("Publicacion no existe");
        }

        Publicacion p = publicaciones.get(codigo);
        return p.toString();
    }

    public Map<Integer, String> obtenerTitulos() {
        Map<Integer, String> resultado = new TreeMap<>();

        for (Publicacion p : publicaciones.values()) {
            resultado.put(p.getCodigo(), p.getTitulo());
        }

        return resultado;
    }

    public void agregarComentario(int codigoPublicacion, String email, String ip, String texto) throws Exception {
        if (!publicaciones.containsKey(codigoPublicacion)) {
            throw new Exception("Publicacion no existe");
        }

        Publicacion p = publicaciones.get(codigoPublicacion);
        p.agregarComentario(email, ip, texto);
    }

    public void borrarComentario(int codigoPublicacion, int posicion) throws Exception {
        if (!publicaciones.containsKey(codigoPublicacion)) {
            throw new Exception("Publicacion no existe");
        }

        Publicacion p = publicaciones.get(codigoPublicacion);
        p.borrarComentario(posicion);
    }
}
