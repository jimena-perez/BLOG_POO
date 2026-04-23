import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {

    private static int contador = 1;

    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        this.codigo = contador++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void agregarComentario(String email, String ip, String texto) {
        Comentario c = new Comentario(email, ip, texto);
        comentarios.add(c);
    }

    public void borrarComentario(int posicion) throws Exception {
        if (posicion < 0 || posicion >= comentarios.size()) {
            throw new Exception("Comentario no valido");
        }
        comentarios.remove(posicion);
    }

    public String toString() {
        String resultado = titulo + " - " + nombreCreador + " - " + fechaPublicacion + "\n";
        resultado += texto + "\n";

        if (comentarios.size() == 0) {
            resultado += "No hay comentarios\n";
        } else {
            for (Comentario c : comentarios) {
                resultado += c.toString() + "\n";
            }
        }

        return resultado;
    }
}