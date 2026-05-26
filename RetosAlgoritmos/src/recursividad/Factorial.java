package recursividad;

/**
 * Un ejemplo clásico de recursividad: el cálculo del factorial de un número.
 * n! = n * (n-1) * (n-2) * ... * 1
 */
public class Factorial {

    /**
     * Calcula el factorial de un número n de forma recursiva.
     *
     * @param n El número para calcular el factorial (debe ser no negativo).
     * @return El valor de n!
     */
    public static long calcular(int n) {
        // Condición de seguridad para evitar números negativos.
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        // CASO BASE: El factorial de 0 es 1. La recursión se detiene aquí.
        if (n == 0) {
            return 1;
        }

        // CASO RECURSIVO: n! = n * (n-1)!
        // La función se llama a sí misma con un problema más pequeño (n-1).
        return n * calcular(n - 1);
    }

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("Calculando el factorial de " + numero);
        long resultado = calcular(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado); // Esperado: 120

        numero = 10;
        System.out.println("\nCalculando el factorial de " + numero);
        resultado = calcular(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado); // Esperado: 3628800
    }
}

