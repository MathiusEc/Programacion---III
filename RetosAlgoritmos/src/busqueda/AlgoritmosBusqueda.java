package busqueda;

import java.util.Arrays;

/**
 * Contiene algoritmos de búsqueda comunes: lineal y binaria.
 */
public class AlgoritmosBusqueda {

    /**
     * Búsqueda Lineal (o Secuencial).
     * Recorre el array elemento por elemento hasta encontrar el objetivo.
     * Funciona con arrays desordenados.
     *
     * Complejidad: O(n)
     *
     * @param array El array donde buscar.
     * @param numero El elemento a encontrar.
     * @return Un array de 2 enteros: {índice, pasos}. Retorna -1 como índice si no se encuentra.
     */
    public static int[] busquedaLineal(int[] array, int numero) {
        int pasos = 0;
        for (int i = 0; i < array.length; i++) {
            pasos++;
            if (array[i] == numero) {
                return new int[]{i, pasos}; // Encontrado
            }
        }
        return new int[]{-1, pasos}; // No encontrado
    }

    /**
     * Búsqueda Binaria.
     * Reduce repetidamente a la mitad el intervalo de búsqueda.
     * Requiere que el array esté ORDENADO.
     *
     * Complejidad: O(log n)
     *
     * @param array El array ordenado donde buscar.
     * @param numero El elemento a encontrar.
     * @return Un array de 2 enteros: {índice, pasos}. Retorna -1 como índice si no se encuentra.
     */
    public static int[] busquedaBinaria(int[] array, int numero) {
        int pasos = 0;
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda <= derecha) {
            pasos++;
            int medio = izquierda + (derecha - izquierda) / 2;

            if (array[medio] == numero) {
                return new int[]{medio, pasos}; // Encontrado
            } else if (array[medio] < numero) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }
        return new int[]{-1, pasos}; // No encontrado
    }

    public static void main(String[] args) {
        System.out.println("--- Pruebas de Algoritmos de Búsqueda ---");

        // Array para búsqueda lineal (puede estar desordenado)
        int[] arrayDesordenado = {4, 8, 1, 15, 7, 3, 10};
        int numeroABuscar1 = 7;

        System.out.println("\n1. Búsqueda Lineal");
        System.out.println("Array: " + Arrays.toString(arrayDesordenado));
        System.out.println("Buscando el número: " + numeroABuscar1);
        int[] resultadoLineal = busquedaLineal(arrayDesordenado, numeroABuscar1);
        System.out.printf("Resultado: Índice %d (encontrado en %d pasos)\n", resultadoLineal[0], resultadoLineal[1]);

        // Array para búsqueda binaria (DEBE estar ordenado)
        int[] arrayOrdenado = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int numeroABuscar2 = 23;

        System.out.println("\n2. Búsqueda Binaria");
        System.out.println("Array: " + Arrays.toString(arrayOrdenado));
        System.out.println("Buscando el número: " + numeroABuscar2);
        int[] resultadoBinario = busquedaBinaria(arrayOrdenado, numeroABuscar2);
        System.out.printf("Resultado: Índice %d (encontrado en %d pasos)\n", resultadoBinario[0], resultadoBinario[1]);

        // Caso no encontrado
        int numeroNoExistente = 100;
        System.out.println("\n3. Búsqueda Binaria (Elemento no existente)");
        System.out.println("Buscando el número: " + numeroNoExistente);
        resultadoBinario = busquedaBinaria(arrayOrdenado, numeroNoExistente);
        System.out.printf("Resultado: Índice %d (búsqueda finalizada en %d pasos)\n", resultadoBinario[0], resultadoBinario[1]);
    }
}

