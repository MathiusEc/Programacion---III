package deque;

/**
 * Representa un nodo en una lista doblemente enlazada.
 * Cada nodo contiene un valor y referencias a los nodos siguiente y anterior.
 * @param <T> El tipo de dato que almacena el nodo.
 */
public class Nodo<T> {
    T valor;
    Nodo<T> siguiente;
    Nodo<T> anterior;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}

