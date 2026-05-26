package backtracking;

import java.util.Arrays;

/**
 * Representa el estado y las reglas de un laberinto.
 *
 * El laberinto se representa con una matriz de enteros:
 * 0: Camino libre
 * 1: Pared
 * 2: Salida
 * 3: Inicio
 * 5: Camino sin salida (visitado durante el backtracking)
 * 9: Camino actual de la solución
 */
public class Laberinto {

    private int[][] data;
    private int filaInicio;
    private int colInicio;

    // Contadores para estadísticas
    public int llamadasRecursivas = 0;
    public int retrocesos = 0;
    public int nodosExplorados = 0;

    public Laberinto(int[][] data) {
        this.data = data;
        // Encontrar el punto de inicio
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 3) {
                    this.filaInicio = i;
                    this.colInicio = j;
                    return;
                }
            }
        }
        // Si no se encuentra un 3, se asume el inicio en (0,0) si es válido
        this.filaInicio = 0;
        this.colInicio = 0;
    }

    public int getFilaInicio() {
        return filaInicio;
    }

    public int getColInicio() {
        return colInicio;
    }

    public int[][] getData() {
        return data;
    }

    /**
     * Imprime el estado actual del laberinto en la consola.
     */
    public void imprimir() {
        for (int[] fila : data) {
            System.out.println(Arrays.toString(fila)
                .replace("0", " ") // Camino
                .replace("1", "█") // Pared
                .replace("2", "S") // Salida
                .replace("3", "E") // Entrada
                .replace("5", "·") // Visitado sin salida
                .replace("9", "*"));// Camino de solución
        }
        System.out.println("-".repeat(data[0].length * 3));
    }

    /**
     * Devuelve una copia del laberinto para ejecutar pruebas sin modificar el original.
     */
    public static Laberinto crearLaberintoDePrueba() {
        int[][] layout = {
            {3, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1},
            {0, 0, 0, 0, 2}
        };
        return new Laberinto(layout);
    }
}
