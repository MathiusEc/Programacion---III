import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Documento> cola = new ArrayList<>();


        // Llegada de documentos a la cola
        Impresora.agregarDocumento(cola, new Documento("Tesis", 2));
        Impresora.agregarDocumento(cola, new Documento("Pack del ña", 1));
        Impresora.mostrarCola(cola);
        Impresora.imprimirDocumento(cola);
    }
}