
import java.time.LocalDateTime;

public class Comentario {

    private String emailAutor;
    private String direccionIP;
    private String texto;
    private LocalDateTime fechaCreacion;

    public Comentario(String emailAutor, String direccionIP, String texto) {
        this.emailAutor = emailAutor;
        this.direccionIP = direccionIP;
        this.texto = texto;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getEmail() {
        return emailAutor;
    }

    public String getIP() {
        return direccionIP;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String toString() {
        return emailAutor + " - " + direccionIP + " - " + fechaCreacion + "\n" + texto;
    }
}