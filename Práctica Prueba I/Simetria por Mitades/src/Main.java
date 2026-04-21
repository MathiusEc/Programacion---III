import java.util.Scanner;

/**
 *Enunciado:
 * Solicitar al usuario dos cadenas. El programa debe determinar si la segunda cadena es exactamente la reversa de la primera
 * (ignorando espacios y mayúsculas/minúsculas). Debe insertarse carácter a carácter de la primera cadena en una `Pila`
 * y carácter a carácter de la segunda cadena en una `Cola`, luego comparar `pop()` vs `dequeue()`.
 * Restricciones:
 * No usar métodos automáticos de inversión de cadenas.
 * Usar `Pila` y `Cola` implementadas con `Nodo` (dinámicas).
 * Normalizar quitando espacios y caracteres no alfanuméricos, y pasar a minúsculas.
 * Requisitos obligatorios:
 * Solicitar dos entradas al usuario.
 * Validar entradas vacías y longitud distinta → salida inmediata.
 * Insertar cada carácter de la primera en la pila y de la segunda en la cola.
 * Comparar elementos hasta vaciar estructuras o detectar diferencia.
 * Mostrar: "La segunda es la reversa de la primera" o "No son reversas".
 * Incluir comentario con análisis Big-O al final del archivo `.java`.
 * Ejemplos:
 * Entrada1: `hola`, Entrada2: `aloh` → Salida: `La segunda es la reversa de la primera`
 * Entrada1: `Reconocer`, Entrada2: `ronecneR` → Tras normalizar → `Sí`.
 * Criterios de evaluación (resumen):
 * Uso correcto de `Pila` (25%) y `Cola` (25%).
 * Validación y normalización (20%).
 * Comparación correcta sin funciones prohibidas (20%).
 * Big-O correcto y comentarios (10%).
 */
public class Main {
    public static void main(String[] args) {

        // Object Declaration
        Scanner sc = new Scanner(System.in);
        Cola cola = new Cola();
        Pila pila = new Pila();

        // Input
        System.out.print("Ingrese la primera cadena: ");
        String cadena1 = sc.nextLine();
        System.out.print("Ingrese la segunda cadena: ");
        String cadena2 = sc.nextLine();

        // Processing
        // Limpiar las cadenas de espacios y caracteres no alfanuméricos, y convertir a minúsculas
        String cadena1Limpia = limpiarCadena(cadena1);
        String cadena2Limpia = limpiarCadena(cadena2);

        // Validar entradas vacías después de la normalización
        if (cadena1Limpia.isEmpty() || cadena2Limpia.isEmpty()) {
            System.out.println("Error: Ambas cadenas deben contener al menos un carácter alfanumérico.");
            sc.close();
            return; // Salida inmediata
        }

        // Validar longitud distinta después de la normalización (salida inmediata)
        if (cadena1Limpia.length() != cadena2Limpia.length()) {
            System.out.println("Error: Las cadenas normalizadas tienen distinta longitud.");
            sc.close();
            return; // Salida inmediata
        }

        // Insertar cada carácter de la primera cadena en la pila y de la segunda cadena en la cola
        for (char c : cadena1Limpia.toCharArray()) {
            pila.push(c);
        }

        for (char c : cadena2Limpia.toCharArray()) {
            cola.enqueue(c);
        }

        // Comparar elementos hasta vaciar estructuras o detectar diferencia
        if (sonReversas(pila, cola)) {
            System.out.println("La segunda es la reversa de la primera");
        } else {
            System.out.println("No son reversas");
        }

        sc.close();
    }

    /**Dev Methods*/
    // Método para limpiar la cadena de espacios y caracteres no alfanuméricos, y convertir a minúsculas
    public static String limpiarCadena(String cadena) {
        return cadena.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Elimina todos los caracteres que no son letras o números y convierte la cadena a minúsculas
        // ^ indica negación, por lo que [^a-zA-Z0-9] coincide con cualquier carácter que no sea una letra mayúscula, una letra minúscula o un dígito
    }


    // Método comparar elementos de la pila y la cola para determinar si son reversas
    public static boolean sonReversas(Pila pila, Cola cola) {
        while (!pila.isEmpty() && !cola.isEmpty()) {
            if (pila.pop() != cola.dequeue()) {
                return false; // Si encontramos una diferencia, no son reversas
            }
        }
        return pila.isEmpty() && cola.isEmpty(); // Ambas estructuras deben estar vacías para ser reversas
    }

    /*
     * Complejidad:
     * Tiempo: O(n) donde n es la longitud de la cadena normalizada. Cada carácter se procesa, se inserta una vez y se compara una vez.
     * Espacio: O(n) por el uso de la pila y la cola (almacenan cada carácter de la cadena).
     */
}