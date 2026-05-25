import java.util.Arrays;
import java.util.Random;

public class GeneradorDatos {
    /** Atributos de la Clase */
    private int tamañoArray;
    private int[] arrayDatos;
    private int[] arrayOrdenado;
    private Random generador;


    /** Constructores & Destructores */
    public GeneradorDatos(int tamañoArray) {
        this.tamañoArray = tamañoArray;
        this.arrayDatos = new int[tamañoArray];
        this.arrayOrdenado = new int[tamañoArray];
        this.generador = new Random();
        generarDatos();
        ordenarArray();
    }


    /** Setters & Getters */
    public int getTamañoArray() {
        return tamañoArray;
    }

    public int[] getArrayDatos() {
        return arrayDatos;
    }

    public int[] getArrayOrdenado() {
        return arrayOrdenado;
    }


    /** Métodos del Programador */

    // Genera números aleatorios entre 1 y 100 000 para llenar el arrayDatos y copia los datos a arrayOrdenado
    public void generarDatos() {
        for (int i = 0; i < tamañoArray; i++) {
            arrayDatos[i] = generador.nextInt(100000) + 1;
            arrayOrdenado[i] = arrayDatos[i];
        }
    }

    // Ordena el arrayOrdenado utilizando Arrays.sort()
    public void ordenarArray() {
        Arrays.sort(arrayOrdenado);
    }

    // Imprime el array sin ordenar en una línea
    public void imprimirArraySinOrdenar() {
        System.out.println("\n--- ARRAY SIN ORDENAR ---");
        System.out.print("{");
        for (int i = 0; i < arrayDatos.length; i++) {
            System.out.print(arrayDatos[i]);
            if (i < arrayDatos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}\n");
    }

    // Imprime el array ordenado en una línea
    public void imprimirArrayOrdenado() {
        System.out.println("--- ARRAY ORDENADO (BUSQUEDAS) ---");
        System.out.print("{");
        for (int i = 0; i < arrayOrdenado.length; i++) {
            System.out.print(arrayOrdenado[i]);
            if (i < arrayOrdenado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}\n");
    }

    // Imprime los resultados de las búsquedas en formato de tabla
    public void imprimirTablaBusqueda(int[] resultadoLineal, int[] resultadoBinaria, int numero) {
        System.out.println("\n--- RESULTADOS DE BUSQUEDAS DEL NUMERO: " + numero + " ---");
        
        // Búsqueda Lineal
        System.out.println("\nBUSQUEDA LINEAL (Array ordenado)");
        System.out.println("***");
        if (resultadoLineal[0] != -1) {
            System.out.println("ENCONTRADO | Posicion: " + resultadoLineal[0] + " | Iteraciones: " + resultadoLineal[1]);
        } else {
            System.out.println("NO ENCONTRADO | Iteraciones: " + resultadoLineal[1]);
        }
        
        System.out.println();
        
        // Búsqueda Binaria
        System.out.println("BUSQUEDA BINARIA (Array ordenado)");
        System.out.println("---");
        if (resultadoBinaria[0] != -1) {
            System.out.println("ENCONTRADO | Posicion: " + resultadoBinaria[0] + " | Iteraciones: " + resultadoBinaria[1]);
        } else {
            System.out.println("NO ENCONTRADO | Iteraciones: " + resultadoBinaria[1]);
        }
    }

    // Muestra un resumen comparativo de las iteraciones entre búsqueda lineal y binaria
    public void mostrarResumen(int[] resultadoLineal, int[] resultadoBinaria) {
        int ahorro = resultadoLineal[1] - resultadoBinaria[1];
        double porcentaje = (ahorro * 100.0) / resultadoLineal[1];
        
        System.out.println("\n--- RESUMEN COMPARATIVO ---");
        System.out.println("+--------------------+---------------+");
        System.out.println("| Tipo de Busqueda   | Iteraciones   |");
        System.out.println("+--------------------+---------------+");
        System.out.printf("| Busqueda Lineal    | %-13d |\n", resultadoLineal[1]);
        System.out.printf("| Busqueda Binaria   | %-13d |\n", resultadoBinaria[1]);
        System.out.println("+--------------------+---------------+");
        System.out.printf("Ahorro con Binaria: %d iteraciones (%.1f%%)%n", ahorro, porcentaje);
    }
}
