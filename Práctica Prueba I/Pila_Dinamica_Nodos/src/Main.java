
/**
 *Consigna: Implementa una pila usando nodos enlazados (LinkedList manual). Debe incluir:
 *
 * Clase Nodo:
 *
 * Atributo dato (int)
 * Atributo siguiente (referencia al siguiente nodo)
 * Constructor
 * Clase PilaDinamica:
 *
 * push(int valor) - Agregar al tope
 * pop() - Remover del tope (retornar valor o -1 si error)
 * mostrar() - Imprimir todos los elementos de arriba hacia abajo
 * estaVacia() - Retornar true si está vacía
 * Requisitos:
 *
 * Evitar UNDERFLOW
 * Complejidad O(1) en push y pop
 *
 * */

public class Main {
    public static void main(String[] args) {
        Pila_LinkedList_Manual pila = new Pila_LinkedList_Manual();
        pila.push(5);
        pila.push(15);
        pila.push(25);
        pila.mostrar(); // Salida: 25 -> 15 -> 5
        System.out.println(pila.pop()); // 25
        pila.mostrar(); // Salida: 15 -> 5
        pila.pop(); // Eliminar el nodo con valor 15
        pila.mostrar(); // Salida: 5
        pila.pop(); // Eliminar el nodo con valor 5
        pila.mostrar(); // Salida: Pila vacía
        pila.pop(); // Intentar hacer pop en una pila vacía, debería mostrar un mensaje de error

    }
}