import java.util.Scanner;

/**
 * Implement linear and binary search algorithms with the following characteristics:
 * • Generate an array of random integers allowing the user to select the array size
 * • Linear search and step count to find an element
 * • Binary search and step count to find an element
 * • Create a graph (Excel or any tool) of number of steps vs. array size
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcomeMessage();
        
        // 1. Request array size
        int size = requestSize();
        
        // 2. Create data generator
        GeneradorDatos generator = new GeneradorDatos(size);
        
        // 3. Print unsorted array
        generator.imprimirArraySinOrdenar();
        
        // 4. Print sorted array
        generator.imprimirArrayOrdenado();
        
        // 5. Create Search instance
        Busqueda search = new Busqueda(generator.getArrayOrdenado());
        
        // 6. Menu to perform searches
        boolean searchMore = true;
        while (searchMore) {
            System.out.print("Enter the number to search for (0 to exit): ");
            
            int number = scanner.nextInt();
            
            if (number == 0) {
                searchMore = false;
            } else {
                // Perform linear search on sorted array
                int[] linearResult = Busqueda.busquedaLineal(generator.getArrayOrdenado(), number);

                // Perform binary search on sorted array
                int[] binaryResult = search.busquedaBinaria(number);
                
                // Show results in a table
                generator.imprimirTablaBusqueda(linearResult, binaryResult, number);
                
                // Show comparative summary
                generator.mostrarResumen(linearResult, binaryResult);
            }
        }
        
        showGoodbyeMessage();
        scanner.close();
    }

    /// Shows the welcome message
    private static void showWelcomeMessage() {
        System.out.println("\n--- LINEAR SEARCH vs BINARY SEARCH ---");
        System.out.println("--- Programming III Lab ---\n");
        System.out.println("Name: Mathías Castillo\n");
    }

    /// Shows the goodbye message
    private static void showGoodbyeMessage() {
        System.out.println("\n--- End of program ---\n");
    }

    // Prompts the user for the array size and validates the input
    private static int requestSize() {
        int size = 0;
        while (size <= 0) {
            System.out.print("Enter the size of the array: ");
            
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Error: The size must be a positive number");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input");
                scanner.nextLine();
                size = 0;
            }
        }
        return size;
    }

}