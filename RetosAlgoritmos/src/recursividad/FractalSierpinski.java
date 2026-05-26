package recursividad;

/**
 * Adaptación del algoritmo recursivo para generar el Triángulo de Sierpinski.
 *
 * Esta versión se enfoca únicamente en la lógica recursiva,
 * imprimiendo en consola las llamadas para visualizar la estructura.
 * Se eliminaron todas las dependencias de bibliotecas gráficas (AWT/Swing).
 */
public class FractalSierpinski {

    /**
     * Punto de entrada que inicia la recursión.
     *
     * @param nivel La profundidad de la recursión.
     */
    public void dibujar(int nivel) {
        System.out.println("--- Iniciando Triángulo de Sierpinski de nivel " + nivel + " ---");
        sierpinski(nivel, "A", "B", "C");
        System.out.println("\n--- Fin del Triángulo de Sierpinski ---");
        System.out.println("Total de triángulos base dibujados: " + contarTriangulos(nivel));
        System.out.println("Total de llamadas a la función recursiva: " + contarLlamadas(nivel));
    }

    /**
     * El método recursivo principal.
     *
     * @param nivel    El nivel de profundidad actual.
     * @param vertice1 Vértice 1 del triángulo actual.
     * @param vertice2 Vértice 2 del triángulo actual.
     * @param vertice3 Vértice 3 del triángulo actual.
     */
    private void sierpinski(int nivel, String vertice1, String vertice2, String vertice3) {
        // Imprime la llamada actual para visualizar el proceso.
        String indentacion = "  ".repeat(4 - nivel);
        System.out.println(indentacion + "Nivel " + nivel + ": Triángulo(" + vertice1 + ", " + vertice2 + ", " + vertice3 + ")");

        // CASO BASE: Si el nivel es 0, hemos llegado a un triángulo que se "dibuja".
        // En esta versión, simplemente terminamos la recursión para esta rama.
        if (nivel == 0) {
            System.out.println(indentacion + "-> Caso base. Dibujando triángulo final.");
            return; // Detiene la recursión.
        }

        // CASO RECURSIVO: Si el nivel es mayor que 0, subdividimos el triángulo.

        // 1. Calcular los puntos medios de cada lado.
        String medio12 = "M(" + vertice1 + vertice2 + ")";
        String medio23 = "M(" + vertice2 + vertice3 + ")";
        String medio31 = "M(" + vertice3 + vertice1 + ")";

        System.out.println(indentacion + "-> Subdividiendo en 3 triángulos más pequeños.");

        // 2. Realizar tres llamadas recursivas con un nivel menos.
        //    Cada llamada corresponde a uno de los tres subtriángulos de las esquinas.
        sierpinski(nivel - 1, vertice1, medio12, medio31);  // Triángulo superior
        sierpinski(nivel - 1, medio12, vertice2, medio23);   // Triángulo inferior izquierdo
        sierpinski(nivel - 1, medio31, medio23, vertice3);   // Triángulo inferior derecho
    }

    /**
     * Calcula cuántos triángulos base (de nivel 0) se dibujan para un nivel N.
     * La fórmula es 3^N.
     */
    public static long contarTriangulos(int nivel) {
        return (long) Math.pow(3, nivel);
    }

    /**
     * Calcula el número total de llamadas a la función `sierpinski`.
     * La fórmula es la suma de 3^i desde i=0 hasta N.
     */
    public static long contarLlamadas(int nivel) {
        long total = 0;
        for (int i = 0; i <= nivel; i++) {
            total += (long) Math.pow(3, i);
        }
        return total;
    }

    public static void main(String[] args) {
        FractalSierpinski fractal = new FractalSierpinski();
        // Se recomienda un nivel bajo (2 o 3) para no saturar la consola.
        fractal.dibujar(2);
    }
}

