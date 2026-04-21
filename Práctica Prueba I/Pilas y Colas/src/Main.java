import java.util.Scanner;

/**
 * Herramientas permitidas: Documentación del curso y apuntes personales
 * Herramientas NO permitidas: Métodos automáticos de inversión de cadenas (reverse, StringBuilder.reverse(), etc.)
 * Enunciado:
 * Desarrolle un programa en Java que permita determinar si una cadena ingresada por el usuario corresponde a:
 * •	un palíndromo (texto): Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios y diferencias entre mayúsculas y minúsculas. Por ejemplo: reconocer, radar, “La ruta natural”
 * •	un capicúa (número): Un capicúa es un número que se lee igual de izquierda a derecha que de derecha a izquierda.
 * El programa debe utilizar obligatoriamente:
 * •	una pila para invertir la secuencia
 * •	una cola para conservar el orden original
 * Posteriormente deberá comparar ambas estructuras para determinar el resultado.
 * Requisitos funcionales del programa
 * El programa debe:
 * •	Solicitar una cadena al usuario
 * •	Eliminar espacios en blanco
 * •	Ignorar diferencias entre mayúsculas y minúsculas
 * •	Detectar automáticamente si la entrada es:
 * o	texto
 * o	número
 * •	Determinar si:
 * o	el texto es palíndromo
 * o	el número es capicúa
 * •	Mostrar el resultado en pantalla
 * o	Ejemplo:
 * Entrada: reconocer
 * Resultado: Es palíndromo
 * Requisitos técnicos obligatorios:
 * El programa debe:
 * •	Usar una pila
 * •	Usar una cola
 * •	Insertar los caracteres en ambas estructuras
 * No se permite usar funciones automáticas de inversión de cadenas
 * Análisis de complejidad (obligatorio):
 *
 * Responder al final del programa (como comentario):
 * •	¿Cuál es la complejidad temporal del algoritmo desarrollado?
 * */


public class Main {
    public static void main(String[] args) {

        /**Object Declaration*/
        Scanner sc = new Scanner(System.in);
        Cola cola = new Cola();
        Pila pila = new Pila();

        /**Input*/
        System.out.print("Ingrese una cadena: ");
        String input = sc.nextLine();

        /**Processing*/
        // Limpiar la cadena de espacios y convertir a minúsculas
        String cadenaLimpia = limpiarCadena(input);

        // Detectar si la cadena es un número o un texto
        if (esNumero(cadenaLimpia)==true) {
            // Es un número, verificar si es capicúa
            if (esPalindromoOCapicua(cadenaLimpia)) {
                System.out.println("Es capicúa");
            } else {
                System.out.println("No es capicúa");
            }
        } else {
            // Es un texto, verificar si es palíndromo
            if (esPalindromoOCapicua(cadenaLimpia)) {
                System.out.println("Es palíndromo");
            } else {
                System.out.println("No es palíndromo");
            }
        }

        /**
         * La complejidad temporal del algoritmo desarrollado es O(n), donde n es la longitud
         * de la cadena ingresada por el usuario. Esto se debe a que el algoritmo recorre la
         * cadena una vez para limpiarla y otra vez para insertar los caracteres en la pila y
         * la cola, así como para comparar los elementos de ambas estructuras. Por lo tanto,
         * el tiempo de ejecución crece linealmente con respecto al tamaño de la entrada.
         * */
    }

    /** Dev Methods*/
    // Método para eliminar espacios y convertir a minúsculas
    public static String limpiarCadena(String cadena) {
        return cadena.replaceAll("\\s+", "").toLowerCase();
        // Elimina todos los espacios en blanco y convierte la cadena a minúsculas
    }

    // Método para determinar si la cadena es un número
    public static boolean esNumero(String cadena) {
        return cadena.matches("\\d+");
        // Verifica si la cadena contiene solo dígitos
    }

    // Método para determinar si la cadena es un palíndromo o capicúa
    public static boolean esPalindromoOCapicua(String cadena) {
        Cola cola = new Cola();
        Pila pila = new Pila();

        // Insertar caracteres en la pila y la cola
        for (char c : cadena.toCharArray()) {
            cola.enqueue(c);
            pila.push(c);
        }

        // Comparar los elementos de la pila y la cola
        while (!cola.isEmpty() && !pila.isEmpty()) {
            if (cola.dequeue() != pila.pop()) {
                return false; // No es palíndromo ni capicúa
                // Se verifica si el carácter extraído de la cola es diferente al carácter extraído de la pila.
                // Si son diferentes, se retorna false, indicando que la cadena no es un palíndromo ni un capicúa.
            }
        }
        return true; // Es palíndromo o capicúa
    }


}