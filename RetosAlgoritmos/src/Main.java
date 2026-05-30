import backtracking.Laberinto;
import backtracking.SolucionadorLaberinto;
import busqueda.AlgoritmosBusqueda;
import colasdeprioridad.ColaPrioridad;
import deque.Deque;
import recursividad.Factorial;
import recursividad.FractalSierpinski;

import java.util.Arrays;

/**
 * Main class to demonstrate and test the different implemented algorithms.
 * Each section of the `main` method corresponds to one of the algorithm packages.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("####################################################");
        System.out.println("#          KEY ALGORITHM DEMONSTRATION         #");
        System.out.println("####################################################");

        // --- 1. Recursion ---
        demonstrateRecursion();

        // --- 2. Backtracking ---
        demonstrateBacktracking();

        // --- 3. Linear and Binary Search ---
        demonstrateSearch();

        // --- 4. Deque (Double-Ended Queue) ---
        demonstrateDeque();

        // --- 5. Priority Queue ---
        demonstratePriorityQueue();
    }

    public static void demonstrateRecursion() {
        System.out.println("\n\n--- 1. RECURSION DEMO ---");
        System.out.println("\n--- a) Factorial ---");
        int factorialNumber = 7;
        long factorialResult = Factorial.calculate(factorialNumber);
        System.out.println("The factorial of " + factorialNumber + " is: " + factorialResult);

        System.out.println("\n--- b) Sierpinski Fractal (console simulation) ---");
        FractalSierpinski fractal = new FractalSierpinski();
        fractal.draw(2); // Level 2 for a manageable output
    }

    public static void demonstrateBacktracking() {
        System.out.println("\n\n--- 2. BACKTRACKING DEMO ---");
        System.out.println("Solving a 5x5 maze...");
        Laberinto lab = Laberinto.createTestMaze();
        SolucionadorLaberinto solver = new SolucionadorLaberinto(lab);
        solver.solve();
    }

    public static void demonstrateSearch() {
        System.out.println("\n\n--- 3. SEARCH DEMO ---");
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] unsortedArray = {55, 23, 78, 11, 99, 42, 67};
        int elementToSearch = 40;

        System.out.println("\n--- a) Linear Search ---");
        System.out.println("Array: " + Arrays.toString(unsortedArray));
        int[] linearResult = AlgoritmosBusqueda.linearSearch(unsortedArray, 42);
        System.out.printf("Searching for 42: Found at index %d in %d steps.\n", linearResult[0], linearResult[1]);

        System.out.println("\n--- b) Binary Search (requires sorted array) ---");
        System.out.println("Array: " + Arrays.toString(sortedArray));
        int[] binaryResult = AlgoritmosBusqueda.binarySearch(sortedArray, elementToSearch);
        System.out.printf("Searching for %d: Found at index %d in %d steps.\n", elementToSearch, binaryResult[0], binaryResult[1]);
    }

    public static void demonstrateDeque() {
        System.out.println("\n\n--- 4. DEQUE DEMO ---");
        Deque<Integer> deque = new Deque<>();
        System.out.println("Initial state: " + deque);
        deque.addFront(10);
        deque.addRear(20);
        deque.addFront(5);
        deque.addRear(25);
        System.out.println("After adding 10, 20, 5, 25: " + deque);
        System.out.println("Remove from front: " + deque.removeFront());
        System.out.println("Remove from rear: " + deque.removeRear());
        System.out.println("Final state: " + deque);
    }

    public static void demonstratePriorityQueue() {
        System.out.println("\n\n--- 5. PRIORITY QUEUE DEMO ---");
        ColaPrioridad<String> pq = new ColaPrioridad<>();
        System.out.println("Enqueuing items with priorities (value, priority)...");
        pq.enqueue("Low", 1);
        pq.enqueue("High", 5);
        pq.enqueue("Medium", 3);
        pq.enqueue("Critical", 10);
        System.out.println("Queue state: " + pq);

        System.out.println("\nDequeuing in priority order:");
        while (!pq.isEmpty()) {
            System.out.println("Serviced item: " + pq.dequeue());
        }
    }
}
