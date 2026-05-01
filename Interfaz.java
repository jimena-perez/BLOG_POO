import java.util.Scanner;

public class Interfaz {

    private Scanner entrada;
    private Controladora sistema;

    public Interfaz() {
        entrada = new Scanner(System.in);
        sistema = new Controladora();
    }

    public void iniciar() {
        System.out.println("===== SISTEMA DE BLOG =====");
        System.out.println("Interfaz iniciada correctamente.");
    }
}
