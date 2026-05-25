import java.util.Scanner;

/**
 * Implementar algoritmo de búsqueda lineal y binaria con las siguientes características:
 * • Generar un array de números enteros aleatorios permitiendo seleccionar el tamaño del arreglo
 * • Búsqueda lineal y conteo de pasos para encontrar un elemento
 * • Búsqueda binaria y conteo de pasos para encontrar un elemento
 * • Crear una gráfica (excel o cualquier herramienta) número de pasos vs. tamaño del array
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarBienvenida();
        
        // 1. Solicitar tamaño del array
        int tamaño = solicitarTamaño();
        
        // 2. Crear generador de datos
        GeneradorDatos generador = new GeneradorDatos(tamaño);
        
        // 3. Imprimir array sin ordenar
        generador.imprimirArraySinOrdenar();
        
        // 4. Imprimir array ordenado
        generador.imprimirArrayOrdenado();
        
        // 5. Crear instancia de Busqueda
        Busqueda busqueda = new Busqueda(generador.getArrayOrdenado());
        
        // 6. Menú para realizar búsquedas
        boolean buscarMas = true;
        while (buscarMas) {
            System.out.print("Ingresa el numero a buscar (0 para salir): ");
            
            int numero = scanner.nextInt();
            
            if (numero == 0) {
                buscarMas = false;
            } else {
                // Realizar búsqueda lineal en array ordenado
                int[] resultadoLineal = Busqueda.busquedaLineal(generador.getArrayOrdenado(), numero);

                // Realizar búsqueda binaria en array ordenado
                int[] resultadoBinaria = busqueda.busquedaBinaria(numero);
                
                // Mostrar resultados en tabla
                generador.imprimirTablaBusqueda(resultadoLineal, resultadoBinaria, numero);
                
                // Mostrar resumen comparativo
                generador.mostrarResumen(resultadoLineal, resultadoBinaria);
            }
        }
        
        mostrarDespedida();
        scanner.close();
    }

    /// Muestra el mensaje de bienvenida
    private static void mostrarBienvenida() {
        System.out.println("\n--- BUSQUEDA LINEAL vs BUSQUEDA BINARIA ---");
        System.out.println("--- Laboratorio de Programacion III ---\n");
        System.out.println("Nombre: Mathías Castillo\n");
    }

    /// Muestra el mensaje de despedida
    private static void mostrarDespedida() {
        System.out.println("\n--- Fin del programa ---\n");
    }

    // Solicita al usuario el tamaño del array y valida la entrada
    private static int solicitarTamaño() {
        int tamaño = 0;
        while (tamaño <= 0) {
            System.out.print("Ingresa el tamano del array: ");
            
            try {
                tamaño = scanner.nextInt();
                if (tamaño <= 0) {
                    System.out.println("Error: El tamano debe ser un numero positivo");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada invalida");
                scanner.nextLine();
                tamaño = 0;
            }
        }
        return tamaño;
    }

}