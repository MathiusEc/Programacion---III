import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         /**
         * This program demonstrates the usage of dynamic nodes and a dynamic stack (PilaDinamica)
         * by testing push and peek operations and monitoring memory consumption.
         */

        // Initialize Scanner for user input and create instances of Nodo and PilaDinamica
        Scanner sc = new Scanner(System.in);
        Nodo nodo1 = new Nodo();
        PilaDinamica pilad = new PilaDinamica();
        Runtime runtime = Runtime.getRuntime(); // runtime is for monitoring memory usage

        // Test push method - adds elements to the stack
        // Calculate and display memory usage before pushing elements
        double usedMemoryBefore = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("Initial memory usage: " + String.format("%.3f GB", usedMemoryBefore));

        // Add n elements to the stack (from 0 to 10)
        System.out.println("Enter the number of elements to push onto the stack:");
        int n1= sc.nextInt();
        for (int i = 0; i <n1 ; i++) {
            pilad.push(i);
        }

        // Display memory usage after pushing elements
        double usedMemoryAfterPush = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("After calling the push method");
        System.out.println("Memory used: " + String.format("%.3f GB", usedMemoryAfterPush));

        // Test peek method - retrieves the top element without removing it
        // Display initial memory usage before peek operation
        double usedMemoryBeforePeek = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("Initial memory usage: " + String.format("%.3f GB", usedMemoryBeforePeek));

        // Retrieve n elements from the stack without removing them
        System.out.println("Enter the number of elements to peek from the stack:");
        int n1_5 = sc.nextInt();
        for (int i = 0; i < n1_5; i++) {
            int valor = pilad.peek();
            System.out.println("Peeked value: " + valor);
        }

        // Display memory usage after peek operation
        double usedMemoryAfterPeek = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("After calling the peek method");
        System.out.println("Memory used: " + String.format("%.3f GB", usedMemoryAfterPeek));

        // Test pop method - removes elements from the stack
        // Display initial memory usage before pop operation
        double usedMemoryBeforePop = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("Initial memory usage: " + String.format("%.3f GB", usedMemoryBeforePop));

        // Retrieve n elements from the stack
        System.out.println("Enter the number of elements to pop onto the stack:");
        int n2= sc.nextInt();
        for (int i = 0; i <n2 ; i++) {
            pilad.pop();
        }

        // Display memory usage after pop operation
        double usedMemoryAfterPop = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0 * 1024.0);
        System.out.println("After calling the pop method");
        System.out.println("Memory used: " + String.format("%.3f GB", usedMemoryAfterPop));

        //System.out.println("Value of the stack\n");

        sc.close();
    }
}