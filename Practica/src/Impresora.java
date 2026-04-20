import java.util.ArrayList;

public abstract class Impresora {
    /** Dev Methods*/

    // Agregar
    public static void agregarDocumento(ArrayList<Documento> cola, Documento doc ){
        cola.add(doc);
        System.out.println("Documento en lista de espera: "+doc.getTipo());

    }

    //Imprimir
    public static void imprimirDocumento(ArrayList<Documento> cola){
        if (!cola.isEmpty()){
            Documento doc = cola.remove(0);
            System.out.println("Imprimiendo: "+ doc.getTipo()+" "+doc.getPags()+" pags");
        }else{
            System.out.println("No hay documentos para imprimir");
        }
    }

    public static void mostrarCola(ArrayList<Documento> cola) {
        System.out.println("\n--- Estado de la Cola ---");
        if (cola.isEmpty()) {
            System.out.println("No hay documentos pendientes.");
        } else {
            for (Documento doc : cola) {
                System.out.println("- " + doc.getTipo() + " [" + doc.getPags() + " páginas]");
            }
        }
        System.out.println("-------------------------\n");
    }

}
