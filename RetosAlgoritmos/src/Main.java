import backtracking.Laberinto;
import backtracking.SolucionadorLaberinto;
import busqueda.AlgoritmosBusqueda;
import colasdeprioridad.ColaPrioridad;
import deque.Deque;
import recursividad.Factorial;
import recursividad.FractalSierpinski;

import java.util.Arrays;

/**
 * Clase principal para demostrar y probar los diferentes algoritmos implementados.
 * Cada sección del método `main` corresponde a uno de los paquetes de algoritmos.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("####################################################");
        System.out.println("#      DEMOSTRACIÓN DE ALGORITMOS CLAVE      #");
        System.out.println("####################################################");

        // --- 1. Recursividad ---
        demostrarRecursividad();

        // --- 2. Backtracking ---
        demostrarBacktracking();

        // --- 3. Búsqueda Lineal y Binaria ---
        demostrarBusqueda();

        // --- 4. Deque (Cola de Doble Extremo) ---
        demostrarDeque();

        // --- 5. Cola de Prioridad ---
        demostrarColaDePrioridad();
    }

    public static void demostrarRecursividad() {
        System.out.println("\n\n--- 1. DEMOSTRACIÓN DE RECURSIVIDAD ---");
        System.out.println("\n--- a) Factorial ---");
        int numeroFactorial = 7;
        long resultadoFactorial = Factorial.calcular(numeroFactorial);
        System.out.println("El factorial de " + numeroFactorial + " es: " + resultadoFactorial);

        System.out.println("\n--- b) Fractal de Sierpinski (simulado en consola) ---");
        FractalSierpinski fractal = new FractalSierpinski();
        fractal.dibujar(2); // Nivel 2 para una salida manejable
    }

    public static void demostrarBacktracking() {
        System.out.println("\n\n--- 2. DEMOSTRACIÓN DE BACKTRACKING ---");
        System.out.println("Resolviendo un laberinto 5x5...");
        Laberinto lab = Laberinto.crearLaberintoDePrueba();
        SolucionadorLaberinto solucionador = new SolucionadorLaberinto(lab);
        solucionador.resolver();
    }

    public static void demostrarBusqueda() {
        System.out.println("\n\n--- 3. DEMOSTRACIÓN DE BÚSQUEDA ---");
        int[] arrayOrdenado = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] arrayDesordenado = {55, 23, 78, 11, 99, 42, 67};
        int elementoABuscar = 40;

        System.out.println("\n--- a) Búsqueda Lineal ---");
        System.out.println("Array: " + Arrays.toString(arrayDesordenado));
        int[] resLineal = AlgoritmosBusqueda.busquedaLineal(arrayDesordenado, 42);
        System.out.printf("Buscando 42: Encontrado en índice %d en %d pasos.\n", resLineal[0], resLineal[1]);

        System.out.println("\n--- b) Búsqueda Binaria (requiere array ordenado) ---");
        System.out.println("Array: " + Arrays.toString(arrayOrdenado));
        int[] resBinaria = AlgoritmosBusqueda.busquedaBinaria(arrayOrdenado, elementoABuscar);
        System.out.printf("Buscando %d: Encontrado en índice %d en %d pasos.\n", elementoABuscar, resBinaria[0], resBinaria[1]);
    }

    public static void demostrarDeque() {
        System.out.println("\n\n--- 4. DEMOSTRACIÓN DE DEQUE ---");
        Deque<Integer> deque = new Deque<>();
        System.out.println("Estado inicial: " + deque);
        deque.agregarFrente(10);
        deque.agregarFin(20);
        deque.agregarFrente(5);
        deque.agregarFin(25);
        System.out.println("Después de agregar 10, 20, 5, 25: " + deque);
        System.out.println("Remover del frente: " + deque.removerFrente());
        System.out.println("Remover del final: " + deque.removerFin());
        System.out.println("Estado final: " + deque);
    }

    public static void demostrarColaDePrioridad() {
        System.out.println("\n\n--- 5. DEMOSTRACIÓN DE COLA DE PRIORIDAD ---");
        ColaPrioridad<String> pq = new ColaPrioridad<>();
        System.out.println("Encolando elementos con prioridades (valor, prioridad)...");
        pq.encolar("Baja", 1);
        pq.encolar("Alta", 5);
        pq.encolar("Media", 3);
        pq.encolar("Crítica", 10);
        System.out.println("Estado de la cola: " + pq);

        System.out.println("\nDesencolando en orden de prioridad:");
        while (!pq.estaVacia()) {
            System.out.println("Elemento atendido: " + pq.desencolar());
        }
    }
}
