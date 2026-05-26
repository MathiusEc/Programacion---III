package backtracking;

/**
 * Contiene el algoritmo de backtracking para resolver un laberinto.
 *
 * El algoritmo explora recursivamente los caminos posibles. Si llega a un
 * punto sin salida, "retrocede" (backtrack) y prueba una dirección diferente.
 */
public class SolucionadorLaberinto {

    private Laberinto laberinto;

    public SolucionadorLaberinto(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

    /**
     * Punto de entrada público para iniciar la resolución del laberinto.
     * @return true si se encontró una solución, false en caso contrario.
     */
    public boolean resolver() {
        System.out.println("--- Iniciando resolución de laberinto por Backtracking ---");
        laberinto.imprimir();
        boolean encontrado = buscar(laberinto.getFilaInicio(), laberinto.getColInicio());

        System.out.println("\n--- Resultado ---");
        if (encontrado) {
            System.out.println("¡Solución encontrada!");
        } else {
            System.out.println("No se pudo encontrar una solución.");
        }
        laberinto.imprimir();
        System.out.println("Estadísticas:");
        System.out.println(" - Llamadas recursivas: " + laberinto.llamadasRecursivas);
        System.out.println(" - Nodos explorados: " + laberinto.nodosExplorados);
        System.out.println(" - Retrocesos (backtracks): " + laberinto.retrocesos);
        return encontrado;
    }

    /**
     * El método recursivo de backtracking.
     *
     * @param fila Fila actual en la exploración.
     * @param col  Columna actual en la exploración.
     * @return true si esta posición lleva a la solución, false si no.
     */
    private boolean buscar(int fila, int col) {
        laberinto.llamadasRecursivas++;

        // 1. Comprobar si la celda es la salida
        if (esSalida(fila, col)) {
            laberinto.getData()[fila][col] = 9; // Marcar la salida como parte del camino
            laberinto.nodosExplorados++;
            laberinto.imprimir();
            return true; // ¡Éxito!
        }

        // 2. Comprobar condiciones de parada (límites, paredes, visitados)
        if (esInvalido(fila, col)) {
            return false;
        }

        // 3. Marcar la celda actual como parte del camino de la solución
        laberinto.getData()[fila][col] = 9;
        laberinto.nodosExplorados++;
        laberinto.imprimir(); // Muestra el progreso

        // 4. Explorar recursivamente las 4 direcciones (CASO RECURSIVO)
        int[][] direcciones = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // Abajo, Derecha, Arriba, Izquierda

        for (int[] dir : direcciones) {
            if (buscar(fila + dir[0], col + dir[1])) {
                return true; // Si una dirección lleva a la solución, propagamos el éxito.
            }
        }

        // 5. Si ninguna dirección funcionó, retroceder (BACKTRACK)
        laberinto.retrocesos++;
        laberinto.getData()[fila][col] = 5; // Marcar como visitado sin salida
        laberinto.imprimir(); // Muestra el retroceso

        return false; // Propagamos el fracaso.
    }

    /**
     * Verifica si una celda está fuera de los límites del laberinto,
     * es una pared, o ya forma parte del camino actual.
     */
    private boolean esInvalido(int fila, int col) {
        int[][] data = laberinto.getData();
        return fila < 0 || col < 0 ||
               fila >= data.length || col >= data[0].length || // Fuera de límites
               data[fila][col] == 1 || // Es pared
               data[fila][col] == 5 || // Ya visitado y sin salida
               data[fila][col] == 9;  // Parte del camino actual (evita ciclos)
    }
    
    /**
     * Verifica si una celda es la salida.
     */
    private boolean esSalida(int fila, int col) {
        int[][] data = laberinto.getData();
        // Asegurarse de no estar fuera de los límites antes de consultar
        if (fila >= 0 && col >= 0 && fila < data.length && col < data[0].length) {
            return data[fila][col] == 2;
        }
        return false;
    }

    public static void main(String[] args) {
        Laberinto lab = Laberinto.crearLaberintoDePrueba();
        SolucionadorLaberinto solucionador = new SolucionadorLaberinto(lab);
        solucionador.resolver();
    }
}
