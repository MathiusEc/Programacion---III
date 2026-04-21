/**
 * Enunciado:
 * Ingresar una cadena. El programa debe comprobar si la cadena (tras normalizar) es simétrica por mitades:
 * la primera mitad debe ser igual a la reversa de la segunda mitad. Si la longitud es impar, se ignora el carácter central.
 * Usar una `Cola` para la primera mitad (orden original) y una `Pila` para la segunda mitad (para invertirla) y comparar.
 * Restricciones:
 * No usar métodos automáticos de inversión.
 * Usar `Pila` y `Cola` dinámicas con `Nodo`.
 * Normalizar quitando espacios y no alfanuméricos; pasar a minúsculas.
 * Requisitos obligatorios:
 * Solicitar una cadena al usuario y validar que, tras limpieza, tenga al menos longitud 2.
 * Dividir en dos mitades (si impar, descartar el carácter central).
 * Enqueue caracteres de la primera mitad; push caracteres de la segunda mitad.
 * Comparar `dequeue()` vs `pop()` hasta terminar.
 * Mostrar: "Es simétrica por mitades" o "No es simétrica por mitades".
 * Incluir comentario con análisis Big-O al final del archivo `.java`.
 * Ejemplos:
 * Entrada: `abccba` → Primera mitad `abc`, segunda `cba` → Resultado: `Es simétrica por mitades`.
 * Entrada: `anitalava` → Tras limpiar y dividir → evaluar según mitades.
 * Criterios de evaluación (resumen):
 * Correcta partición y manejo de caso impar (25%).
 * Uso correcto de `Pila` y `Cola` (30%).
 * Validaciones y limpieza (25%).
 * Big-O y comentarios (20%).
 * Entrega y formato (válido para ambos ejercicios):
 * Archivo `.java` ejecutable con `main`.
 * Código correctamente indentado y comentado.
 * Comentario final con análisis de complejidad temporal (Big-O).
 * No usar métodos automáticos de inversión de cadenas.
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Object Declaration
        Scanner sc = new Scanner(System.in);
        Cola cola = new Cola();
        Pila pila = new Pila();

        // Input
        System.out.println("Ingrese una cadena: ");
        String input = sc.nextLine();

        // Processing
        // Limpiar la cadena de espacios y caracteres no alfanuméricos, y convertir
        String cadenaLimpia = limpiarCadena(input);

        // Validar que la cadena tenga al menos longitud 2 después de la limpieza
        if (cadenaLimpia.length() < 2) {
            System.out.println("Error: La cadena debe contener al menos dos caracteres alfanuméricos después de la limpieza.");
            sc.close();
            return; // Salida inmediata
        }

        // Dividir la cadena en dos mitades y llenar la pila y la cola
        llenarEstructuras(cadenaLimpia, cola, pila);
        if (compararEstructuras(cola, pila)) {
            System.out.println("Es simétrica por mitades");
        } else {
            System.out.println("No es simétrica por mitades");
        }


         /**
          * La complejidad temporal del algoritmo desarrollado es O(n), donde n es la longitud
          * de la cadena ingresada por el usuario. Esto se debe a que el algoritmo recorre la
          * cadena una vez para limpiarla y otra vez para insertar los caracteres en la pila y
          * la cola, así como para comparar los elementos de ambas estructuras. Por lo tanto,
          * el tiempo de ejecución crece linealmente con respecto a la longitud de la cadena.
          */

    }

    /**Dev Methods*/
    // Método para limpiar la cadena de espacios y caracteres no alfanuméricos, y convertir a minúsculas
    public static String limpiarCadena(String cadena) {
        return cadena.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Método para dividir la cadena en dos mitades y llenar la pila y la cola
    public static void llenarEstructuras(String cadena, Cola cola, Pila pila) {
        int longitud = cadena.length(); // Obtener la longitud de la cadena empieza desde 1, no desde 0
        int mitad = longitud / 2;

        // Enqueue caracteres de la primera mitad en la cola
        for (int i = 0; i < mitad; i++) {
            cola.enqueue(cadena.charAt(i));
        }

        // Push caracteres de la segunda mitad en la pila (si impar, se ignora el carácter central)
        // recorrer la segunda mitad en orden normal y hacer push para que pop devuelva la inversa
        int inicioSegundaMitad = mitad + (longitud % 2); // si es impar, saltar el carácter central
        for (int i = inicioSegundaMitad; i < longitud; i++) {
            pila.push(cadena.charAt(i));
            // se empuja la segunda mitad en su orden natural; al hacer pop obtendremos la reversa
        }
    }

    // Método para comparar los elementos de la pila y la cola (Son simétricas por mitades si todos los elementos coinciden)
    public static boolean compararEstructuras(Cola cola, Pila pila) {
        while (!cola.isEmpty() && !pila.isEmpty()) {
            if (cola.dequeue() != pila.pop()) {
                return false; // Si se encuentra una diferencia, no son simétricas por mitades
            }
        }
        // Si alguna de las estructuras quedó con elementos, no son equivalentes
        return cola.isEmpty() && pila.isEmpty(); // true sólo si ambas quedaron vacías
    }


}