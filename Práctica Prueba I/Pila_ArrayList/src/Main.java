/***
 *Consigna: Crea una clase Pila que implemente una estructura LIFO (Last In, First Out) usando ArrayList. Debe tener los siguientes métodos:
 *
 * push(int elemento) - Agregar elemento al tope
 * pop() - Remover y retornar el elemento del tope
 * peek() - Ver el elemento del tope sin remover
 * isEmpty() - Verificar si la pila está vacía
 * tamaño() - Retornar la cantidad de elementos
 * Requisitos:
 *
 * Evitar UNDERFLOW (verificar si está vacía antes de pop)
 * Mostrar mensaje de error si ocurre underflow
 */

public class Main {
    public static void main(String[] args) {

        /** Object Declaration*/
        Pila p = new Pila();
        p.push(10);
        p.push(20);
        p.push(30);
        System.out.println(p.pop()); // Debe imprimir: 30
        System.out.println(p.tamaño()); // Debe imprimir: 2
        p.pop(); // Remueve 20
        p.pop(); // Remueve 10
        System.out.println(p.isEmpty()); // Debe imprimir: true
        p.pop(); // ERROR: UNDERFLOW
        System.out.println(p.tamaño()); // Debe imprimir: 0

    }
}