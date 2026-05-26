package deque;

import java.util.NoSuchElementException;

/**
 * Implementación de una Deque (Double-Ended Queue) usando una lista doblemente enlazada.
 * Permite agregar y remover elementos tanto del frente como del final de la cola.
 *
 * @param <T> El tipo de dato que almacenará la deque.
 */
public class Deque<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Deque() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    /**
     * Verifica si la deque está vacía.
     * @return true si no hay elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamano == 0;
    }

    /**
     * Devuelve el número de elementos en la deque.
     * @return El tamaño de la deque.
     */
    public int tamano() {
        return tamano;
    }

    /**
     * Agrega un elemento al frente de la deque.
     * @param valor El elemento a agregar.
     */
    public void agregarFrente(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            frente = fin = nuevoNodo;
        } else {
            nuevoNodo.siguiente = frente;
            frente.anterior = nuevoNodo;
            frente = nuevoNodo;
        }
        tamano++;
    }

    /**
     * Agrega un elemento al final de la deque.
     * @param valor El elemento a agregar.
     */
    public void agregarFin(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
        tamano++;
    }

    /**
     * Remueve y devuelve el elemento del frente de la deque.
     * @return El elemento que estaba al frente.
     * @throws NoSuchElementException si la deque está vacía.
     */
    public T removerFrente() {
        if (estaVacia()) {
            throw new NoSuchElementException("La deque está vacía.");
        }
        T valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null; // La deque quedó vacía.
        } else {
            frente.anterior = null;
        }
        tamano--;
        return valor;
    }

    /**
     * Remueve y devuelve el elemento del final de la deque.
     * @return El elemento que estaba al final.
     * @throws NoSuchElementException si la deque está vacía.
     */
    public T removerFin() {
        if (estaVacia()) {
            throw new NoSuchElementException("La deque está vacía.");
        }
        T valor = fin.valor;
        fin = fin.anterior;
        if (fin == null) {
            frente = null; // La deque quedó vacía.
        } else {
            fin.siguiente = null;
        }
        tamano--;
        return valor;
    }

    /**
     * Devuelve el elemento del frente sin removerlo.
     * @return El primer elemento.
     * @throws NoSuchElementException si la deque está vacía.
     */
    public T verFrente() {
        if (estaVacia()) {
            throw new NoSuchElementException("La deque está vacía.");
        }
        return frente.valor;
    }

    /**
     * Devuelve el elemento del final sin removerlo.
     * @return El último elemento.
     * @throws NoSuchElementException si la deque está vacía.
     */
    public T verFin() {
        if (estaVacia()) {
            throw new NoSuchElementException("La deque está vacía.");
        }
        return fin.valor;
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.valor);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Pruebas de la Deque ---");
        Deque<String> deque = new Deque<>();

        System.out.println("Estado inicial: " + deque);
        System.out.println("¿Está vacía? " + deque.estaVacia());

        System.out.println("\nAgregando 'B' al frente...");
        deque.agregarFrente("B");
        System.out.println(deque);

        System.out.println("Agregando 'A' al frente...");
        deque.agregarFrente("A");
        System.out.println(deque);

        System.out.println("Agregando 'C' al final...");
        deque.agregarFin("C");
        System.out.println(deque);

        System.out.println("Agregando 'D' al final...");
        deque.agregarFin("D");
        System.out.println(deque);

        System.out.println("\nTamaño actual: " + deque.tamano());
        System.out.println("Elemento al frente: " + deque.verFrente());
        System.out.println("Elemento al final: " + deque.verFin());

        System.out.println("\nRemoviendo del frente: " + deque.removerFrente());
        System.out.println(deque);

        System.out.println("Removiendo del final: " + deque.removerFin());
        System.out.println(deque);

        System.out.println("\nRemoviendo del frente: " + deque.removerFrente());
        System.out.println(deque);

        System.out.println("Removiendo del final: " + deque.removerFin());
        System.out.println(deque);

        System.out.println("\n¿Está vacía? " + deque.estaVacia());
    }
}

